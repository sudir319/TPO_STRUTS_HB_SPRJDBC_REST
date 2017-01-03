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

import com.dts.core.util.LoggerManager;
import com.dts.tpo.dao.TrainingDAO;
import com.dts.tpo.model.Training_Details;

/**
 * 
 * @author PRANEETH
 * 
 */
public class TrainingsAction extends DispatchAction {

	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		getTrainings(request);

		return mapping.findForward("view");
	}

	private void getTrainings(HttpServletRequest request) {
		TrainingDAO aTrainingdao = new TrainingDAO();
		Hashtable cHashtable = aTrainingdao.getTrainings();

		request.getSession().setAttribute("trainings", cHashtable);
	}

	public ActionForward add_new(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("add_new");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Training_Details aTraining = (Training_Details) form;
		System.out.println("TrainingsAction.add(ADDDDDDDDDDDDDDD)");
		System.out.println("TrainingAction trainingId : "+aTraining.getTrainingId());
		System.out.println("TrainingAction start_date : "+aTraining.getStart_date());
		System.out.println("TrainingAction end_date : "+aTraining.getEnd_date());
		aTraining.setStatus("Process");
		new TrainingDAO().addTraining(aTraining);

		getTrainings(request);

		return mapping.findForward("view");
	}
	
	java.sql.Date getSqlDate(String dateString)
	{
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date parsed = null;
		try {
			parsed = format.parse("10-8-2015");
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

		System.out.println("TrainingsAction.delete(DELETEEEEEEEEEE)");

		String check[] = request.getParameterValues("ch");

		TrainingDAO trainingDAO = new TrainingDAO();

		for (int i = 0; i < check.length; i++) {
			trainingDAO.deleteTraining(Integer.parseInt(check[i]));
		}

		getTrainings(request);

		return mapping.findForward("view");
	}

	public ActionForward load_edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		TrainingDAO trainingDAO = new TrainingDAO();
		Training_Details training = trainingDAO.getTraining(Integer.parseInt(request
				.getParameter("id")));

		request.getSession().setAttribute("load_training", training);

		return mapping.findForward("load_edit");
	}

	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			Training_Details aTraining = (Training_Details) form;

			new TrainingDAO().updateTraining(aTraining);
		} catch (Exception e) {
			LoggerManager.writeLogWarning(e);
		}
		getTrainings(request);
		return mapping.findForward("view");
	}

}
