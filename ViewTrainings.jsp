<%@ page
	import="com.dts.tpo.model.*,com.dts.tpo.dao.*,com.dts.core.util.*,java.util.*"%>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Training and Placement Operations</title>

<link rel="stylesheet" type="text/css" media="screen"
	href="styles/jquery-ui-1.9.2.custom.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="styles/ui.jqgrid.css" />

<link href="index_files/Style.css" type="text/css" rel="stylesheet">
<link href="styles/pager.css" type="text/css" rel="stylesheet">

<script type="text/javaScript" src="index_files/main_menu.js"></script>
<script type="text/javaScript" src="scripts/general.js"></script>
<script type="text/javaScript" src="scripts/pager.js"></script>

<script type="text/javascript" src="scripts/jquery-1.8.3.js"></script>
<script type="text/javascript" src="scripts/jquery-ui-1.9.2.custom.js"></script>
<script src="scripts/grid.locale-en.js" type="text/javascript"></script>
<script src="scripts/jquery.jqGrid.min.js" type="text/javascript"></script>


<script type="text/javascript">
	$(function() {
		$("#list").jqGrid(
				{
					url : "reports.jsp?type=trainings",
					datatype : "json",
					mtype : "GET",
					colNames : [ "Name", "Start Date", "End Date", "Start Time",
							"End Time", "Status", "Edit", "Delete" ],
					colModel : [ {
						name : "ID",
						align : "left",
						sortable : false
					}, {
						name : "Start Date",
						align : "left",
						sortable : false
					}, {
						name : "End Date",
						align : "left",
						sortable : false
					}, {
						name : "Start Time",
						align : "left",
						sortable : false
					}, {
						name : "End Time",
						align : "left",
						sortable : false
					}, {
						name : "Status",
						align : "left",
						sortable : false
					}, {
						name : "Edit",
						align : "left",
						sortable : false
					}, {
							name : "Delete",
							align : "left",
							sortable : false
					}],
					pager : "#pager",
					rowNum : 7,
					rownumbers : true,
					rowList : [ 2, 5, 10, 15 ],
					height : 'auto',
					width : '776',
					loadonce : true,
					caption : "Trainings Information"
				});
	});
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
					<td><jsp:include page="tpooptions.html" /></td>
				</tr>
				<tr>
					<td align="center" valign="top" width="700">
						<table id="list">
							<tr>
								<td></td>
							</tr>
						</table>
						<div id="pager"></div>
					</td>
				</tr>
				<tr>
					<td align="left" valign="top">&nbsp;</td>
				</tr>
				<tr>
					<td><img style="width: 503px; height: 4px;" alt=""
						src="index_files/TOP.gif" height="5" width="15"></td>
				</tr>
				
				<tr>
					<td style="width: 30px;" align="center" valign="bottom"
										width="30"><a href="javascript:location.href='Trainings.do?action=add_new'"><img style="width: 20px; height: 20px;" alt=""
										src="images/add.png" border="0" height="20" hspace="0"
										width="20" ></a></td>
				</tr>
				
			</tbody>
		</table>
		<!--
			Below is the logic to call the Paination logic to show the pages.
		 -->
</body>
</html>