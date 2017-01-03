<%@ page
	import="com.dts.tpo.model.*,com.dts.tpo.dao.*,com.dts.core.util.*,java.util.*"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<title>Training and Placement Operations</title>
<link href="index_files/Style.css" type="text/css" rel="stylesheet">
<script language="JavaScript" src="index_files/main_menu.js"></script>
<script language="JavaScript" src="scripts/general.js"></script>
<script language="javascript">
	function validate() {
		if (document.login.username.value == ""
				|| document.login.password.value == "") {
			alert("All Fields are manditory");
			return false;
		}
		return true;
	}
</script>
<style type="text/css">
<!--
.style38 {
	color: #000000;
	font-weight: bold;
}

.style40 {
	color: #000000
}
-->
</style>
</head>
<body leftmargin="0" rightmargin="0" topmargin="0" bottommargin="0"
	background="index_files/BG.gif" bgcolor="silver">
	<center>
		<table style="width: 778px;" background="" border="0" cellpadding="0"
			cellspacing="0" width="778">
			<tbody>

				<tr>
					<td align="left" valign="top">
						<table style="width: 778px; height: 20px;"
							background="index_files/SEP_002.gif" border="0" cellpadding="0"
							cellspacing="0" height="20" width="778">

							<tbody>
								<tr>
									<td style="width: 535px; height: 20px;" class="nlink"
										align="left" height="20" valign="middle" width="535"><jsp:include
											page="scroll.html" /></td>
									<td style="width: 30px;" align="right" valign="bottom"
										width="30"><img style="width: 20px; height: 20px;" alt=""
										src="index_files/CMB.gif" border="0" height="20" hspace="0"
										width="20"></td>
									<td style="width: 213px; height: 20px;" align="left"
										bgcolor="#ff9900" height="20" valign="center" width="213">&nbsp;</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td align="left" valign="top">
						<table style="height: 80px;" bgcolor="ivory" border="0"
							cellpadding="0" cellspacing="0" height="80" width="778">

							<tbody>
								<tr>
									<td align="left" valign="top"><img
										src="index_files/BANNER.gif" width="778" height="80"
										border="0" style="width: 778px; height: 80px;"></td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td><jsp:include page="tpooptions.html" /></td>
				</tr>
				<tr>
					<td align="left" valign="top">
						<table bgcolor="#ff9900" border="0" cellpadding="0"
							cellspacing="0" width="778">
							<tbody>

								<tr>
									<td width="14"></td>
									<td width="751" height="391" align="center" valign="top"
										background="index_files/BG.gif" bgcolor="#ff9900"
										style="width: 190px;"><div align="center">
											<table width="743" border="0" align="center">
												<tr>
													<td width="737" height="42"><div align="center"
															class="style25">
															<form name="form1" method="post" action="">
																<label> <strong>Select Notification ID</strong>
																	<select name="notiid" id="id"
																	onChange="javascript:location.href='ViewStudentsRejected.jsp?notiid='+document.form1.notiid.value">
																		<%
																			ArrayList aArrayList = new ArrayList();
																			Hashtable cHashtable = new Hashtable();
																			if (request.getParameter("notiid") != null)
																			{
																		%>
																		<option value="<%=request.getParameter("notiid")%>"><%=request.getParameter("notiid")%></option>
																		<%
																			}
																			else
																			{
																		%>
																		<option>--None--</option>
																		<%
																			}
																																			aArrayList = new ArrayList();
																																			cHashtable = new Hashtable();
																																			try
																																			{
																																				int categoryid = 0;
																																				int itemid = 0;
																																				NotificationDAO aNotificationdao = new NotificationDAO();

																																				cHashtable = aNotificationdao.getNotifications();
																																				session.setAttribute("notifications", cHashtable);
																																				if (!cHashtable.isEmpty())
																																				{
																																					Enumeration enu = cHashtable.elements();
																																					Notification_Details notification = null;
																																					Hashtable aHashtable = new CompanyDAO().listCompanies();
																																					while (enu.hasMoreElements())
																																					{
																																						notification = (Notification_Details) enu.nextElement();
																		%><option
																			value="<%=(notification.getNotificationID())%>"><%=(notification.getNotificationID())%></option>
																		<%
																			}
																																				}
																																			}
																																			catch (Exception e)
																																			{
																																				LoggerManager.writeLogWarning(e);
																																			}
																		%>
																</select>
																</label>
															</form>
														</div></td>
												</tr>
												<tr>
													<td height="232" valign="top"><form name="f"
															method="post" action="UpdateStatus.jsp">



															<%
																if (request.getParameter("notiid") != null)
																													{
																														aArrayList = new ArrayList();
																														cHashtable = new Hashtable();
																														try
																														{
																															int categoryid = 0;
																															int itemid = 0;
																															NotificationDAO aNotificationdao = new NotificationDAO();

																															cHashtable = aNotificationdao.listStudents();
																															String report = "";
																															if (!cHashtable.isEmpty())
																															{
																																report += "<table width='60%' border='0' align='center'><tr>" + "<td width='289' bgcolor='#FF9600'><div align='center'><strong>Roll No</strong></div></td>" + "<td width='289' bgcolor='#FF9600'><div align='center'><strong>Student Name</strong></div></td>" + "<td width='289' bgcolor='#FF9600'><div align='center'><strong>Course</strong></div></td>" + "<td width='289' bgcolor='#FF9600'><div align='center'><strong>Discipline</strong></div></td>"
																																		+ "<td width='289' bgcolor='#FF9600'><div align='center'><strong>Semister</strong></div></td>" + "</tr>";
															%>
															<span class="style36">
																<center>Rejected Students</center>
																<div align="Right">
																	<strong> Export to:</strong> <a href="ExportXLS"><strong>XLS</strong>
																	</a>
																</div>
															</span>
															<table width="66%" border="0" align="center">
																<tr>
																	<td width="65" bgcolor="#FF9600"><div
																			align="center">
																			<strong>Roll No</strong>
																		</div></td>
																	<td width="102" bgcolor="#FF9600"><div
																			align="center">
																			<strong>Student Name</strong>
																		</div></td>
																	<td width="82" bgcolor="#FF9600"><div
																			align="center">
																			<strong>Course</strong>
																		</div></td>
																	<td width="93" bgcolor="#FF9600"><div
																			align="center">
																			<strong>Discipline</strong>
																		</div></td>
																	<td width="122" bgcolor="#FF9600"><div
																			align="center">
																			<strong>Semister</strong>
																		</div></td>
																</tr>
																<%
																	Enumeration enu = cHashtable.elements();
																																		Notification_Details aNotification = null;
																																		int count = 0;
																																		//Hashtable aHashtable = new CompanyDAO().listCompanies();
																																		while (enu.hasMoreElements())
																																		{
																																			count++;
																																			aNotification = (Notification_Details) enu.nextElement();
																																			if (aNotification.getStatus().equals("Rejected") && aNotification.getNotificationID() == Integer.parseInt(request.getParameter("notiid")))
																																			{
																																				Acadamic aAcadamic = new AcadamicDAO().getAcademicDetails(aNotification.getLoginname());
																																				report += "<tr><td bgcolor='#FFB76F'><span class='style40'><strong>" + (aNotification.getRollNo()) + "</strong></span></td>" + " <td bgcolor='#FFB76F'><span class='style40'><strong>" + (aNotification.getLoginname()) + "</strong></span></td>" + "<td bgcolor='#FFB76F'><span class='style40'><strong>" + (aAcadamic.getCourse()) + "</strong></span></td>" + "<td bgcolor='#FFB76F'><span class='style40'><strong>" + (aAcadamic.getDiscipline()) + "</strong></span></td>"
																																						+ "<td bgcolor='#FFB76F'><span class='style40'><strong>" + (aAcadamic.getSemister()) + "</strong></span></td>" + "</tr>";
																%>

																<tr>
																	<td bgcolor="#FFB76F"><span class="style40"><strong><%=(aNotification.getRollNo())%></strong></span></td>
																	<td bgcolor="#FFB76F"><span class="style40"><strong><%=(aNotification.getLoginname())%></strong></span></td>
																	<td bgcolor="#FFB76F"><span class="style40"><strong><%=(aAcadamic.getCourse())%></strong></span></td>
																	<td bgcolor="#FFB76F"><span class="style40"><strong><%=(aAcadamic.getDiscipline())%></strong></span></td>
																	<td bgcolor="#FFB76F"><span class="style40"><strong><%=(aAcadamic.getSemister())%></strong></span></td>
																</tr>
																<%
																	}
																		}
																			report += "</table>";
																			session.setAttribute("Reports", report);
																%>
															</table>
															<%
																}else{
															%>
															<div align="center" class="style38">No Records
																Found</div>
															<%
																}
															%>
															<%
																}
																	catch (Exception e)
																	{
																		LoggerManager.writeLogWarning(e);
																	}
																}
															%>
														</form></td>
												</tr>
											</table>
										</div></td>
									<td width="13"></td>
								</tr>
								<tr>
									<td height="19" colspan="3" align="left" valign="top"
										bgcolor="#ff9900" style="width: 190px;">&nbsp;</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td align="left" valign="top">&nbsp;</td>
				</tr>
				<tr>
					<td><img style="width: 503px; height: 4px;" alt=""
						src="index_files/TOP.gif" height="5" width="15"></td>
				</tr>
			</tbody>
		</table>
</body>
</html>