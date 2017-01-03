package com.dts.tpo.scheduler;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.dts.tpo.mail.TPOMailSender;
import com.dts.tpo.model.Company_Details;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;
import com.dts.tpo.dao.AcadamicDAO;
import com.dts.tpo.model.Acadamic;
import com.dts.tpo.model.CronScheduleParameters;
import com.dts.tpo.model.Notification_Details;
import com.dts.tpo.model.RepeatedScheduleParameters;
import com.dts.tpo.model.Schedule;
import com.dts.tpo.dao.CompanyDAO;
@SuppressWarnings({ "unused", "rawtypes", "unchecked", "serial" })
public class TPOJobCreatorAndInvoker extends Thread implements java.io.Serializable
{
	ArrayList cronSchedulesList;
	ArrayList repSchedulesList;
	
	Schedule schedule;
	static
	{
		LoggerManager.writeLogInfo("TPOJobCreatorAndInvoker.enclosing_method(CLASS LOADED)");
	}
	public TPOJobCreatorAndInvoker(final Schedule schedule)
	{
		super();
		LoggerManager.writeLogInfo("TPOJobCreatorAndInvoker.TPOJobCreatorAndInvoker(schedule) : " + schedule);
		this.schedule = schedule;
	}
	
	@Override
	public void run()
	{
		LoggerManager.writeLogInfo("TPOJobCreatorAndInvoker.run(schedule) : " + schedule);
		String scheduleType = null;
		
		if(schedule != null)
		{
			scheduleType = schedule.getScheduleType();
			LoggerManager.writeLogInfo("TPOJobCreatorAndInvoker.run(scheduleType) : " + scheduleType);
			if(scheduleType != null)
			{
				if(scheduleType.equals("CRON"))
				{
					createCronJob(schedule);
				}
				else
				{
					createRepeatedJob(schedule);
				}
			}
		}
	}
	public void createCronJob(final Schedule cronSchedule)
	{
		final Notification_Details notification = cronSchedule.getNotification();
		final CronScheduleParameters cronParameters = cronSchedule.getCronScheduleParameters();
		
		checkCronScheduleAndInvoke(cronParameters, notification);
		
	}
	private void checkCronScheduleAndInvoke(final CronScheduleParameters cronParameters, final Notification_Details notification)
	{
		final String day = cronParameters.getDay();
		final int hours = cronParameters.getHours();
		
		int requiredDay = -1;
		
		if(day.equalsIgnoreCase("SUNDAY"))
		{
			requiredDay = Calendar.FRIDAY;
		}
		else if(day.equalsIgnoreCase("MONDAY"))
		{
			requiredDay = Calendar.MONDAY;
		}
		else if(day.equalsIgnoreCase("TUESDAY"))
		{
			requiredDay = Calendar.TUESDAY;
		}
		else if(day.equalsIgnoreCase("WEDNESDAY"))
		{
			requiredDay = Calendar.WEDNESDAY;
		}
		else if(day.equalsIgnoreCase("THURSDAY"))
		{
			requiredDay = Calendar.THURSDAY;
		}
		else if(day.equalsIgnoreCase("FRIDAY"))
		{
			requiredDay = Calendar.FRIDAY;
		}
		else if(day.equalsIgnoreCase("SATURDAY"))
		{
			requiredDay = Calendar.SATURDAY;
		}
		
		final  Calendar today = Calendar.getInstance();
		
		final  int dayOfWeek = today.get(Calendar.DAY_OF_WEEK);
		int daystoWait = requiredDay - dayOfWeek;
		if(daystoWait < 0)
		{
			daystoWait = daystoWait + 7;
		}
		
		final int hourOfTheDay = today.get(Calendar.HOUR);
		int hoursRequired = hours - hourOfTheDay;
		if(hoursRequired < 0)
		{
			hoursRequired = hoursRequired + 24;
			daystoWait = daystoWait + 6;
		}
		else
		{
			hoursRequired = daystoWait * 24 + hoursRequired;
		}

		final int hoursToWait = daystoWait * 24 + hoursRequired;
		
		// Now its time to execute the Job
		sendMailWithNotificationDetails(hoursToWait, notification);
	}

	public void createRepeatedJob(final Schedule repeatedSchdule)
	{
		LoggerManager.writeLogInfo("TPOJobCreatorAndInvoker.createRepeatedJob(repeatedSchdule) : " + repeatedSchdule);
		final Notification_Details notification = repeatedSchdule.getNotification();
		final RepeatedScheduleParameters repeatedParameters = repeatedSchdule.getRepeatedScheduleParameters();
		checkRepeatedScheduleAndInvoke(repeatedParameters, notification);
	}
	
	private void checkRepeatedScheduleAndInvoke(final RepeatedScheduleParameters repeatedParameters, final  Notification_Details notification)
	{
		final int days = repeatedParameters.getDays();
		final int hours = repeatedParameters.getHours();
		
		int hoursToWait = 0;
		if(days >= 0)
		{
			hoursToWait += days * 24;
		}
		if(hours >= 0)
		{
			hoursToWait += hours;
		}
		sendMailWithNotificationDetails(hoursToWait, notification);
	}

	
	public void sendMailWithNotificationDetails(final int hoursToWait, final  Notification_Details notification)
	{
		LoggerManager.writeLogInfo("TPOJobCreatorAndInvoker.sendMailWithNotificationDetails(hoursToWait) : " + hoursToWait);
		try
		{
			Thread.sleep(hoursToWait * 60 * 60);
		}
		catch (Exception e)
		{
			LoggerManager.writeLogSevere(e);
		}
		
		final int notificationID = notification.getNotificationID();
		final int companyID = notification.getCompanyID();
		final String noofvac = notification.getNoofvac();
		final String jobdesc = notification.getJobdesc();
		final String category = notification.getCategory();
		final String location = notification.getLocation();
		final String desiredskills = notification.getSkills();
		final Date createddate = notification.getCreateddate();
		final String createddate1 = notification.getCreateddate1();
		final Date expirydate = notification.getExpirydate();
		final String expirydate1 = notification.getExpirydate1();
		final String designation = notification.getDesignation();
		final String status = notification.getStatus();
		final String loginname = notification.getLoginname();
		final String rollNo = notification.getRollNo();

		final AcadamicDAO aAcadamicdao = new AcadamicDAO(); 
        
		final  Hashtable studentInfo = aAcadamicdao.getProfile("student");
        
		final Enumeration students = studentInfo.elements();
        Acadamic acadamic = null;
        final ArrayList studentMailIds = new ArrayList();
        final ArrayList ccMailIds = new ArrayList();
        ccMailIds.add("sudir.319@gmail.com");
        ccMailIds.add("chpraneeth37@gmail.com");
        while(students.hasMoreElements())
        {
        	acadamic = (Acadamic) students.nextElement();
        	//To Get to Mail IDs
        	//studentMailIds.add(acadamic.getMailId());
        }
        
        final CompanyDAO companyDao = new CompanyDAO();
        final Company_Details companyInfo = companyDao.getCompanyDetails(companyID);
        
        studentMailIds.add("sudir.319@gmail.com");
		
        final StringBuilder mailMessageBuilder = new StringBuilder();
        
        mailMessageBuilder.append("Dear Students\n\n");
        mailMessageBuilder.append("\tThis is to inform you that our Company has inviting ");
        mailMessageBuilder.append(companyInfo.getCompanyName());
        mailMessageBuilder.append(" for a visit on ");
        mailMessageBuilder.append(DateWrapper.parseDate(notification.getCreateddate1()));
        mailMessageBuilder.append(" for a campus Drive.");
        mailMessageBuilder.append("\n\n\tPlease be available in the Office atleast before an hour to get resgistered for the drive with 2 copies of your RESUME");
        mailMessageBuilder.append("\n\tAnd this is strictly only for our college students");
        
        final TPOMailSender sender = new TPOMailSender();
		sender.setToRecipientsList(studentMailIds);
		sender.setSubject("Invitation for Campus Drive");
		sender.setCcRecipientsList(ccMailIds);

		try
		{
			sender.sendMail();
		}
		catch (AddressException e)
		{
			LoggerManager.writeLogSevere(e);
		}
		catch (MessagingException e)
		{
			LoggerManager.writeLogSevere(e);
		}
	}
}