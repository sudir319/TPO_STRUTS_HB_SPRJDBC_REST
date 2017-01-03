package com.dts.tpo.model;

public class Aggregates
{

	private String loginName;
	private int semister;
	private int yearOfPass;
	private double aggregate;

	public String getLoginName()
	{
		return loginName;
	}

	public void setLoginName(final String loginName)
	{
		this.loginName = loginName;
	}

	public int getSemister()
	{
		return semister;
	}

	public void setSemister(final int semister)
	{
		this.semister = semister;
	}

	public int getYearOfPass()
	{
		return yearOfPass;
	}

	public void setYearOfPass(final int yearOfPass)
	{
		this.yearOfPass = yearOfPass;
	}

	public double getAggregate()
	{
		return aggregate;
	}

	public void setAggregate(final double aggregate)
	{
		this.aggregate = aggregate;
	}
}
