package com.dts.tpo.model;

import java.sql.Date;

@SuppressWarnings("serial")
/**
 * 
 * @author PRANEETH
 *
 */
public class Notification_Details extends org.apache.struts.action.ActionForm implements java.io.Serializable
{

	// instance variables

	private int notificationID;
	private int companyID;
	private String noofvac;
	private String jobdesc;
	private String category;
	private String location;
	private String skills;
	private Date createddate;
	private String createddate1;
	private Date expirydate;
	private String expirydate1;
	private String designation;
	private String status;
	private String loginname;
	private String rollNo;
	
/*	@Override
	public String toString() {
		// TODO Auto-generated method stub
		System.out.println("notificationID : "+notificationID);
		System.out.println("CompanyId : "+companyID);
		System.out.println("noofvac : "+noofvac);
		System.out.println("jodesc : "+jobdesc);
		System.out.println("Category : "+category);
		System.out.println("location : "+location);
		System.out.println("skill : "+skills);
		System.out.println("createdDate : "+createddate);
		System.out.println("expirydate : "+expirydate);
		System.out.println("designation : "+designation);
		System.out.println("Status : "+status);
		System.out.println("Loginname : "+loginname);
		System.out.println("roll no : "+rollNo);
		return super.toString();
	}
*/
	public int getNotificationID() {
		return notificationID;
	}
	public void setNotificationID(int notificationID) {
		//System.out.println("NOtification_Details notificationID : "+notificationID);
		this.notificationID = notificationID;
	}
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		//System.out.println("NOtification_Details companyID : "+companyID);
		this.companyID = companyID;
	}
	public String getNoofvac() {
		return noofvac;
	}
	public void setNoofvac(String noofvac) {
		//System.out.println("NOtification_Details noofvac : "+noofvac);
		this.noofvac = noofvac;
	}
	public String getJobdesc() {
		return jobdesc;
	}
	public void setJobdesc(String jobdesc) {
		//System.out.println("NOtification_Details jobdesc : "+jobdesc);
		this.jobdesc = jobdesc;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		//System.out.println("NOtification_Details category : "+category);
		this.category = category;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		//System.out.println("NOtification_Details location : "+location);
		this.location = location;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		//System.out.println("NOtification_Details createddate : "+createddate);
		this.createddate = createddate;
	}
	public String getCreateddate1() {
		return createddate1;
	}
	public void setCreateddate1(String createddate1) {
		this.createddate1 = createddate1;
	}
	public Date getExpirydate() {
		
		return expirydate;
	}
	public void setExpirydate(Date expirydate) {
		//System.out.println("NOtification_Details expirydate : "+expirydate);
		this.expirydate = expirydate;
	}
	public String getExpirydate1() {
		return expirydate1;
	}
	public void setExpirydate1(String expirydate1) {
		this.expirydate1 = expirydate1;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getStatus() {
		//System.out.println("Get status from Notification_Details : "+status);
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
		//System.out.println("Set status from Notification_Details : "+status);
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
}