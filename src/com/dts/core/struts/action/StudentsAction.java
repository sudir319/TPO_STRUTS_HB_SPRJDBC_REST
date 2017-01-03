package com.dts.core.struts.action;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.dts.core.util.DateWrapper;
import com.dts.tpo.dao.AcadamicDAO;
import com.dts.tpo.dao.TrainingDAO;
import com.dts.tpo.model.Training_Details;

/**
 * 
 * @author PRANEETH
 * 
 */
public class StudentsAction extends DispatchAction {

	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		getStudents(request);

		return mapping.findForward("view");
	}

	private void getStudents(HttpServletRequest request) {
		AcadamicDAO aAcadamicDAO = new AcadamicDAO();
		Hashtable cHashtable = aAcadamicDAO.getProfile("student");

		request.getSession().setAttribute("students", cHashtable);
	}

	public ActionForward add_new(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("add_new");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		System.out.println("StudentsAction.add(ADDDDDDDDDDDDDDD)");
		final Training_Details aTraining = new Training_Details();
		aTraining.setTrainingName(request.getParameter("training_name"));
		aTraining.setStart_date1(DateWrapper.parseDate(request
				.getParameter("start_date")));
		aTraining.setEnd_date1(DateWrapper.parseDate(request
				.getParameter("end_date")));
		aTraining.setStart_time(request.getParameter("start_time"));
		aTraining.setEnd_time(request.getParameter("end_time"));
		aTraining.setTrainingdesc(request.getParameter("description"));
		aTraining.setStatus("Process");
		aTraining.toString();
		new TrainingDAO().addTraining(aTraining);

		getStudents(request);

		return mapping.findForward("view");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		System.out.println("StudentsAction.delete(DELETEEEEEEEEEE)");

		String check[] = request.getParameterValues("ch");

		TrainingDAO trainingDAO = new TrainingDAO();

		for (int i = 0; i < check.length; i++) {
			trainingDAO.deleteTraining(Integer.parseInt(check[i]));
		}

		getStudents(request);

		return mapping.findForward("view");
	}

}
