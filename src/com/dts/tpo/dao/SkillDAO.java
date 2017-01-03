package com.dts.tpo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.LoggerManager;
import com.dts.tpo.model.Skill;

@SuppressWarnings("serial")
public class SkillDAO implements java.io.Serializable
{

	Connection con;
	@SuppressWarnings("rawtypes")
	Hashtable aHashtable;
	@SuppressWarnings("rawtypes")
	Hashtable tHashtable;
	Skill aSkill;
	AbstractDataAccessObject dao = AbstractDataAccessObject.getInstance();

	public void setSkill(final Skill aSkill)
	{
		try
		{
			con = dao.getConnection();
			final PreparedStatement pstatement = con.prepareStatement("insert into STUDENT_SKILLS values(?,?,?,?)");
			pstatement.setString(1, aSkill.getLoginname());
			pstatement.setString(2, aSkill.getSkillname());
			pstatement.setString(3, aSkill.getDescription());
			pstatement.setString(4, aSkill.getLevel());

			pstatement.executeUpdate();
		}
		catch (Exception e)
		{
			LoggerManager.writeLogWarning(e);
		}
		finally
		{
			try
			{
				//con.close();
			}
			catch (Exception e)
			{
				LoggerManager.writeLogWarning(e);
			}
		}
	}

	public void updateSkill(final Skill aSkill)
	{
		try
		{
			con = dao.getConnection();
			final PreparedStatement pstatement = con.prepareStatement("update STUDENT_SKILLS set description=?, leveldesc=?  where loginname=? and skillname=?");

			pstatement.setString(1, aSkill.getDescription());
			pstatement.setString(2, aSkill.getLevel());
			pstatement.setString(3, aSkill.getLoginname());
			pstatement.setString(4, aSkill.getSkillname());

			pstatement.executeUpdate();
		}
		catch (Exception e)
		{
			LoggerManager.writeLogWarning(e);
		}
		finally
		{
			try
			{
				//con.close();
			}
			catch (Exception e)
			{
				LoggerManager.writeLogWarning(e);
			}
		}
	}

	public void deleteSkill(final Skill aSkill)
	{
		try
		{
			con = dao.getConnection();
			final PreparedStatement pstatement = con.prepareStatement("delete from  STUDENT_SKILLS where loginname=? and skillname=?");

			pstatement.setString(1, aSkill.getLoginname());
			pstatement.setString(2, aSkill.getSkillname());

			pstatement.executeUpdate();
		}
		catch (Exception e)
		{
			LoggerManager.writeLogWarning(e);
		}
		finally
		{
			try
			{
				//con.close();
			}
			catch (Exception e)
			{
				LoggerManager.writeLogWarning(e);
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Hashtable getSkills(final String loginname)
	{
		try
		{
			con = dao.getConnection();
			final Statement statement = con.createStatement();
			final ResultSet resultSet = statement.executeQuery("select loginname, skillname, description, leveldesc from STUDENT_SKILLS where loginname='" + loginname + "'");
			aHashtable = new Hashtable();
			tHashtable = new Hashtable();

			int value = 1;
			while (resultSet.next())
			{
				aSkill = new Skill();

				aSkill.setSkillname(resultSet.getString(2));
				aSkill.setDescription(resultSet.getString(3));
				aSkill.setLevel(resultSet.getString(4));
				aHashtable.put(Integer.valueOf(value), aSkill);
				value++;
			}
			tHashtable.put(loginname, aHashtable);
		}
		catch (Exception e)
		{
			LoggerManager.writeLogWarning(e);
		}
		finally
		{
			try
			{
				//con.close();
			}
			catch (Exception e)
			{
				LoggerManager.writeLogWarning(e);
			}
		}
		return tHashtable;
	}
}
