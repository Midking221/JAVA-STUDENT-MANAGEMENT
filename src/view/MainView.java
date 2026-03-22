package view;

import controller.CourseController;
import controller.LibraryController;
import controller.StudentController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.entities.Book;
import model.entities.Course;
import model.entities.Student;

public class MainView extends JFrame {
    private final StudentController studentController = new StudentController();
    private final CourseController courseController = new CourseController();
    private final LibraryController libraryController = new LibraryController();

    public MainView() {
        setTitle("Student Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);

        JTabbedPane tabPane = new JTabbedPane();
        tabPane.addTab("Students", createStudentsPanel());
        tabPane.addTab("Courses", createCoursesPanel());
        tabPane.addTab("Library", createLibraryPanel());

        add(tabPane);
    }

    private JPanel createStudentsPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JPanel form = new JPanel(new GridLayout(5, 2, 6, 6));

        JTextField regNo = new JTextField();
        JTextField fullName = new JTextField();
        JTextField programme = new JTextField();
        JTextField email = new JTextField();

        JButton addStudent = new JButton("Add Student");

        form.add(new JLabel("Registration Number"));
        form.add(regNo);
        form.add(new JLabel("Full Name"));
        form.add(fullName);
        form.add(new JLabel("Programme"));
        form.add(programme);
        form.add(new JLabel("Email"));
        form.add(email);
        form.add(new JLabel());
        form.add(addStudent);

        String[] columns = {"ID", "Reg No", "Name", "Programme", "Email"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        table.setAutoCreateRowSorter(true);

        addStudent.addActionListener((ActionEvent e) -> {
            try {
                Student student = studentController.createStudent(regNo.getText(), fullName.getText(), programme.getText(), email.getText());
                JOptionPane.showMessageDialog(this, "Student created: " + student.getFullName());
                refreshStudentsTable(model);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error adding student: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        try {
            refreshStudentsTable(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading students: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        panel.add(form, BorderLayout.NORTH);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }

    private void refreshStudentsTable(DefaultTableModel model) throws SQLException {
        model.setRowCount(0);
        List<Student> students = studentController.getStudents();
        for (Student s : students) {
            model.addRow(new Object[]{s.getId(), s.getRegistrationNumber(), s.getFullName(), s.getProgramme(), s.getEmail()});
        }
    }

    private JPanel createCoursesPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JPanel form = new JPanel(new GridLayout(4, 2, 6, 6));

        JTextField code = new JTextField();
        JTextField title = new JTextField();
        JTextField credits = new JTextField();

        JButton addCourse = new JButton("Add Course");

        form.add(new JLabel("Course Code"));
        form.add(code);
        form.add(new JLabel("Title"));
        form.add(title);
        form.add(new JLabel("Credits"));
        form.add(credits);
        form.add(new JLabel());
        form.add(addCourse);

        String[] columns = {"ID", "Code", "Title", "Credits"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        table.setAutoCreateRowSorter(true);

        addCourse.addActionListener(e -> {
            try {
                int cr = Integer.parseInt(credits.getText());
                Course course = courseController.createCourse(code.getText(), title.getText(), cr);
                JOptionPane.showMessageDialog(this, "Course created: " + course.getTitle());
                refreshCoursesTable(model);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "Credits must be numeric", "Input Error", JOptionPane.WARNING_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error adding course: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        try {
            refreshCoursesTable(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading courses: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        panel.add(form, BorderLayout.NORTH);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }

    private void refreshCoursesTable(DefaultTableModel model) throws SQLException {
        model.setRowCount(0);
        List<Course> courses = courseController.listCourses();
        for (Course c : courses) {
            model.addRow(new Object[]{c.getId(), c.getCourseCode(), c.getTitle(), c.getCredits()});
        }
    }

    private JPanel createLibraryPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JPanel top = new JPanel(new BorderLayout(4, 4));

        JTextField searchField = new JTextField();
        JButton refreshButton = new JButton("Refresh");

        String[] columns = {"ID", "ISBN", "Title", "Edition", "Version", "Year", "Total", "Avail"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        table.setAutoCreateRowSorter(true);

        top.add(new JLabel("Search by title:"), BorderLayout.WEST);
        top.add(searchField, BorderLayout.CENTER);
        top.add(refreshButton, BorderLayout.EAST);

        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search();
            }

            private void search() {
                try {
                    String text = searchField.getText().trim();
                    List<Book> books = text.isEmpty() ? libraryController.listBooks() : libraryController.searchBooks(text);
                    model.setRowCount(0);
                    for (Book b : books) {
                        model.addRow(new Object[]{b.getId(), b.getIsbn(), b.getTitle(), b.getEdition(), b.getVersion(), b.getYearPublished(), b.getTotalCopies(), b.getAvailableCopies()});
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(MainView.this, "Error searching books: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        refreshButton.addActionListener(e -> {
            try {
                List<Book> books = libraryController.listBooks();
                model.setRowCount(0);
                for (Book b : books) {
                    model.addRow(new Object[]{b.getId(), b.getIsbn(), b.getTitle(), b.getEdition(), b.getVersion(), b.getYearPublished(), b.getTotalCopies(), b.getAvailableCopies()});
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error loading books: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(top, BorderLayout.NORTH);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) {
        }

        LoginView.showLogin();
    }
}
