# Expense Tracker

A console-based Expense Tracker built using Java. The application allows users to manage income and expenses, view transaction history, search transactions by category, and generate financial summaries. Transaction data is stored in a file so that it persists between program runs.

## Features

* Add Income
* Add Expense
* View Current Balance
* View Transaction History
* Search Transactions by Category
* Financial Summary Dashboard
* Save Transactions to File
* Load Transactions from File
* Transaction IDs
* Transaction Categories
* Transaction Timestamps

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* ArrayList
* File Handling
* Git & GitHub

## Project Structure

```text
ExpenseTracker
│
├── Main.java
├── Transaction.java
├── transactions.txt
└── README.md
```

## How to Run

Compile the project:

```bash
javac *.java
```

Run the application:

```bash
java Main
```

## Sample Features

### Add Income

```text
Enter Income Amount: 5000
Enter Category: Salary
Income Added Successfully!
```

### Add Expense

```text
Enter Expense Amount: 1200
Enter Category: Food
Expense Added Successfully!
```

### Financial Summary

```text
===== Financial Summary =====

Total Income      : ₹10000.0
Total Expense     : ₹4000.0
Net Savings       : ₹6000.0

Highest Expense:
Category : Rent
Amount   : ₹2500.0
```

## Future Improvements

* Delete Transactions
* Edit Transactions
* Monthly Reports
* Java Swing GUI
* Database Integration (MySQL)

## Author

Ramachandran K S
