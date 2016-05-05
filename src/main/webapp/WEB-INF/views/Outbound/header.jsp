<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv='cache-control' content='no-cache'>
<meta http-equiv='expires' content='0'>
<meta http-equiv='pragma' content='no-cache'>
<title>UCCX Campaign Manager</title>
<link rel="icon" href="<c:url value="/resources/images/favicon.png" />"
	type="image/gif" sizes="16x16">
<link rel="shortcut icon"
	href="<c:url value="/resources/images/favicon.ico" />">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/fonts/fonts.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/animate.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/prettyPhoto.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/responsive.css" />"
	rel="stylesheet">

<script src="<c:url value="/resources/js/jquery-1.10.2.min.js" />"></script>
<script type='text/javascript'
	src='http://code.jquery.com/jquery-1.11.0.js'></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type='text/javascript'
	src="<c:url value="/resources/js/jquery.csv-0.71.js" />"></script>

</head>
<body>
	<header id="header">
		<div class="top-bar">
			<div class="container">
				<div class="row">
					<div class="col-md-3">
						<img src="<c:url value="/resources/images/SSS-Logo.png" />" />
					</div>
					<div class="col-md-6">
						<form class="omb_loginForm" action="logout" autocomplete="off"
							method="POST">
							<div class="main-heading text-center"
								style="font-family: BEBAS; font-size: 30px; margin-top: 43px; text-align: center; color: #000080;">
								UCCX Outbound</div>
							<div class="col-sm-12 pull-center">
								<div class="col-md-3"></div>
							</div>
						</form>
					</div>
					<div class="col-md-3">
						<div class="pull-right" align='right'>
							<div class="form-group form-inline">
								<!-- 								<a class='btn-primary' href="http://10.1.6.196:8080/UCCXVerS3/dashboard" style='width: 125px'>Logout</a>
								<a class='btn-primary' href="http://10.1.6.196:8080/UCCXVerS3/dashboard" -->
								<a class='btn-primary'
									href="http://localhost:8080/UCCXCampaignManager/"
									style='width: 125px'>Logout</a> <a class='btn-primary'
									href="http://localhost:8080/UCCXCampaignManager/"
									style="padding-left: 20px; width: 125px;">Home</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--/.container-->
		</div>
		<!--/.top-bar-->
		<!-- <div class="main-heading text-center" style="font-size:30px;margin-top:43px;text-align: center;color:#4f4f4f;"> -->

		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
		</div>
		<!--/.container-->

	</header>
	<!--/header-->
</body>
</html>