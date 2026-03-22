package controller;

import dao.CourseDao;
import dao.StudentDao;
import java.sql.SQLException;
import java.util.List;
import model.entities.Course;
import model.entities.Student;

public class StudentController {
    public Student createStudent(String regNo, String fullName, String programme, String email) throws SQLException {
        Student student = new Student(regNo, fullName, programme, email);
        return StudentDao.addStudent(student);
    }

    public List<Student> getStudents() throws SQLException {
        return StudentDao.getAllStudents();
    }

    public Student findStudentByRegNo(String regNo) throws SQLException {
        return StudentDao.findByRegNo(regNo);
    }

    public List<Course> getAllCourses() throws SQLException {
        return CourseDao.getAllCourses();
    }
}
