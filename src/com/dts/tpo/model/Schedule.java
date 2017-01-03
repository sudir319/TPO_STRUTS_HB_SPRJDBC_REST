package com.dts.tpo.model;

@SuppressWarnings("serial")
public class Schedule implements java.io.Serializable
{
	private int scheduleId;
	private String scheduleName;
	private String scheduleType;
	private int notificationId;
	private Notification_Details notification;
	private CronScheduleParameters cronScheParas;
	private RepeatedScheduleParameters repScheParas;
	
	public int getScheduleId()
	{
		return scheduleId;
	}
	public void setScheduleId(final int scheduleId)
	{
		this.scheduleId = scheduleId;
	}
	public String getScheduleName()
	{
		return scheduleName;
	}
	public void setScheduleName(final String scheduleName)
	{
		this.scheduleName = scheduleName;
	}
	public String getScheduleType()
	{
		return scheduleType;
	}
	public void setScheduleType(final String scheduleType)
	{
		this.scheduleType = scheduleType;
	}
	public int getNotificationId()
	{
		return notificationId;
	}
	public void setNotificationId(final int notificationId)
	{
		this.notificationId = notificationId;
	}
	public Notification_Details getNotification()
	{
		return notification;
	}
	public void setNotification(final Notification_Details notification)
	{
		this.notification = notification;
	}
	
	public CronScheduleParameters getCronScheduleParameters()
	{
		return cronScheParas;
	}
	public void setCronScheduleParameters(final CronScheduleParameters cronScheParas)
	{
		this.cronScheParas = cronScheParas;
	}
	
	public RepeatedScheduleParameters getRepeatedScheduleParameters()
	{
		return repScheParas;
	}
	
	public void setRepeatedScheduleParameters(final RepeatedScheduleParameters repScheParas)
	{
		this.repScheParas = repScheParas;
	}
}
