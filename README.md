# BookStore
Java school project - Library Management System

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Classes](#classes)
  - [myapp.Book](#book)
  - [myapp.User](#user)
  - [BookLoanManagement](#bookloanmanagement)
- [Getting Started](#getting-started)
- [Usage](#usage)

## Introduction

The BookStore project is a Java-based Library Management System designed to assist librarians and library staff in efficiently managing the library's resources. It provides functionalities for adding and removing books, managing user information, and handling book loans.

## Features

List the key features of your Library Management System.

- **myapp.Book Management:**
  - Add a new book
  - Remove a book
  - Display a list of all books

- **myapp.User Management:**
  - Add a new user
  - Remove a user
  - Display a list of all users

- **myapp.Book Loan Management:**
  - Check out a book to a user
  - Return a book
  - Display a list of all book loans

## Classes

The main class in this project is `BookLoanManagement`. It manages users with their list of borrowed books, their payment, and also saves all the necessary information.

### myapp.Book

The `myapp.Book` class represents a book in the library. It contains information such as the book's title, author, ISBN, and availability status.

### myapp.User

The `myapp.User` class represents a library user. It includes information such as the user's name, contact details, and a unique user ID.

### BookLoanManagement

The `BookLoanManagement` class manages the book loans in the library. It facilitates checking out books to users, returning books, and keeps track of loan history.

## Getting Started

To run this application, specify in the arguments whether you want to run the application as an admin or a user. Then, choose a number for different functionalities.

## Usage

Provide instructions on how users can interact with your Library Management System and give examples of common commands or operations.
