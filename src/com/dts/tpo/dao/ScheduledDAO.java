package com.dts.tpo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.LoggerManager;
import com.dts.tpo.model.Schedule;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ScheduledDAO
{
	AbstractDataAccessObject dao = AbstractDataAccessObject.getInstance();
	{
		LoggerManager.writeLogInfo("ScheduledDAO.enclosing_method(AFTER DAO)");
	}
	Connection con = dao.getConnection();
	{
		LoggerManager.writeLogInfo("ScheduledDAO.enclosing_method(after conn ) : " + con);
	}
	public ScheduledDAO()
	{
		LoggerManager.writeLogInfo("ScheduledDAO.ScheduledDAO()");
	}
	
	public HashMap getActiveSchedules()
	{
		LoggerManager.writeLogInfo("ScheduledDAO.getActiveSchedules()");
		HashMap returnMap = null;
		ArrayList cronSchdulesList = null;
		ArrayList repeatedSchdulesList = null;
		Schedule schedule = null;
		try
		{
			final PreparedStatement pstatement = con.prepareStatement("SELECT SCHEDULE_ID, NOTIFICATION_ID, SCHEDULE_NAME, SCHEDULE_TYPE, DAY_OF_WEEK, DAYS, HOURS, MINUTES FROM TPO_SCHEDULES WHERE STATUS = '1'");
			final ResultSet resultSet = pstatement.executeQuery();
			String scheduleType = null;
			while(resultSet.next())
			{
				schedule = new Schedule();
				schedule.setScheduleId(resultSet.getInt(1));
				schedule.setNotificationId(resultSet.getInt(2));
				schedule.setScheduleName(resultSet.getString(3));
				scheduleType = resultSet.getString(4);
				schedule.setScheduleType(scheduleType);
				
				if(scheduleType != null && scheduleType.equalsIgnoreCase("CRON"))
				{
					if(cronSchdulesList == null)
					{
						cronSchdulesList = new ArrayList();
					}
					cronSchdulesList.add(schedule);
				}
				else
				{
					if(repeatedSchdulesList == null)
					{
						repeatedSchdulesList = new ArrayList();
					}
					repeatedSchdulesList.add(schedule);
				}
			}
		}
		catch(Exception e)
		{
			LoggerManager.writeLogSevere(e);
		}
		returnMap = new HashMap();
		if(cronSchdulesList != null && cronSchdulesList.size() > 0)
		{
			returnMap.put("CRON", cronSchdulesList);
		}
		if(repeatedSchdulesList != null && repeatedSchdulesList.size() > 0)
		{
			returnMap.put("REPEAT", repeatedSchdulesList);
		}
		LoggerManager.writeLogInfo("ScheduledDAO.getActiveSchedules(returnMap) : " + returnMap);
		return returnMap;
	}
}
