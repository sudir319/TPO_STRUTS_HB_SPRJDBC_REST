package com.dts.tpo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.LoggerManager;
import com.dts.tpo.model.Acadamic;

public class AcadamicDAO
{

	Connection con;
	AbstractDataAccessObject dao = AbstractDataAccessObject.getInstance();

	public AcadamicDAO()
	{
		con = dao.getConnection();
	}

	// Registering acadamic details
	public boolean registerAcadamicDetails(final Acadamic adto)
	{
		Statement statement;
		boolean flag = false;

		try
		{
			final String loginname = adto.getLoginname();
			final int yearofpass1 = adto.getYearofpass1();
			final double percentage1 = adto.getPercentage1();
			final int yearofpass2 = adto.getYearofpass2();
			final double percentage2 = adto.getPercentage2();
			final int yearofpass3 = adto.getYearofpass3();
			final double percentage3 = adto.getPercentage3();
			final String rollno = adto.getRollno();
			final int yearofjoin = adto.getYearofjoining();
			final String course = adto.getCourse();
			final String discipline = adto.getDiscipline();
			final String semister = adto.getSemister();

			final PreparedStatement pstatement = con.prepareStatement("insert into ACADAMIC_DETAILS values(?,?,?,?,?,?,?,?,?,?,?,?)");

			pstatement.setString(1, loginname);
			pstatement.setInt(2, yearofpass1);
			pstatement.setDouble(3, percentage1);
			pstatement.setInt(4, yearofpass2);
			pstatement.setDouble(5, percentage2);
			pstatement.setInt(6, yearofpass3);
			pstatement.setDouble(7, percentage3);
			pstatement.setString(8, rollno);
			pstatement.setInt(9, yearofjoin);
			pstatement.setString(10, course);
			pstatement.setString(11, discipline);
			pstatement.setString(12, semister);

			final int updated = pstatement.executeUpdate();

			if (updated != 0)
			{
				statement = con.createStatement();
				statement.executeUpdate("Update LOGIN_DETAILS set firstlogin=1 where loginname='" + loginname + "'");
				flag = true;
			}
			else{
				flag = false;
			}
		}
		catch (SQLException e)
		{
			flag = false;
			LoggerManager.writeLogSevere(e);
		}
		return flag;
	}

	// checking acadamic details
	public boolean checkAcadamicDetails(final String loginname)
	{
		Statement statement;
		boolean flag = false;
		try
		{
			statement = con.createStatement();
			final ResultSet resultSet = statement.executeQuery("select loginname, sscyop, sscpercentage, ugyop, ugpercentage, gyop, gpercentage, rollno, yearofjoining, course, discipline, semister from ACADAMIC_DETAILS where loginname='" + loginname + "'" + "order by rollno asc");
			if (resultSet.next()){
				flag = true;
			}
		}
		catch (SQLException e)
		{
			LoggerManager.writeLogSevere(e);
		}
		return flag;
	}

	// get Acadamic details

	public Acadamic getAcademicDetails(final String loginname)
	{
		Acadamic acdto = null;
		try
		{
			final Statement statement = con.createStatement();
			final ResultSet resultSet = statement.executeQuery("select sscyop,sscpercentage,ugyop,ugpercentage," + "gyop,gpercentage,rollno,yearofjoining,course,discipline,semister " + "from ACADAMIC_DETAILS where loginname='" + loginname + "'" + " order by rollno");
			if (resultSet.next())
			{
				acdto = new Acadamic();
				acdto.setYearofpass1(resultSet.getInt(1));
				acdto.setPercentage1(resultSet.getDouble(2));
				acdto.setYearofpass2(resultSet.getInt(3));
				acdto.setPercentage2(resultSet.getDouble(4));
				acdto.setYearofpass3(resultSet.getInt(5));
				acdto.setPercentage3(resultSet.getDouble(6));
				acdto.setRollno(resultSet.getString(7));
				acdto.setYearofjoining(resultSet.getInt(8));
				acdto.setCourse(resultSet.getString(9));
				acdto.setDiscipline(resultSet.getString(10));
				acdto.setSemister(resultSet.getString(11));
				acdto.setLoginname(loginname);
			}
		}
		catch (SQLException sex)
		{
			LoggerManager.writeLogSevere(sex);
		}
		return acdto;
	}

	// Updating acadamic details
	public boolean updateAcadamicDetails(final Acadamic adto)
	{
		boolean flag = false;

		try
		{
			final String loginname = adto.getLoginname();
			final int yearofpass1 = adto.getYearofpass1();
			final double percentage1 = adto.getPercentage1();
			final int yearofpass2 = adto.getYearofpass2();
			final double percentage2 = adto.getPercentage2();
			final int yearofpass3 = adto.getYearofpass3();
			final double percentage3 = adto.getPercentage3();
			final String rollno = adto.getRollno();
			final int yearofjoin = adto.getYearofjoining();
			final String course = adto.getCourse();
			final String discipline = adto.getDiscipline();
			final String semister = adto.getSemister();

			final PreparedStatement pstatement = con.prepareStatement("update ACADAMIC_DETAILS set sscyop=?,sscpercentage=?,ugyop=?,ugpercentage=?,gyop=?,gpercentage=?,rollno=?,yearofjoining=?,course=?,discipline=?,semister=? where loginname=?");

			pstatement.setInt(2, yearofpass1);
			pstatement.setDouble(3, percentage1);
			pstatement.setInt(4, yearofpass2);
			pstatement.setDouble(5, percentage2);
			pstatement.setInt(6, yearofpass3);
			pstatement.setDouble(7, percentage3);
			pstatement.setString(8, rollno);
			pstatement.setInt(9, yearofjoin);
			pstatement.setString(10, course);
			pstatement.setString(11, discipline);
			pstatement.setString(12, semister);
			pstatement.setString(1, loginname);

			final int updated = pstatement.executeUpdate();
			if (updated != 0)
			{
				flag = true;
			}
		}
		catch (Exception e)
		{
			LoggerManager.writeLogSevere(e);
		}
		return flag;
	}

	// Getting profiles
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Hashtable getProfile(final String role)
	{
		Acadamic acadamic = null;
		final Hashtable aHashtable = new Hashtable();
		try
		{
			con = dao.getConnection();
			final Statement statement = con.createStatement();
			/*
			 * ResultSet rs = st.executeQuery(
			 * "select ld.loginname,ac.course,ac.discipline,ac.semister,ac.rollno,ag.aggregate "
			 * +
			 * "from LOGIN_DETAILS ld, acadamicdetails ac , STUDENT_AGGREGATES ag where "
			 * + "ld.logintype='"+role+
			 * "' and ac.loginname=ld.loginname and ld.loginstatus=1 and ag.loginname=ld.loginname"
			 * );
			 */
			final ResultSet resultSet = statement.executeQuery("select ad.loginname, ad.sscyop, ad.sscpercentage, ad.ugyop, ad.ugpercentage, ad.gyop, ad.gpercentage, ad.rollno, ad.yearofjoining, ad.course, ad.discipline,lp.email, ad.semister From ACADAMIC_DETAILS ad, LOGIN_PROFILE lp where ad.loginname=lp.loginid order by ad.loginname asc");
			String loginname = "";
			while (resultSet.next())
			{
				acadamic = new Acadamic();
				loginname = resultSet.getString(1);
				acadamic.setLoginname(loginname);
				acadamic.setCourse(resultSet.getString(10));
				acadamic.setDiscipline(resultSet.getString(11));
				acadamic.setSemister(resultSet.getString(13));
				acadamic.setRollno(resultSet.getString(8));
				acadamic.setEmail(resultSet.getString(12));
				acadamic.setAggregate(resultSet.getDouble(7));
				aHashtable.put(loginname, acadamic);
			}
			// con.close();;;
		}
		catch (Exception e)
		{
			LoggerManager.writeLogSevere(e);
		}
		return aHashtable;
	}

	// Getting profiles
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Hashtable getProfile(final String course,final String discipline,final String semister,final String email)
	{
		Acadamic acadamic = null;
		final Hashtable aHashtable = new Hashtable();
		try
		{
			con = dao.getConnection();
			final Statement statement = con.createStatement();
			final ResultSet resultSet = statement.executeQuery("select ld.loginname,ac.course,ac.discipline,ac.semister,ac.rollno,ag.aggregate, lp.email   " + "from LOGIN_DETAILS ld, LOGIN_PROFILE lp, ACADAMIC_DETAILS ac, STUDENT_AGGREGATES ag where " + "ac.loginname=ld.loginname and ld.loginstatus=1 and lp.email='" + email + "' " + " and ac.course='" + course + "' " + "and ac.discipline='" + discipline + "' and ac.semister='" + semister + "' and ag.loginname=ld.loginname");
			// and " +
			// "ag.aggregate>=0 and ld.loginname not in (select loginname from "
			// +
			// " placements where status='Recruited')");
			String loginname = "";
			while (resultSet.next())
			{
				acadamic = new Acadamic();
				loginname = resultSet.getString(1);
				acadamic.setLoginname(loginname);
				acadamic.setCourse(resultSet.getString(10));
				acadamic.setDiscipline(resultSet.getString(11));
				acadamic.setSemister(resultSet.getString(12));
				acadamic.setRollno(resultSet.getString(8));
				//System.out.println("GetProfile(-,-,-,-) setEmail : " + rs.getString(10));
				acadamic.setEmail(resultSet.getString(10));
				acadamic.setAggregate(resultSet.getDouble(7));
				aHashtable.put(loginname, acadamic);
			}
			// con.close();;
		}
		catch (Exception e)
		{
			LoggerManager.writeLogSevere(e);
		}
		return aHashtable;
	}

	// Getting profiles
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Hashtable getProfile(final String course, final String discipline, final String semister, final String percentage,final String email)
	{
		Acadamic acadamic = null;
		final Hashtable aHashtable = new Hashtable();
		try
		{
			con = dao.getConnection();
			final Statement statement = con.createStatement();

			final ResultSet resultSet = statement.executeQuery("select lp.email, ld.loginname,ac.course,ac.discipline,ac.semister,ac.rollno,ag.aggregate  " + "from LOGIN_DETAILS ld,LOGIN_PROFILE lp, ACADAMIC_DETAILS ac, STUDENT_AGGREGATES ag where " + "ac.loginname=ld.loginname and ld.loginstatus=1 and ac.course='" + course + "' " + "and ac.discipline='" + discipline + "' and ac.semister='" + semister + "' and " + "ag.aggregate>=" + percentage + " and " + "lp.email>=" + email
					+ " and ld.loginname not in (select loginname from " + " PLACEMENT_DETAILS where status='Recruited') and ag.loginname=ld.loginname");
			String loginname = "";
			while (resultSet.next())
			{
				acadamic = new Acadamic();
				loginname = resultSet.getString(1);
				acadamic.setLoginname(loginname);
				acadamic.setCourse(resultSet.getString(10));
				acadamic.setDiscipline(resultSet.getString(11));
				acadamic.setSemister(resultSet.getString(12));
				acadamic.setRollno(resultSet.getString(8));
				acadamic.setAggregate(resultSet.getDouble(7));

				aHashtable.put(loginname, acadamic);
			}
			// con.close();;
		}
		catch (Exception e)
		{
			LoggerManager.writeLogSevere(e);
		}
		return aHashtable;
	}
}
