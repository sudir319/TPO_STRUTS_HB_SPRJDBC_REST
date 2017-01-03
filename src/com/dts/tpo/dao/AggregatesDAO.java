package com.dts.tpo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.LoggerManager;
import com.dts.tpo.model.Aggregates;

@SuppressWarnings("serial")
public class AggregatesDAO implements java.io.Serializable
{
	Aggregates aAggregates = new Aggregates();
	@SuppressWarnings("rawtypes")
	Hashtable aHashtable;
	@SuppressWarnings("rawtypes")
	Hashtable tHashtable;
	Connection con;
	AbstractDataAccessObject dao = AbstractDataAccessObject.getInstance();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Hashtable getAggregates(final String loginname)
	{
		try
		{
			con = dao.getConnection();
			final Statement statement = con.createStatement();
			final ResultSet resultSet = statement.executeQuery("select loginname, semister, yearofpass, aggregate from SEM_PERCENTAGES where loginname='" + loginname + "'");
			aHashtable = new Hashtable();
			tHashtable = new Hashtable();
			int i = 1;
			while (resultSet.next())
			{
				i = resultSet.getInt(2);
				aAggregates.setSemister(i);
				aAggregates.setYearOfPass(resultSet.getInt(3));
				aAggregates.setAggregate(resultSet.getDouble(4));
				aHashtable.put(Integer.valueOf(i), aAggregates);
			}
			tHashtable.put(loginname, aHashtable);
		}
		catch (Exception e)
		{
			LoggerManager.writeLogWarning(e);
		}
		
		return tHashtable;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Hashtable getOverallAggregates()
	{
		try
		{
			con = dao.getConnection();
			final Statement statement = con.createStatement();
			final ResultSet resultSet = statement.executeQuery("select loginname, aggregate from STUDENT_AGGREGATES");
			aHashtable = new Hashtable();

			while (resultSet.next())
			{
				aHashtable.put(resultSet.getString(1),Integer.valueOf(resultSet.getInt(2)));
			}
		}
		catch (Exception e)
		{
			LoggerManager.writeLogWarning(e);
		}
		
		return aHashtable;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Hashtable getAggregates()
	{
		try
		{
			con = dao.getConnection();
			final Statement statement = con.createStatement();
			final ResultSet resultSet = statement.executeQuery("select loginname, semister, yearofpass, aggregate from SEM_PERCENTAGES order by semister asc");
			aHashtable = new Hashtable();
			tHashtable = new Hashtable();
			int i = 1;
			String loginname = "";
			String loginname1 = "";
			int flag = 0;
			while (resultSet.next())
			{
				loginname = resultSet.getString(1);

				aAggregates.setSemister(resultSet.getInt(2));
				aAggregates.setYearOfPass(resultSet.getInt(3));
				aAggregates.setAggregate(resultSet.getDouble(4));

				if (loginname.equals(loginname1))
				{
					aHashtable.put(Integer.valueOf(i), aAggregates);
				}
				else if (!loginname.equals(loginname1) && flag == 0)
				{
					aHashtable.put(Integer.valueOf(i), aAggregates);
					flag = 1;
					loginname1 = loginname;
				}
				if (!loginname.equals(loginname1) && flag == 1)
				{
					i = 1;
					flag = 0;
					tHashtable.put(loginname, aHashtable);
					aHashtable.put(Integer.valueOf(i), aAggregates);
					loginname1 = "";
				}
				i++;
			}

		}
		catch (Exception e)
		{
			LoggerManager.writeLogWarning(e);
		}
		
		return tHashtable;
	}

	public void setAggregate(final Aggregates aAggregates)
	{
		Connection con = null;
		try
		{
			final int semister = aAggregates.getSemister();
			final int year = aAggregates.getYearOfPass();
			final double percentage = aAggregates.getAggregate();
			final String loginname = aAggregates.getLoginName();

			con = dao.getConnection();
			final PreparedStatement pstatement = con.prepareStatement("insert into SEM_PERCENTAGES values(?,?,?,?)");
			pstatement.setString(1, loginname);
			pstatement.setInt(2, semister);
			pstatement.setInt(3, year);
			pstatement.setDouble(4, percentage);

			pstatement.executeUpdate();
		}
		catch (Exception e)
		{
			LoggerManager.writeLogWarning(e);
		}
	}
}
