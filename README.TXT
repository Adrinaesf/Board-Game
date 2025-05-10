# 🎲 Halfgammon

A personal board game inspired by Backgammon, created to practice and demonstrate mastery of **inheritance**, **method overriding**, and **method overloading** in Java.

---

### 📌 Project Info

- **Project Title:** UBG-Halfgammon  
- **Purpose:** Practice object-oriented programming, especially inheritance  
- **Version/Date:** Sunday, Feb 11, 2024  
- **Author:** Adrina E (Grade 12A)  
- **How to Run:** Launch the program from the `Main` class and press `Start`

---

### 🕹️ Game Instructions

Welcome to **Halfgammon**, a two-player strategy game inspired by Backgammon.

- Choose your color: **Red** or **Pink**
- Two dice will roll to determine who goes first — the player with the higher total starts
- On your turn, roll the dice again and choose which value to use for your move
- If you're **Red**, you move pieces to the **right**; if you're **Pink**, you move pieces to the **left**
- Players cannot move through or land on a space occupied by the opponent. If you try, you'll receive the message:  
  `"You chose the wrong player"` and your turn will be skipped

---

### 🏁 How to Win

Each player must move all their pieces to their designated home area:
- **Red Home:** Avenues 19 to 24  
- **Pink Home:** Avenues 0 to 5  

The first player to bring all their pieces to their home wins!

---

### 🔧 Object-Oriented Programming Features

This project was a challenge, but also a valuable learning experience in Java OOP:

#### ✔️ Inheritance
- **BetterRobot** class extends **MyRobot**
  - Adds functionality to move based on dice rolls
  - Determines win condition and changes piece colors
- **MyRobot** class extends **RobotSE**
  - Inherits basic robot functions
  - Adds a method to get all movable robots

#### ✔️ Method Overriding & Overloading
- Overrode and overloaded `move()` methods to handle different scenarios
- Attempted to override methods like `isRobotAtIntersection` and `nextPlayerMove`
  - Faced challenges with overriding methods that return `boolean` values compared to `void` methods like `move()` or `pickThing()`

---

### 💬 Personal Reflection

This project was one of the hardest I’ve done so far, but also one of the most rewarding. I learned how powerful inheritance and method reuse can be, and how it can simplify complex logic like moving game pieces according to dice values. Overall, I gained a lot of experience and confidence in object-oriented design and Java programming.

---
