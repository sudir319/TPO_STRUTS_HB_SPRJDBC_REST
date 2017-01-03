/*
 * SecurityDAO.java
 *
 * 
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
public class SecurityDAO implements java.io.Serializable
{
	/**
	 * for connection
	 */
	Connection con;
	/**
	 * 
	 */
	AbstractDataAccessObject dao = AbstractDataAccessObject.getInstance();
	/**
	 * 
	 */
	private String desc;
	/**
	 * 
	 */
	private boolean flag;

	/** Creates a new instance of SecurityDAO */
	public SecurityDAO()
	{
		//System.out.println("from SecurityDao Constuctor");
		// getting Database Connection
		con = dao.getConnection();
	}

	/**
	 * Compare Password
	 * @param regbean
	 * @return
	 */
	public boolean checkPassword(final Profile regbean)
	{
		final String loginid = regbean.getLoginID();
		final String oldpassword = regbean.getPassword();

		try
		{
			final PreparedStatement pstatement = con.prepareStatement("select loginname, password, firstname, lastname, logintype, loginstatus, regdate, squestionid, sanswer,firstlogin, passmodifieddate from LOGIN_DETAILS where password=? and loginname=?");
			pstatement.setString(1, oldpassword);
			pstatement.setString(2, loginid);
			final ResultSet resultSet = pstatement.executeQuery();
			if (resultSet.next())
			{
				flag = true;
				LoggerManager.writeLogInfo("Login Success");
			}
			else
			{
				flag = false;
			}
		}
		catch (SQLException ex)
		{
			LoggerManager.writeLogSevere(ex);
			LoggerManager.writeLogInfo("Database Connection problem");
			flag = false;
		}
		return flag;
	}

	/**
	 * Compare Password
	 * @param loginname
	 * @return
	 */
	public int checkFirstLogin(final String loginname)
	{
		int fstatus = 2;
		try
		{
			con.setAutoCommit(true);
			final PreparedStatement pstatement = con.prepareStatement("select firstlogin from LOGIN_DETAILS where loginname=?");
			pstatement.setString(1, loginname);
			final ResultSet resultSet = pstatement.executeQuery();

			if (resultSet.next())
			{
				fstatus = resultSet.getInt(1);
			}
			// con.close();
		}
		catch (SQLException ex)
		{
			LoggerManager.writeLogSevere(ex);
			LoggerManager.writeLogInfo("Database Connection problem");
			flag = false;
		}
		return fstatus;
	}

	/**
	 *  Login Check
	 * @param regbean
	 * @return
	 */
	public String loginCheck(final Profile regbean)
	{
		//System.out.println("from login check");
		final String loginid = regbean.getLoginID();
		//System.out.println("LoginID from securityDao: "+loginid);
		final String password = regbean.getPassword();
		//System.out.println("LoginPassword from securityDao: "+password);
		//System.out.println("After pAssword in securityDao");
		String role = "";
		try
		{
			//System.out.println("In try from securityDao");
			con.setAutoCommit(true);
			final PreparedStatement pstatment = con.prepareStatement("select logintype from LOGIN_DETAILS where password=? and loginname=? and loginstatus=1");
			pstatment.setString(2, loginid);
			pstatment.setString(1, password);

			final ResultSet resultSet = pstatment.executeQuery();
			if (resultSet.next())
			{
				/*
				 * Statement st=con.createStatement(); st.executeUpdate(
				 * "Update login_details set firstlogin=1 where loginname='"
				 * +loginid+"'");
				 */
				role = resultSet.getString(1);
				desc = "Login Success";
			}
			else
			{
				flag = false;
				desc = "Entered Invalid password";
			}
		}
		catch (SQLException ex)
		{
			LoggerManager.writeLogSevere(ex);
			desc = "Database Connection problem";
			flag = false;
		}
		loginaudit(loginid, desc);
		return role;
	}

	/**
	 *  Method for login audit
	 * @param loginid
	 * @param desc
	 */
	public void loginaudit(final String loginid, final String desc)
	{
		try
		{
			final String newdate = DateWrapper.parseDate(new Date());
			final PreparedStatement pstatement = con.prepareStatement("insert into LOGIN_AUDIT values(?,?,?)");
			pstatement.setString(1, loginid);
			pstatement.setString(2, newdate);
			pstatement.setString(3, desc);
			final int updated = pstatement.executeUpdate();
			if (updated == 1){
				con.commit();
			}
			else{
				con.rollback();
			}
			// con.close();
		}
		catch (Exception e)
		{
			try
			{
				con.rollback();
			}
			catch (SQLException ex)
			{
				LoggerManager.writeLogSevere(ex);
			}
			LoggerManager.writeLogSevere(e);
		}
	}

	/**
	 * Change Password
	 * @param regbean
	 * @return
	 */
	public boolean changePassword(final Profile regbean)
	{
		final String loginid = regbean.getLoginID();
		final String oldpassword = regbean.getPassword();
		final String newpassword = regbean.getNewPassword();
		try
		{
			con.setAutoCommit(false);
			final String newdate = DateWrapper.parseDate(new Date());
			final PreparedStatement pstatement = con.prepareStatement("UPDATE LOGIN_DETAILS SET password=?,passmodifieddate=? WHERE loginname=? and password=?");

			pstatement.setString(1, newpassword);
			pstatement.setString(2, newdate);
			pstatement.setString(3, loginid);
			pstatement.setString(4, oldpassword);

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
			catch (SQLException sex)
			{
				LoggerManager.writeLogSevere(sex);
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
			catch (SQLException sex)
			{
				LoggerManager.writeLogSevere(sex);
			}
		}
		return flag;
	}

	/**
	 * Change Secret Question
	 * @param regbean
	 * @return
	 */
	public boolean changeQuestion(final Profile regbean)
	{
		final String loginid = regbean.getLoginID();
		final String password = regbean.getPassword();
		String secretquestid = regbean.getSecretQuestionID();
		final String ownsecretquest = regbean.getOwnSecretQuestion();
		final String secretans = regbean.getSecretAnswer();

		PreparedStatement pstatement;
		int updated = 0;
		try
		{
			con.setAutoCommit(false);
			if (checkPassword(regbean))
			{
				if (secretquestid != null && secretquestid.equals(""))
				{
					final Statement statement = con.createStatement();
					final ResultSet resultSet = statement.executeQuery("select (max(questionid))+1 from QUESTION_BASE");

					if (resultSet.next()){
						secretquestid = resultSet.getString(1);
					}
					pstatement = con.prepareStatement("INSERT INTO question_base VALUES(?,?)");

					pstatement.setString(1, secretquestid);
					pstatement.setString(2, ownsecretquest);

					pstatement.executeUpdate();
				}

				pstatement = con.prepareStatement("UPDATE LOGIN_DETAILS SET squestionid=?,sanswer=? WHERE loginname=? and password=?");

				pstatement.setString(2, secretans);
				pstatement.setString(3, loginid);
				pstatement.setString(4, password);

				updated = pstatement.executeUpdate();
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
			catch (SQLException sex)
			{
				LoggerManager.writeLogSevere(sex);
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
			catch (SQLException sex)
			{
				LoggerManager.writeLogSevere(sex);
			}
		}
		return flag;
	}

	/**
	 *  Recover Password using Existed Question
	 * @param regbean
	 * @return
	 */
	public String recoverPasswordByExistQuestion(final Profile regbean)
	{
		String password;
		final String loginid = regbean.getLoginID();
		final String secretquestid = regbean.getSecretQuestionID();
		final String secretans = regbean.getSecretAnswer();
		try
		{
			con.setAutoCommit(true);
			final PreparedStatement pstatement = con.prepareStatement("SELECT password FROM LOGIN_DETAILS  WHERE loginname=? and squestionid=? and sanswer=?");

			pstatement.setString(1, loginid);
			pstatement.setString(2, secretquestid);
			pstatement.setString(3, secretans);

			final ResultSet resultSet = pstatement.executeQuery();

			if (resultSet.next()){
				password = resultSet.getString(1);
			}
			else{
				password = "";
			}
			// con.close();
		}
		catch (SQLException ex)
		{
			LoggerManager.writeLogSevere(ex);
			password = "";
		}
		catch (Exception e)
		{
			LoggerManager.writeLogSevere(e);
			password = "";
		}
		return password;
	}

	/**
	 * Recover Password using OWN Question
	 * @param regbean
	 * @return
	 */
	public String recoverPasswordByOWNQuestion(final Profile regbean)
	{
		String password;
		final String loginid = regbean.getLoginID();
		final String ownsecretquest = regbean.getOwnSecretQuestion();
		final String secretans = regbean.getSecretAnswer();
		try
		{
			con.setAutoCommit(true);
			final PreparedStatement pstatement = con.prepareStatement("SELECT password FROM LOGIN_DETAILS  WHERE loginname=? and squestionid=(select questionid from QUESTION_BASE where questiondetails=?) and sanswer=?");

			pstatement.setString(1, loginid);
			pstatement.setString(2, ownsecretquest);
			pstatement.setString(3, secretans);

			final ResultSet resultSet = pstatement.executeQuery();

			if (resultSet.next()){
				password = resultSet.getString(1);
			}
			else{
				password = "";
			}
			// con.close();
		}
		catch (SQLException ex)
		{
			LoggerManager.writeLogSevere(ex);
			password = "";
		}
		catch (Exception e)
		{
			LoggerManager.writeLogSevere(e);
			password = "";
		}
		return password;
	}
	/**
	 * 
	 */
	public String checkUser(final String username)
	{
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 
	 * @param attribute
	 */
	public void loginaudit(final String attribute)
	{
		// TODO Auto-generated method stub

	}

}
