import java.util.ArrayList;

public class Student {
    private String name;
    private String id;
    private int age;
    private double gpa;
    private ArrayList<Course> takeCourse;
	
	// Default Constructor
	public Student(){
		this.name = "unknown";
		this.id = "0000";
		this.age = 0;
		this.gpa = 0.00;
		this.takeCourse = new ArrayList<>();
	}

    // Parameterized Constructor
    public Student(String name, String id, int age, double gpa, ArrayList<Course> takeCourse) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.gpa = gpa;
    	this.takeCourse = takeCourse;
    }

    // Getter Methods
    public String getName() { return name; }
    public String getId() { return id; }
    public int getAge() { return age; }
    public double getGpa() { return gpa; }
	public ArrayList<Course> getTakeCourse() { return takeCourse; }

    // Setter Methods
    public void setName(String name) { this.name = name; }
    public void setId(String id) { this.id = id; }
    public void setAge(int age) { this.age = age; }
    public void setGpa(double gpa) { this.gpa = gpa; }
    public void setTakeCourse(ArrayList<Course> takeCourse) { this.takeCourse = takeCourse; }

    // Update GPA
    public void updateGpa(double gpa) {
        this.gpa = gpa;
    }
	
	@Override
	public String toString(){
		return "Student("+id+","+name+")";
	}

    // Display Student Information
    public String displayStuInfo() {
        return "\n=== Student Information ==="
        +"\nID: " + id
        +"\nName: " + name
        +"\nAge: " + age
        +"\nGPA: " + gpa
    	+"\nCourse: "+takeCourse;
    }
}
