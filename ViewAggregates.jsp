<%@ page import="com.dts.dae.*,com.dts.tpo.model.*,com.dts.tpo.dao.*"%>
<%@page import="java.util.Hashtable"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<title>Training and Placement Operations</title>
<link href="index_files/Style.css" type="text/css" rel="stylesheet">
<script language="JavaScript" src="index_files/main_menu.js"></script>
<script language="JavaScript" src="scripts/ts_picker.js"></script>
<script language="JavaScript" src="scripts/general.js"></script>
<script language="javascript">
function validate()
{
   var temp = document.acadamic;
   if(temp.percentage1.value=="" || temp.percentage2.value=="" || temp.rollno.value=="")
   {
       alert("All Fields are manditory");
       return false;
   }
   if(temp.ch.checked && temp.percentage3.value=="")
   {
       alert("All Fields are manditory");
       return false;
   }
   if(!IsNumeric(temp.percentage1.value) || !IsNumeric(temp.percentage2.value))
   {
       alert("Percentage should be Neumeric");
       return false;
   }
   if(!IsNumeric(temp.rollno.value))
   {
       alert("Roll No. should be Neumeric");
       return false;
   }
   return true;
}
</script>

<style type="text/css">
<!--
.style38 {
	color: #FF0000
}

.style39 {
	font-size: 10px
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
					<td></td>
				</tr>
				<tr>
					<td align="left" valign="top" bgcolor="#FF9A00">
						<table bgcolor="#ff9900" border="0" cellpadding="0"
							cellspacing="0" width="766">
							<tbody>

								<tr>
									<td width="14"></td>
									<td width="752" height="391" align="center" valign="top"
										background="index_files/BG.gif" bgcolor="#ff9900"
										style="width: 190px;"><div align="center">
											<table width="743" border="0" align="center">
												<tr>
													<td width="737" height="42"><div align="center"
															class="style25">
															
															<%String user = request.getParameter("id"); %>
															<strong> <%=user %> Aggregates</strong>
															
															
														<div align="center">
														<%
																try
												               {
												        			String username=(String)session.getAttribute("user");
												            		Hashtable tHashtable = new AggregatesDAO().getAggregates(user);
												            		Hashtable aHashtable = (Hashtable)tHashtable.get(user); 
												            		//if(!aHashtable.isEmpty())
												            		{
												                                 
												        %>
															</div>
															<table width="469" border="0" align="center"
																bgcolor="#FFDBA6">
																<%
																Aggregates aAggregates = null;
																int i=1;
																for(i=1; i<=8; i++)
																{
																     aAggregates = (Aggregates)aHashtable.get(new Integer(i)); 
																     if(aAggregates!=null)
																     {	     
																%>
																<tr>
																	<td width="88" class="style36 style38">Semister <%=(aAggregates.getSemister())%></td>
																	<td width="144"></td>
																	<td width="75">&nbsp;</td>
																	<td width="144"></td>
																</tr>
																<tr>
																	<td class="style36" align="right">Year</td>
																	<td><label> <input type="text"
																			name="textfield" readonly id="textfield"
																			value="<%=aAggregates.getYearOfPass()%>">
																	</label></td>
																	<td width="75" class="style36">Percentage</td>
																	<td width="144"><label> <input type="text"
																			name="textfield2" readonly id="textfield2"
																			value="<%=aAggregates.getAggregate()%>">
																	</label></td>
																</tr>
																<%}
																  else
																  {%>
																<tr>
																	<td width="88" class="style36 style38">Semister <%=i%></td>
																	<td width="144"></td>
																	<td width="75">&nbsp;</td>
																	<td width="144"></td>
																</tr>
																<tr>
																	<td class="style36" align="right">Year</td>
																	<td><label> <input type="text"
																			name="sem<%=i %>pass" id="textfield">
																	</label></td>
																	<td width="75" class="style36">Percentage</td>
																	<td width="144"><label> <input type="text"
																			name="sem<%=i %>per" id="textfield2">
																	</label></td>
																</tr>
																<%
																  }}%>
																<tr>
																	<td colspan="6"><div align="center">
																			<br> <input type="button" value="Close"
																				onClick="javascript:window.close()" />
																		</div></td>
																</tr>

															</table>
															<div align="center">
																<%} }
																	catch(Exception e){}%>
															</div>
														</td>
									<td width="16"></td>
								</tr>
								<tr>
									<td height="19" colspan="6" align="left" valign="top"
										bgcolor="#ff9900" style="width: 190px;">&nbsp;</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
</body>
</html>		