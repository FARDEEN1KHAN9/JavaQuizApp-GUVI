# JavaQuizApp-GUVI
The JavaQuizApp is an interactive quiz application designed to enhance learning through engaging multiple-choice questions. Built using Java, this application provides users with a platform to test their knowledge across various subjects.
Java Quiz App – GUI Based Project
🎯 A GUI-based Java application that allows students to take a quiz, enter their name and course, receive a grade and feedback, and stores results in a MySQL database for teacher review.

📦 Features
Student Info Form (name, roll no, course)
Multiple-choice questions from MySQL
Java Swing GUI interface
Grade calculation (Outstanding, Average, Fail, etc.)
Feedback showing correct/wrong answers
Stores results in MySQL (quiz_results table)
📁 Folder Structure
JavaQuizApp/ ├── src/ │ ├── ui/ │ ├── model/ │ ├── dao/ │ └── utilities/ ├── quizdb.sql ├── JavaQuizApp-Presentation.pptx └── README.md

🛠️ Technologies Used
Java (Swing + JDBC)
MySQL (Workbench)
Eclipse IDE
GitHub
📊 Database Design
students: name, roll_no, course
questions: all quiz questions and options
quiz_results: stores student scores, grade, and timestamp
Use quizdb.sql to create and restore your database.

🖥️ How to Run This Project
Clone or download this repo
Import into Eclipse as a Java project
Run quizdb.sql in MySQL Workbench
Update DB password in DBConnection.java
Run Main.java to start the app
👤 Author/Admin
FARDEEN KHAN (24SECE1290012).
https://github.com/FARDEEN1KHAN
📝 License
This project is for academic use (GUVI - Review 1).

MIT Licensed.
