<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript"
	src="<c:url value="/resources/js/listcampaigns.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/contactshistory.js" />"></script>
<link href="<c:url value="/resources/css/contactshistory.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/listcampaigns.css" />"
	rel="stylesheet">
<style>
.btn-download-imgbg {
	background: url(resources/images/download2.png) no-repeat;
	background-position: 0 100%;
	padding-left: 50px
}

.btn-add-bg-img {
	background: url(resources/images/add2.png) no-repeat;
	background-position: 0 100%;
}

.btn-cron-bg-img {
	background: transparent url(resources/images/cronjob4.png) no-repeat;
	background-position: 0 100%;
}
</style>
</head>
<body>

	<section id="contact-page">
		<div class="wrapper">
			<div class="container">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<legend>
						<div class="main-heading text-center"
							style="font-family: BEBAS; font-size: 20px; margin-top: 43px; text-align: left; color: #000080;">
							List Campaigns</div>
					</legend>
					<div id="wait"
						style="display: none; width: 69px; height: 89px; border: 0px; position: absolute; top: 10%; left: 50%; padding: 2px;">
						<img src='<c:url value="/resources/images/ajaxloader.gif" />'
							width="64" height="64" /><br>Loading..
					</div>
					<div class='table-responsive'>
						<table data-show-multi-sort="true" data-show-columns="true"
							class="table table-striped table-bordered bootstrap-datatable datatable data-sortable "
							id="campaignresults">
							<tr>
								<th data-sortable="true">Campaign Name</th>
								<th>Pending Contacts</th>
								<th>Start Time</th>
								<th>End Time</th>
								<th>Enabled</th>
								<th>Action</th>
							</tr>
							<tbody id='allcampaigns'>
							</tbody>
						</table>
					</div>
					<legend>
						Contacts History
						<!-- <div class="main-heading text-center"
							style="font-family: BEBAS; font-size: 20px; margin-top: 43px; text-align: left; color: #000080;">
							Contacts History</div> -->
					</legend>
					<div class='table-responsive'>
						<div class='table-responsive'>
							<table data-show-multi-sort="true" data-show-columns="true"
								class="table table-striped table-bordered bootstrap-datatable datatable"
								id="logFiles">
								<tr>
									<th>File Name</th>
									<th>Action</th>
								</tr>

								<tbody id='contactshistory'>
									<c:forEach items="${LogFiles}" var="logFile">
										<tr>
											<td><c:out value="${logFile.fileName}" /></td>
											<%-- <td class='delete-cell'><input type=button class='btn-download-imgbg'
												onclick="downloadfile('${logFile.fileName}')"
												value="Download" /></td> --%>

											<td class='delete-cell'>
												<%-- <img
												src='resources/images/download2.png'
												onclick="downloadfile('${logFile.fileName}')">  --%> <input
												type=button class='btn-download-imgbg'
												onclick="downloadfile('${logFile.fileName}')" />
											</td>
										</tr>
										<tr />
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
	</section>
</body>
<%@ include file="footer.jsp"%>
</html>