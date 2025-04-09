# 🔐 Java Hashing Projects

This repository contains two very basic but effective Java projects demonstrating the use of **SHA-256 hashing** for secure password handling and general encryption. These are console-based applications created using Java's built-in cryptographic libraries.

## 📁 Contents

1. **Password Hasher + Login Verifier**
2. **Hash Encryptor**


## 1️. Password Hasher + Login Verifier

A basic secure login system using SHA-256 hashing with a randomly generated salt. This demonstrates how to:

- Safely hash a password with `MessageDigest`
- Add cryptographic salt using `SecureRandom`
- Verify user login by matching hashes

### 🔧 How it works:
- User sets a password → it gets salted & hashed
- Salt is stored
- During login, user enters a password
- The entered password is salted the same way and hashed again
- Hashes are compared for authentication

📂 File: `login_verifier.java`

---

## 2️⃣ Hash Encryptor

A simple tool that takes a word or sentence from the user and prints its SHA-256 hash. It’s a minimal example to show how cryptographic hash functions work.

📂 File: `password_hasher.java` 

---

## ▶️ How to Run (Eclipse/VS Code or Terminal)

1. Make sure you are using **Java 8+**
2. Compile:
   - javac login_verifier.java
   - javac simple_hasher.java
4. Run:
   - java login_verifier
   - java simple_hasher



