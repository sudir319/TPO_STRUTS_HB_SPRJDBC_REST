package com.dts.core.export;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
/**
 * 
 * @author PRANEETH
 *
 */
public class ExportXLS extends HttpServlet
{
	/**
	 * 
	 */
	public void doGet(final HttpServletRequest req,final HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("application/vnd.ms-excel");
		final PrintWriter printWriter = res.getWriter();

		
		final HttpSession session = req.getSession();
		final String html = (String) session.getAttribute("Reports");

		printWriter.print(html);
		printWriter.close();
	}
}
