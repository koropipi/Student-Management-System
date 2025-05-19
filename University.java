public class University {  
    private String name;
    private String location;
    private int totalStudents;
    private int ranking;
    private String faculties;
    private String programmes;

    // Parameterized Constructor
    public University(String name, String location, int totalStudents, int ranking, String faculties, String programmes) {
        this.name = name;
        this.location = location;
        this.totalStudents = totalStudents;
        this.ranking = ranking;
        this.faculties = faculties;
        this.programmes = programmes;
    }

    // Getter Methods
    public String getName() { return name; }
    public String getLocation() { return location; }
    public int getTotalStudents() { return totalStudents; }
    public int getRanking() { return ranking; }
    public String getFaculties() { return faculties; }
    public String getProgrammes() { return programmes; }

    // Setter Methods
    public void setName(String name) { this.name = name; }
    public void setLocation(String location) { this.location = location; }
    public void setTotalStudents(int totalStudents) { this.totalStudents = totalStudents; }
    public void setRanking(int ranking) { this.ranking = ranking; }
    public void setFaculties(String faculties) { this.faculties = faculties; }
    public void setProgrammes(String programmes) { this.programmes = programmes; }
	
	// Method  - Increment Total Students
	public void incrementTotalStudents(){
		totalStudents++;
	}

    // Method  - Display university name and location
    public String displayUniversityDetails() {
        return "== University Details ==\n"
    		+"\nName: " + name
    		+"\nLocation: " + location
    		+"\nRanking: " + ranking
    		+"\nThe total number of students in the university is " + totalStudents
    		+"\nThe available faculties in the university are: " + faculties;
    }
}