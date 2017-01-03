<%@ page
	import="com.dts.tpo.model.*,com.dts.tpo.dao.*,com.dts.core.util.*,java.util.*"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<title>Training and Placement Operations</title>
<link href="index_files/Style.css" type="text/css" rel="stylesheet">
<script language="JavaScript" src="index_files/main_menu.js"></script>
<script language="JavaScript" src="scripts/ts_picker.js"></script>
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
.style40 {
	color: #000000;
	font-weight: normal;
}

.style42 {
	color: #660000
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
															class="menunolink style42">
															<strong>New Training</strong>
														</div></td>
												</tr>
												<tr>
													<td height="232" valign="top">

														<form name="newtraining" method="post"
															action="Trainings.do?action=update">
															<input type="hidden" name="trainingId"
																value="<%=request.getParameter("id")%>" />
															<%
																Training_Details aTraining = (Training_Details) session.getAttribute("load_training");
															%>
															<table width="328" border="0" align="center">
																<tr>
																	<td width="114"><span class="style40">Course
																	</span></td>
																	<td width="204"><label> <input
																			name="trainingName" type="text" id="tname" size="30"
																			value="<%=aTraining.getTrainingName()%>">
																	</label></td>
																</tr>
																<tr>
																	<td><span class="style40">Start Date </span></td>
																	<td><label> <input name="start_date"
																			type="text" id="textfield2" size="30" readonly
																			value=<%=DateWrapper.parseDate(aTraining.getStart_date())%>>
																			<a
																			href="javascript:show_calendar('document.newtraining.tdate', document.newtraining.tdate.value);">
																				<img src="images/cal.gif" alt="f" width="18"
																				height="18" border="0" />
																		</a>
																	</label></td>
																</tr>
																<tr>
																	<td><span class="style40">End Date </span></td>
																	<td><label> <input name="end_date"
																			type="text" id="textfield2" size="30" readonly
																			value=<%=DateWrapper.parseDate(aTraining.getEnd_date())%>>
																			<a
																			href="javascript:show_calendar('document.newtraining.tdate', document.newtraining.tdate.value);">
																				<img src="images/cal.gif" alt="f" width="18"
																				height="18" border="0" />
																		</a>
																	</label></td>
																</tr>
																<tr>
																	<td><span class="style40">Start Time </span></td>
																	<td><label> <input name="start_time"
																			type="text" id="ttime" size="30"
																			value="<%=aTraining.getStart_time()%>">
																	</label></td>
																</tr>
																<tr>
																	<td><span class="style40">End Time </span></td>
																	<td><label> <input name="end_time"
																			type="text" id="ttime" size="30"
																			value="<%=aTraining.getEnd_time()%>">
																	</label></td>
																</tr>
																<tr>
																	<td><span class="style40">Description </span></td>
																	<td><label> <textarea name="trainingdesc"
																				id="tdesc" cols="28" rows="5"><%=aTraining.getTrainingdesc()%></textarea>
																	</label></td>
																</tr>
																<tr>
																	<td><span class="style40">Status</span></td>
																	<td><label> <select name="status">
																				<option><%=aTraining.getStatus() %></option>
																				<option>Running</option>
																				<option>Completed</option>
																		</select>
																	</label></td>
																</tr>
																<tr>
																	<td></td>
																	<td></td>
																</tr>
																<tr>
																	<td height="21" colspan="2"><label>
																			<div align="center">
																				<input type="submit" name="button" id="button"
																					value="Update">
																			</div>
																	</label></td>
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