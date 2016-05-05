<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript"
	src="<c:url value="/resources/js/addcontacts.js" />"></script>
</head>
<body>
	<div class="wrapper">
		<div class="container">

			<form name="fileupload" method="GET">
				<div id="dvImportSegments" class="fileupload "
					style="font-family: BEBAS;">
					<fieldset>
						<legend>
							<div class="main-heading text-center"
								style="font-family: BEBAS; font-size: 20px; margin-top: 43px; text-align: left; color: #000080;">
								Add Contacts</div>
						</legend>
						&nbsp;
						<div class="row">
							<div class="col-lg-4 ">
								<!-- 	<label for="campaignName" class="col-sm-4 control-label">Name</label>
								<div class="col-lg-6 ">
									<div id='campaignName' class="pull-center" align='left'
								style="font-family: BEBAS; font-size: 20px; color: #3b5998;"></div>
								</div> -->
							</div>
							<!-- <div class="col-lg-3 ">
								<div class="col-lg-6 ">Id</div>
								<div class="col-lg-6 ">
									<div id='campaignId' class="pull-center" align='left'
								style="font-family: BEBAS; font-size: 20px; color: #3b5998;"></div>
								</div>
							</div> -->
							<div class="col-lg-4">
								<label for="campaignName" class="col-sm-4 control-label">Name</label>
								<div id='campaignName' class="pull-center" align='left'
									style="font-family: BEBAS; font-size: 20px; color: #3b5998;">
								</div>
								<br /> <label for="campaignId" class="col-sm-4 control-label">Id</label>
								<div id='campaignId' class="pull-center" align='left'
									style="font-family: BEBAS; font-size: 20px; color: #3b5998;"></div>

								<div>
									<br /> <br />
									<br /> <br />
								</div>
								<div>
									<input type="file" name="File Upload" id="txtFileUpload"
										class="btn btn-primary" accept=".csv" />
								</div>
								<!-- <div class="col-lg-6 ">Id</div>
							<div class="col-lg-6 ">
								<div id='campaignId' class="pull-center" align='left'
									style="font-family: BEBAS; font-size: 20px; color: #3b5998;"></div>
							</div> -->

								<!-- <div class="col-lg-12 ">
									<input type="file" name="File Upload" id="txtFileUpload"
										class="btn btn-primary" accept=".csv" />
								</div> -->
							</div>
							<div class="col-lg-4"></div>
						</div>

					</fieldset>
				</div>
			</form>
		</div>


		<!-- <div class="wrapper">
			<div class="container">
				<div class="col-md-6">
					<div class='row'>&nbsp;</div>
					<legend>Campaigns</legend>
					<div class='table-responsive'> -->
		<div class="wrapper">
			<div class="container">
				<div class="col-md-3"></div>
				<div class="col-md-6">

					<div class='table-responsive'>
						<table
							class="table table-striped table-bordered bootstrap-datatable datatable"
							id="results">
							<tr>
								<th>Account Number</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Phone1</th>
							</tr>

							<tbody id='uploadedcontacts' style='min-height: 200px;'>
							</tbody>
						</table>
						<div class="col-md-3"></div>
						<div class="col-md-3">
							<a class='btn btn-primary' style='width: 125px' onclick='save();'>Save</a>
						</div>
						&nbsp;
						<div class="col-md-3">
							<a class='btn btn-primary' style='width: 125px'
								onclick='clearTable()'>Reset</a>
						</div>
						<div class="col-md-3"></div>
					</div>
				</div>
				<div class="col-md-3"></div>
				<div class="col-md-4"></div>
				<div></div>

			</div>
			<div id="dialog" title="Save">
				<p>Would you like to Save?</p>
			</div>
			<br> <br>
		</div>
	</div>
</body>
</html>