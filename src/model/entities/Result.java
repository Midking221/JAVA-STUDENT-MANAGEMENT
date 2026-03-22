package model.entities;

public class Result {
    private int id;
    private int studentId;
    private int courseId;
    private int cat;
    private int exam;

    public Result() {}

    public Result(int id, int studentId, int courseId, int cat, int exam) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.cat = cat;
        this.exam = exam;
    }

    public Result(int studentId, int courseId, int cat, int exam) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.cat = cat;
        this.exam = exam;
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

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCat() {
        return cat;
    }

    public void setCat(int cat) {
        this.cat = cat;
    }

    public int getExam() {
        return exam;
    }

    public void setExam(int exam) {
        this.exam = exam;
    }

    public int getTotal() {
        return cat + exam;
    }

    public String getGrade() {
        int total = getTotal();
        if (total >= 70) return "A";
        if (total >= 60) return "B";
        if (total >= 50) return "C";
        if (total >= 40) return "D";
        return "F";
    }
}
