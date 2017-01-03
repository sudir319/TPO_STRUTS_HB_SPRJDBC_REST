/*
 * ProfileDAO.java
 */

package com.dts.dae.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;
import com.dts.dae.model.Profile;

/**
 * 
 * @author
 */
@SuppressWarnings("serial")
public class ProfileDAO implements java.io.Serializable
{
	/**
	 * for creating Connection
	 */
	public Connection con;
	/**
	 * for AbstractDataAccessObject
	 */
	final private AbstractDataAccessObject dao = AbstractDataAccessObject.getInstance();
	/**
	 * 
	 */
	private boolean flag;

	/**
	 * User Registration
	 * @param regbean
	 * @return
	 */
	public boolean registration(final Profile regbean)
	{
		final String loginid = regbean.getLoginID();
		final String password = regbean.getPassword();
		final String firstname = regbean.getFirstName();
		final String lastname = regbean.getLastName();
		final String logintype = regbean.getLoginType();
		final int status = regbean.getStatus();
		String secretquest = regbean.getSecretQuestionID();
		final String ownsecretquest = regbean.getOwnSecretQuestion();
		final String secretans = regbean.getSecretAnswer();
		final int firstlogin = regbean.getFirstLogin();
		final String bdate = DateWrapper.parseDate(regbean.getBirthDate());
		final String hno = regbean.getHno();
		final String street = regbean.getStreet();
		final String city = regbean.getCity();
		final String state = regbean.getState();
		final String country = regbean.getCountry();
		final String pincode = regbean.getPincode();
		final String phoneno = regbean.getPhoneNo();
		final String email = regbean.getEmail();
		final String locale = regbean.getLocale();

		try
		{
			con = dao.getConnection();
			con.setAutoCommit(false);
			PreparedStatement pstatement = null;
			final Statement statement = con.createStatement();
			int updated = 0;
			if (secretquest != null && secretquest.equals(""))
			{
				final ResultSet resultSet = statement.executeQuery("select (max(questionid))+1 from QUESTION_BASE");
				if (resultSet.next()){
					secretquest = resultSet.getString(1);
				}
				pstatement = con.prepareStatement("INSERT INTO QUESTION_BASE VALUES(?,?)");

				pstatement.setString(1, secretquest);
				pstatement.setString(2, ownsecretquest);

				pstatement.executeUpdate();
			}
			final String newdate = DateWrapper.parseDate(new Date());

			pstatement = con.prepareStatement("insert into LOGIN_DETAILS values(?,?,?,?,?,?,?,?,?,?,?)");

			pstatement.setString(1, loginid);
			pstatement.setString(2, password);
			pstatement.setString(3, firstname);
			pstatement.setString(4, lastname);
			pstatement.setString(5, logintype);
			pstatement.setInt(6, status);
			pstatement.setString(7, newdate);
			pstatement.setString(8, secretquest);
			pstatement.setString(9, secretans);
			pstatement.setInt(10, firstlogin);
			pstatement.setString(11, newdate);
			updated = pstatement.executeUpdate();
			if (updated == 1)
			{
				pstatement = con.prepareStatement("insert into LOGIN_PROFILE values(?,?,?,?,?,?,?,?,?,?,?,?)");
				pstatement.setString(1, loginid);
				pstatement.setString(2, bdate);
				pstatement.setString(3, hno);
				pstatement.setString(4, street);
				pstatement.setString(5, city);
				pstatement.setString(6, state);
				pstatement.setString(7, country);
				pstatement.setString(8, pincode);
				pstatement.setString(9, phoneno);
				pstatement.setString(10, email);
				pstatement.setString(11, locale);
				pstatement.setString(12, newdate);
				updated = pstatement.executeUpdate();
			}
			if (updated == 1)
			{
				flag = true;
				con.commit();
			}
			else
			{
				flag = false;
				con.rollback();
			}
			// con.close();
		}
		catch (SQLException ex)
		{
			LoggerManager.writeLogWarning(ex);
			flag = false;
			try
			{
				con.rollback();
			}
			catch (SQLException sex)
			{
				LoggerManager.writeLogWarning(sex);
			}
		}
		catch (Exception e)
		{
			LoggerManager.writeLogWarning(e);
			flag = false;
			try
			{
				con.rollback();
			}
			catch (SQLException se)
			{
				LoggerManager.writeLogWarning(se);
			}
		}
		return flag;
	}

	/**
	 * Getting profile
	 * @param loginname
	 * @return
	 */
	public Profile getProfile(final String loginname)
	{
		Profile profile = null;
		try
		{
			con = dao.getConnection();
			final Statement statement = con.createStatement();
			final ResultSet resultSet = statement.executeQuery("select ld.firstname,ld.lastname,lp.birthdate,lp.hno,lp.street,lp.city,lp.state,lp.country,lp.pincode,lp.contactno,lp.email from LOGIN_DETAILS ld,LOGIN_PROFILE lp where ld.loginname=lp.loginid and ld.loginname='" + loginname + "'");
			if (resultSet.next())
			{
				profile = new Profile();
				profile.setLoginID(loginname);
				profile.setFirstName(resultSet.getString(1));
				profile.setLastName(resultSet.getString(2));
				profile.setBirthDate1(resultSet.getDate(3));
				profile.setHno(resultSet.getString(4));
				profile.setStreet(resultSet.getString(5));
				profile.setCity(resultSet.getString(5));
				profile.setState(resultSet.getString(6));
				profile.setCountry(resultSet.getString(7));
				profile.setPincode(resultSet.getString(9));
				profile.setPhoneNo(resultSet.getString(10));
				profile.setEmail(resultSet.getString(11));
			}
		}
		catch (Exception e)
		{
			LoggerManager.writeLogSevere(e);
		}
	/*	finally{
			try{
				if(statement != null){statement.close();}
				if(resultSet != null){resultSet.close();}
			}catch(SQLException e){
				LoggerManager.writeLogSevere(e);
			}
		}
	*/
		return profile;
	}

	/**
	 * Modify Profile
	 * @param regbean
	 * @return
	 */
	public boolean modifyProfile(final Profile regbean)
	{
		final String loginid = regbean.getLoginID();
		final String hno = regbean.getHno();
		final String street = regbean.getStreet();
		final String bdate = DateWrapper.parseDate(regbean.getBirthDate());
		final String city = regbean.getCity();
		final String state = regbean.getState();
		final String country = regbean.getCountry();
		final String pincode = regbean.getPincode();
		final String contactno = regbean.getPhoneNo();
		final String email = regbean.getEmail();

		final String firstname = regbean.getFirstName();
		final String lastname = regbean.getLastName();
		
		PreparedStatement pstatement;
		try
		{
			con = dao.getConnection();
			con.setAutoCommit(false);
			pstatement= con.prepareStatement("UPDATE LOGIN_PROFILE SET birthdate=?,hno=?,street=?,city=?,state=?,country=?,pincode=?,contactno=?,email=?,profilemodifieddate=? WHERE loginid=?");
			final PreparedStatement pst1 = con.prepareStatement("UPDATE LOGIN_DETAILS SET firstname=?,lastname=? WHERE loginname=?");

			pstatement.setString(1, bdate);
			pstatement.setString(2, hno);
			pstatement.setString(3, street);
			pstatement.setString(4, city);
			pstatement.setString(5, state);
			pstatement.setString(6, country);
			pstatement.setString(7, pincode);
			pstatement.setString(8, contactno);
			pstatement.setString(9, email);
			pstatement.setString(10, DateWrapper.parseDate(new Date()));
			pstatement.setString(11, loginid);

			pst1.setString(1, firstname);
			pst1.setString(2, lastname);
			pst1.setString(3, loginid);

			int updated = pstatement.executeUpdate();

			if (updated != 0)
			{
				updated = pst1.executeUpdate();
				if (updated != 0)
				{
					flag = true;
					con.commit();
				}
				else
				{
					flag = false;
					con.rollback();
				}
			}
			else
			{
				flag = false;
				con.rollback();
			}
			// con.close();
		}
		catch (SQLException ex)
		{
			LoggerManager.writeLogSevere(ex);
			flag = false;
			try
			{
				con.rollback();
			}
			catch (SQLException se)
			{
				LoggerManager.writeLogSevere(se);
			}
		}
		catch (Exception e)
		{
			LoggerManager.writeLogSevere(e);
			flag = false;
			try
			{
				con.rollback();
			}
			catch (SQLException se)
			{
				LoggerManager.writeLogSevere(se);
			}
		}
		return flag;
	}
	/**
	 * changing account Status
	 * @param loginid
	 * @param status
	 * @return
	 */
	public boolean changeAccountStatus(final String loginid, int status)
	{
		try
		{
			con = dao.getConnection();
			con.setAutoCommit(false);
			if(status == 0){
				status = 1;
			}
			else{
				status = 0;
			}
			final PreparedStatement pstatement= con.prepareStatement("UPDATE LOGIN_DETAILS SET loginstatus=? WHERE loginname=?");

			pstatement.setInt(1, status);
			pstatement.setString(2, loginid);
			final int updated = pstatement.executeUpdate();

			if (updated == 1)
			{
				flag = true;
				con.commit();
			}
			else
			{
				flag = false;
				con.rollback();
			}
			// con.close();
		}
		catch (SQLException ex)
		{
			LoggerManager.writeLogSevere(ex);
			flag = false;
			try
			{
				con.rollback();
			}
			catch (SQLException se)
			{
				LoggerManager.writeLogSevere(se);
			}
		}
		catch (Exception e)
		{
			LoggerManager.writeLogSevere(e);
			flag = false;
			try
			{
				con.rollback();
			}
			catch (SQLException se)
			{
				LoggerManager.writeLogSevere(se);
			}
		}
		return flag;
	}
}
