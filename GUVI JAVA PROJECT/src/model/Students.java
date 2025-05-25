package model;
/**
 * Simple class to represent a student attempting the quiz.
 * It stores the name, roll number, and course name.
 */
public class Students {
    private String name;
    private String rollNo;
    private String courseName;
    // Constructor to initialize all student details
    public Students(String name, String rollNo, String courseName) {
        this.name = name;
        this.rollNo = rollNo;
        this.courseName = courseName;
    }
    // Getter methods
    public String getName() {
        return name;
    }
     public String getRollNo() {
        return rollNo;
    }
    public String getCourseName() {
        return courseName;
    }
}
