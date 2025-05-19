#Student Registration System

##Overview

This project is a Java GUI-based student registration system. It manages information about universities, courses, lecturers, and students, allowing registration of students and updating their GPA.

##System Structure
	•	Course :Contains a lecturer object and manages a list of enrolled students.
	•	Lecturer :Maintains a list of courses they teach.
	•	Student :When registering, a student selects a course, and is automatically added to the student list of the chosen course.
	•	University :Tracks the total number of registered students (totalStudent), which increases automatically as new students register.
	•	MainGUI :The main menu allows users to view information and perform student registration and GPA updates.

##Key Features
	•	Register new students (with course selection)
	•	Update student GPA
	•	Real-time update of university’s total student count
	•	Automatic update of student count per course
	•	View information about universities, courses, lecturers, and students

##How to Use
	1.	Clone or download the repository.
	2.	Install JDK (Java 8 or higher recommended).
	3.	Compile and run the program from the command line:
 		javac MainGUI.java
   		java MainGUI
        4.	Use the GUI menu to view information, register students, and update GPA.

##File Structure
	•	Course.java
	•	Lecturer.java
	•	Student.java
	•	University.java
	•	MainGUI.java


 
