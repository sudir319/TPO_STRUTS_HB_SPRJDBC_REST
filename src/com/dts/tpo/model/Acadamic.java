package com.dts.tpo.model;

@SuppressWarnings("serial")
public class Acadamic implements java.io.Serializable
{

	private String loginName;
	private int yearofpass1;
	private double percentage1;
	private double percentage2;
	private double percentage3;
	private int yearofpass2;
	private int yearofpass3;
	private int yearofjoining;
	private String course;
	private String rollNo;
	private String discipline;
	private String semister;
	private double aggregate;
	private String email;
	
	public String getEmail()
	{
		//System.out.println(" get Email from acadamic : "+ email);
		return email;
	}

	public void setEmail(final String email)
	{
		//System.out.println("set email from acadamic : "+ email);
		this.email = email;
	}

	public double getAggregate()
	{
		return aggregate;
	}

	public void setAggregate(final double aggregate)
	{
		this.aggregate = aggregate;
	}

	/**
	 * @return the loginname
	 */
	public String getLoginname()
	{
		return loginName;
	}

	/**
	 * @param loginname
	 *            the loginname to set
	 */
	public void setLoginname(final String loginName)
	{
		this.loginName = loginName;
	}

	/**
	 * @return the yearofpass
	 */
	public int getYearofpass1()
	{
		return yearofpass1;
	}

	/**
	 * @param yearofpass
	 *            the yearofpass to set
	 */
	public void setYearofpass1(final int yearofpass1)
	{
		this.yearofpass1 = yearofpass1;
	}

	/**
	 * @return the yearofjoining
	 */
	public int getYearofjoining()
	{
		return yearofjoining;
	}

	/**
	 * @param yearofjoining
	 *            the yearofjoining to set
	 */
	public void setYearofjoining(final int yearofjoining)
	{
		this.yearofjoining = yearofjoining;
	}

	/**
	 * @return the rollno
	 */
	public String getRollno()
	{
		return rollNo;
	}

	/**
	 * @param rollno
	 *            the rollno to set
	 */
	public void setRollno(final String rollNo)
	{
		this.rollNo = rollNo;
	}

	public double getPercentage1()
	{
		return percentage1;
	}

	public void setPercentage1(final double percentage1)
	{
		this.percentage1 = percentage1;
	}

	public double getPercentage2()
	{
		return percentage2;
	}

	public void setPercentage2(final double percentage2)
	{
		this.percentage2 = percentage2;
	}

	public double getPercentage3()
	{
		return percentage3;
	}

	public void setPercentage3(final double percentage3)
	{
		this.percentage3 = percentage3;
	}

	public int getYearofpass2()
	{
		return yearofpass2;
	}

	public void setYearofpass2(final int yearofpass2)
	{
		this.yearofpass2 = yearofpass2;
	}

	public int getYearofpass3()
	{
		return yearofpass3;
	}

	public void setYearofpass3(final int yearofpass3)
	{
		this.yearofpass3 = yearofpass3;
	}

	public String getCourse()
	{
		return course;
	}

	public void setCourse(final String course)
	{
		this.course = course;
	}

	public String getDiscipline()
	{
		return discipline;
	}

	public void setDiscipline(final String discipline)
	{
		this.discipline = discipline;
	}

	public String getSemister()
	{
		return semister;
	}

	public void setSemister(final String semister)
	{
		this.semister = semister;
	}
}