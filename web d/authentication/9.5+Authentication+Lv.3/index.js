import express from "express";
import bodyParser from "body-parser";
import pg from "pg";
import bcrypt from "bcrypt";
import passport from "passport";
import { Strategy } from "passport-local";
import session from "express-session";
import env from "dotenv"; // 1
import GoogleStrategy from "passport-google-oauth2"; //2  // // is needed to use the google oAuth strategy of passport

const app = express();
const port = 3000;
const saltRounds = 10;
env.config();// 1  //Load environment variables from a .env file into "process.env" . to use in "js" file such as index.js


app.use(
  session({
    secret: process.env.SESSION_SECRET,  // 1
    resave: false,
    saveUninitialized: true,
      cookie: { maxAge: 24 * 60 * 60 * 1000 }

  })
);

app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.static("public"));

app.use(passport.initialize());
app.use(passport.session());

const db = new pg.Client({       // 1
  user: process.env.PG_USER,
  host: process.env.PG_HOST,
  database: process.env.PG_DATABASE,
  password: process.env.PG_PASSWORD,
  port: process.env.PG_PORT,
});
db.connect();

app.get("/", (req, res) => {
  res.render("home.ejs");
});

app.get("/login", (req, res) => {
  res.render("login.ejs");
});

app.get("/register", (req, res) => {
  res.render("register.ejs");
});

app.get("/logout", (req, res) => {
  req.logout(function (err) {
    if (err) {
      return next(err);
    }
    res.redirect("/");
  });
});

app.get("/secrets", (req, res) => {   //3
  console.log(req.user);
  if (req.isAuthenticated()) {
    res.render("secrets.ejs");
  } else {
    res.redirect("/login");
  }
});


app.get("/auth/google",                 // the get route will going to be hit up when user click on the "Sign up with google" button. in signup or login page (check the register.ejs & login.ejs)
  passport.authenticate("google",{   //must mention the name of the strategy  we want to authenticate with . it should be the same strategy name below written in "passport.use("google",new GoogleStrategy({ }) ". as its written "google" so here must write the strategy name also google

    scope:["profile","email"],  //the data we need must mention  here. after we will get the data it should be receive inside  the strategy down below  ("passport.use("google",new GoogleStrategy({ }) ") as the strategy name mention here is "google"
}));

app.get("/auth/google/secrets",passport.authenticate("google",{
    successRedirect:"/secrets",   // if successfully authenticated then it will redirect you to the "/secrets" route .   you can see "app.get("/secrets", (req, res) => {code })" in your code it will redirect there 

    failureRedirect:"/login",  /* if not authenticated the it will redirect to the "/login " route . you can see in your code    "app.get("/login", (req, res) => {
                                                                                                                                  res.render("login.ejs");
                                                                                                                                   });"   */
}));



app.get("/logout",(req,res)=>{   // for the "logout" button work
  req.logout((err)=>{
    if(err){
      console.log(err);
    }else{
      res.redirect("/")
    }
  })
});


app.post(
  "/login",                     
  passport.authenticate("local", {
    successRedirect: "/secrets",
    failureRedirect: "/login",
  })
);

app.post("/register", async (req, res) => {  // not in use here as we are logging in with google here
  const email = req.body.username;
  const password = req.body.password;

  try {
    const checkResult = await db.query("SELECT * FROM users WHERE email = $1", [
      email,
    ]);

    if (checkResult.rows.length > 0) {
      req.redirect("/login");
    } else {
      bcrypt.hash(password, saltRounds, async (err, hash) => {
        if (err) {
          console.error("Error hashing password:", err);
        } else {
          const result = await db.query(
            "INSERT INTO users (email, password) VALUES ($1, $2) RETURNING *",
            [email, hash]
          );
          const user = result.rows[0];
          req.login(user, (err) => {
            console.log("success");
            res.redirect("/secrets");
          });
        }
      });
    }
  } catch (err) {
    console.log(err);
  }
});


// not in use here as we are logging in with google here
passport.use("local",          // as here we have two strategies so we must mention which one is for which strategy .this is for local strategy. if we had only one strategy no need to mention it

  new Strategy(async function verify(username, password, cb) {
    try {
      const result = await db.query("SELECT * FROM users WHERE email = $1 ", [
        username,
      ]);
      if (result.rows.length > 0) {
        const user = result.rows[0];
        const storedHashedPassword = user.password;
        bcrypt.compare(password, storedHashedPassword, (err, valid) => {
          if (err) {
            console.error("Error comparing passwords:", err);
            return cb(err);
          } else {
            if (valid) {
              return cb(null, user);
            } else {
              return cb(null, false);
            }
          }
        });
      } else {
        return cb("User not found");
      }
    } catch (err) {
      console.log(err);
    }
  })
);


passport.use("google", new GoogleStrategy({  //  2      // as here we have two strategies in this file, so we must mention which one is for which strategy .this is for google  strategy. if we had only one strategy no need to mention it

  clientID: process.env.GOOGLE_CLIENT_ID, // 1 //GOOGLE_CLIENT_ID is in .env file . check the .env file  . "process.env.GOOGLE_CLIENT_ID"  here 'process.env' is used as we configured the .env to process.env through  "env.config();" 
  clientSecret: process.env.GOOGLE_CLIENT_SECRET,    // 1 //GOOGLE_CLIENT_SECRET is in .env file . check the .env file  . "process.env.GOOGLE_CLIENT_ID"  here 'process.env' is used as we configured the .env to process.env through  "env.config();" 
  callbackURL: "http://localhost:3000/auth/google/secrets", //"Authorised redirect URIs"   set on google auth
  userProfileURL: "https://www.googleapis.com/oauth2/v3/userinfo",    // standard Google User Info endpoint, This is a fixed, official URL provided by Google to all apps using OAuth.

  passReqToCallback: true  // allows us to access `req` in the verify callback
}, async (req, accessToken, refreshToken, profile, cb) => {          // "refreshToken" :- help us keep that user signed in or track their session as we go along   
  console.log(profile);

  try {
    const result = await db.query("SELECT * FROM users WHERE email=$1", [profile.email]);
    if (result.rows.length === 0) { // if the result means email is not found in database. then create a new user and call back the new user
      const newUser = await db.query("INSERT INTO users (email,password) VALUES($1,$2) RETURNING *", [profile.email, "google"]); // in google authentication google doesn't provide the password. it depends upon you, you can specify what can be the password, some people store their "userid"(profile.ID) from googleAuth to identify themselves, some people place "google" as the password. it's not important what the password is
      const user = newUser.rows[0];
      req.login(user, (err) => {
        if (err) return cb(err);
        return cb(null, user);   // null means no error
      });
    } else {
      // user already exists. so no need to create new user. call back the result
         return cb(null, result.rows[0]);

    }
  } catch (err) { // if error found then call back the error
    return cb(err);
  }
}));


passport.serializeUser((user, cb) => {
  cb(null, user);
});
passport.deserializeUser((user, cb) => {
  cb(null, user);
});

app.listen(port, () => {
  console.log(`Server running on port ${port}`);
});
