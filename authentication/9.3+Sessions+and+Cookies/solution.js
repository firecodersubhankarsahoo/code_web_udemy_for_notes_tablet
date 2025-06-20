import express from "express";
import bodyParser from "body-parser";
import pg from "pg";
import bcrypt from "bcrypt";
import passport from "passport";
import { Strategy } from "passport-local";
import session from "express-session";
import env from "dotenv";

const app = express();
const port = 3000;
const saltRounds = 10;
env.config(); // Load environment variables from .env file

// Configure session middleware for authentication
app.use(
    session({
      secret: "TOPSECRETWORD", // Secret for signing session ID cookie
      resave: false,           // Don't save session if unmodified
      saveUninitialized: true, // Save new sessions
    })
);
app.use(bodyParser.urlencoded({ extended: true })); // Parse URL-encoded bodies
app.use(express.static("public")); // Serve static files from 'public' folder

app.use(passport.initialize()); // Initialize Passport
app.use(passport.session());    // Use Passport to manage sessions

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

// Secrets page, only accessible if authenticated
app.get("/secrets", (req, res) => {
  // console.log(req.user);
  if (req.isAuthenticated()) {
    res.render("secrets.ejs");
  } else {
    res.redirect("/login");
  }
});

// Login POST route, uses Passport authentication
app.post(
    "/login",
    passport.authenticate("local", {
      successRedirect: "/secrets",
      failureRedirect: "/login",
    })
);

// Register POST route, hashes password and saves user
app.post("/register", async (req, res) => {
  const email = req.body.username;
  const password = req.body.password;

  try {
    // Check if user already exists
    const checkResult = await db.query("SELECT * FROM users WHERE email = $1", [
      email,
    ]);

    if (checkResult.rows.length > 0) {
      req.redirect("/login"); // User exists, redirect to login
    } else {
      // Hash password and insert new user
      bcrypt.hash(password, saltRounds, async (err, hash) => {
        if (err) {
          console.error("Error hashing password:", err);
        } else {
          const result = await db.query(
              "INSERT INTO users (email, password) VALUES ($1, $2) RETURNING *",
              [email, hash]
          );
          const user = result.rows[0];
          // Log in the new user
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

// Configure Passport local strategy for authentication
passport.use(
    new Strategy(async function verify(username, password, cb) {
      try {
        // Find user by email
        const result = await db.query("SELECT * FROM users WHERE email = $1 ", [
          username,
        ]);
        if (result.rows.length > 0) {
          const user = result.rows[0];
          const storedHashedPassword = user.password;
          // Compare entered password with stored hash
          bcrypt.compare(password, storedHashedPassword, (err, valid) => {
            if (err) {
              // Error with password check
              console.error("Error comparing passwords:", err);
              return cb(err);
            } else {
              if (valid) {
                // Password matches
                return cb(null, user);
              } else {
                // Password does not match
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

// Serialize user into session
passport.serializeUser((user, cb) => {
  cb(null, user);
});
// Deserialize user from session
passport.deserializeUser((user, cb) => {
  cb(null, user);
});

// Start the server
app.listen(port, () => {
  console.log(`Server running on port ${port}`);
});