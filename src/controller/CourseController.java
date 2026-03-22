package controller;

import dao.CourseDao;
import model.entities.Course;

import java.sql.SQLException;
import java.util.List;

public class CourseController {
    public Course createCourse(String courseCode, String title, int credits) throws SQLException {
        Course course = new Course(courseCode, title, credits);
        return CourseDao.addCourse(course);
    }

    public List<Course> listCourses() throws SQLException {
        return CourseDao.getAllCourses();
    }

    public Course findCourse(String code) throws SQLException {
        return CourseDao.findByCode(code);
    }
}
