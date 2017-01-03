package com.dts.tpo.model;

public class CronScheduleParameters
{
	private String day;
	private int hours;
	private int minutes;
	public String getDay()
	{
		return day;
	}
	public void setDay(final String day)
	{
		this.day = day;
	}
	public int getHours()
	{
		return hours;
	}
	public void setHours(final int hours)
	{
		this.hours = hours;
	}
	public int getMinutes()
	{
		return minutes;
	}
	public void setMinutes(final int minutes)
	{
		this.minutes = minutes;
	}
}