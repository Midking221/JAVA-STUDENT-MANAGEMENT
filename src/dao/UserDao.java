package dao;

import model.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static final List<User> users = new ArrayList<>();

    static {
        users.add(new User("admin", "admin123", "ADMIN"));
        users.add(new User("lecturer", "lect123", "LECTURER"));
        users.add(new User("student", "student123", "STUDENT"));
    }

    public static User authenticate(String username, String password, String role) {
        return users.stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password) && u.getRole().equalsIgnoreCase(role))
                .findFirst()
                .orElse(null);
    }
}
