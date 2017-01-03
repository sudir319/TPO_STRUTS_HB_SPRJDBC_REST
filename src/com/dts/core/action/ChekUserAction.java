package com.dts.core.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.dae.dao.SecurityDAO;
/**
 * 
 * @author PRANEETH
 *
 */
public class ChekUserAction extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The doPost method of the servlet
	 * This method is called when a form has its tag value method equals to post.
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
	{
		final String username = request.getParameter("userName");
		String target ;
		try
		{
			final String user = new SecurityDAO().checkUser(username);
			if (user == null)
			{
				target = "Registerform.jsp?status1=<font color=green>_/Available</font>";
			}
			else
			{
				target = "Registerform.jsp?status1=<font color=red>Alreadyexist</font>&userName=" + username;
			}
		}
		catch (Error e)
		{
			target = "Registerform.jsp?status1=<font color=green>_/<b>Available</b></font>&userName=" + username;
		}
		final RequestDispatcher requestDispatcher = request.getRequestDispatcher(target);
		requestDispatcher.forward(request, response);
	}

}
