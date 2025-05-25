package dao;

import model.Question;
import utilities.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Data Access Object (DAO) for retrieving quiz questions from the database.
 */
public class QuestionDAO {
     /**
     * Retrieves all quiz questions from the database.
     * @return List of Question objects.
     */
    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
        String query = "SELECT * FROM Questions";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
        	while (rs.next()) {
                Question q = new Question(
                    rs.getInt("id"),
                    rs.getString("question_text"),
                    rs.getString("option_a"),
                    rs.getString("option_b"),
                    rs.getString("option_c"),
                    rs.getString("option_d"),
                    rs.getString("correct_answer").charAt(0)
                );
                questions.add(q);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching questions: " + e.getMessage());
        }
        return questions;
    }
}