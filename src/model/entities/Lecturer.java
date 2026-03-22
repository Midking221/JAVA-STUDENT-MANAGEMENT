package model.entities;

public class Lecturer {
    private int id;
    private String employeeId;
    private String fullName;
    private String department;
    private String email;

    public Lecturer() {
    }

    public Lecturer(int id, String employeeId, String fullName, String department, String email) {
        this.id = id;
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.department = department;
        this.email = email;
    }

    public Lecturer(String employeeId, String fullName, String department, String email) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.department = department;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - %s", fullName, employeeId, department);
    }
}
