# Rest_API_Application
# Book Manager Application
This repository contains a simple Spring Boot application for managing books and authors. The application is built using Java, Spring Boot, and JPA (Java Persistence API). It provides RESTful API endpoints for performing CRUD (Create, Read, Update, Delete) operations on books.

# Project Structure
The project is organized into the following packages:

BookManagerApplication: The main class with the main method to run the Spring Boot application.

entity: Contains the Author and Book entities representing the data model for authors and books.

dao: Includes the repository interface Repository extending JpaRepository for CRUD operations on books.

controller: Defines the RESTful API endpoints for handling book-related requests.

services: Contains the BookService class responsible for business logic and interacting with the repository.

# Entity Classes
# Author
Fields:
authorId: Unique identifier for the author.
name: Name of the author.
dateOfBirth: Date of birth of the author.
nationality: Nationality of the author.
books: One-to-One relationship with the Book entity using JsonBackReference.
# Book
 Fields:
id: Unique identifier for the book.
title: Title of the book.
genre: Genre of the book.
publishedDate: Published date of the book.
author: One-to-One relationship with the Author entity using JsonManagedReference.
# Repository
Repository extends JpaRepository and provides methods for CRUD operations on books.
# Controller
BookController: Handles HTTP requests for book-related operations (GET, POST, PUT, DELETE).
# Services
BookService: Contains methods for business logic related to books, including retrieving all books, getting a single book by ID, adding a new book, updating a book, and deleting a book.
# How to Run
To run the application, execute the main method in the BookManagerApplication class. The application will start, and you can access the RESTful API endpoints for managing books.

# API Endpoints
GET /books: Retrieve a list of all books.
GET /books/{id}: Retrieve details of a specific book by ID.
POST /books: Add a new book.
PUT /books/{id}: Update details of a specific book by ID.
DELETE /books/{id}: Delete a book by ID.

# Screenshot
# IDE
(https://github.com/manku888/Rest_API_Application/assets/119672884/bfe09af1-f0bf-47d5-8c07-88a423cd5fed)


