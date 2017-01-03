package com.dts.core.struts.action;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;
import com.dts.tpo.dao.CompanyDAO;
import com.dts.tpo.dao.TrainingDAO;
import com.dts.tpo.model.Company_Details;
import com.dts.tpo.model.Training_Details;

/**
 * 
 * @author PRANEETH
 * 
 */
public class CompaniesAction extends DispatchAction {

	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		getCompanies(request);

		return mapping.findForward("view");
	}

	private void getCompanies(HttpServletRequest request) {
		CompanyDAO aCompanydao = new CompanyDAO();

		Hashtable cHashtable = aCompanydao.listCompanies();

		request.getSession().setAttribute("companies", cHashtable);
	}

	public ActionForward add_new(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("add_new");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Company_Details aCompany = (Company_Details)form;

		System.out.println("CompaniesAction.add() before*********************");
		
		System.out.println("CompanyID from actionclass**********: "+aCompany.getCompanyId());
		System.out.println("CompanyName from actionclass******* : "+aCompany.getCompanyName());
		//System.out.println("New Company : "+aCompany);
		new CompanyDAO().addCompany(aCompany);
		
		System.out.println("CompaniesAction.add() After*********************************");
		getCompanies(request);

		return mapping.findForward("view");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		System.out.println("CompaniesAction.delete(DELETEEEEEEEEEE)");

		String check[] = request.getParameterValues("ch");

		CompanyDAO companyDAO = new CompanyDAO();

		for (int i = 0; i < check.length; i++) {
			companyDAO.deleteCompany(Integer.parseInt(check[i]));
		}

		getCompanies(request);

		return mapping.findForward("view");
	}
	
	public ActionForward load_edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		CompanyDAO companyDAO = new CompanyDAO();
		Company_Details company = companyDAO.getCompanyDetails(Integer.parseInt(request.getParameter("id")));

		request.getSession().setAttribute("load_company", company);

		return mapping.findForward("load_edit");
	}

	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		try
	     {
	        Company_Details aCompany = (Company_Details)form;
	        
	        new CompanyDAO().updateCompany(aCompany);
	        
	     }
	     catch(Exception e)
	     {
	       LoggerManager.writeLogWarning(e);
	     }
		getCompanies(request);
		return mapping.findForward("view");
	}

}
