import express from "express";
import bodyParser from "body-parser";
import pg from "pg";
import bcrypt, { hash } from "bcrypt";

const app = express();
const port = 3000;

const saltRounds = 15; // Number of salt rounds for bcrypt hashing

// Create a new PostgreSQL client to connect to the database
const db = new pg.Client({
  user: "postgres",      // Database username
  host: "localhost",     // Database host
  database: "SECRETS",   // Database name
  password: "sahoo@9832",// Database password
  port: 5432,            // Database port
});
db.connect(); // Connect to the database

app.use(bodyParser.urlencoded({ extended: true })); // Parse URL-encoded bodies
app.use(express.static("public")); // Serve static files from 'public' directory

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

// Handle user registration
app.post("/register", async (req, res) => {
  const email = req.body.username;
  const password = req.body.password;

  try {
    // Check if user already exists
    const checkResult = await db.query("SELECT * FROM users WHERE email = $1", [
      email,
    ]);

    if (checkResult.rows.length > 0) {
      res.send("Email already exists. Try logging in.");
    } else {
      // Hash the password before storing
      bcrypt.hash(password, saltRounds, async (err, hash) => {
        if (err) {
          console.error("err hashing password ", err);
        } else {
          console.log("hashed password", hash);
          // Insert new user into the database
          await db.query("INSERT INTO users (email,password) VALUES ($1,$2)", [email, hash]);
          res.render("login.ejs");
        }
      });
    }
  } catch (err) {
    console.log(err);
  }
});

// Handle user login
app.post("/login", async (req, res) => {
  const email = req.body.username;
  const loginPassword = req.body.password;

  try {
    // Find user by email
    const result = await db.query("SELECT * FROM users WHERE email = $1", [
      email,
    ]);
    if (result.rows.length > 0) {
      const user = result.rows[0];
      const storedHashedPassword = user.password;

      // Compare entered password with stored hash
      bcrypt.compare(loginPassword, storedHashedPassword, (err, result) => {
        if (err) {
          console.error("error compairing password", err);
        } else {
          if (result) {
            // Password matches, render secrets page
            res.render("secrets.ejs");
          } else {
            res.send("Incorrect Password!!");
          }
        }
      });
    } else {
      res.send("user not foumd!!!");
    }
  } catch (err) {
    console.log(err);
  }
});

// Start the server
app.listen(port, () => {
  console.log(`Server running on port