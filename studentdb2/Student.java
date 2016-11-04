package studentdb2;
import java.io.*;

public class Student implements Serializable {
	private String studentNumber;
	private String firstName;
	private char middleInitial;
	private String lastName;
	private String course;
	private int yearLevel;
	private String crushName;
	private Course favSubject;
	
	public Student(String studentNumber2, String fn, char mi, String ln,
			String dp, int level, String crush, Course favSub) {
		
		this.studentNumber = studentNumber2;
		this.firstName = fn;
		this.middleInitial = mi;
		this.lastName = ln;
		this.course = dp;
		this.yearLevel = level;
		this.setCrushName(crush);
		this.setFavSubject(favSub);
		
		
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public char getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(char middleInitial) {
		this.middleInitial = middleInitial;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getYearLevel() {
		return yearLevel;
	}
	public void setYearLevel(int yearLevel) {
		this.yearLevel = yearLevel;
	}
	public String getCrushName() {
		return crushName;
	}
	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}
	public Course getFavSubject() {
		return favSubject;
	}
	public void setFavSubject(Course favSubject) {
		this.favSubject = favSubject;
	}
}