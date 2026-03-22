package model.entities;

import java.time.LocalDate;

public class Reservation {
    private int id;
    private int studentId;
    private int bookId;
    private LocalDate reservedAt;
    private boolean fulfilled;

    public Reservation() {}

    public Reservation(int studentId, int bookId, LocalDate reservedAt) {
        this.studentId = studentId;
        this.bookId = bookId;
        this.reservedAt = reservedAt;
        this.fulfilled = false;
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

    public LocalDate getReservedAt() {
        return reservedAt;
    }

    public void setReservedAt(LocalDate reservedAt) {
        this.reservedAt = reservedAt;
    }

    public boolean isFulfilled() {
        return fulfilled;
    }

    public void setFulfilled(boolean fulfilled) {
        this.fulfilled = fulfilled;
    }
}
