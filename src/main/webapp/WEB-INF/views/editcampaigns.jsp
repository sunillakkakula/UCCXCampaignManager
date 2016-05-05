<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript"
	src="<c:url value="/resources/js/editcampaigns.js" />"></script>
</head>
<body>

	<section id="contact-page">
		<div class="col-md-3"></div>
		<div class="wrapper">
			<div class="container">
				<div class="col-md-6">
					<div class='row'>&nbsp;</div>
					<legend>
						<div class="main-heading text-center"
							style="font-family: BEBAS; font-size: 20px; margin-top: 43px; text-align: left; color: #000080;">
							Edit Campaigns</div>
					</legend>
					&nbsp;
					<div class='table-responsive'>
						<table
							class="table table-striped table-bordered bootstrap-datatable datatable"
							id="results">
							<tr>
								<th>Campaign Name</th>
								<th>Campaign Id</th>
								<th>Current Records</th>
								<th>Enable Status</th>
								<th>Action</th>
							</tr>
							<tbody id='allcampaigns' style='min-height: 200px;'>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
<%@ include file="footer.jsp"%>
</html>