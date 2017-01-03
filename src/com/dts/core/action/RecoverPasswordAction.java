package com.dts.core.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.core.util.LoggerManager;
import com.dts.dae.dao.SecurityDAO;
import com.dts.dae.model.Profile;
/**
 * 
 * @author PRANEETH
 *
 */
public class RecoverPasswordAction extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The doPost method of the servlet. <br>
	 * This method is called when a form has its tag value method equals to post.
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
	{

		String target = "Recoverpasswordfprm.jsp?status=<font color=red>Entries not Matched... Try Again</font>";
		
		try
		{
			final Profile profile = new Profile();
			final String loginid = request.getParameter("username");
			final String sanswer = request.getParameter("sanswer");
			profile.setLoginID(loginid);
			profile.setSecretAnswer(sanswer);
			String password;
			String  squestid = request.getParameter("squest");
			if (request.getParameter("ch") != null)
			{
				squestid = request.getParameter("ownquest");
			}
			profile.setSecretQuestionID(squestid);
			password = new SecurityDAO().recoverPasswordByExistQuestion(profile);
			if (password == null || password.equals("")){
				target = "Recoverpassword.jsp?status=<font color=red>Entries not Matched... Try Again</font>";
			}
			else{
				target = "LoginForm.jsp?status=Password is  <font color=green>" + password + "</font>";
			}
		}
		catch (Exception e)
		{
			LoggerManager.writeLogSevere(e);
		}
		final RequestDispatcher requestDispatcher = request.getRequestDispatcher(target);
		requestDispatcher.forward(request, response);
	}
}