# Student Library & Course Management System (Java, MVC, MySQL)

## Overview
This project implements an MVC desktop application in Java (Swing) with a MySQL database.

### Features:
- Student management (create, list)
- Lecturer management scaffold
- Course management (create, list)
- Library management (add book, list, search with live filter)
- Result class for grades, and borrowing/reservation domain logic

## Project structure
- `schema.sql` - MySQL schema and relationships
- `src/database/DBConnection.java` - JDBC connection helper
- `src/model/entities` - domain model classes
- `src/dao` - data access layer
- `src/controller` - business logic
- `src/view/MainView.java` - Swing main GUI and entry point

## Installation
1. Run MySQL script:
   - `mysql -u root -p < schema.sql`
2. Update DB credentials in `src/database/DBConnection.java`.
3. Compile:
   - `javac -d bin src/database/DBConnection.java src/model/entities/*.java src/dao/*.java src/controller/*.java src/view/MainView.java`
4. Run:
   - `java -cp bin view.MainView`

## UML diagrams (textual)
### Use case (text)
Actors: Admin, Lecturer, Student.
- Admin: manage students, manage lecturers, manage courses, view reports.
- Lecturer: view assigned courses, view enrolled students, record scores.
- Student: register for courses, view courses, borrow books, reserve books, check results.

### Structural class diagram (brief)
- `MainView` (View) uses controllers:
  - `StudentController` -> `StudentDao` -> `students`
  - `CourseController` -> `CourseDao` -> `courses`
  - `LibraryController` -> `BookDao` -> `books`
- Entities: `Student`, `Lecturer`, `Course`, `Book`, `Result`, `Borrowing`, `Reservation`.
- `DBConnection` provides shared DB connection.

### Sequence (borrow book) text
1. Student requests borrow from `MainView` UI.
2. `LibraryController` checks `BookDao` availability.
3. if available, decrement `available_copies` and add `borrowed_books` record.
4. respond with success/failure.

### Activity (reserve book) text
- user submits book title -> search available books
- if none available -> create reservation `reservations` record
- admin/librarian later fulfills, updates `fulfilled`.
