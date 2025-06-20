import express from "express";
import bodyParser from "body-parser";
import pg from "pg";

const app = express();
const port = 3000;

// Create a new PostgreSQL client to connect to the database
const db = new pg.Client({
  user: "postgres",        // Database username
  host: "localhost",       // Database host
  database: "SECRETS",     // Database name
  password: "sahoo@9832",  // Database password
  port: 5432,              // Database port
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
    const checkresult = await db.query("SELECT * FROM users WHERE email=$1", [email]);

    if (checkresult.rows.length > 0) {
      res.send("email already exists .try logging in !!");
    } else {
      // Insert new user into the database
      const result = await db.query(
          "INSERT INTO users ( email,password) VALUES ($1,$2)",
          [email, password]
      );
      console.log(result);
      res.render("login.ejs");
    }
  } catch (err) {
    console.log(err);
  }
});

// Handle user login
app.post("/login", async (req, res) => {
  const email = req.body.username;
  const password = req.body.password;
  try {
    // Find user by email
    const result = await db.query("SELECT * FROM users WHERE email=$1", [email]);
    if (result.rows.length > 0) {
      const user = result.rows[0];
      const storedPassword = user.password;
      // Compare entered password with stored password
      if (password == storedPassword) {
        res.render("secrets.ejs");
      } else {
        res.send("INCORRECT PASSWORD !!");
      }
    } else {
      res.send("user not found !!");
    }
  } catch (err) {
    console.log(err);
  }
});

// Start the server
app.listen(port, () => {
  console.log(`Server running on port ${port}`);