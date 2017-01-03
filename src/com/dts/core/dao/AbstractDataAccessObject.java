package com.dts.core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.springframework.jdbc.core.JdbcTemplate;

import com.dts.core.util.LoggerManager;

@SuppressWarnings("serial")
/**
 * 
 * @author PRANEETH
 *
 */
public class AbstractDataAccessObject implements java.io.Serializable
{
	/**
	 * 
	 */
	private Connection con;
	/**
	 * 
	 */
	private static AbstractDataAccessObject instance;
	/**
	 * 
	 */
	private Properties props;
	
	private boolean hibernateEnabled;
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setHibernateEnabled(boolean hibernateEnabled) {
		this.hibernateEnabled = hibernateEnabled;
	}
	
	public boolean getHibernateEnabled()
	{
		return hibernateEnabled;
	}

	/**
	 * @return the props
	 */
	public Properties getProperties()
	{
		return props;
	}
	
	/**
	 * 
	 * @return
	 */
	public static AbstractDataAccessObject getInstance()
	{
		if (instance == null)
		{
			instance = new AbstractDataAccessObject();
		}
		return instance;
	}

	/**
	 * @param props
	 *            the props to set
	 */
	public void setProperties(final Properties props)
	{
		this.props = props;
	}
	
	/**
	 * 
	 * @return
	 */
	public Connection getConnection()
	{
		if (con == null)
		{
			try
			{
				final Properties properties = getProperties();
				Class.forName(properties.getProperty("driver"));
				con = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("duser"), properties.getProperty("dpass"));
				LoggerManager.writeLogInfo("Connection created");

				/*
				 * String JNDI=p.getProperty("JNDI_NAME"); InitialContext ic;
				 * try { ic = new InitialContext(); DataSource
				 * ds=(DataSource)ic.lookup(JNDI); con=ds.getConnection(); }
				 * catch (NamingException ne) {
				 * LoggerManager.writeLogWarning(ne); }
				 */
			}
			catch (ClassNotFoundException cnf)
			{
				LoggerManager.writeLogWarning(cnf);
			}
			catch (SQLException se)
			{
				LoggerManager.writeLogWarning(se);
			}
		}
		return con;
	}

	/**
	 * 
	 * @param tableName
	 * @param pkid
	 * @return
	 */
	public int getSequenceID(final String tableName,final String pkid) throws SQLException
	{
		int identity = 0;
		con = getConnection();
		final Statement statement = con.createStatement();
		final ResultSet resultSet = statement.executeQuery("select max(" + pkid + ") from " + tableName);
		try
		{
			if (resultSet.next()){
				identity = resultSet.getInt(1);
			}
			identity++;
		}
		catch (SQLException se)
		{
			LoggerManager.writeLogWarning(se);
		}
		catch (Error e)
		{
			LoggerManager.writeLogWarning(e);
		}
		finally{
			statement.close();
			resultSet.close();
		/*	try{
			if(statement != null){statement.close();}
			if(resultSet != null){resultSet.close();}
			}
			catch(SQLException se){
				LoggerManager.writeLogWarning(se);
			}
		*/
		}
		return identity;
	}
}
