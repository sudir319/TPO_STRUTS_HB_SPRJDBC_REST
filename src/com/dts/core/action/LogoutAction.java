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

@SuppressWarnings("serial")
/**
 * 
 * @author PRANEETH
 *
 */
public class LogoutAction extends HttpServlet
{
	/**
	 * 
	 */
	public LogoutAction()
	{
		super();
		LoggerManager.writeLogInfo("in logout action cons.........");
	}
	/**
	 * 
	 */
	public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
	{

		final HttpSession session = request.getSession();
		LoggerManager.writeLogInfo("in logout user=" + session.getAttribute("user"));
		new SecurityDAO().loginaudit((String) session.getAttribute("user"));
		session.setAttribute("user", null);
		session.setAttribute("role", null);
		session.invalidate();
		final RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp?status=logout successfull");
		requestDispatcher.forward(request, response);
	}

}
