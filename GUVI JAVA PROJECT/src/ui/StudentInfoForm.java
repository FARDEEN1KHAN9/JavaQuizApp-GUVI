package ui;

import model.Students;
import dao.StudentsDao;
import javax.swing.*;
import java.awt.*;
/**
 * Simple form to collect student details before starting the quiz.
 */
public class StudentInfoForm extends JFrame {
	public static int studentId = -1;  // Used to pass student ID to the quiz
    private JTextField nameField, rollField, courseField;
    private JButton startQuizButton;
    public StudentInfoForm() {
        setTitle("Student Information");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));
        // Create form labels and fields
        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Roll Number:"));
        rollField = new JTextField();
        add(rollField);

        add(new JLabel("Course Name:"));
        courseField = new JTextField();
        add(courseField);

        // Empty label for layout spacing
        add(new JLabel(""));

        // Start Quiz button
        startQuizButton = new JButton("Start Quiz");
        add(startQuizButton);

        // Button click action
        startQuizButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String roll = rollField.getText().trim();
            String course = courseField.getText().trim();

            // Validate form
            if (name.isEmpty() || roll.isEmpty() || course.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.");
                return;
            }

            // Save student to database
            Students student = new Students(name, roll, course);
            StudentInfoForm.studentId = new StudentsDao().saveStudent(student);
            studentId = new StudentsDao().saveStudent(student);

            // Start the quiz
            dispose(); // close this form
            new JavaQuizApp().setVisible(true); // open quiz
        });
    }
}
