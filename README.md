# 💼 Virtual Financial Portfolio

A Java-based console application that simulates an investment portfolio management system with **buy/sell transactions, portfolio valuation, CSV persistence, and advanced Object-Oriented Programming concepts**.

## 📌 Overview

The Virtual Financial Portfolio is an interactive console-based investment management application designed to manage stock holdings and perform basic portfolio transactions.

The application allows users to buy and sell stocks, view their current portfolio, calculate the total portfolio value, and save portfolio data to a CSV file. The project demonstrates practical implementation of **Inheritance, Polymorphism, Abstraction, Interfaces, Java Collections, and Java I/O**.

## ✨ Features

* Buy stocks
* Sell stocks
* Track stock quantities
* Store stock name and unit price
* View complete investment portfolio
* Calculate total portfolio value
* Validate available stock quantity before selling
* Save portfolio data to `portfolio.csv`
* Interactive console-based menu
* Continuous transaction processing
* Formatted portfolio reports
* CSV-based data persistence

## 💰 Transaction Operations

### Buy Stock

Users can purchase a stock by providing:

* Stock name
* Unit price
* Quantity

If the stock already exists in the portfolio, its quantity is increased. Otherwise, a new stock object is created and added to the portfolio.

### Sell Stock

Users can sell stocks by specifying:

* Stock name
* Quantity

The application verifies whether sufficient quantity is available before completing the transaction.

### Portfolio Valuation

The system calculates the total portfolio value using:

```text
Portfolio Value = Quantity × Unit Price
```

The total value is calculated across all stocks held in the portfolio.

## 💾 Data Persistence

Portfolio data can be saved to a CSV file using Java I/O streams.

The generated file is:

```text
portfolio.csv
```

The CSV contains:

```text
ItemName,Quantity,UnitPrice,Total
```

This allows the portfolio information to be stored in a structured text-based format.

## 🛠️ Technologies Used

* **Java**
* **Object-Oriented Programming (OOP)**
* **Java Collections Framework**
* **Java I/O Streams**
* **CSV File Handling**
* **Console / Command-Line Interface**

## 🎯 OOP Concepts Demonstrated

### Inheritance

`Stock` inherits from the abstract `FinancialProduct` class:

```java
class Stock extends FinancialProduct
```

This allows common financial product properties such as name, price, and quantity to be defined in the parent class.

### Abstraction

`FinancialProduct` is implemented as an abstract class that provides a common structure for financial products.

```java
abstract class FinancialProduct
```

### Interface

The `Tradable` interface defines the basic transactional operations:

```java
interface Tradable {
    void buy(int qty);
    void sell(int qty);
}
```

The `Stock` class implements this interface.

### Polymorphism

The `Stock` class provides its own implementation of the `buy()` and `sell()` methods defined by the `Tradable` interface.

```java
@Override
public void buy(int qty)

@Override
public void sell(int qty)
```

This demonstrates polymorphic behavior through interface-based method implementation.

### Encapsulation

The properties of `FinancialProduct` are controlled through methods such as:

```java
getName()
getPrice()
getQuantity()
```

This provides controlled access to portfolio data.

## 📚 Java Concepts Demonstrated

* Abstract classes
* Interfaces
* Inheritance
* Polymorphism
* Encapsulation
* Method overriding
* Constructors
* ArrayList
* Enhanced for loops
* Scanner
* File I/O
* PrintWriter
* Try-with-resources
* Exception handling
* Switch statements
* CSV data handling

## 📂 Project Structure

```text
Virtual-Financial-Portfolio/
│
├── VirtualFinancialPortfolio.java
├── portfolio.csv
└── README.md
```

> `portfolio.csv` is generated when the **Save Portfolio** option is selected.

## 🔄 How It Works

1. The application starts with an interactive console menu.
2. The user selects an operation.
3. For **Buy Stock**, the user enters the stock name, unit price, and quantity.
4. For **Sell Stock**, the application checks whether the requested quantity is available.
5. **View Portfolio** displays all current holdings.
6. **Save Portfolio** exports the portfolio to `portfolio.csv`.
7. **View Portfolio Value** calculates the total value of all holdings.
8. The user can continue performing transactions until selecting **Exit**.

## 📋 Menu Options

```text
1. Buy Stock
2. Sell Stock
3. View Portfolio
4. Save Portfolio
5. View Portfolio Value
6. Exit
```

## ▶️ How to Run

Make sure **Java/JDK** is installed on your system.

Compile the application:

```bash
javac VirtualFinancialPortfolio.java
```

Run the application:

```bash
java VirtualFinancialPortfolio
```

The interactive investment portfolio menu will then be displayed in the console.

## 🎯 Project Objective

The objective of this project is to **code a database-persisted investment portfolio console engine** while applying advanced Object-Oriented Programming principles and Java I/O techniques.

The implementation focuses on:

* Inheritance
* Polymorphism
* Interfaces
* Abstraction
* Transactional Buy/Sell operations
* Java Collections Framework
* CSV-based data persistence
* Java I/O streams
* Interactive console menus

## 📋 Project Requirements

The project fulfills the following requirements:

* Leverage advanced **Object-Oriented Programming** properties including Inheritance, Polymorphism, Abstraction, and Interfaces.
* Manage financial products using a structured class hierarchy.
* Implement basic transactional mechanics through Buy/Sell operations.
* Store and retrieve portfolio information using Java I/O streams and CSV storage.
* Use Java Collections Framework, specifically `ArrayList`, to manage portfolio holdings.
* Provide an interactive console-based menu for user operations.
* Implement exception handling and try-with-resources for safe file operations.

## 🚀 Purpose

This project was developed to strengthen advanced Java and Object-Oriented Programming skills by implementing a practical investment portfolio management system with transactional operations, financial product modeling, collection management, and persistent CSV-based storage.

## 👨‍💻 Author

Developed by: Muhammad Reza<br>
Institute: DHA Suffa University<br>
LinkedIn: https://www.linkedin.com/in/muhammad-reza-rawjani
