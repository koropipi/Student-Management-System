import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainGUI{
	public static void main(String[] args){
		new MainGUI();
	}
	
	private static University msu;
	private static Lecturer drJamal;
	private static Course oop;
	private static Course dsa;
	private static ArrayList<Student> studentList = new ArrayList<>();
	private static ArrayList<Course> courseList = new ArrayList<>();
	
	//create object
	public MainGUI(){
		// Create University object
        msu = new University("MSU", "Shah Alam, Selangor, Malaysia",0, 580, 
                                         "FISE, FBMP, FHLS, IMS, SHCA, SESS", 
                                         "BCS, BCF, BBC, BGD, BICT");
		// Create Lecturer object
        drJamal = new Lecturer("Dr. Jamal", "L1023", "FISE",new ArrayList<>());
		 // Create Course objects (Assigning Dr. Jamal)
        oop = new Course("Object Oriented Programming", "CCS20704", 3, drJamal);
		courseList.add(oop);
        dsa = new Course("Data structure and algorithm", "CCS20503", 3, drJamal);
		courseList.add(dsa);
		
		mainMenu();
	}
	
	//mainmenu
	public static void mainMenu(){
		
		JFrame frame = new JFrame("University Management System");
		frame.setSize(600,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		frame.add(mainPanel);
		
		JLabel mainTitle = new JLabel("University Management");
		mainTitle.setBounds(100,50,400,40);
		mainPanel.add(mainTitle);
		
		JButton infoButton = new JButton("Information display");
		infoButton.setBounds(250,140,150,50);
		mainPanel.add(infoButton);
		
		JButton stuButton = new JButton("Student Management");
		stuButton.setBounds(250,240,150,50);
		mainPanel.add(stuButton);
		
		ActionListener mainListener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String command = e.getActionCommand();
				if(command.equals("Information display")){
					frame.dispose();
					infoSubMenu();
				}else if(command.equals("Student Management")){
					frame.dispose();
					stuSubMenu();
				}
			}
		};
		
		infoButton.addActionListener(mainListener);
		stuButton.addActionListener(mainListener);
		
		frame.setVisible(true);
	}
	//submenu1
	public static void infoSubMenu(){
		JFrame frame = new JFrame("Information display");
		frame.setSize(600,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//main panel
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		frame.add(panel);
		
		//display panel
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(panel1);
		
		String[] option = {"university","lecturer","course","student"};
		JComboBox<String> infoCombo = new JComboBox<>(option);
		panel1.add(infoCombo);
		
		JButton displayButton = new JButton("display");
		panel1.add(displayButton);
		
		//Button action
		displayButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String selectedItem = (String) infoCombo.getSelectedItem();
				displayInfo(selectedItem);
			}
		});
	
		//back panel
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(panel2);
		
		JButton backButton = new JButton("BACK");
		panel2.add(backButton);
		
		//Button aciton
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				mainMenu();
			}
		});
		
		frame.setVisible(true);
	}
	
	//submenu1-display
	public static void displayInfo(String selectedItem){
	JFrame infoDisplay = new JFrame("Information");
	infoDisplay.setSize(600,500);
	infoDisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JPanel MainPanel = new JPanel();
	MainPanel.setLayout(new BoxLayout(MainPanel,BoxLayout.Y_AXIS));
	infoDisplay.add(MainPanel);
	
	//display panel
	JPanel panel1 = new JPanel();
	MainPanel.add(panel1);
	panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
	
	//display area	
	JTextArea area = new JTextArea(20,50);
	area.setEditable(false);
	JScrollPane scrollPane = new JScrollPane(area);
	panel1.add(scrollPane);
	
	if(selectedItem.equals("university")){
		area.setText(msu.displayUniversityDetails());			
	}else if(selectedItem.equals("lecturer")){
		area.setText(drJamal.displayLecturerDetails());			
	}else if(selectedItem.equals("course")){
		StringBuilder sb = new StringBuilder();
		for(Course course: courseList){
			sb.append(course.getCourseDetails()).append("\n");
		}
		area.setText(sb.toString());	
	}else if(selectedItem.equals("student")){
		StringBuilder sb = new StringBuilder();
		for(Student stu : studentList){
			sb.append(stu.displayStuInfo()).append("\n");
		}
		area.setText(sb.toString());
	}
		
	//back panel
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		MainPanel.add(panel2);
		
		JButton backButton = new JButton("BACK");
		panel2.add(backButton);
		
		//Button aciton
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				infoDisplay.dispose();
				infoSubMenu();
			}
		});
	
	infoDisplay.setVisible(true);
	}
	
	//submenu2
	public static void stuSubMenu(){
		JFrame frame = new JFrame("Student Management");
		frame.setSize(600,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//main panel
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		frame.add(panel);
		
		//display panel
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(panel1);
		
		String[] option = {"register new student","update GPA"};
		JComboBox<String> stuCombo = new JComboBox<>(option);
		panel1.add(stuCombo);
		
		JButton displayButton = new JButton("display");
		panel1.add(displayButton);
		
		//Button action
		displayButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String selectedItem = (String) stuCombo.getSelectedItem();
				if(selectedItem.equals("register new student")){
					registerStu();
				}else if(selectedItem.equals("update GPA")){
					updateGPA();
				}
			}
		});		
		
		//back panel
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(panel2);
		
		JButton backButton = new JButton("BACK");
		panel2.add(backButton);
		
		//Button aciton
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				mainMenu();
			}
		});
		frame.setVisible(true);
	}
		
	//submenu2-register
		public static void registerStu(){
			JFrame frame = new JFrame("regiter new student");
			frame.setSize(600,500);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel mainPanel = new JPanel();
			mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
			frame.add(mainPanel);
			
			//ID
			JPanel idPanel = new JPanel();
			mainPanel.add(idPanel);
			idPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			idPanel.add(new JLabel("ID:"));
			JTextField idField = new JTextField(20);
			idPanel.add(idField);
			
			//name
			JPanel namePanel = new JPanel();
			mainPanel.add(namePanel);
			namePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			namePanel.add(new JLabel("name: "));
			JTextField nameField = new JTextField(20);
			namePanel.add(nameField);
			
			//age
			JPanel agePanel = new JPanel();
			mainPanel.add(agePanel);
			agePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			agePanel.add(new JLabel("age: "));
			JTextField ageField = new JTextField(20);
			agePanel.add(ageField);
			
			//GPA
			JPanel GPAPanel = new JPanel();
			mainPanel.add(GPAPanel);
			GPAPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			GPAPanel.add(new JLabel("GPA: "));
			
			SpinnerNumberModel model1 = new SpinnerNumberModel(0,0,4,1);
			SpinnerNumberModel model2 = new SpinnerNumberModel(0,0,9,1);
			SpinnerNumberModel model3 = new SpinnerNumberModel(0,0,9,1);
			JSpinner spinner1 = new JSpinner(model1);
			JSpinner spinner2 = new JSpinner(model2);
			JSpinner spinner3 = new JSpinner(model3);
			JLabel labelP = new JLabel(".");
			
			GPAPanel.add(spinner1);
			GPAPanel.add(labelP);
			GPAPanel.add(spinner2);
			GPAPanel.add(spinner3);
			
			//course
			JPanel coursePanel = new JPanel();
			mainPanel.add(coursePanel);
			coursePanel.setLayout(new BoxLayout(coursePanel,BoxLayout.Y_AXIS));
			coursePanel.add(new JLabel("course: "));
			
			ArrayList<JCheckBox> courseCheckBoxList = new ArrayList<>();
			for(Course course: courseList){
				JCheckBox checkBox = new JCheckBox(course.getCourseName());
				courseCheckBoxList.add(checkBox);
				coursePanel.add(checkBox);
			}
			
			//register button
			JPanel buttonPanel = new JPanel();
			mainPanel.add(buttonPanel);
			buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			JButton registerButton = new JButton ("REGISTER");
			buttonPanel.add(registerButton);
			
			//button action
				registerButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						Student stu = new Student();
						//name
						String name = nameField.getText();
						//id
						String id = idField.getText();
						//age
						int age = Integer.parseInt(ageField.getText());
						
						//GPA
						int one = (int) spinner1.getValue();
						int two = (int) spinner2.getValue();
						int three = (int) spinner3.getValue();
						String gpaString = String.format("%d.%d%d",one,two,three);
						double gpa = Double.parseDouble(gpaString);
						
						//course
						ArrayList<Course> selectedCourseList = new ArrayList<>();
						for(int i=0;i<courseCheckBoxList.size();i++){
							if(courseCheckBoxList.get(i).isSelected()){
								Course selectedCourse = courseList.get(i);
								selectedCourse.enrollStudent(stu);
								selectedCourseList.add(selectedCourse);
							}
						}
	
						//set student object 
						stu.setName(name);
						stu.setId(id);
						stu.setAge(age);
						stu.setGpa(gpa);
						stu.setTakeCourse(selectedCourseList);
						studentList.add(stu);
						msu.incrementTotalStudents();
						
						frame.dispose();
						stuSubMenu();
					}
				});
			frame.setVisible(true);
		}
			
	//submenu2-updateGPA
		public static void updateGPA(){
			JFrame frame = new JFrame();
			frame.setSize(600,500);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel mainPanel = new JPanel();
			mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
			frame.add(mainPanel);
			
			//studentlist
			JPanel stuPanel = new JPanel();
			stuPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			mainPanel.add(stuPanel);
			stuPanel.add(new JLabel("students list (id): "));
			JComboBox<String> studentComboBox = new JComboBox<>();
			for(Student s: studentList){
				studentComboBox.addItem(s.getId());
			}
			stuPanel.add(studentComboBox);
			//gpa spinner
			JPanel GPAPanel = new JPanel();
			mainPanel.add(GPAPanel);
			GPAPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			GPAPanel.add(new JLabel("GPA: "));
			
			SpinnerNumberModel model1 = new SpinnerNumberModel(0,0,4,1);
			SpinnerNumberModel model2 = new SpinnerNumberModel(0,0,9,1);
			SpinnerNumberModel model3 = new SpinnerNumberModel(0,0,9,1);
			JSpinner spinner1 = new JSpinner(model1);
			JSpinner spinner2 = new JSpinner(model2);
			JSpinner spinner3 = new JSpinner(model3);
			JLabel labelP = new JLabel(".");
			
			GPAPanel.add(spinner1);
			GPAPanel.add(labelP);
			GPAPanel.add(spinner2);
			GPAPanel.add(spinner3);
			
			//update button
			JPanel updatePanel = new JPanel();
			updatePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			mainPanel.add(updatePanel);
			
			JButton updateButton = new JButton ("UPDATE");
			updatePanel.add(updateButton);
			
				updateButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						//GPA
						int one = (int) spinner1.getValue();
						int two = (int) spinner2.getValue();
						int three = (int) spinner3.getValue();
						String gpaString = String.format("%d.%d%d",one,two,three);
						double gpa = Double.parseDouble(gpaString);
						
						String selectedID = (String) studentComboBox.getSelectedItem();
						for(Student s: studentList){
							if(s.getId().equals(selectedID)){
								s.updateGpa(gpa);
							}
						}
						frame.dispose();
						stuSubMenu();
					}
				});	

			frame.setVisible(true);
		}
			
}
		