package view;

import dao.UserDao;
import model.entities.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {
    private final JTextField usernameField = new JTextField(16);
    private final JPasswordField passwordField = new JPasswordField(16);
    private final JComboBox<String> roleCombo = new JComboBox<>(new String[]{"STUDENT", "LECTURER", "ADMIN"});

    public LoginView() {
        setTitle("Login - Student Management System");
        setSize(360, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));

        JPanel form = new JPanel(new GridLayout(4, 2, 6, 6));
        form.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        form.add(new JLabel("Username:"));
        form.add(usernameField);
        form.add(new JLabel("Password:"));
        form.add(passwordField);
        form.add(new JLabel("Role:"));
        form.add(roleCombo);

        JButton loginButton = new JButton("Login");
        JButton cancelButton = new JButton("Cancel");

        loginButton.addActionListener(this::handleLogin);
        cancelButton.addActionListener(e -> System.exit(0));

        form.add(loginButton);
        form.add(cancelButton);

        add(form, BorderLayout.CENTER);
    }

    private void handleLogin(ActionEvent e) {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());
        String role = roleCombo.getSelectedItem().toString();

        User user = UserDao.authenticate(username, password, role);
        if (user == null) {
            JOptionPane.showMessageDialog(this, "Invalid username/password/role", "Authentication Failed", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Login successful as " + role, "Welcome", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();

        if ("ADMIN".equalsIgnoreCase(role)) {
            new AdminDashboard(user).setVisible(true);
        } else if ("LECTURER".equalsIgnoreCase(role)) {
            new LecturerDashboard(user).setVisible(true);
        } else {
            new MainView().setVisible(true);
        }
    }

    public static void showLogin() {
        SwingUtilities.invokeLater(() -> new LoginView().setVisible(true));
    }
}
