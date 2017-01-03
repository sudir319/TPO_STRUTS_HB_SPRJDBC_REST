package com.dts.core.struts.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;
import com.dts.tpo.dao.NotificationDAO;
import com.dts.tpo.dao.TrainingDAO;
import com.dts.tpo.model.Notification_Details;
import com.dts.tpo.model.Training_Details;

/**
 * 
 * @author PRANEETH
 * 
 */
public class NotificationsAction extends DispatchAction {

	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		getNotifications(request);

		return mapping.findForward("view");
	}

	private void getNotifications(HttpServletRequest request) {
		NotificationDAO aNotificationdao = new NotificationDAO();

		Hashtable cHashtable = aNotificationdao.getNotifications();

		request.getSession().setAttribute("notifications", cHashtable);
	}

	public ActionForward add_new(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("add_new");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Notification_Details aNotification = (Notification_Details)form; 
		System.out.println("NotificationAction.add(ADDDDDDDDDDDDDDD)");
		
		System.out.println("NOtificationAction Add() createddate : "+request.getParameter("cdate"));
		System.out.println("NOtificationAction Add() Expirydate : "+request.getParameter("expdate"));

		aNotification.setStatus("Process");
		new NotificationDAO().addNotification(aNotification);

		getNotifications(request);

		return mapping.findForward("view");
	}
	
	java.sql.Date getSqlDate(String dateString)
	{
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date parsed = null;
		try {
			parsed = format.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sql = new java.sql.Date(parsed.getTime());
		return sql;
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		System.out.println("NotificationAction.delete(DELETEEEEEEEEEE)");

		String check[] = request.getParameterValues("ch");

		NotificationDAO aNotificationDAO = new NotificationDAO();

		for (int i = 0; i < check.length; i++) {
			aNotificationDAO.deleteNotification(Integer.parseInt(check[i]));
		}

		getNotifications(request);

		return mapping.findForward("view");
	}
	
	public ActionForward load_edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		NotificationDAO notificationDAO = new NotificationDAO();
		Notification_Details notification = notificationDAO.getNotifications(Integer.parseInt(request.getParameter("id")));

		request.getSession().setAttribute("load_notification", notification);

		return mapping.findForward("load_edit");
	}
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		try
	    {
	        Notification_Details aNotification = (Notification_Details)form;
	        
	    	new NotificationDAO().updateNotification(aNotification); 
	    }
	    catch(Exception e)
	    {
	       LoggerManager.writeLogWarning(e);
	    }
		getNotifications(request);
		return mapping.findForward("view");
	}
}