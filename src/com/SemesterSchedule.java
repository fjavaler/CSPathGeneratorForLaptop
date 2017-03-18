package com;

import java.util.HashSet;

public class SemesterSchedule
{
	private HashSet<Course> thisSemestersCourses;
	private int semesterCreditHours;
	
	public SemesterSchedule()
	{
		thisSemestersCourses = new HashSet<Course>();
		semesterCreditHours = 0;
	}
	
	public void addACourse(Course addedCourse)
	{
		thisSemestersCourses.add(addedCourse);
		semesterCreditHours += addedCourse.getCredits();
	}
	
	public void removeACourse(Course removedCourse)
	{
		thisSemestersCourses.remove(removedCourse);
		semesterCreditHours -= removedCourse.getCredits();
	}
	
	public String printSchedule()
	{
		String courseList = "";
		for(Course c : thisSemestersCourses)
		{
			courseList +=  c.getFullCourseTitle() + " (" + c.getCredits() + "cr)\n" ;
		}
		return courseList;
	}
	
	public HashSet<Course> getThisSemestersCourses()
	{
		return thisSemestersCourses;
	}
}