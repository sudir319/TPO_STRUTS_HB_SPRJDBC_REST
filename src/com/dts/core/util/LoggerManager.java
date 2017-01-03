/*
 * LoggerManager.java
 *
 * 
 */

package com.dts.core.util;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


/**
 * 
 * @author
 */
@SuppressWarnings("serial")
public class LoggerManager implements java.io.Serializable
{

	/** Creates a new instance of LoggerManager */
	public static Logger logger;
	/**
	 * 
	 * @param file
	 * @return
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public Logger getLogger(final String file) throws SecurityException, IOException
	{
		//System.out.println("From GetLogger");
		final String dir = file.substring(0, file.lastIndexOf('/'));
		//System.out.println("before writeloginfo call");
		
		//System.out.println("after writeloginfo call");
		logger = Logger.getLogger("Logger");
		LoggerManager.writeLogInfo("-----dir----" + dir);
		try
		{
			final File file1 = new File(dir);
			boolean success = file1.exists();

			if (!success){
				success = file1.mkdir();
			}
			final LogManager logManager = LogManager.getLogManager();
			final FileHandler fileHeader = new FileHandler(file, true);
			logger = Logger.getLogger("LoggerManager");
			logger.setUseParentHandlers(false);
			logManager.addLogger(logger);
			logger.setLevel(Level.INFO);
			fileHeader.setFormatter(new SimpleFormatter());
			logger.addHandler(fileHeader);
			// fh.close();
		}
		catch (Error error)
		{

			logger.log(Level.INFO, error.toString(), error.fillInStackTrace());
		}
		return logger;
	}
	/**
	 * 
	 * @param exception
	 */
	public static void writeLogInfo(final Exception exception)
	{
		logger.log(Level.INFO, exception.toString(), exception.fillInStackTrace());
	}
	/**
	 * 
	 * @param e
	 */
	public static void writeLogSevere(final Exception exception)
	{
		logger.log(Level.SEVERE, exception.toString(), exception.fillInStackTrace());
	}
	/**
	 * 
	 * @param throwable
	 */
	public static void writeLogWarning(final Throwable throwable)
	{
		logger.log(Level.WARNING, throwable.toString(), throwable.fillInStackTrace());
	}
	/**
	 * 
	 * @param info
	 */
	public static void writeLogInfo(final String info)
	{
		logger.log(Level.INFO, info);
	}
	/**
	 * 
	 * @param severe
	 */
	public static void writeLogSevere(final String severe)
	{
		logger.log(Level.SEVERE, severe);
	}
	/**
	 * 
	 * @param warning
	 */
	public static void writeLogWarning(final String warning)
	{
		logger.log(Level.WARNING, warning);
	}
}
