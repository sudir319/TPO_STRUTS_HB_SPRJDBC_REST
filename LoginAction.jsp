<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.dts.dae.dao.*,com.dts.dae.model.*,com.dts.dae.dao.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'RegisterAction.jsp' starting page</title>

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
	<%--				
		<jsp:include page="tpooptions.html" />
	
	
		<br>

		<tr>
    <td></td>
  </tr>
	--%>
	<% 
		//System.out.println("in loginAction");
		String target = "index.jsp?status=Invalid username and password";			
		
		//System.out.println("from loginAction page");
		
		try{

			 Profile  rb=new Profile();
			 String username = request.getParameter("username");
			 //System.out.println(username +" from loginaction");
	         rb.setLoginID(username);
	         rb.setPassword(request.getParameter("password"));
			// System.out.println(request.getParameter("password")+" from loginaction pass");
         
         String role=new SecurityDAO().loginCheck(rb);
         //System.out.println("after role in LoginAction");
         
         if(role.equals("tpo"))
         { 
            target = "tpohome.jsp?status=Welcome "+username;
            session.setAttribute("user",username);
            session.setAttribute("role",role);
         } 
         else if(role.equals("student"))
         {
            int status = new SecurityDAO().checkFirstLogin(username);
           if(status==1)
            	target = "studenthome.jsp?status=Welcome "+username;
            else if(status==0)
                target = "acadamicdetails.jsp?loginname="+username;
            else
                target = "LoginForm.jsp?status=Invalid username and password";    	
            session.setAttribute("user",username);
            session.setAttribute("role",role);
         } 
         else  
            target = "LoginForm.jsp?status=Invalid username and password";
            }catch(Exception e){} 
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request,response);    
    %>
</body>
</html>
