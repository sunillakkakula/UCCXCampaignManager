<%@page
	import="java.io.File,com.speechsoft.util.*,java.util.*,com.speechsoft.bean.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<link href="<c:url value="/resources/css/contactshistory.css" />"
	rel="stylesheet">
<script type="text/javascript"
	src="<c:url value="/resources/js/contactshistory.js" />"></script>

</head>
<body>
	<section id="history-page">
		<div class="col-md-1"></div>
		<div class="wrapper">
			<div class="container">
				<div class="col-md-10">
					<div class='row'>&nbsp;</div>
					<legend>
						<div class="main-heading text-center"
							style="font-family: BEBAS; font-size: 20px; margin-top: 43px; text-align: left; color: #000080;">
							Contacts History</div>
					</legend>
					<div class='table-responsive'>
						<table
							class="table table-striped table-bordered bootstrap-datatable datatable"
							id="logFiles">
							<tr>
								<th>File Name</th>
								<th>Action</th>
							</tr>

							<tbody id='contactshistory' style='min-height: 200px;'>
								<c:forEach items="${LogFiles}" var="logFile">
									<%
										String str = "Sunil";
									%>
									<tr>
										<td><c:out value="${logFile.fileName}" /></td>
										<td class='delete-cell'><input type=button
											class='btn-delete'
											onclick="downloadfile('${logFile.fileName}')"
											value="Download" /></td>
										<%-- <td><input type =button onclick="downloadfile('${logFile.fileName}')" value="${logFile.fileName}" >Download </input></td> --%>

									</tr>
									<tr />
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
	</section>
</body>
<%@ include file="footer.jsp"%>
</html>