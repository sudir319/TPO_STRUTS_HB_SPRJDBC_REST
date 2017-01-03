package com.dts.dae.dto;

import java.util.Date;

@SuppressWarnings("serial")
public class RegistrationBean implements java.io.Serializable
{

	private String loginName;
	
	private String userName;

	private String loginId;

	private String firstName;

	private Date birthDate1;

	private String hno;

	private String street;

	private String city;

	private String state;

	private String country;

	private String pincode;

	private String phoneNo;

	private String email;

	private String lastName;
	
	public String getLoginname()
	{
		return loginName;
	}

	public void setLoginname(final String loginName)
	{
		this.loginName = loginName;
	}

	public Date getBirthDate1()
	{
		return birthDate1;
	}

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

	public String getCity()
	{
		return city;
	}

	public void setCity(final String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return state;
	}

	public void setState(final String state)
	{
		this.state = state;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(final String country)
	{
		this.country = country;
	}

	public String getPincode()
	{
		return pincode;
	}

	public void setPincode(final String pincode)
	{
		this.pincode = pincode;
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

	public String getUsername()
	{
		return userName;
	}

	public void setUsername(final String userName)
	{
		this.loginName = userName;
	}

	public String getLoginID()
	{
		return loginId;
	}

	public void setLoginID(final String loginID)
	{
		this.loginId = loginID;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}
}
