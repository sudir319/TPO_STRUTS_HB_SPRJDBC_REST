<%@ page
	import="com.dts.dae.dao.*,com.dts.dae.model.*,com.dts.core.util.*,com.dts.tpo.dao.*,com.dts.tpo.model.*"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<title>Training and Placement Operations</title>
<link href="index_files/Style.css" type="text/css" rel="stylesheet">
<script language="JavaScript" src="index_files/main_menu.js"></script>
<script language="JavaScript" src="scripts/general.js"></script>
<script language="JavaScript" src="scripts/ts_picker.js"></script>
<script language="javascript">
	function validate() {
		var temp = document.notification;
		if (temp.companyName.value == "" || temp.noofvac.value == ""
				|| temp.jobdesc.value == "" || temp.location.value == ""
				|| temp.desiredskills.value == "" || temp.cdate.value == ""
				|| temp.expdate.value == "" || temp.desig.value == "") {
			alert("All Fields are manditory");
			return false;
		}
		if (!IsNumeric(temp.noofvac.value)) {
			alert("Number of vacancies must be numeric");
			return false;
		}

		return true;
	}
</script>
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
					<td></td>
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
															class="style36">
															<strong> Notification</strong> Details
														</div></td>
												</tr>
												<tr>
													<td height="594" valign="top">
														<form name="notification"
															action="UpdateNotificationAction.jsp"
															onSubmit="return validate()">
															<input type="hidden" name="id"
																value="<%=request.getParameter("id")%>" />
															<%
																Hashtable tHashtable = (Hashtable) session.getAttribute("notifications");

																													Notification_Details aNotification = (Notification_Details) tHashtable.get(new Integer(request.getParameter("id")));
															%>
															<table width="379" border="0" align="center"
																bordercolor="#CD817E" bgcolor="#FFDBA6">
																<tr>
																	<td width="357"><table width="394" height="355"
																			border="0" align="center" bgcolor="#FFDBA6">
																			<tr>
																				<td width="114" height="27" class="style36"><span
																					class="style36">Company Name</span></td>
																				<td width="270"><label> <select
																						name="companyName" id="select">
																							<%
																								try
																								{
																									String select = "";
																									Hashtable cHashtable = new CompanyDAO().listCompanies();
																									Enumeration enu = cHashtable.keys();
																									int compid = 0;
																									while (enu.hasMoreElements())
																									{
																										select = "";
																										compid = ((Integer) enu.nextElement()).intValue();
																										if (compid == aNotification.getCompanyID())
																										{
																											select = "selected";
																										}
																							%>
																							<option value="<%=(compid)%>" <%=select%>><%=((Company) cHashtable.get(new Integer(compid))).getCompanyName()%></option>
																							<%
																								}
																								}
																								catch (Exception e)
																								{
																									LoggerManager.writeLogWarning(e);
																								}
																							%>
																					</select>
																				</label></td>
																			</tr>
																			<tr>
																				<td height="27" class="style36">No of Vacancies</td>
																				<td><label> <input type="text"
																						name="noofvac"
																						value="<%=aNotification.getNoofvac()%>">
																				</label></td>
																			</tr>
																			<tr>
																				<td height="69" class="style36"><span
																					class="style36">Description</span></td>
																				<td><label> <textarea name="jobdesc"
																							rows="4"><%=aNotification.getJobdesc()%></textarea>
																				</label></td>
																			</tr>
																			<tr>
																				<td height="24" class="style36"><span
																					class="style36">Category</span></td>
																				<td><label> <input type="text"
																						name="category" readonly
																						value="<%=aNotification.getCategory()%>" />
																				</label></td>
																			</tr>
																			<tr>
																				<td height="27" class="style36"><span
																					class="style36">Location</span></td>
																				<td><label> <input type="text"
																						name="location"
																						value="<%=aNotification.getLocation()%> " readonly>
																				</label></td>
																			</tr>
																			<tr>
																				<td height="27" class="style36"><span
																					class="style36">Desired Skills</span></td>
																				<td><label><input type="text"
																						name="desiredskills"
																						value="<%=aNotification.getDesiredskills()%>"
																						readonly> </label></td>
																			</tr>

																			<tr>
																				<td height="27" class="style36"><span
																					class="style36">Created Date</span></td>
																				<td><label> <input type="text"
																						name="cdate" readonly
																						value="<%=DateWrapper.parseDate(aNotification.getCreateddate1())%>">
																				</label></td>
																			</tr>
																			<tr>
																				<td height="27" class="style36"><span
																					class="style36">Expiry Date</span></td>
																				<td><label> <input type="text"
																						name="expdate" readonly
																						value="<%=DateWrapper.parseDate(aNotification.getExpirydate1())%>">
																				</label></td>
																			</tr>

																			<tr>
																				<td height="27" class="style36"><span
																					class="style36">Designation</span></td>
																				<td><label> <input type="text"
																						name="desig"
																						value="<%=aNotification.getDesignation()%>"
																						readonly>
																				</label></td>
																			</tr>
																			<tr>
																				<td height="27" class="style36"><span
																					class="style36">Status</span></td>
																				<td><label> <input type="text"
																						name="status"
																						value="<%=aNotification.getStatus()%>" />
																				</label></td>
																			</tr>

																			<tr>
																				<td height="51" colspan="2">
																					<div align="center">
																						&nbsp; <input name="Input" type="reset"
																							value="Close"
																							onclick="javascript:window.close();">
																					</div>
																				</td>
																			</tr>
																		</table></td>
																</tr>
																<tr>
																	<td height="21" valign="baseline" bgcolor="#FFDBA6"><div
																			align="center">
																			<img src="images/regisbot.gif" alt="a" width="280"
																				height="3">
																		</div></td>
																</tr>
															</table>
														</form>
													</td>
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