package model.entities;

import java.time.LocalDate;

public class Borrowing {
    private int id;
    private int studentId;
    private int bookId;
    private LocalDate borrowedAt;
    private LocalDate dueDate;
    private LocalDate returnedAt;

    public Borrowing() {}

    public Borrowing(int studentId, int bookId, LocalDate borrowedAt, LocalDate dueDate) {
        this.studentId = studentId;
        this.bookId = bookId;
        this.borrowedAt = borrowedAt;
        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public LocalDate getBorrowedAt() {
        return borrowedAt;
    }

    public void setBorrowedAt(LocalDate borrowedAt) {
        this.borrowedAt = borrowedAt;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(LocalDate returnedAt) {
        this.returnedAt = returnedAt;
    }

    public boolean isOverdue() {
        return returnedAt == null && LocalDate.now().isAfter(dueDate);
    }
}
