package com.dts.tpo.scheduler;

import java.util.ArrayList;
import java.util.HashMap;

import com.dts.core.util.LoggerManager;
import com.dts.tpo.dao.ScheduledDAO;
import com.dts.tpo.model.Schedule;
@SuppressWarnings({ "rawtypes" })
/**
 * 
 * @author PRANEETH
 *
 */
public class TPOSchdulesReader
{
	/**
	 * 
	 */
	public TPOSchdulesReader()
	{
		final TPOSchdulesReader reader = new TPOSchdulesReader();
		reader.readSchdules();
	}
	/**
	 * 
	 */
	public void readSchdules()
	{
		LoggerManager.writeLogInfo("TPOSchdulesReader.readSchdules()");
		final ScheduledDAO scheduledDAO = new ScheduledDAO();
		LoggerManager.writeLogInfo("scheduledDAO : " + scheduledDAO);
		final HashMap schedulesMap = scheduledDAO.getActiveSchedules();
		LoggerManager.writeLogInfo("TPOSchdulesReader.readSchdules(schedulesMap) : " + schedulesMap);

		if(schedulesMap != null)
		{
			final ArrayList cronSchedulesList = (ArrayList) schedulesMap.get("CRON");
			final ArrayList repeatSchedulesList = (ArrayList) schedulesMap.get("REPEAT");
			LoggerManager.writeLogInfo("TPOSchdulesReader.readSchdules(repeatedSchedulesList) : " + repeatSchedulesList);
			
			if(cronSchedulesList != null)
			{
				final int noOfCronSchedules = cronSchedulesList.size();
				
				for (int eachScheduleIndex = 0; eachScheduleIndex < noOfCronSchedules; eachScheduleIndex++)
				{
					final Schedule newCronSchedule = (Schedule) cronSchedulesList.get(eachScheduleIndex);
					new TPOJobCreatorAndInvoker(newCronSchedule).start();
				}
			}

			if(repeatSchedulesList != null)
			{
				final int noOfRepeSched = repeatSchedulesList.size();
				LoggerManager.writeLogInfo("TPOSchdulesReader.readSchdules(noOfRepeatedSchedules) : " + noOfRepeSched);
				for (int eachScheduleIndex = 0; eachScheduleIndex < noOfRepeSched; eachScheduleIndex++)
				{
					final Schedule newRepeatSchedule = (Schedule) repeatSchedulesList.get(eachScheduleIndex);
					LoggerManager.writeLogInfo("TPOSchdulesReader.readSchdules(newRepeatedSchedule) : " + newRepeatSchedule);
					LoggerManager.writeLogInfo("BEFOER CREATING THREAD1");
					new TPOJobCreatorAndInvoker(newRepeatSchedule).start();
					LoggerManager.writeLogInfo("CREATED Thread and started: ");
				}
			}
			
		}
	}
}