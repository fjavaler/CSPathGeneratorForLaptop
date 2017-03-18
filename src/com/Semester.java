package com;

public class Semester
{
	private String season;
	private int year;
	private boolean hasYear;
	private SemesterSchedule schedule;
	
	public Semester(String calendarSeason, int calendarYear)
	{
		season = calendarSeason;
		year = calendarYear;
		hasYear = true;
		schedule = new SemesterSchedule();
	}
	
	public Semester(String calendarSeason)
	{
		season = calendarSeason;
		hasYear = false;
	}
	
	public String getSeason()
	{
		return season;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public SemesterSchedule getSemesterSchedule()
	{
		return schedule;
	}
	
	/**
	 * Format: ex) Spring2015, Spring
	 * 
	 * @return
	 */
	public String getFormattedName()
	{
		if(hasYear == true)
			return "" + season + year;
		else
			return "" + season;
	}
}
