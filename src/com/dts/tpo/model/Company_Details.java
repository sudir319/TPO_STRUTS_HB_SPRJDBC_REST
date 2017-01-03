package com.dts.tpo.model;

import java.io.Serializable;

public class Company_Details extends org.apache.struts.action.ActionForm implements Serializable
{

	private int companyId;
	private String companyName;
	private String profile;
	private String street;
	private String city;
	private String state;
	private String country;
	private String phone;
	private String email;

	public Company_Details(){}
	
	/*	@Override
	public String toString() {
		// TODO Auto-generated method stub
		System.out.println("companyid : "+companyId);
		System.out.println("CompanyNAme : "+companyName);
		System.out.println("profile : "+profile);
		System.out.println("street : "+street);
		System.out.println("city : "+city);
		System.out.println("state : "+state);
		System.out.println("country : "+country);
		System.out.println("phone : "+phone);
		System.out.println("email : "+email );
		return super.toString();
	}
*/	
	public Company_Details(String companyName, String profile, String street, String city, String state, String country, String phone, String email){
		this.companyName = companyName;
		this.profile = profile;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.phone = phone;
		this.email = email;
	}
	
	public int getCompanyId()
	{
		return companyId;
	}

	public void setCompanyId(final int companyId)
	{
		this.companyId = companyId;
	}

	public String getCompanyName()
	{
		return companyName;
	}

	public void setCompanyName(final String companyName)
	{
		this.companyName = companyName;
	}

	public String getProfile()
	{
		return profile;
	}

	public void setProfile(final String profile)
	{
		this.profile = profile;
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

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(final String phone)
	{
		this.phone = phone;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(final String email)
	{
		this.email = email;
	}
}
