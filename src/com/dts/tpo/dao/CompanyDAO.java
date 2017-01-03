package com.dts.tpo.dao;

import java.sql.*;
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
import com.dts.tpo.mapper.CompanyMapper;
import com.dts.tpo.mapper.TrainingMapper;
import com.dts.tpo.model.Company_Details;
import com.dts.tpo.model.Training_Details;

@SuppressWarnings("serial")
public class CompanyDAO implements java.io.Serializable {
	Connection con;
	AbstractDataAccessObject dao = AbstractDataAccessObject.getInstance();
	boolean hibernateEnabled = dao.getHibernateEnabled();
	private JdbcTemplate jdbcTemplate;
	
	public int addCompany(final Company_Details aCompany) {
		int returnId = -1;
		if(hibernateEnabled)
		{
			SessionFactory factory = new Configuration().configure()
					.buildSessionFactory();
			Session session = factory.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				System.out.println("company Details : "+aCompany);
				returnId = (Integer)session.save(aCompany);
				session.save(aCompany);
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
			
			String query1 = "select max(companyid) from Company_Details";
	        int maxCompanyId = jdbcTemplate.queryForInt(query1);
	        
	        System.out.println("maxCompanyId---------------" + maxCompanyId);
			
			aCompany.setCompanyId(maxCompanyId + 1); 
			System.out.println("Companyid : "+aCompany.getCompanyId()+"*****************");
			String query = "insert into Company_Details values(" + aCompany.getCompanyId() + ",'"
																   + aCompany.getCompanyName() + "','" 
																   + aCompany.getProfile() +"','"
																   + aCompany.getStreet() +"','"
																   + aCompany.getCity() +"','"
																   + aCompany.getState() +"','"
																   + aCompany.getCountry() +"','"
																   + aCompany.getPhone() +"','"
																   + aCompany.getEmail() +"')";
			System.out.println("id : "+aCompany.getCompanyId());
			System.out.println("name : "+aCompany.getCompanyName());
			System.out.println("profile : "+aCompany.getProfile());
			System.out.println("street : "+aCompany.getStreet());
			System.out.println("city : "+aCompany.getCity());
			System.out.println("state : "+aCompany.getState());
			System.out.println("Country : "+aCompany.getCountry());
			System.out.println("phone : "+aCompany.getPhone());
			System.out.println("email : "+aCompany.getEmail());
			returnId = jdbcTemplate.update(query);
		}
		return returnId;
	}
	/*
	public void addCompany(final Company_Details aCompany) {
		Session session = factory.openSession();
	      Transaction tx = null;
	      Integer companyId = null;
	      try{
		         tx = session.beginTransaction();
		         String name = 
		         Company_details company = new Company_details(name, profile, street, city, state, country, phone, email);
		         companyId = (Integer) session.save(company); 
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		      return companyId;
	}
	*/
	public void updateCompany(final Company_Details aCompany) {
		if(hibernateEnabled)
		{
			SessionFactory factory = new Configuration().configure()
					.buildSessionFactory();
			Session session = factory.openSession();
			Transaction tx = null;
			Integer employeeID = null;
			try {
				tx = session.beginTransaction();
				session.update(aCompany);
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
			System.out.println("updateCompanyDao else************************************");
			ApplicationContext ctx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");

			AbstractDataAccessObject dao = (AbstractDataAccessObject) ctx.getBean("edao");
			 
			jdbcTemplate = dao.getJdbcTemplate();
			
			System.out.println("id : "+aCompany.getCompanyId());
			System.out.println("name : "+aCompany.getCompanyName());
			System.out.println("profle : "+aCompany.getProfile());
			System.out.println("Street : "+aCompany.getStreet());
			System.out.println("city : "+aCompany.getCity());
			System.out.println("state : "+aCompany.getState());
			System.out.println("country : "+aCompany.getCountry());
			System.out.println("phone : "+aCompany.getPhone());
			System.out.println("email : "+aCompany.getEmail());
			
			String query = "update Company_Details set companyName='" +aCompany.getCompanyName()
					   + "',profile='" + aCompany.getProfile()
					   + "',street='" + aCompany.getStreet()
					   + "',city='" + aCompany.getCity()
					   + "',state='" + aCompany.getState()
					   + "',country='" + aCompany.getCountry()
					   + "',phone='"+ aCompany.getPhone() 
					   + "',email='"+ aCompany.getEmail()
					   + "' where companyId=" + aCompany.getCompanyId()+ "";
			
			try{
				jdbcTemplate.update(query);
			}
			catch(Throwable t){t.printStackTrace();}
		}
	}

	public Company_Details getCompanyDetails(final int companyid) {
		System.out.println("CompanyDAO.getCompanyDetails(companyid) : " + companyid);
		Company_Details company_Details = null;
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List companies = session.createQuery("FROM Company_Details where COMPANYID = " + companyid)
					.list();
			for (Iterator iterator = companies.iterator(); iterator.hasNext();) {
				company_Details = (Company_Details) iterator.next();
//				System.out.println("Company Id   : "
//						+ company_Details.getCompanyId());
//				System.out.println("Company Name : "
//						+ company_Details.getCompname());
//				System.out.println("profile      : "
//						+ company_Details.getProfile());
//				System.out.println("street       : "
//						+ company_Details.getStreet());
//				System.out.println("city         : "
//						+ company_Details.getCity());
//				System.out.println("state        : " + company_Details.getState());
//				System.out.println("country      : " + company_Details.getCountry());
//				System.out.println("phone        : " + company_Details.getPhone());
//				System.out.println("email        : " + company_Details.getEmail());
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
		return company_Details;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Hashtable listCompanies() {
		final Hashtable aHashtable = new Hashtable();
		if(hibernateEnabled)
		{
			System.out.println("hibernateEnabled *************: "+hibernateEnabled);
			SessionFactory factory = new Configuration().configure()
					.buildSessionFactory();
			Session session = factory.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				List companies = session.createQuery("FROM Company_Details").list();
				for (Iterator iterator = companies.iterator(); iterator.hasNext();) {
					Company_Details company = (Company_Details) iterator.next();
	//				System.out.println("Company Id   : " + company.getCompanyId());
	//				System.out
	//						.println("Company Name : " + company.getCompname());
	//				System.out.println("Profile      : " + company.getProfile());
	//				System.out.println("Street       : " + company.getStreet());
	//				System.out.println("City         : " + company.getCity());
	//				System.out.println("State        : " + company.getState());
	//				System.out.println("Country      : " + company.getCountry());
	//				System.out.println("Phone        : " + company.getPhone());
	//				System.out.println("Email        : " + company.getEmail());
	//				if (iterator.hasNext()) {
	//					System.out.println("**********************");
	//				}
					aHashtable.put(Integer.valueOf(company.getCompanyId()),
							company);
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
			//System.out.println("***************else jdbctemplate");
			ApplicationContext ctx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");

			AbstractDataAccessObject dao = (AbstractDataAccessObject) ctx.getBean("edao");
			 
			jdbcTemplate = dao.getJdbcTemplate();
			String query = "select * from COMPANY_DETAILS";
			
			List<Company_Details> companies = jdbcTemplate.query(query, new CompanyMapper());
			System.out.println("jdbctemplate : "+companies);
			for (Iterator iterator = companies.iterator(); iterator.hasNext();) {
				Company_Details company = (Company_Details) iterator.next();
				aHashtable.put(Integer.valueOf(company.getCompanyId()),
						company);
			}
		}
		return aHashtable;
	}

	public void deleteCompany(final int companyid) {
		if(hibernateEnabled)
		{
			SessionFactory factory = new Configuration().configure()
					.buildSessionFactory();
			Session session = factory.openSession();
			Transaction tx = null;
			Company_Details aCompany = new Company_Details();
			aCompany.setCompanyId(companyid);
			try {
				tx = session.beginTransaction();
				session.delete(aCompany);
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
			
			String query = "delete from Company_Details where companyid=" + companyid + " ";
			jdbcTemplate.update(query);
		}
	}
}
