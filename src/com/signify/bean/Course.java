/**
 * 
 */
package com.signify.bean;

/**
 * @author asus
 *
 */
public class Course {

	private int courseId;
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getStudentCount() {
		return studentCount;
	}
	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}
	public int getIsOffered() {
		return isOffered;
	}
	public void setIsOffered(int isOffered) {
		this.isOffered = isOffered;
	}
	public int getProfessorId() {
		return professorId;
	}
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}
	public int getCourseFee() {
		return courseFee;
	}
	public void setCourseFee(int courseFee) {
		this.courseFee = courseFee;
	}
	private String courseName;
	private int studentCount;
	private int isOffered;
	private int professorId;
	private int courseFee;
}
