package com.dts.tpo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dts.tpo.model.Notification_Details;

public class NotificationMapper implements RowMapper<Notification_Details>
{

	@Override
	public Notification_Details mapRow(ResultSet resultSet, int rowNumber)
			throws SQLException {
		Notification_Details notification = new Notification_Details();
		notification.setNotificationID(resultSet.getInt("notificationID"));
		notification.setCompanyID(resultSet.getInt("companyID"));
		notification.setNoofvac(resultSet.getString("noofvac"));
		notification.setJobdesc(resultSet.getString("jobdesc"));
		notification.setCategory(resultSet.getString("category"));
		notification.setLocation(resultSet.getString("location"));
		notification.setSkills(resultSet.getString("skills"));
		notification.setCreateddate(resultSet.getDate("createddate"));
		notification.setExpirydate(resultSet.getDate("expirydate"));
		notification.setDesignation(resultSet.getString("designation"));
		notification.setStatus(resultSet.getString("status"));
		
		return notification;
	}
}