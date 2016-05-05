<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp"%>
<script type="text/javascript"
	src="<c:url value="/resources/js/addcampaign.js" />"></script>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript"
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment-with-locales.js"></script>
<script
	src="http://cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/src/js/bootstrap-datetimepicker.js"></script>

<link href="<c:url value="/resources/css/bootstrap-select.min.css" />"
	rel="stylesheet">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

<script>
	$(function() {
		$('#startTime').datetimepicker({
			format : 'LT'
		});
		$('#endTime').datetimepicker({
			format : 'LT'
		});
	});
</script>
</head>
<body>
	<div class="wrapper">
		<div class="container">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<legend>Results Page</legend>
				&nbsp; &nbsp;&nbsp; &nbsp; <br />
				&nbsp; &nbsp;&nbsp; &nbsp; <br />
				&nbsp; &nbsp;&nbsp; &nbsp; <br />&nbsp; &nbsp;&nbsp; &nbsp; <br />&nbsp; &nbsp;&nbsp; &nbsp; <br />
				&nbsp; &nbsp;&nbsp; &nbsp; <br />
				&nbsp; &nbsp;&nbsp; &nbsp; <br />
				&nbsp; &nbsp;&nbsp; &nbsp; <br />&nbsp; &nbsp;&nbsp; &nbsp; <br />&nbsp; &nbsp;&nbsp; &nbsp; <br />
				&nbsp; &nbsp;&nbsp; &nbsp; <br />
				&nbsp; &nbsp;&nbsp; &nbsp; <br />
				&nbsp; &nbsp;&nbsp; &nbsp; <br />
				<div class="col-md-3"></div>
				&nbsp;
				<div class="col-md-3"></div>
			</div>
			<div class="col-md-2"></div>
		</div>
		<!-- <div id="dialog" title="Save">
			<p>Would you like to Save?</p>
			
		</div> -->
		<br> <br>
	</div>
</body>
<%@ include file="footer.jsp"%>