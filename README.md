# Pharmacy System — OOP Project

**Course:** CSIS215
**Language:** Java

---

##  What’s This Project About?

This is a simple **Pharmacy System** built in Java as part of my Object-Oriented Programming course. The system helps manage medicines in a pharmacy — adding new ones, updating info, and keeping everything organized.

It’s a menu-based program that uses **Object-Oriented Programming concepts** like inheritance, encapsulation, and polymorphism to make the system clean and easy to expand.

---

## How It Works

The project uses a **main file** that shows a menu for the user and connects to different classes that handle medicines. There are three main types of files:

1. **OOP_Project.java** — This is where the program starts. It shows a menu to the user and calls functions from other classes.

2. **Medicine.java** — This is the main blueprint for any medicine. It includes:

   * Name, composition, dose, price, quantity
   * Getters and setters to read or change info
   * Methods to display medicine details and compare medicines

3. **OverTheCounter.java** — For medicines you can buy without a prescription.

4. **Prescription.java** — For medicines that need a prescription.

---

##  Features

* Add new medicines to the system
* View details of medicines
* Update or delete medicine information
* Compare medicines by name and dose
* Menu-based interaction for easy navigation

---

## What I Learned

Working on this project helped me:

* Practice **Object-Oriented Programming** with real-life examples
* Work with **class inheritance** and **polymorphism**
* Design an interactive **menu system**
* Use Java for file handling and object management

---

## 🚀 How to Run It

1. Clone the repo:

```bash
git clone https://github.com/GhinaBouGhannam/Student_Information_System.git
```

2. Compile all files:

```bash
javac *.java
```

3. Run the main program:

```bash
java OOP_Project
```
