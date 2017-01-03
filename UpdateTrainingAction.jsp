<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.dts.tpo.model.*,com.dts.tpo.dao.*,com.dts.core.util.*,java.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
		        Training aTraining = new Training();
		        //System.out.println("Traningid from update : "+Integer.parseInt(request.getParameter("trainingid")));
		        aTraining.setTrainingid(Integer.parseInt(request.getParameter("trainingid")));
		        //System.out.println("Traning_name from update : "+request.getParameter("training_name"));
		        aTraining.setTraining_name(request.getParameter("training_name"));
		        //System.out.println("Start_date from update : "+request.getParameter("start_date"));
		        aTraining.setTrainingStartDate(DateWrapper.parseDate(request.getParameter("start_date")));
		        //System.out.println("end_date from update : "+request.getParameter("end_date"));
		        aTraining.setTrainingEndDate(DateWrapper.parseDate(request.getParameter("end_date")));
		        //System.out.println("Start_time from update : "+request.getParameter("start_time"));
		        aTraining.setTrainingStartTime(request.getParameter("start_time"));
		        //System.out.println("End_time from update : "+request.getParameter("end_time"));
		        aTraining.setTrainingEndTime(request.getParameter("end_time"));
		        //System.out.println("Description from update : "+request.getParameter("description"));
		        aTraining.setDescription(request.getParameter("description"));
		        //System.out.println("updated status : "+(request.getParameter("status")));
		        aTraining.setStatus(request.getParameter("status"));
		        
		        new TrainingDAO().updateTraining(aTraining);
		     }
		     catch(Exception e)
		     {
		        LoggerManager.writeLogWarning(e);
		     }
		     response.sendRedirect("ViewTrainings.jsp");
	%>
</body>
</html>
