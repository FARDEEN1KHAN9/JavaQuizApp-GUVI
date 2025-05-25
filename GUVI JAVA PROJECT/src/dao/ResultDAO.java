package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import utilities.DBConnection;
public class ResultDAO {
	public void saveResult(int studentId, int score, String grade) {
        String query = "INSERT INTO quiz_results (student_id, score, grade) VALUES (?, ?, ?)";
try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, studentId);
            ps.setInt(2, score);
            ps.setString(3, grade);
            ps.executeUpdate();
            System.out.println("Result saved successfully.");
        } catch (Exception e) {
            System.err.println("Error saving result: " + e.getMessage());
        }
    }
}


