import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private String courseCode;
    private int credits;
    private Lecturer lecturer;
    private ArrayList<Student> enrolledStudents;

    // Constructor
    public Course(String courseName, String courseCode, int credits, Lecturer lecturer) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credits = credits;
        this.lecturer = lecturer;
        this.enrolledStudents = new ArrayList<>();
    	
    	if(lecturer != null){
    		lecturer.addCourse(courseName);
    	}
    }

    // Getter Methods
    public String getCourseName() { return courseName; }
    public String getCourseCode() { return courseCode; }
    public int getCredits() { return credits; }
    public Lecturer getLecturer() { return lecturer; }
    public List<Student> getEnrolledStudents() { return enrolledStudents; }

    // Methods to Add Students
    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }
	
	@Override 
	public String toString(){
		return "("+courseName+")";
	}

    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
        System.out.println(student.getName() + " has been removed from " + courseName);
    }

    public String getCourseDetails() {
        return "\nCourse: " + courseName + " (" + courseCode + ")"
        +"\nCredits: " + credits
        +"\nLecturer: " + lecturer.getName()
        +"\nTotal Enrolled Students: " + enrolledStudents.size();
    }
}