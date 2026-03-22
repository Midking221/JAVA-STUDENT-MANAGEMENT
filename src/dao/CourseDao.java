package dao;

import model.entities.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseDao {
    private static final List<Course> courses = new ArrayList<>();
    private static int nextId = 1;

    static {
        courses.add(new Course(nextId++, "CS201", "Data Structures", 4));
        courses.add(new Course(nextId++, "CS202", "Algorithms", 4));
    }

    public static Course addCourse(Course course) {
        course.setId(nextId++);
        courses.add(course);
        return course;
    }

    public static List<Course> getAllCourses() {
        return new ArrayList<>(courses);
    }

    public static Course findByCode(String code) {
        return courses.stream().filter(c -> c.getCourseCode().equalsIgnoreCase(code)).findFirst().orElse(null);
    }
}
