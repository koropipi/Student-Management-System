import java.util.ArrayList;
import java.util.List;

public class Lecturer {  
    private String name;
    private String lecturerID;
    private String department;
    private List<String> coursesTaught;

    // Parameterized Constructor
    public Lecturer(String name, String lecturerID, String department, List<String> coursesTaught) {
        this.name = name;
        this.lecturerID = lecturerID;
        this.department = department;
        this.coursesTaught = coursesTaught;
    }

    // Getter Methods
    public String getName() { return name; }
    public String getLecturerID() { return lecturerID; }
    public String getDepartment() { return department; }
    public List<String> getCoursesTaught() { return coursesTaught; }

    // Setter Methods
    public void setName(String name) { this.name = name; }
    public void setLecturerID(String lecturerID) { this.lecturerID = lecturerID; }
    public void setDepartment(String department) { this.department = department; }
    public void setCoursesTaught(List<String> coursesTaught) { this.coursesTaught = coursesTaught; }

	// Method  - add course
	public void addCourse(String course){
		coursesTaught.add(course);
	}
	
    // Method  - Display Lecturer Details
    public String displayLecturerDetails() {
        return "\n== Lecturer Details =="
        +"\nName: " + name
        +"\nID: " + lecturerID
        +"\nDepartment: " + department
        +"\nCourses Taught: " + String.join(", ",coursesTaught);
    }
}