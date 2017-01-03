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
public class ChangequestionAction extends HttpServlet
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
	public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
	{

		String target = "Changequestion.jsp?status=Change Failed";
		try
		{
			final HttpSession session = request.getSession();
			final Profile profile = new Profile();
			final String loginid = request.getParameter("username");
			final String password = request.getParameter("password");
			final String sanswer = request.getParameter("sanswer");
			String squestid;

			if (request.getParameter("ch") == null)
			{
				squestid = request.getParameter("squest");
				profile.setSecretQuestionID(squestid);
			}
			else
			{
				profile.setSecretQuestionID(request.getParameter("ownquest"));
			}

			profile.setLoginID(loginid);
			profile.setPassword(password);
			profile.setSecretAnswer(sanswer);

			final boolean flag = new SecurityDAO().changeQuestion(profile);

			String pathString = "LoginForm.jsp";
			if (((String) session.getAttribute("role")).equals("admin"))
			{
				pathString = "adminhome.jsp";
			}
			else
			{
				pathString = "userhome.jsp";
			}	
			if (flag)
			{
				target = pathString + "?status=Change Success";
			}
			else
			{
				target = "Changequestion.jsp?status=Change Failed";
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
