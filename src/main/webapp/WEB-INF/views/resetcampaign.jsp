<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%-- <link href="<c:url value="/resources/css/prettyPhoto.css" />" --%>
<script type="text/javascript"
	src="<c:url value="/resources/js/resetcampaign.js" />"></script>
<style>
#resetClass {
	width: 125px;
	height: 25px;
	text: 'Reset';
	background-image: resources/images/trash.png;
	background: transparent url("resources/images/trash.png") no-repeat;
	text-decoration: none;
	background-repeat: no-repeat;
	background: #dcdcdc no-repeat scroll 5px center;
}
</style>
</head>
<body>

	<section id="contact-page">
		<div class="container">
			<div class="left">
				<div class="row contact-wrap">
					<div class='table-responsive'>
						<table
							class="table table-striped table-bordered bootstrap-datatable datatable"
							id="results">
							<tr>
								<th>Campaign Name</th>
								<th>Campaign Id</th>
								<th>Current Records</th>
								<th></th>
							</tr>

							<tbody id='allcampaigns' style='min-height: 200px;'>
							</tbody>
							<!-- 	<div align='center' id="pageNavPosition"></div> -->
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
<%@ include file="footer.jsp"%>
</html>