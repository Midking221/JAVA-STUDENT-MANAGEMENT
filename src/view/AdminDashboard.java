package view;

import model.entities.User;

import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends JFrame {
    public AdminDashboard(User user) {
        setTitle("Admin Dashboard - " + user.getUsername());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 650);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Admin dashboard under construction", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 20));

        add(label);
    }
}
