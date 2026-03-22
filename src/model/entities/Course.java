package model.entities;

public class Course {
    private int id;
    private String courseCode;
    private String title;
    private int credits;

    public Course() {
    }

    public Course(int id, String courseCode, String title, int credits) {
        this.id = id;
        this.courseCode = courseCode;
        this.title = title;
        this.credits = credits;
    }

    public Course(String courseCode, String title, int credits) {
        this.courseCode = courseCode;
        this.title = title;
        this.credits = credits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%d credits)", courseCode, title, credits);
    }
}
