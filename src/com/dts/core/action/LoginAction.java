package com.dts.core.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dts.core.util.LoggerManager;
import com.dts.dae.dao.SecurityDAO;
import com.dts.dae.model.Profile;
/**
 * 
 * @author PRANEETH
 *
 */
public class LoginAction extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
	{

		String target = null;
		try
		{
			final HttpSession session = request.getSession();
			final Profile profile = new Profile();
			final String username = request.getParameter("username");
			LoggerManager.writeLogInfo("username is..." + username);
			profile.setLoginID(username);
			final String pass = request.getParameter("password");
			LoggerManager.writeLogInfo("pwd is ...." + pass);
			profile.setPassword(pass);

			final String role = new SecurityDAO().loginCheck(profile);

			if (role.equals("admin"))
			{
				target = "adminhome.jsp?status=Welcome " + username;
				session.setAttribute("user", username);
				session.setAttribute("role", role);
				session.setAttribute("pass", pass);
			}
			else if (role.equals("manager"))
			{

				target = "ManagerHome.jsp?status=Welcome " + username;
				session.setAttribute("user", username);
				session.setAttribute("role", role);
				session.setAttribute("pass", pass);
			}
			else if (role.equals("employee"))
			{

				target = "EmployeeHome.jsp?status=Welcome " + username;
				session.setAttribute("user", username);
				session.setAttribute("role", role);
				session.setAttribute("pass", pass);
			}
			else
			{
				target = "index.jsp?status=Invalid username and password";
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
