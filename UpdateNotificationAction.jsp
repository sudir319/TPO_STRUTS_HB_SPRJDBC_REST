<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.dts.dae.dao.*,com.dts.dae.model.*,com.dts.core.util.*,com.dts.tpo.dao.*,com.dts.tpo.model.*"%>
<%@ page import="java.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'NotificationAction.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<%
		try
		    {
		        Notification_Details aNotification = new Notification_Details();
		        aNotification.setNotificationID(Integer.parseInt(request.getParameter("id")));
		       	aNotification.setCompanyID(Integer.parseInt(request.getParameter("companyName")));
		    	aNotification.setNoofvac(request.getParameter("noofvac"));
		    	aNotification.setJobdesc(request.getParameter("jobdesc"));
		    	aNotification.setCategory(request.getParameter("category"));
		    	aNotification.setLocation(request.getParameter("location"));
		    	aNotification.setCreateddate(DateWrapper.parseDate(request.getParameter("cdate")));
		    	aNotification.setExpirydate(DateWrapper.parseDate(request.getParameter("expdate")));
		    	aNotification.setDesiredskills(request.getParameter("desiredskills"));
		    	aNotification.setDesignation(request.getParameter("desig"));
		    	aNotification.setStatus(request.getParameter("status"));
		    	
		    	new NotificationDAO().updateNotification(aNotification); 
		    }
		    catch(Exception e)
		    {
		       LoggerManager.writeLogWarning(e);
		    }
		    response.sendRedirect("ViewNotification.jsp");
	%>
</body>
</html>
