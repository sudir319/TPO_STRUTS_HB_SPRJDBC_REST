package com.dts.core.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.core.util.LoggerManager;
import com.dts.dae.dao.ProfileDAO;
import com.dts.dae.model.Profile;

@SuppressWarnings("serial")
/**
 * 
 * @author PRANEETH
 *
 */
public class RegisterAction extends HttpServlet
{
	/**
	 * 
	 */
	public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
	{

		String target = "Registerform.jsp?status=Registration Failed";
		try
		{
			final Profile profile = new Profile();
			// profile.setPhoto(request.getParameter("photo"));
			new Profile().setFirstName(request.getParameter("firstName"));
			new Profile().setLastName(request.getParameter("lastName"));
			new Profile().setBirthDate(request.getParameter("dob"));
			new Profile().setEmail(request.getParameter("email"));
			// profile.setFax(request.getParameter("fax"));
			// home
			final String home = request.getParameter("homeaddresstype");
			if (home != null)
			{
				// profile.setHome(home);
				profile.setHno(request.getParameter("homehouseno"));
				profile.setStreet(request.getParameter("homestreet"));
				profile.setCity(request.getParameter("homecity"));
				profile.setState(request.getParameter("homestate"));
				profile.setCountry(request.getParameter("homecountry"));
				// profile.setPin(request.getParameter("homepin"));
				// profile.setHomePhoneType(request.getParameter("homephonetype"));
				// profile.setPhone(request.getParameter("homephoneno"));
			}
			// office
			final String office = request.getParameter("officeaddresstype");
			if (office != null)
			{
				// profile.setOffice(office);
				// profile.setOhno(request.getParameter("officehouseno"));
				// profile.setOstreet(request.getParameter("officestreet"));
				// profile.setOcity(request.getParameter("officecity"));
				// .setOstate(request.getParameter("officestate"));
				// profile.setOcountry(request.getParameter("officecountry"));
				// profile.setOpin(request.getParameter("officepin"));
				// profile.setOfficePhoneType(request.getParameter("officephonetype"));
				// profile.setOphone(request.getParameter("officephoneno"));
			}
			// contact
			final String contact = request.getParameter("personaladdresstype");
			if (contact != null)
			{
				// profile.setContact(contact);
				// profile.setChno(request.getParameter("personalhouseno"));
				// profile.setCstreet(request.getParameter("personalstreet"));
				// profile.setCcity(request.getParameter("personalcity"));
				// profile.setCstate(request.getParameter("personalstate"));
				// profile.setCcountry(request.getParameter("personalcountry"));
				// profile.setCpin(request.getParameter("personalpin"));
				// profile.setPersonalPhoneType(request.getParameter("personalphonetype"));
				// profile.setCphone(request.getParameter("personalphoneno"));
			}

			// profile.setStatus(1);
			// profile.setFirstLogin(0);
			profile.setLoginID(request.getParameter("userName"));
			profile.setLoginType("customer");
			profile.setPassword(request.getParameter("password"));
			profile.setLogintype(request.getParameter("logintype"));
			String questid;
			if (request.getParameter("ch") != null)
			{
				// profile.setSecretQuestionID(questid);
				profile.setSecretQuestionID(request.getParameter("ownquest"));
			}
			else
			{
				questid = request.getParameter("squest");
				profile.setSecretQuestionID(questid);
				profile.setOwnSecretQuestion("Not Mentioned");
			}
			profile.setSecretAnswer(request.getParameter("secrete"));
			profile.setLocale(request.getLocale().toString());
			final boolean flag = new ProfileDAO().registration(profile);

			if (flag){
				target = "Registerform.jsp?status=Registration Success";
			}
			else{
				target = "Registerform.jsp?status=Registration Failed";
			}
		}
		catch (Error e)
		{
			LoggerManager.writeLogWarning(e);
		}
		final RequestDispatcher requestDispatcher = request.getRequestDispatcher(target);
		requestDispatcher.forward(request, response);
	}

}
