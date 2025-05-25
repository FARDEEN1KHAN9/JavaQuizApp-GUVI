package ui;

import dao.QuestionDAO;
import model.Question;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
/**
 * Main GUI class for displaying the quiz application.
 */
public class JavaQuizApp extends JFrame implements ActionListener {
	private List<Character> studentAnswers = new ArrayList<>();
	private static final long serialVersionUID = 1L;
	private final List<Question> questions;
    private int current = 0, score = 0;
    private final JLabel questionLabel;
    private final JRadioButton[] options;
    private final ButtonGroup group;
    private final JButton nextButton;
    public JavaQuizApp() {
        setTitle("Java Quiz App");
        setSize(600, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        questions = new QuestionDAO().getAllQuestions();
        System.out.println("Questions loaded: " + questions.size());

        questionLabel = new JLabel("", JLabel.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(questionLabel, BorderLayout.NORTH);

        JPanel optionPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        options = new JRadioButton[4];
        group = new ButtonGroup();
        for (int i = 0; i < options.length; i++) {
            options[i] = new JRadioButton();
            options[i].setFont(new Font("Arial", Font.PLAIN, 14));
            group.add(options[i]);
            optionPanel.add(options[i]);
        }
        add(optionPanel, BorderLayout.CENTER);
        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.BOLD, 14));
        nextButton.addActionListener(this);
        add(nextButton, BorderLayout.SOUTH);
        loadQuestion();
    }
    private void loadQuestion() {
    	System.out.println("Current question index: " + current);
        if (current >= questions.size()) {
            showScore();  // ✅ should stop here
            return;
        }
        Question q = questions.get(current);
        questionLabel.setText("Q" + (current + 1) + ": " + q.getQuestion());
        options[0].setText("A) " + q.getOptionA());
        options[1].setText("B) " + q.getOptionB());
        options[2].setText("C) " + q.getOptionC());
        options[3].setText("D) " + q.getOptionD());
        group.clearSelection();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (current < questions.size()) {
            char selected = getSelectedOption();
            
            if (selected == ' ') {
                JOptionPane.showMessageDialog(this, "Please select an option before proceeding.");
                return;
            }
            // ✅ Save the student's selected answer
            studentAnswers.add(selected);
            // ✅ Increase score if correct
            if (selected == questions.get(current).getCorrectAnswer()) {
                score++;
            }
            current++; // go to next question
            loadQuestion(); // load next question
        }
    }
        private char getSelectedOption() {
        for (int i = 0; i < options.length; i++) {
            if (options[i].isSelected()) {
                return (char) ('A' + i);
            }
        }
        return ' ';
    }
        private void showScore() {
            StringBuilder feedback = new StringBuilder();
            feedback.append("🎉 Congratulations! You've completed the quiz!\n\n");
            feedback.append("Score: ").append(score).append(" / ").append(questions.size()).append("\n");
            // ✅ Calculate grade
            String grade;
            double percentage = (double) score / questions.size() * 100;

            if (percentage >= 90) {
                grade = "Outstanding";
            } else if (percentage >= 75) {
                grade = "Very Good";
            } else if (percentage >= 60) {
                grade = "Average";
            } else if (percentage >= 40) {
                grade = "Below Average";
            } else {
                grade = "Fail";
            }
            feedback.append("Grade: ").append(grade).append("\n\n");
            // ✅ Add question-by-question review
            for (int i = 0; i < questions.size(); i++) {
                Question q = questions.get(i);
                char studentAns = studentAnswers.get(i);
                char correctAns = q.getCorrectAnswer();

                feedback.append("--------------------------------------------------\n");
                feedback.append("Q").append(i + 1).append(": ").append(q.getQuestion()).append("\n");
                feedback.append("Your Answer: ").append(studentAns).append(") ").append(getOptionText(q, studentAns)).append("\n");
                feedback.append("Correct Answer: ").append(correctAns).append(") ").append(getOptionText(q, correctAns)).append("\n");

                if (studentAns == correctAns) {
                    feedback.append("✅ Correct\n");
                } else {
                    feedback.append("❌ Incorrect\n");
                }
                feedback.append("--------------------------------------------------\n\n");
            }
            // ✅ Save result to database
            saveResultToDatabase(score, grade);
           // ✅ Show feedback in scrollable text area
            JTextArea textArea = new JTextArea(feedback.toString());
            textArea.setEditable(false);
            textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(700, 500));
            // ✅ Show final popup and wait for OK
            int choice = JOptionPane.showConfirmDialog(this,
                    scrollPane,
                    "Quiz Feedback - Review Your Answers",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);
            if (choice == JOptionPane.OK_OPTION || choice == JOptionPane.CANCEL_OPTION) {
                dispose(); // close window
            }
        }
    private void saveResultToDatabase(int score, String grade) {
        int studentId = ui.StudentInfoForm.studentId;

        if (studentId != -1) {
            new dao.ResultDAO().saveResult(studentId, score, grade);
        } else {
            System.err.println("Student ID not found. Result not saved.");
        }
    }
    private String getOptionText(Question q, char option) {
        switch (option) {
            case 'A': return q.getOptionA();
            case 'B': return q.getOptionB();
            case 'C': return q.getOptionC();
            case 'D': return q.getOptionD();
            default: return "Not Answered";
        }
    }
	}

    
