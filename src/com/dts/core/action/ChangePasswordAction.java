package com.dts.core.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dts.dae.dao.SecurityDAO;
import com.dts.dae.model.Profile;

/**
 * 
 * @author PRANEETH
 *
 */
public class ChangePasswordAction extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	/**
	 * 
	 */
	public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
	{

		final HttpSession session = request.getSession();
		final String attribute = (String)session.getAttribute("user"); 
		if (attribute  == null)
		{
			response.sendRedirect("LoginForm.jsp?status=Session Expired");
		}

		final Profile profile = new Profile();
		boolean flag;
		profile.setPassword(request.getParameter("oldpassword"));
		profile.setLoginID(request.getParameter("username"));
		profile.setNewPassword(request.getParameter("newpassword"));
		String target;

		if (request.getParameter("oldpassword").equals(request.getParameter("newpassword")))
		{
			target = "Changepassword.jsp?status=Oldpassword and Newpassword are same..";
		}
		else
		{
			flag = new SecurityDAO().changePassword(profile);

			if (flag)
			{
				target = "Changepassword.jsp?status=Password Changed Successfully";
			}	
			else
			{
				target = "Changepassword.jsp?status=Password Change Failed";
			}
		}

		final RequestDispatcher requestDispatcher = request.getRequestDispatcher(target);
		requestDispatcher.forward(request, response);
	}

}
