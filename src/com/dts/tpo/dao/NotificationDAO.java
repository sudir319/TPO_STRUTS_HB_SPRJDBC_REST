package com.dts.tpo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.LoggerManager;
import com.dts.tpo.mapper.NotificationMapper;
import com.dts.tpo.mapper.TrainingMapper;
import com.dts.tpo.model.Company_Details;
import com.dts.tpo.model.Notification_Details;
import com.dts.tpo.model.Training_Details;


@SuppressWarnings({ "unused", "serial" })
/**
 * 
 * @author PRANEETH
 *
 */
public class NotificationDAO implements java.io.Serializable
{

	//public Notification_Details notidto;
	public Connection con;
	AbstractDataAccessObject dao = AbstractDataAccessObject.getInstance();
	boolean hibernateEnabled = dao.getHibernateEnabled();
	
	private JdbcTemplate jdbcTemplate;

	// Registering Vacancy

	public int addNotification(final Notification_Details aNotification)
	{
		int returnId = -1;
		if(hibernateEnabled)
		{
			SessionFactory factory = new Configuration().configure()
					.buildSessionFactory();
			Session session = factory.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				List notifications = session.createQuery("from Notification_Details order by notificationid asc").list();
				Notification_Details notification = null;
				for (Iterator iterator = notifications.iterator(); iterator
						.hasNext();) {
					 notification = (Notification_Details) iterator
							.next();
					System.out.println("notificationID *************** : ******************"+notification.getNotificationID());
				}
				System.out.println("notification id : ********* : "+notification.getNotificationID()+"***************");
				aNotification.setNotificationID(notification.getNotificationID() + 1);
				//System.out.println(aNotification);
				returnId = (Integer)session.save(aNotification);
				session.save(aNotification);
				//System.out.println("Notification Created date : "+aNotification.getCreateddate()+"***************");
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
				factory.close();
			}
		}
		else
		{
			
			ApplicationContext ctx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");

			AbstractDataAccessObject dao = (AbstractDataAccessObject) ctx.getBean("edao");
			 
			jdbcTemplate = dao.getJdbcTemplate();
			
			String query1 = "select max(notificationid) from Notification_Details";
	        int maxNotificationId = jdbcTemplate.queryForInt(query1);
			aNotification.setNotificationID(maxNotificationId + 1);
			String query = "insert into Notification_Details values(" + aNotification.getNotificationID() + ","
																   + aNotification.getCompanyID() + ",'"
																   + aNotification.getNoofvac() + "','"
																   + aNotification.getCategory() + "','"
																   + aNotification.getLocation() + "','"
																   + aNotification.getJobdesc() + "','"
																   + aNotification.getSkills() + "'," 
																   + "TO_DATE('" +aNotification.getCreateddate() +"', 'YYYY-MM-DD'),"
																   + "TO_DATE('" +aNotification.getExpirydate() +"', 'YYYY-MM-DD'),'"
																   + aNotification.getDesignation() + "','" 
																   + aNotification.getStatus() + "')";
			returnId = jdbcTemplate.update(query);
		}
		return returnId;
	}

	// get Vacancy details

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Hashtable getNotifications()
	{
		final Hashtable aHashtable = new Hashtable();
		if(hibernateEnabled)
		{
			SessionFactory factory = new Configuration().configure()
					.buildSessionFactory();
			Session session = factory.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				List notifications = session.createQuery(
						"FROM Notification_Details").list();
				for (Iterator iterator = notifications.iterator(); iterator
						.hasNext();) {
					Notification_Details notification = (Notification_Details) iterator
							.next();
		/*			System.out.println("Notification Id   : "
							+ notification.getNotificationID());
					System.out.println("Company Id: "
							+ notification.getCompanyID());
					System.out.println("category      : "
							+ notification.getCategory());
					System.out.println("created_Date       : "
							+ notification.getCreateddate());
					System.out.println("Desc         : "
							+ notification.getJobdesc());
					System.out.println("Satus        : "
							+ notification.getStatus());
					System.out.println("Expirydate_Date      : "
							+ notification.getExpirydate());
					System.out.println("noofvac        : "
							+ notification.getNoofvac());
					if (iterator.hasNext()) {
						System.out.println("**********************");
					}
		*/
					aHashtable.put(
							Integer.valueOf(notification.getNotificationID()),
							notification);
				}
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
				factory.close();
			}
		}
		else
		{
			System.out.println("***************else jdbctemplate");
			ApplicationContext ctx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");

			AbstractDataAccessObject dao = (AbstractDataAccessObject) ctx.getBean("edao");
			 
			jdbcTemplate = dao.getJdbcTemplate();
			String query = "select * from Notification_Details";
			
			List<Notification_Details> notificatios = jdbcTemplate.query(query, new NotificationMapper());
			System.out.println("jdbctemplate : "+notificatios);
			for (Iterator iterator = notificatios.iterator(); iterator.hasNext();) {
				Notification_Details notification = (Notification_Details) iterator.next();
				aHashtable.put(Integer.valueOf(notification.getNotificationID()),
						notification);
			} 
		}
		return aHashtable;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Hashtable getNotifications(final String user)
	{
		final Hashtable nHashtable = new Hashtable();
		final Notification_Details vacdto = new Notification_Details();
		try
		{
			con = dao.getConnection();
			final Statement statement = con.createStatement();
			final ResultSet resultSet = statement.executeQuery("select n.notificationid,n.companyid,n.noofvac,n.category,n.location,n.jobdesc,n.skills,n.createddate,n.expirydate,n.designation,n.status,p.status from NOTIFICATION_DETAILS n,PLACEMENT_DETAILS p where p.loginname='" + user + "' and p.notificationid=n.notificationid");
			int notiId = 0;
			while (resultSet.next())
			{
				notiId = resultSet.getInt(1);
				vacdto.setNotificationID(notiId);
				vacdto.setCompanyID(resultSet.getInt(2));
				vacdto.setNoofvac(resultSet.getString(3));
				vacdto.setCategory(resultSet.getString(4));
				vacdto.setLocation(resultSet.getString(5));
				vacdto.setJobdesc(resultSet.getString(6));
				vacdto.setSkills(resultSet.getString(7));
				vacdto.setCreateddate(resultSet.getDate(8));
				vacdto.setExpirydate(resultSet.getDate(9));
				vacdto.setDesignation(resultSet.getString(10));
				vacdto.setStatus(resultSet.getString(11));

				nHashtable.put(Integer.valueOf(notiId), vacdto);
			}
		}
		catch (Exception e)
		{
			LoggerManager.writeLogSevere(e);
		}
		return nHashtable;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Hashtable getNotifications(final String loginname, final int i)
	{
		final Hashtable nHashtable = new Hashtable();
		final Notification_Details vacdto = new Notification_Details();
		try
		{
			con = dao.getConnection();
			final Statement statement = con.createStatement();
			final ResultSet resultSet = statement.executeQuery("select n.notificationid,n.companyid,n.noofvac,n.category,n.location,n.jobdesc,n.skills,n.createddate,n.expirydate,n.designation,n.status,p.status from NOTIFICATION_DETAILS,PLACEMENT_DETAILS p where p.loginname='" + loginname + "' and p.notificationid=n.notificationid");
			int notiId = 0;
			while (resultSet.next())
			{
				notiId = resultSet.getInt(1);
				vacdto.setNotificationID(notiId);
				vacdto.setCompanyID(resultSet.getInt(2));
				vacdto.setNoofvac(resultSet.getString(3));
				vacdto.setCategory(resultSet.getString(4));
				vacdto.setLocation(resultSet.getString(5));
				vacdto.setJobdesc(resultSet.getString(6));
				vacdto.setSkills(resultSet.getString(7));
				vacdto.setCreateddate(resultSet.getDate(8));
				vacdto.setExpirydate(resultSet.getDate(9));
				vacdto.setDesignation(resultSet.getString(10));
				vacdto.setStatus(resultSet.getString(12));

				nHashtable.put(Integer.valueOf(notiId), vacdto);
			}
		}
		catch (Exception e)
		{
			LoggerManager.writeLogSevere(e);
		}
		return nHashtable;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Notification_Details getNotifications(final int notificationId)
	{System.out.println("NotificationDAO.getNotifications(notificationId) : " + notificationId);
	Notification_Details notification_Details = null;
	SessionFactory factory = new Configuration().configure()
			.buildSessionFactory();
	Session session = factory.openSession();
	Transaction tx = null;
	try {
		tx = session.beginTransaction();
		List notifications = session.createQuery("FROM Notification_Details where NOTIFICATIONID = " + notificationId)
				.list();
		for (Iterator iterator = notifications.iterator(); iterator.hasNext();) {
			notification_Details = (Notification_Details) iterator.next();
			System.out.println("Company Id   : "
					+ notification_Details.getCompanyID());
			System.out.println("noofvac		: "
					+ notification_Details.getNoofvac());
			System.out.println("jobdesc      : "
					+ notification_Details.getJobdesc());
			System.out.println("category       : "
					+ notification_Details.getCategory());
			System.out.println("location         : "
					+ notification_Details.getLocation());
			System.out.println("skills        : " + notification_Details.getSkills());
			System.out.println("createddate      : " + notification_Details.getCreateddate());
			System.out.println("expirydate        : " + notification_Details.getExpirydate());
			System.out.println("designation        : " + notification_Details.getDesignation());
			System.out.println("status        : " + notification_Details.getStatus());
		}
	} catch (HibernateException e) {
		if (tx != null)
			tx.rollback();
		e.printStackTrace();
	} finally {
		session.close();
		factory.close();
	}
	return notification_Details;
	}

	// getStudentsByCompany
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Hashtable getStudentsByCompany(final int companyid)
	{
		final Hashtable nHashtable = new Hashtable();
		final Notification_Details vacdto = new Notification_Details();
		try
		{
			con = dao.getConnection();
			final Statement statement = con.createStatement();
			final ResultSet resultSet = statement.executeQuery("select n.notificationid,n.createddate,p.loginname,a.rollno,p.status " + "from NOTIFICATION_DETAILS n, PLACEMENT_DETAILS p, acadamicdetails a where " + "n.companyid=" + companyid + " and a.loginname=p.loginname and p.status='Recruited'");
			int notiId = 0;
			while (resultSet.next())
			{
				notiId = resultSet.getInt(1);
				vacdto.setNotificationID(notiId);
				vacdto.setCreateddate(resultSet.getDate(2));
				vacdto.setLoginname(resultSet.getString(3));
				vacdto.setRollNo(resultSet.getString(4));
				vacdto.setStatus(resultSet.getString(5));
				nHashtable.put(Integer.valueOf(notiId), vacdto);
			}
		}
		catch (Exception e)
		{
			LoggerManager.writeLogSevere(e);
		}
		return nHashtable;
	}

	public void updateNotification(final Notification_Details aNotification)
	{
		if(hibernateEnabled)
		{
			SessionFactory factory = new Configuration().configure()
					.buildSessionFactory();
			Session session = factory.openSession();
			Transaction tx = null;
			Integer employeeID = null;
			try {
				tx = session.beginTransaction();
				session.update(aNotification);
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
				factory.close();
			}
		}
		else
		{
			System.out.println("updateNotificationDAo else************************************");
			ApplicationContext ctx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");

			AbstractDataAccessObject dao = (AbstractDataAccessObject) ctx.getBean("edao");
			 
			jdbcTemplate = dao.getJdbcTemplate();
			
			System.out.println("Notification Id   : "
					+ aNotification.getNotificationID());
			System.out.println("Company Id: "
					+ aNotification.getCompanyID());
			System.out.println("category      : "
					+ aNotification.getCategory());
			System.out.println("created_Date       : "
					+ aNotification.getCreateddate());
			System.out.println("Desc         : "
					+ aNotification.getJobdesc());
			System.out.println("Satus        : "
					+ aNotification.getStatus());
			System.out.println("Expirydate_Date      : "
					+ aNotification.getExpirydate());
			System.out.println("noofvac        : "
					+ aNotification.getNoofvac());
			
			String query = "update Notification_Details set companyid=" +aNotification.getCompanyID()
					   + ",noofvac='" + aNotification.getNoofvac()
					   + "',Category='" + aNotification.getCategory()
					   + "',Location='" + aNotification.getLocation()
					   + "',Jobdesc='" + aNotification.getJobdesc()
					   + "',Skills='" + aNotification.getSkills()
					   + "',createddate=" + "TO_DATE('" +aNotification.getCreateddate() +"', 'YYYY-MM-DD')"
					   + ",expirydate=" + "TO_DATE('" +aNotification.getExpirydate() +"', 'YYYY-MM-DD')"
					   + ",designation='"+aNotification.getDesignation() 
					   + "',status='"+aNotification.getStatus()
					   + "' where notificationid=" + aNotification.getNotificationID()+ "";
			
			System.out.println("Data before update : "+query);
			try{
				System.out.println("before update in try ********************");
				jdbcTemplate.update(query);
				System.out.println("After update in try ********************");
			}
			catch(Throwable t){t.printStackTrace();}
		}
	}

	public void deleteNotification(final int notificationid)
	{
		if(hibernateEnabled)
		{
			SessionFactory factory = new Configuration().configure()
					.buildSessionFactory();
			Session session = factory.openSession();
			Transaction tx = null;
			Notification_Details aNotification = new Notification_Details();
			aNotification.setNotificationID(notificationid);
			try {
				tx = session.beginTransaction();
				session.delete(aNotification);
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
				factory.close();
			}
		}
		else
		{
			System.out.println("delete notification else ***********************");
			ApplicationContext ctx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");

			AbstractDataAccessObject dao = (AbstractDataAccessObject) ctx.getBean("edao");
			 
			jdbcTemplate = dao.getJdbcTemplate();
			
			System.out.println("before delete placement details*****************");
			String query1 = "delete from PLACEMENT_DETAILS where notificationid=" + notificationid+ " ";
			//jdbcTemplate.update(query1);
			System.out.println("after delete placement details *************");
			
			System.out.println("before delete notification *************************");
			String query = "delete from Notification_Details where notificationid=" + notificationid + " on delete cascade";
			try
			{
				jdbcTemplate.update(query);
			}
			catch(Throwable t){t.printStackTrace();}
			System.out.println("After delete notification*************");
		}
	}

	public void addToNotification(final String loginName, final int notiId, final String rollNo)
	{
		try
		{
			con = dao.getConnection();
			final PreparedStatement pstatement = con.prepareStatement("insert into PLACEMENT_DETAILS values(?,?,?,?)");

			pstatement.setInt(1, notiId);
			pstatement.setString(2, rollNo);
			pstatement.setString(3, loginName);
			pstatement.setString(4, "Process");
			pstatement.executeUpdate();
		}
		catch (Exception e)
		{
			LoggerManager.writeLogWarning(e);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Hashtable listStudents()
	{
		final Hashtable aHashtable = new Hashtable();
		try
		{
			con = dao.getConnection();
			final Statement statement = con.createStatement();
			final ResultSet resultSet = statement.executeQuery("select notificationid, rollno, loginname, status from PLACEMENT_DETAILS");
			Notification_Details aNotification = null;
			int i = 1;
			while (resultSet.next())
			{
				aNotification = new Notification_Details();
				aNotification.setNotificationID(resultSet.getInt(1));
				aNotification.setRollNo(resultSet.getString(2));
				aNotification.setLoginname(resultSet.getString(3));
				aNotification.setStatus(resultSet.getString(4));

				aHashtable.put(Integer.valueOf(i), aNotification);
				i++;
			}

		}
		catch (Exception e)
		{
			LoggerManager.writeLogWarning(e);
		}
		
		return aHashtable;
	}

	public void updateStatus(final Notification_Details aNotification)
	{
		try
		{
			con = dao.getConnection();
			final PreparedStatement pstatement = con.prepareStatement("update PLACEMENT_DETAILS set status=? where notificationid=? and loginname=?");

			pstatement.setInt(2, aNotification.getNotificationID());
			pstatement.setString(3, aNotification.getLoginname());
			pstatement.setString(1, aNotification.getStatus());
			pstatement.executeUpdate();
		}
		catch (Exception e)
		{
			LoggerManager.writeLogWarning(e);
		}
	}

	public void setAggregate(final String loginName, final String aggregate)
	{
		try
		{
			con = dao.getConnection();
			final Statement statement = con.createStatement();
			statement.executeUpdate("insert into STUDENT_AGGREGATES values('" + loginName + "'," + aggregate + ")");
		}
		catch (Exception e)
		{
			LoggerManager.writeLogWarning(e);
		}
	}

	public void updateAggregate(final String loginName, final String aggregate)
	{
		try
		{
			con = dao.getConnection();
			final Statement statement = con.createStatement();
			statement.executeUpdate("update STUDENT_AGGREGATES set aggregate=" + aggregate + " where loginname='" + loginName + "'");
		}
		catch (Exception e)
		{
			LoggerManager.writeLogWarning(e);
		}
	}
}