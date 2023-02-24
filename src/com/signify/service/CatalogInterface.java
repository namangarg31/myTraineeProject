/**
 * 
 */
package com.signify.service;

/**
 * @author asus
 *
 */
public interface CatalogInterface {

	void addCourse(int courseCode,String name,String instructor);
	void deleteCourse(int courseCode);
	void viewCourseDetails(int courseCode);
}
