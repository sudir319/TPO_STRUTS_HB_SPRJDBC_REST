<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.dts.tpo.model.*,com.dts.tpo.dao.*,com.dts.core.util.*,java.util.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'NewTrainingAction.jsp' starting page</title>

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
			/*	Map<String, String[]> parameters = request.getParameterMap();
		for (String parameter : parameters.keySet())
		{
			System.out.println(parameter + " : " + request.getParameter(parameter));
		}
			*/
		Training aTraining = new Training();
		aTraining.setTraining_name(request.getParameter("training_name"));
		aTraining.setTrainingStartDate(DateWrapper.parseDate(request.getParameter("start_date")));
		aTraining.setTrainingEndDate(DateWrapper.parseDate(request.getParameter("end_date")));
		aTraining.setTrainingStartTime(request.getParameter("start_time"));
		aTraining.setTrainingEndTime(request.getParameter("end_time"));
		aTraining.setDescription(request.getParameter("description"));
		aTraining.setStatus("Process");
		aTraining.toString();
		//System.out.println("new Training Action jsp");
		new TrainingDAO().addTraining(aTraining);
			}
			catch (Exception e)
			{
		LoggerManager.writeLogWarning(e);
			}
			response.sendRedirect("ViewTrainings.jsp");
	%>
</body>
</html>
