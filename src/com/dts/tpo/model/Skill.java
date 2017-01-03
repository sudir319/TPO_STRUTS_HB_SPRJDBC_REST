package com.dts.tpo.model;

public class Skill
{

	private String loginname;
	private String skillname;
	private String description;
	private String level;

	public String getLoginname()
	{
		return loginname;
	}

	public void setLoginname(final String loginname)
	{
		this.loginname = loginname;
	}

	public String getSkillname()
	{
		return skillname;
	}

	public void setSkillname(final String skillname)
	{
		this.skillname = skillname;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getLevel()
	{
		return level;
	}

	public void setLevel(final String level)
	{
		this.level = level;
	}

}
