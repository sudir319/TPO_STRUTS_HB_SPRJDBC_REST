package com.dts.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import com.dts.core.dao.AbstractDataAccessObject;

@SuppressWarnings({ "serial" })
/**
 * 
 * @author PRANEETH
 *
 */
public class InitServlet extends HttpServlet
{
	/**
	 * 
	 */
	AbstractDataAccessObject dobject;
	/**
	 * 
	 */
	public void init(final ServletConfig servletConfig)
	{
		final ServletContext ctx = servletConfig.getServletContext();
		dobject = AbstractDataAccessObject.getInstance();
		final InputStream fis = ctx.getResourceAsStream(servletConfig.getInitParameter("config"));
		final Properties props = new Properties();
		try
		{
			props.load(fis);
		}
		catch (IOException ioe)
		{
			LoggerManager.writeLogWarning(ioe);
		}
		dobject.setProperties(props);

		try
		{
			//System.out.println("initServlet try");
			LoggerManager.logger = new LoggerManager().getLogger(props.getProperty("logfile"));
			//String hibernateEnabled = props.getProperty("hibernate_enabled");
			//servletConfig.getServletContext().setAttribute("hibernate_enabled", hibernateEnabled);
			AbstractDataAccessObject dao = AbstractDataAccessObject.getInstance();
			dao.setHibernateEnabled(Boolean.parseBoolean(props.getProperty("hibernate_enabled")));
		}
		catch (SecurityException error)
		{
			// TODO Auto-generated catch block
			LoggerManager.writeLogSevere(error);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LoggerManager.writeLogInfo("Logger Instatiated");
		
		//final TPOSchdulesReader schdulesReader = new TPOSchdulesReader();
		//schdulesReader.readSchdules();
	}
}
