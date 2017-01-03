package com.dts.tpo.dao;

import java.sql.Connection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.tpo.mapper.TrainingMapper;
import com.dts.tpo.model.Training_Details;

@SuppressWarnings("serial")
public class TrainingDAO implements java.io.Serializable {
	Connection con;
	AbstractDataAccessObject dao = AbstractDataAccessObject.getInstance();
	boolean hibernateEnabled = dao.getHibernateEnabled();
	
	private JdbcTemplate jdbcTemplate;

	public int addTraining(final Training_Details aTraning) {
		int returnId = -1;
		int trainingId = -1;
		if(hibernateEnabled)
		{
			SessionFactory factory = new Configuration().configure()
					.buildSessionFactory();
			Session session = factory.openSession();
			
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				
				Criteria criteria = session
					    .createCriteria(Training_Details.class)
					    .setProjection(Projections.max("trainingId"));
					trainingId = (Integer)criteria.uniqueResult();
					System.out.println("********AddTriningDAO trainingID : "+trainingId);
					aTraning.setTrainingId(trainingId + 1);
				
				returnId = (Integer)session.save(aTraning);
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
			
			String query1 = "select max(trainingId) from Training_Details";
	        int maxTrainingId = jdbcTemplate.queryForInt(query1);
			
			aTraning.setTrainingId(maxTrainingId + 1);
			System.out.println("TraininId : "+aTraning.getTrainingId()+"*****************");
			String query = "insert into Training_Details values(" + aTraning.getTrainingId() + ",'"
																   + aTraning.getTrainingName() + "'," 
																   + "TO_DATE('" +aTraning.getStart_date() +"', 'YYYY-MM-DD'),'"
																   + aTraning.getStart_time() +"','"
																   + aTraning.getTrainingdesc() +"','"
																   + aTraning.getStatus() +"',"
																   + "TO_DATE('" +aTraning.getEnd_date() +"', 'YYYY-MM-DD'),'"
																   + aTraning.getEnd_time() + "')";
			returnId = jdbcTemplate.update(query);
		}
		return returnId;
	}

	/**
	 * This is test <b>method</b>
	 * 
	 * @param aTraning
	 */
	public void updateTraining(final Training_Details aTraning) {
		if(hibernateEnabled)
		{
			SessionFactory factory = new Configuration().configure()
					.buildSessionFactory();
			Session session = factory.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.update(aTraning);
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
			System.out.println("updateTrainingDAO else************************************");
			ApplicationContext ctx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");

			AbstractDataAccessObject dao = (AbstractDataAccessObject) ctx.getBean("edao");
			 
			jdbcTemplate = dao.getJdbcTemplate();
			String query = "update Training_Details set TrainingName='" +aTraning.getTrainingName()
					   + "',Start_date=" + "TO_DATE('" +aTraning.getStart_date() +"', 'YYYY-MM-DD')"
					   + ",Start_time='" + aTraning.getStart_time()
					   + "',TrainingDesc='" + aTraning.getTrainingdesc()
					   + "',Status='" + aTraning.getStatus()
					   + "',End_date=" + "TO_DATE('" +aTraning.getEnd_date() +"', 'YYYY-MM-DD')"
					   + ",End_time='"+aTraning.getEnd_time() 
					   + "' where trainingID=" + aTraning.getTrainingId()+ "";
			
			try{
				jdbcTemplate.update(query);
			}
			catch(Throwable t){t.printStackTrace();}
		}
	}

	// delete Training

	public void deleteTraining(final int trainingid) {
		if(hibernateEnabled)
		{
			SessionFactory factory = new Configuration().configure()
					.buildSessionFactory();
			Session session = factory.openSession();
			Transaction tx = null;
			Training_Details aTraning = new Training_Details();
			aTraning.setTrainingId(trainingid);
			try {
				tx = session.beginTransaction();
				session.delete(aTraning);
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
			
			String query = "delete from Training_Details where trainingid=" + trainingid + " ";
			jdbcTemplate.update(query);
		}
	}

	// get Training Details

	public Training_Details getTraining(final int trainingid) {
		System.out.println("TrainingDAO.getTraining(trainingid) : " + trainingid);
		Training_Details training_Details = null;
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List trainings = session.createQuery("FROM Training_Details where TRAININGID = " + trainingid)
					.list();
			for (Iterator iterator = trainings.iterator(); iterator.hasNext();) {
				training_Details = (Training_Details) iterator.next();
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
		return training_Details;
	}

	// view Training Details

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Hashtable getTrainings() {
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
				List trainings = session.createQuery("FROM Training_Details")
						.list();
				for (Iterator iterator = trainings.iterator(); iterator.hasNext();) {
					Training_Details training = (Training_Details) iterator.next();
					aHashtable.put(Integer.valueOf(training.getTrainingId()),
							training);
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
			ApplicationContext ctx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");

			AbstractDataAccessObject dao = (AbstractDataAccessObject) ctx.getBean("edao");
			 
			jdbcTemplate = dao.getJdbcTemplate();
			String query = "select * from Training_Details";
			
			List<Training_Details> trainings = jdbcTemplate.query(query, new TrainingMapper());
			System.out.println("jdbctemplate : "+trainings);
			for (Iterator iterator = trainings.iterator(); iterator.hasNext();) {
				Training_Details training = (Training_Details) iterator.next();
				aHashtable.put(Integer.valueOf(training.getTrainingId()),
						training);
			}
		}
		return aHashtable;
	}
}