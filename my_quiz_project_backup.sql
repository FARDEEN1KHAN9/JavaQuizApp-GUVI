-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: quizguvi
-- ------------------------------------------------------
-- Server version	8.0.42

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `question_text` text NOT NULL,
  `option_a` varchar(255) DEFAULT NULL,
  `option_b` varchar(255) DEFAULT NULL,
  `option_c` varchar(255) DEFAULT NULL,
  `option_d` varchar(255) DEFAULT NULL,
  `correct_answer` char(1) DEFAULT NULL,
  `difficulty_level` varchar(50) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,'What is GUVI?','A programming language','A database management system','A cloud storage service','An online learning platform','D','Easy','Education'),(2,'What is Java?','Java Virtual Machine','A database system','A web browser','A programming language','D','Easy','Programming'),(3,'Which language is used for Android development?','Java','Python','Swift','Ruby','A','Easy','Programming'),(4,'What is the capital of India?','Mumbai','Kolkata','New Delhi','Chennai','C','Easy','Geography'),(5,'What is the chemical symbol for water?','Wo','H2O','H2SO4','HO2','B','Easy','Science'),(6,'What does the ‘static’ keyword do in Java?','Prevents instantiation of a class','Hides the method from subclasses','Allows a variable or method to belong to the class rather than an instance','Stops memory allocation','C','Medium','Programming'),(7,'Which of the following can be used to store key-value pairs in Java?','ArrayList','HashMap','Queue','Stack','B','Medium','Programming'),(8,'What is the currency of Japan?','Won','Yuan','Ringgit','Yen','D','Easy','Geography'),(9,'What is a common symbol of love and romance?','Sending a funny meme','A wilting cactus','A red rose','A broken umbrella','C','Easy','Culture'),(10,'Who is the designated Group Leader of the Teen Titans team?','Garv Saxena','Fardeen Khan','Akshat Trivedi','Rayyan Ali Khan','B','Medium','Entertainment'),(11,'Which of these phrases is most often associated with romantic feelings?','\"You complete me.\"','\"Get off my lawn!\"','\"Can you pass the salt?\"','\"Time is money.\"','A','Medium','Culture'),(12,'Who painted the Mona Lisa?','Vincent van Gogh','Leonardo da Vinci','Michelangelo','Raphael','B','Medium','Art'),(13,'A feeling of great happiness and joy is often described as:','Excitement','Frustration','Disappointment','Jealousy','A','Easy','Emotions'),(14,'A pun is a joke based on:','A play on words with similar sounds but different meanings','A complicated plot','A historical event','A scientific theory','A','Medium','Language'),(15,'Which TV series is famous for the phrase \"Winter is Coming\"?','Vikings','Game of Thrones','The Witcher','The Mandalorian','B','Medium','Entertainment'),(16,'What is a group of lions called?','A flock','A herd','A pride','A school','C','Easy','Biology'),(17,'What is the term for our awareness of ourselves and our environment?','Memory','Consciousness','Intelligence','Personality','B','Medium','Psychology'),(18,'Which of the following is considered the most romantic city in the world?','Venice','New York','Tokyo','Paris','D','Easy','Geography'),(19,'Which planet in our solar system is known as the \"Red Planet\"?','Venus','Jupiter','Saturn','Mars','D','Easy','Astronomy'),(20,'Which famous playwright wrote \"Hamlet\" and \"Romeo and Juliet\"?','Ernest Hemingway','Harper Lee','Tennessee Williams','William Shakespeare','D','Medium','Literature'),(21,'Who developed the theory of relativity?','Albert Einstein','Isaac Newton','Stephen Hawking','Galileo Galilei','A','Medium','Science');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quiz_questions`
--

DROP TABLE IF EXISTS `quiz_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quiz_questions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `question` text NOT NULL,
  `optionA` varchar(255) DEFAULT NULL,
  `optionB` varchar(255) DEFAULT NULL,
  `optionC` varchar(255) DEFAULT NULL,
  `optionD` varchar(255) DEFAULT NULL,
  `correct_answer` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz_questions`
--

LOCK TABLES `quiz_questions` WRITE;
/*!40000 ALTER TABLE `quiz_questions` DISABLE KEYS */;
/*!40000 ALTER TABLE `quiz_questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quiz_results`
--

DROP TABLE IF EXISTS `quiz_results`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quiz_results` (
  `result_id` int NOT NULL AUTO_INCREMENT,
  `student_id` int DEFAULT NULL,
  `score` int DEFAULT NULL,
  `grade` varchar(50) DEFAULT NULL,
  `attempt_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`result_id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `quiz_results_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz_results`
--

LOCK TABLES `quiz_results` WRITE;
/*!40000 ALTER TABLE `quiz_results` DISABLE KEYS */;
INSERT INTO `quiz_results` VALUES (1,3,0,'Fail','2025-05-23 18:51:52'),(2,5,0,'Fail','2025-05-23 18:56:48'),(3,7,0,'Fail','2025-05-23 18:57:36'),(4,11,17,'Very Good','2025-05-23 19:07:05');
/*!40000 ALTER TABLE `quiz_results` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `student_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `roll_no` varchar(50) DEFAULT NULL,
  `course` varchar(100) DEFAULT NULL,
  `course_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'Test Student','12345',NULL,'Computer Science'),(2,'cac','casc',NULL,'cascs'),(3,'cac','casc',NULL,'cascs'),(4,'fvfdvd','vsv',NULL,'vsv'),(5,'fvfdvd','vsv',NULL,'vsv'),(6,'dewd','edqed',NULL,'dqd'),(7,'dewd','edqed',NULL,'dqd'),(8,'s','s',NULL,'s'),(9,'s','s',NULL,'s'),(10,'FARDEEN','XY',NULL,'DEMO TRY'),(11,'FARDEEN','XY',NULL,'DEMO TRY');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-25 11:36:23
