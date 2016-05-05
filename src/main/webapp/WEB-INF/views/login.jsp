
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv='cache-control' content='no-cache'>
<meta http-equiv='expires' content='0'>
<meta http-equiv='pragma' content='no-cache'>
<title>Speech-Soft UCCX</title>
<link rel="icon" href="<c:url value="/resources/images/favicon.png" />" type="image/gif" sizes="16x16">
<link rel="shortcut icon"
	href="<c:url value="/resources/images/favicon.ico" />">
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/animate.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/prettyPhoto.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/responsive.css" />"
	rel="stylesheet">
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"
	rel="stylesheet">
<link rel="shortcut icon"
	href="<c:url value="/resources/images/favicon3.ico" />">
<style>
</style>
<script src="<c:url value="/resources/js/jquery-1.10.2.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/login.js" />"></script>
<body onload="setFocus()">
	<section id="login-page">
		<div class="wrapper">
			<div class="container">
				<div class="omb_login">
					<div class='row'>&nbsp;</div>
					<!-- <h3 class="omb_authTitle">UCCX Outbound</h3> -->
					<div class="row">
						<div class="col-md-3"></div>
						<div class="col-md-6">
							<div class='row'>
								<img src="<c:url value="/resources/images/SSS-Logo.png" />" />
							</div>
							<div class='row'>
								<h3 class="omb_authTitle">UCCX Outbound</h3>
							</div>
							<div class='row'>&nbsp;</div>
							<div class='row'>
								<form class="omb_loginForm" method="POST" name='loginForm'>
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-user"></i></span>
										<input type="text" class="form-control" id='userName'
											placeholder="Enter User Name" />
									</div>
									<span class="help-block"></span>

									<div class="input-group" style="padding-bottom: 50px;">
										<span class="input-group-addon"><i class="fa fa-lock"></i></span>
										<input type="password" class="form-control" id='userPassword'
											placeholder="Enter Password" />
									</div>
									<div align='center'>
										<span id='error' style="display: none;">Password error</span>
									</div>

									<!-- <button class="btn btn-lg btn-primary btn-block" type="button" onclick="getdata();">Sign In</button> -->
									<button class="btn-primary btn-block"
										style="background-color: #286090;" type="submit"
										onclick='return getdata();'>Sign In</button>
								</form>
							</div>
							<div class='row'>&nbsp;</div>

						</div>
						<div class="col-md-3"></div>
					</div>

				</div>


			</div>
		</div>
	</section>
</body>
</html>