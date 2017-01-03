package com.dts.tpo.model;

import java.sql.Date;

@SuppressWarnings("serial")
public class Training_Details extends org.apache.struts.action.ActionForm
		implements java.io.Serializable {

	private int trainingId;
	private String trainingName;
	private String Start_date1;
	private String End_date1;
	private Date start_date;
	private Date end_date;
	private String start_time;
	private String end_time;
	private String trainingdesc;
	private String status;

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String training_name) {
		this.trainingName = training_name;
	}

	public String getStart_date1() {
		return Start_date1;
	}

	public void setStart_date1(String start_date1) {
		this.Start_date1 = start_date1;
	}

	public String getEnd_date1() {
		return End_date1;
	}

	public void setEnd_date1(String end_date1) {
		this.End_date1 = end_date1;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getTrainingdesc() {
		return trainingdesc;
	}

	public void setTrainingdesc(String trainingdesc) {
		this.trainingdesc = trainingdesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}