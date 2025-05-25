package dao;

import model.Students;
import utilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * This class is responsible for saving student details into the database.
 */
public class StudentsDao {
     /**
     * Inserts a new student record into the 'students' table.
     * @param student The student object to be saved.
     */
	public int saveStudent(Students student) {
	    int generatedId = -1;
	    String query = "INSERT INTO students (name, roll_no, course_name) VALUES (?, ?, ?)";
	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, student.getName());
	        ps.setString(2, student.getRollNo());
	        ps.setString(3, student.getCourseName());
	        ps.executeUpdate();

	        ResultSet rs = ps.getGeneratedKeys();
	        if (rs.next()) {
	            generatedId = rs.getInt(1); // get auto-generated student_id
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return generatedId;
	}
}


