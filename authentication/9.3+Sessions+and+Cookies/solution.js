import express from "express";
import bodyParser from "body-parser";
import pg from "pg";
import bcrypt from "bcrypt";
import passport from "passport";  //2
import { Strategy } from "passport-local";
import session from "express-session";   //1

const app = express();
const port = 3000;
const saltRounds = 10;

// Configure session middleware for authentication
app.use(//1
    session({
      secret:"TOPSECRETWORD",
      resave:false,
      saveUninitialized:true,
      cookie:{
        maxAge:1000*60*60*24,  // setting the time of existence of cookie . here Cookie expires in 1 day (in milliseconds)
      }
    })
);


app.use(bodyParser.urlencoded({ extended: true })); // Parse URL-encoded bodies
app.use(express.static("public")); // Serve static files from 'public' folder


app.use(passport.initialize()); // Initialize Passport   //2
app.use(passport.session());    // Use Passport to manage sessions   //2



// Connect to PostgreSQL database
const db = new pg.Client({
  user: "postgres",
  host: "localhost",
  database: "SECRETS",
  password: "sahoo@9832",
  port: 5432,
});
db.connect();

// Render home page
app.get("/", (req, res) => {
  res.render("home.ejs");
});

// Render login page
app.get("/login", (req, res) => {
  res.render("login.ejs");
});

// Render register page
app.get("/register", (req, res) => {
  res.render("register.ejs");
});

// Logout route, ends user session
app.get("/logout", (req, res) => {
  req.logout(function (err) {
    if (err) {
      return next(err);
    }
    res.redirect("/");
  });
});

// Secrets page, only accessible if authenticated  through sessions by cookies
app.get("/secrets", (req, res) => {     //2
  // console.log(req.user);
  if (req.isAuthenticated()) {    // it is from passport .it checks "is the current user who is logged in in the current session authenticated already? "
    res.render("secrets.ejs");
  } else {
    res.redirect("/login");
  }
});



// Register POST route, hashes password and saves user

app.post("/register", async (req, res) => {
  const email = req.body.username;
  const password = req.body.password;

  try {
    const checkResult = await db.query("SELECT * FROM users WHERE email = $1", [
      email,
    ]);

    if (checkResult.rows.length > 0) {
      res.send("Email already exists. Try logging in.");
    } else {
      //hashing the password and saving it in the database
      bcrypt.hash(password, saltRounds, async (err, hash) => {
        if (err) {
          console.error("Error hashing password:", err);
        } else {
          console.log("Hashed Password:", hash);
          await db.query(
              "INSERT INTO users (email, password) VALUES ($1, $2) RETURNING *",   //  ✅ RETURNING * means: return the full inserted row (id, email, password...) immediately after insert
              [email, hash]
          );
          const user=result.rows[0];
          // res.render("secrets.ejs");   instead of using this we will use
          req.login(user,(err)=>{
            console.log(err);
            res.redirect("/secrets");
          });
        }
      });
    }
  } catch (err) {
    console.log(err);
  }
});

// Route to handle login form submission using POST method
app.post("/login",passport.authenticate("local", {
      /* Use Passport's "local" strategy to authenticate the user
      This triggers the "verify" function you defined below:
       - It looks up the user by email in the database
      - Compares the password with bcrypt
      */

      successRedirect: "/secrets", /* If authentication succeeds (valid email and password), user is redirected to the "/secrets" page*/


      failureRedirect: "/login",    // If authentication fails (wrong email or password),   user is redirected back to the "/login" page
    })
);

// Configure Passport local strategy for authentication
passport.use(new Strategy(async function verify(username,password,cb){  //3
  //cb = call back . in passport it always denoted as cb
  /* it automatically access the passport ,username from the "form" in this case its  ejs files, the name must be the same in from which is name ="username" ,name="password " in the register.ejs ,login.ejs etc
      so we dont need this
      const email = req.body.username;
      const loginPassword = req.body.password;
  */

  //place the everything you write in the try -catch block  of post request of login .as this verify finction will check if the password is correct ot not if the user is already authenticated or not etc

  try {
    const result = await db.query("SELECT * FROM users WHERE email = $1", [
      username,
    ]);
    if (result.rows.length > 0) {
      const user = result.rows[0];
      const storedHashedPassword = user.password;
      bcrypt.compare(password, storedHashedPassword, (err, result) => {
        if (err) {
          // console.error("Error comparing passwords:", err);         // instead of  this return a cb() it will do the same work ,as it is just the syntex for passport
          return cb(err);
        } else {
          if (result) {

            //nres.render("secrets.ejs");           //instead of simply render the "secrets.ejs" , we will try and pass a callback  it will do the same work ,as it is just the syntex for passport
            return cb(null,user) ;                 // null :- as no error because it will execute if the result=true ,so no error here
          } else {
            // res.send("Incorrect Password");       //instead of this we will use callback cb() it will do the same work , as it is just the syntex for passport
            return cb(err, false);
          }
        }
      });
    } else {
      // res.send("User not found");            // instead of this we will use callback cb()  it will do the same work, as it is just the syntex for passport
      return cb("user not found ")

    }
  } catch (err) {
    // console.log(err);                   //// instead of this we will use callback cb()  it will do the same work, as it is just the syntex for passport
    return cb(err);
  }
}));


// Serialize user into session  by this we save the data of user(who is logged in ) to the local storage
passport.serializeUser((user, cb) => {
  cb(null, user);  // call back to pass over any of the details of the user
});


passport.deserializeUser((user, cb) => {
  /* Deserialize user from session same as serializeUser  it just passes along the users information .
saves the users information such as their ID,email, to the local session
and when you want to get hold of the user , it decentralizes it back into a way that you
can access the users information through that sessions
 */
  cb(null, user);
});

// Start the server
app.listen(port, () => {
  console.log(`Server running on port ${port}`);
});