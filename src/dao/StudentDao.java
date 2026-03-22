package dao;

import java.util.ArrayList;
import java.util.List;
import model.entities.Student;

public class StudentDao {
    private static final List<Student> students = new ArrayList<>();
    private static int nextId = 1;

    static {
        students.add(new Student(nextId++, "2024001", "Alice Johnson", "BSc Computer Science", "alice@example.com"));
        students.add(new Student(nextId++, "2024002", "Bob Smith", "BSc Information Systems", "bob@example.com"));
    }

    public static Student addStudent(Student student) {
        student.setId(nextId++);
        students.add(student);
        return student;
    }

    public static List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public static Student findByRegNo(String regNo) {
        return students.stream()
                .filter(s -> s.getRegistrationNumber().equalsIgnoreCase(regNo))
                .findFirst()
                .orElse(null);
    }
}
