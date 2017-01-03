<%@ page
	import="com.dts.tpo.model.*,com.dts.tpo.dao.*,com.dts.core.util.*,java.util.*"%>
<%
	Hashtable cHashtable = null;
	StringBuffer jsonBuffer = new StringBuffer();
	String reportType = request.getParameter("type");
	try {
		int categoryid = 0;
		int itemid = 0;
		int noOfRows = 0;

		if (reportType != null && reportType.equals("trainings")) {

	TrainingDAO aTrainingdao = new TrainingDAO();
	cHashtable = (Hashtable) request.getSession().getAttribute(
			"trainings");
	System.out.println(cHashtable);
	noOfRows = cHashtable.size();

	jsonBuffer.append("{");
	jsonBuffer.append("\"page\": \"1\",");
	jsonBuffer.append("\"total\": 2,");
	jsonBuffer.append("\"records\": \"" + noOfRows + "\",");
	jsonBuffer.append("\"rows\": [");
	if (!cHashtable.isEmpty()) {
		Enumeration enu = cHashtable.elements();
		Training_Details training = null;

		while (enu.hasMoreElements()) {
			training = (Training_Details) enu.nextElement();

			jsonBuffer.append("{");
			jsonBuffer.append("\"id\": \""
					+ training.getTrainingId() + "\",");
			jsonBuffer.append("\"cell\": [");
			jsonBuffer.append("\"" + training.getTrainingName()
					+ "\",");
			jsonBuffer.append("\"" + training.getStart_date()
					+ "\",");
			jsonBuffer.append("\"" + training.getEnd_date()
					+ "\",");
			jsonBuffer.append("\"" + training.getStart_time()
					+ "\",");
			jsonBuffer.append("\"" + training.getEnd_time()
					+ "\",");
			jsonBuffer.append("\"" + training.getStatus()
					+ "\",");
			jsonBuffer
					.append("\""
							+ "<img src='images/edit.png' onClick=javascript:location.href='Trainings.do?action=load_edit&id="
							+ training.getTrainingId()
							+ "' height=20 width=20 align=center/>"
							+ "\",");
			jsonBuffer
					.append("\""
							+ "<img src='images/delete.png' onClick=javascript:location.href='Trainings.do?action=delete&ch="
							+ training.getTrainingId()
							+ "' height=20 width=20 align=center/>"
							+ "\"");
			jsonBuffer.append("]");
			jsonBuffer.append("}");

			if (enu.hasMoreElements()) {
				jsonBuffer.append(",");
			}
		}
	}

	jsonBuffer.append("]");
	jsonBuffer.append("}");
		} else if (reportType != null
		&& reportType.equals("notifications")) {

	NotificationDAO aNotificationDAO = new NotificationDAO();
	cHashtable = aNotificationDAO.getNotifications();

	CompanyDAO aCompanyDAO = new CompanyDAO();
	Hashtable companyHashtable = aCompanyDAO.listCompanies();
	noOfRows = cHashtable.size();

	jsonBuffer.append("{");
	jsonBuffer.append("\"page\": \"1\",");
	jsonBuffer.append("\"total\": 2,");
	jsonBuffer.append("\"records\": \"" + noOfRows + "\",");
	jsonBuffer.append("\"rows\": [");
	if (!cHashtable.isEmpty()) {
		Enumeration enu = cHashtable.elements();
		Notification_Details notification = null;

		while (enu.hasMoreElements()) {

			notification = (Notification_Details) enu
					.nextElement();

			jsonBuffer.append("{");
			jsonBuffer.append("\"id\": \""
					+ notification.getNotificationID() + "\",");
			System.out.println("in while getNotificationID : "
					+ notification.getNotificationID());
			jsonBuffer.append("\"cell\": [");
			jsonBuffer.append("\""
					+ notification.getNotificationID() + "\",");
			System.out.println("in while getCompanyID : "
					+ notification.getCompanyID());
			System.out.println("in while before companyName :********************** ");
			System.out.println("in while before companyName :"+ companyHashtable
					.get(new Integer((notification.getCompanyID()))));
			jsonBuffer.append("\""
					+ (((Company_Details) (companyHashtable
							.get(new Integer((notification
									.getCompanyID()))))))
							.getCompanyName() + "\",");
			try{
				System.out.println("in while try before createddate :********************** ");
				jsonBuffer.append("\""
						+ notification.getCreateddate() + "\",");
				System.out.println("in while try after createddate : ************************");
			}
			catch(Throwable t )
			{
				System.out.println("in catch : ************************");
				t.printStackTrace();
			}
			/*		jsonBuffer.append("\""
						+ "createdDate" + "\",");
			 */
			System.out.println("1DONE : ");
			jsonBuffer.append("\"" + notification.getStatus()
					+ "\",");
			System.out.println("2DONE : ");
			jsonBuffer
					.append("\""
							+ "<img src='images/edit.png' onClick=javascript:location.href='Notifications.do?action=load_edit&id="
							+ notification.getNotificationID()
							+ "' height=20 width=20 align=center/>"
							+ "\",");
			jsonBuffer
					.append("\""
							+ "<img src='images/delete.png' onClick=javascript:location.href='Notifications.do?action=delete&ch="
							+ notification.getNotificationID()
							+ "' height=20 width=20 align=center/>"
							+ "\"");
			jsonBuffer.append("]");
			jsonBuffer.append("}");

			if (enu.hasMoreElements()) {
				jsonBuffer.append(",");
			}
			System.out.println("3DONE : "
					+ enu.hasMoreElements());
		}
		System.out.println("4DONE : ");
	}

	jsonBuffer.append("]");
	jsonBuffer.append("}");
		} else if (reportType != null && reportType.equals("companies")) {

	CompanyDAO aCompanyDAO = new CompanyDAO();
	cHashtable = aCompanyDAO.listCompanies();
	noOfRows = cHashtable.size();

	jsonBuffer.append("{");
	jsonBuffer.append("\"page\": \"1\",");
	jsonBuffer.append("\"total\": 2,");
	jsonBuffer.append("\"records\": \"" + noOfRows + "\",");
	jsonBuffer.append("\"rows\": [");
	if (!cHashtable.isEmpty()) {
		Enumeration enu = cHashtable.elements();
		Company_Details company = null;

		while (enu.hasMoreElements()) {
			company = (Company_Details) enu.nextElement();

			jsonBuffer.append("{");
			jsonBuffer.append("\"id\": \""
					+ company.getCompanyId() + "\",");
			jsonBuffer.append("\"cell\": [");
			jsonBuffer.append("\"" + company.getCompanyName()
					+ "\",");
			jsonBuffer
					.append("\"" + company.getEmail() + "\",");
			jsonBuffer
					.append("\"" + company.getPhone() + "\",");
			jsonBuffer
					.append("\""
							+ "<img src='images/edit.png' onClick=javascript:location.href='Companies.do?action=load_edit&id="
							+ company.getCompanyId()
							+ "' height=20 width=20 align=center/>"
							+ "\",");
			jsonBuffer
					.append("\""
							+ "<img src='images/delete.png' onClick=javascript:location.href='Companies.do?action=delete&ch="
							+ company.getCompanyId()
							+ "' height=20 width=20 align=center/>"
							+ "\"");
			jsonBuffer.append("]");
			jsonBuffer.append("}");

			if (enu.hasMoreElements()) {
				jsonBuffer.append(",");
			}
		}
	}

	jsonBuffer.append("]");
	jsonBuffer.append("}");
		} else if (reportType != null && reportType.equals("students")) {

	AcadamicDAO aAcadamicDAO = new AcadamicDAO();
	cHashtable = aAcadamicDAO.getProfile("student");
	noOfRows = cHashtable.size();

	jsonBuffer.append("{");
	jsonBuffer.append("\"page\": \"1\",");
	jsonBuffer.append("\"total\": 2,");
	jsonBuffer.append("\"records\": \"" + noOfRows + "\",");
	jsonBuffer.append("\"rows\": [");
	if (!cHashtable.isEmpty()) {
		Enumeration enu = cHashtable.elements();
		Acadamic acadamic = null;

		while (enu.hasMoreElements()) {
			acadamic = (Acadamic) enu.nextElement();

			jsonBuffer.append("{");
			jsonBuffer.append("\"id\": \""
					+ acadamic.getRollno() + "\",");
			jsonBuffer.append("\"cell\": [");
			jsonBuffer.append("\"" + acadamic.getRollno()
					+ "\",");
			jsonBuffer
					.append("\"<a target=_blank href=ViewAcadamic.jsp?id="
							+ acadamic.getLoginname()
							+ ">"
							+ acadamic.getLoginname()
							+ "</a>\",");
			jsonBuffer.append("\"" + acadamic.getCourse()
					+ "\",");
			jsonBuffer
					.append("\"<a target=_blank href=ViewAggregates.jsp?id="
							+ acadamic.getDiscipline()
							+ ">"
							+ acadamic.getDiscipline()
							+ "</a>\",");
			jsonBuffer.append("\"" + acadamic.getSemister()
					+ "\",");
			jsonBuffer.append("\"" + acadamic.getEmail()
					+ "\",");
			jsonBuffer
					.append("\""
							+ "<img src='images/edit.png' onClick=javascript:location.href='Acadamics.do?action=load_edit' height=20 width=20 align=center/>"
							+ "\",");
			jsonBuffer
					.append("\""
							+ "<img src='images/delete.png' onClick=javascript:location.href='Acadamics.do?action=delete&ch="
							+ acadamic.getRollno()
							+ "' height=20 width=20 align=center/>"
							+ "\"");
			jsonBuffer.append("]");
			jsonBuffer.append("}");

			if (enu.hasMoreElements()) {
				jsonBuffer.append(",");
			}
		}
	}

	jsonBuffer.append("]");
	jsonBuffer.append("}");
		}

		String strToReturn = jsonBuffer.toString();
		strToReturn = strToReturn.replaceAll("", "");
		strToReturn = strToReturn.replaceAll("", "");

		response.setContentType("text/html");
		out.println(strToReturn);
		out.flush();

	} catch (Exception e) {
		LoggerManager.writeLogWarning(e);
	}
%>