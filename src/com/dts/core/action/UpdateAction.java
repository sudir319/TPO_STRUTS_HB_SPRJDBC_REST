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
/**
 * 
 * @author PRANEETH
 *
 */
public class UpdateAction extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The doGet method of the servlet. <br>
	 * This method is called when a form has its tag value method equals to get.
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
	{

		String target = "UpdateProfile.jsp?status=Updation Failed";
		try
		{
			final String username = (String) request.getSession().getAttribute("user");
			final Profile profile = new Profile();
			profile.setFirstName(request.getParameter("firstName"));
			profile.setLastName(request.getParameter("lastName"));

			profile.setEmail(request.getParameter("email"));
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
			}
			// office
			final String office = request.getParameter("officeaddresstype");
			if (office != null)
			{
				// profile.setOffice(office);
				// profile.setOhno(request.getParameter("officehouseno"));
				// profile.setOstreet(request.getParameter("officestreet"));
				// profile.setOcity(request.getParameter("officecity"));
				// profile.setOstate(request.getParameter("officestate"));
				// profile.setOcountry(request.getParameter("officecountry"));
				// profile.setOpin(request.getParameter("officepin"));
				// profile.setOfficePhoneType("office");
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
				// profile.setPersonalPhoneType("mobile");
				// profile.setCphone(request.getParameter("personalphoneno"));
			}

			// profile.setStatus(1);
			// profile.setFirstLogin(0);
			profile.setLoginID(username);

			final boolean flag = new ProfileDAO().modifyProfile(profile);

			if (flag){
				target = "UpdateProfile.jsp?status=Updation Success";
			}
			else{
				target = "UpdateProfile.jsp?status=Updation Failed";
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
