package model;
/**
 * Represents a single quiz question.
 */
public class Question {
    private int id;
    private String question;
    private String optionA, optionB, optionC, optionD;
    private char correctAnswer;
    public Question(int id, String question, String optionA, String optionB, String optionC, String optionD, char correctAnswer) {
        this.id = id;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
    }
    // Getters
    public int getId() { return id; }
    public String getQuestion() { return question; }
    public String getOptionA() { return optionA; }
    public String getOptionB() { return optionB; }
    public String getOptionC() { return optionC; }
    public String getOptionD() { return optionD; }
    public char getCorrectAnswer() { return correctAnswer; }
}