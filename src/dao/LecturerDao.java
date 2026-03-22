package dao;

import model.entities.Lecturer;

import java.util.ArrayList;
import java.util.List;

public class LecturerDao {
    private static final List<Lecturer> lecturers = new ArrayList<>();
    private static int nextId = 1;

    static {
        lecturers.add(new Lecturer(nextId++, "EMP100", "Dr. Heather", "Computer Science", "heather@example.com"));
    }

    public static Lecturer addLecturer(Lecturer lecturer) {
        lecturer.setId(nextId++);
        lecturers.add(lecturer);
        return lecturer;
    }

    public static List<Lecturer> getAllLecturers() {
        return new ArrayList<>(lecturers);
    }
}

