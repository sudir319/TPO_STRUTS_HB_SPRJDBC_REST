package com.dts.core.action;

import com.dts.tpo.dao.*;
import com.dts.tpo.model.*;
import com.dts.core.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;

@SuppressWarnings("serial")
/**
 * 
 * @author PRANEETH
 *
 */
public class ActionServlett extends HttpServlet
{
	/**
	 * 
	 */
	public void doPost(final HttpServletRequest request,final HttpServletResponse response) throws ServletException, IOException{
		
		final String reqtype = request.getParameter("button");
		final String reqtype1 = request.getParameter("hbutton");
		String target;
		LoggerManager.writeLogInfo("reqtype value : "+reqtype);
		LoggerManager.writeLogInfo("reqtype1 value : "+reqtype1);
		LoggerManager.writeLogInfo("from : "+request.getHeader("Referer"));
		
		if(reqtype.equals("Delete") && reqtype1.equals("Training"))
		{
			target="ViewTrainings.jsp";
			
			try{
		            //final TrainingDAO aTrainingdao = new TrainingDAO();
		            final String check[] = request.getParameterValues("ch");
		            
		            for(int i=1;i<check.length;i++)
		            {
		                new TrainingDAO().deleteTraining(Integer.parseInt(check[i])); 
		            }
				}
		         catch(Error e)
		         {
		           LoggerManager.writeLogWarning(e);
		         }
			response.sendRedirect(target);
		}
		else if("button".equals("Delete") && "hbutton".equals("Company")){
				target = "ViewCompanies.jsp";
				
				try
				{
					LoggerManager.writeLogInfo("From deleting company : "+"hbutton");
					final CompanyDAO aCompanydao = new CompanyDAO();
					final String check[] = request.getParameterValues("ch");
					for (int i = 1; i < check.length; i++)
					{
						aCompanydao.deleteCompany(Integer.parseInt(check[i]));
					}
				}
				catch (Error e)
				{
					LoggerManager.writeLogWarning(e);
				}
				response.sendRedirect(target);
		}
		else if("button".equals("Delete") && "hbutton".equals("Notification")){
			//NotificationDAO aNotificationdao;
			  target="ViewNotification.jsp";
		      try{
		    	  final NotificationDAO aNotificationdao = new NotificationDAO();
		            final String check[] = request.getParameterValues("ch");
		            
		            for(int i=1;i<check.length;i++)
		            {
		                aNotificationdao.deleteNotification(Integer.parseInt(check[i]));  
		            }
		         }
		         catch(Error e)
		         {
		           LoggerManager.writeLogWarning(e);
		         }
		      response.sendRedirect(target);
		}
		else if("button".equals("Add")&& "hbutton".equals("Training")){
			target = "ViewTrainings.jsp";
			try
			{
				final Training_Details aTraining = new Training_Details();
				aTraining.setTrainingName(request.getParameter("training_name"));
				aTraining.setStart_date1(DateWrapper.parseDate(request.getParameter("start_date")));
				aTraining.setEnd_date1(DateWrapper.parseDate(request.getParameter("end_date")));
				aTraining.setStart_time(request.getParameter("start_time"));
				aTraining.setEnd_time(request.getParameter("end_time"));
				aTraining.setTrainingdesc(request.getParameter("description"));
				aTraining.setStatus("Process");
				aTraining.toString();
				new TrainingDAO().addTraining(aTraining);
			}
			catch (Error e)
			{
				LoggerManager.writeLogWarning(e);
			}
			response.sendRedirect(target);
		}
		else if("button".equals("Register") && "hbutton".equals("Company")){
			target = "ViewCompanies.jsp";
			try
			{
				final Company_Details aCompany = new Company_Details();
				aCompany.setCompanyName(request.getParameter("companyName"));
				aCompany.setProfile(request.getParameter("profile"));
				aCompany.setStreet(request.getParameter("street"));
				aCompany.setCity(request.getParameter("city"));
				aCompany.setState(request.getParameter("state"));
				aCompany.setCountry(request.getParameter("country"));
				aCompany.setPhone(request.getParameter("phone"));
				aCompany.setEmail(request.getParameter("email"));

				new CompanyDAO().addCompany(aCompany);

			}
			catch (Error e)
			{
				LoggerManager.writeLogWarning(e);
			}
			response.sendRedirect(target);
		}
			else if("button".equals("Register") && "hbutton".equals("Notification")){
				target = "ViewNotification.jsp";
				try
			    {
			        final Notification_Details aNotification = new Notification_Details();
			       	aNotification.setCompanyID(Integer.parseInt(request.getParameter("companyName")));
			    	aNotification.setNoofvac(request.getParameter("noofvac"));
			    	aNotification.setJobdesc(request.getParameter("jobdesc"));
			    	aNotification.setCategory(request.getParameter("category"));
			    	aNotification.setLocation(request.getParameter("location"));
			    	aNotification.setCreateddate1(DateWrapper.parseDate(request.getParameter("cdate")));
			    	aNotification.setExpirydate1(DateWrapper.parseDate(request.getParameter("expdate")));
			    	aNotification.setSkills(request.getParameter("desiredskills"));
			    	aNotification.setDesignation(request.getParameter("desig"));
			    	
			    	
			    	new NotificationDAO().addNotification(aNotification);
			    }
			    catch(Error e)
			    {
			       LoggerManager.writeLogWarning(e);
			    }
				response.sendRedirect(target);
			}
	}
}
