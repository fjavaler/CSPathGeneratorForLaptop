package com;

import java.util.HashSet;

public class Course
{
	private String subjectAbbreviation;
	private int classNumber;
	private String courseTitle;
	private int credits;
	private HashSet<Course> prerequisites;
	private HashSet<Course> corequisites;
	private boolean requiresFullMajorStatus;
	private boolean onTheSchedule;
	private Semester semesterTaken;
	
	public Course(String subjectAbbrev, int courseNumber, String title, int creditHours, HashSet<Course> prereqs, boolean fullMajorStatus, Semester semester)
	{
		subjectAbbreviation = subjectAbbrev;
		classNumber = courseNumber;
		courseTitle = title;
		credits = creditHours;
		prerequisites = prereqs;
		requiresFullMajorStatus = fullMajorStatus;
		onTheSchedule = false;
		semesterTaken = semester;
	}
	
	public Course(String subjectAbbrev, int courseNumber, String title, int creditHours, HashSet<Course> prereqs, HashSet<Course> coreqs, boolean fullMajorStatus, Semester semester)
	{
		subjectAbbreviation = subjectAbbrev;
		classNumber = courseNumber;
		courseTitle = title;
		credits = creditHours;
		prerequisites = prereqs;
		corequisites = coreqs;
		requiresFullMajorStatus = fullMajorStatus;
		onTheSchedule = false;
		semesterTaken = semester;
	}
	
	public String getShortTitle()
	{
		return subjectAbbreviation + classNumber;
	}
	
	public String getCourseTitle()
	{
		return courseTitle;
	}
	
	public String getFullCourseTitle()
	{
		return subjectAbbreviation + classNumber + ": " + courseTitle;
	}
	
	public int getCredits()
	{
		return credits;
	}
	
	public boolean isOnTheScheduleAlready()
	{
		return onTheSchedule;
	}
	
	public void setIsOnTheScheduleAlready(boolean value)
	{
		onTheSchedule = value;
	}
	
	public Semester getSemesterTaken()
	{
		return semesterTaken;
	}
	
	public void setSemesterTaken(Semester semester)
	{
		semesterTaken = semester;
	}
	
	public HashSet<Course> getPrereqs()
	{
		if(prerequisites == null)
			throw new NullPointerException();
		return prerequisites;
	}
	
	public HashSet<Course> getCoreqs()
	{
		return corequisites;
	}
	
	public boolean requiresFullMajorStatus()
	{
		return requiresFullMajorStatus;
	}
}

