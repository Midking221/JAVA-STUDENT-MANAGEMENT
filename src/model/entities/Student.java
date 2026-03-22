package model.entities;

public class Student {
    private int id;
    private String registrationNumber;
    private String fullName;
    private String programme;
    private String email;

    public Student() {
    }

    public Student(int id, String registrationNumber, String fullName, String programme, String email) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.fullName = fullName;
        this.programme = programme;
        this.email = email;
    }

    public Student(String registrationNumber, String fullName, String programme, String email) {
        this.registrationNumber = registrationNumber;
        this.fullName = fullName;
        this.programme = programme;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - %s", fullName, registrationNumber, programme);
    }
}
