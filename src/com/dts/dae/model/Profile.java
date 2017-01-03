package com.dts.dae.model;

import java.sql.Date;

/**
 * 
 * @author
 */
@SuppressWarnings("serial")
public class Profile implements java.io.Serializable
{

	private String secretqid;

	private String identity;

	private String password;

	private String newPassword;

	private String firstName;

	private String lastName;

	private String loginType;

	private int status;

	private String date;

	private int roleId;

	private int flogin;

	private String timeZone;

	private String city;

	private String hno;

	private String street;

	private String phoneNo;

	private String email;

	private String bDate;

	private Date birthDate1;

	private String state;

	private String country;

	private String pincode;

	private String locale;

	private String secretqans;

	private String ownsecretq;

	private String passwordModDate;

	private String profileModDate;

	public void setLoginID(final String identity)
	{
		//System.out.println("from setloginid in profile");
		this.identity = identity;
	}

	public void setPassword(final String password)
	{
		//System.out.println("from setpassword in profile");
		this.password = password;
	}

	public void setNewPassword(final String newPassword)
	{
		this.newPassword = newPassword;
	}

	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}

	public void setLoginType(final String loginType)
	{
		this.loginType = loginType;
	}

	public void setStatus(final int status)
	{
		this.status = status;
	}

	public void setRegDate(final String date)
	{
		this.date = date;
	}

	public void setSecretQuestionID(final String string)
	{
		this.secretqid = string;
	}

	public void setOwnSecretQuestion(final String ownsecretq)
	{
		this.ownsecretq = ownsecretq;
	}

	public void setSecretAnswer(final String secretqans)
	{
		this.secretqans = secretqans;
	}

	public void setFirstLogin(final int flogin)
	{
		this.flogin = flogin;
	}

	public void setRoleId(final int roleId)
	{
		this.roleId = roleId;
	}

	public void setBirthDate(final String bDate)
	{
		this.bDate = bDate;
	}

	public void setCity(final String city)
	{
		this.city = city;
	}

	public void setState(final String state)
	{
		this.state = state;
	}

	public void setCountry(final String country)
	{
		this.country = country;
	}

	public void setLocale(final String locale)
	{
		this.locale = locale;
	}

	public void setTimeZone(final String timeZone)
	{
		this.timeZone = timeZone;
	}

	public void setPasswordModifiedDate(final String passwordModDate)
	{
		this.passwordModDate = passwordModDate;
	}

	public void setProfileModifiedDate(final String profileModDate)
	{
		this.profileModDate = profileModDate;
	}

	// Getter methods used to get the values from bean

	public String getLoginID()
	{
		return identity;
	}

	public String getPassword()
	{
		return password;
	}

	public String getNewPassword()
	{
		return newPassword;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public String getLoginType()
	{
		return loginType;
	}

	public int getStatus()
	{
		return status;
	}

	public String getRegDate()
	{
		return date;
	}

	public String getSecretQuestionID()
	{
		return secretqid;
	}

	public String getOwnSecretQuestion()
	{
		return ownsecretq;
	}

	public String getSecretAnswer()
	{
		return secretqans;
	}

	public int getFirstLogin()
	{
		return flogin;
	}

	public int getRoleId()
	{
		return roleId;
	}

	public String getBirthDate()
	{
		return bDate;
	}

	public String getCity()
	{
		return city;
	}

	public String getState()
	{
		return state;
	}

	public String getCountry()
	{
		return country;
	}

	public String getLocale()
	{
		return locale;
	}

	public String getTimeZone()
	{
		return timeZone;
	}

	public String getPasswordModifiedDate()
	{
		return passwordModDate;
	}

	public String getProfileModifiedDate()
	{
		return profileModDate;
	}

	/**
	 * @return the birthDate1
	 */
	public Date getBirthDate1()
	{
		return birthDate1;
	}

	/**
	 * @param birthDate1
	 *            the birthDate1 to set
	 */
	public void setBirthDate1(final Date birthDate1)
	{
		this.birthDate1 = birthDate1;
	}

	public String getHno()
	{
		return hno;
	}

	public void setHno(final String hno)
	{
		this.hno = hno;
	}

	public String getStreet()
	{
		return street;
	}

	public void setStreet(final String street)
	{
		this.street = street;
	}

	public String getPhoneNo()
	{
		return phoneNo;
	}

	public void setPhoneNo(final String phoneNo)
	{
		this.phoneNo = phoneNo;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(final String email)
	{
		this.email = email;
	}

	public String getPincode()
	{
		return pincode;
	}

	public void setPincode(final String pincode)
	{
		this.pincode = pincode;
	}

	public void setLogintype(final String parameter)
	{
		// TODO Auto-generated method stub

	}
}
