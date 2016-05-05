<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp"%>
<head>
<script type="text/javascript"
	src="<c:url value="/resources/js/modifycampaigndetails.js" />"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css">

<!-- Latest compiled and minified JavaScript -->
<link href="<c:url value="/resources/css/bootstrap-select.min.css" />"
	rel="stylesheet">

<%-- <link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://rawgit.com/FezVrasta/bootstrap-material-design/master/dist/css/material.min.css" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap-material-datetimepicker.css" />"
	rel="stylesheet" /> --%>
<%-- <link href="<c:url value="/resources/css/switch/base.css" />" rel="stylesheet"/> --%>
<link href="<c:url value="/resources/css/switch/style.css" />"
	rel="stylesheet" />
<link href="css/style.css" rel="stylesheet">

<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap-switch.min.css" />" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/modifycampaigndetails.css" />" />
<link rel="stylesheet"
	href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />"
	rel="stylesheet" />
<link rel="stylesheet"
	href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css" />"
	rel="stylesheet" />



<script src="<c:url value="/resources/js/jquery-1.12.3.min.js" /> "></script>
<script src="<c:url value="/resources/js/bootstrap-switch.min.js" /> "></script>

<script src="https://code.jquery.com/jquery-1.12.3.min.js"
	integrity="sha256-aaODHAgvwQW1bFOGXMeX+pC4PZIPsvn2h1sArYOhgXQ="
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<%-- <script type="text/javascript"
	src="https://rawgit.com/FezVrasta/bootstrap-material-design/master/dist/js/material.min.js"></script>
<script type="text/javascript"
	src="http://momentjs.com/downloads/moment-with-locales.min.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap-material-datetimepicker.js" />"></script>
	
	 --%>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/moment.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#datetimepicker4').datetimepicker({
			format : 'LT'
		});
		$('#datetimepicker3').datetimepicker({
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
				<legend>Modify Campaign</legend>
				&nbsp;
				<div id="wait"
					style="display: none; width: 69px; height: 89px; border: 0px; position: absolute; top: 10%; left: 50%; padding: 2px;">
					<img src='<c:url value="/resources/images/ajaxloader.gif" />'
						width="64" height="64" /><br>Loading..
				</div>
				<div class="col-md-12">
					<form class="form-group form-inline">
						<label class="control-label" for="campaignType">Campaign
							Type</label> <select data-style="btn-facebook" id="campaignTypeOption">
							<option value="IVR">IVR</option>
							<option value="AGENT">AGENT</option>
						</select> &nbsp;&nbsp;&nbsp;&nbsp;
						<div class='row'>&nbsp;</div>
						<label for="cmn-toggle-3">Enabled</label>
						<div class="switch">
							<input id="cmn-toggle-3" class="cmn-toggle cmn-toggle-round"
								type="checkbox"> <label for="cmn-toggle-3">Enabled</label>
						</div>


						<label class="control-label" for="dialerType">Dialer Type</label>
						<!-- <select id="dialerTypeOption" class="selectpicker"
							data-style="btn-facebook"> -->
						<select id="dialerTypeOption" data-style="btn-facebook">
							<option value="PROGRESSIVE">PROGRESSIVE</option>
							<option value="PREDICTIVE">PREDICTIVE</option>
							<option value="DIRECT_PREVIEW">DIRECT_PREVIEW</option>
						</select>
						<div class='row'>&nbsp;</div>

						<div class="form-group">
							<label class="control-label" for="startTime">Start Time </label>
							<div class='input-group date' id='datetimepicker4'>
								<input type='text' id='startTime' class="form-control"
									placeholder="HH:MM" /> <span class="input-group-addon">
									<span class="glyphicon glyphicon-time"></span>
								</span>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label" for="endTime">End Time </label>
							<div class='input-group date' id='datetimepicker3'>
								<input type='text' id='endTime' class="form-control"
									placeholder="HH:MM" /> <span class="input-group-addon">
									<span class="glyphicon glyphicon-time"></span>
								</span>
							</div>
						</div>
						<div class='row'>&nbsp;</div>
						<div class="form-group">
							<label class="control-label" for="maxDialAttempts">Max
								Dial Attempts</label> <input type="number" id="maxDialAttempts" min="1"
								max="3" step="1" value="1"/>
						</div>
						<div class='row'>&nbsp;</div>
						<!-- <div class="form-group">
						<label class="control-label"
									for="datetimepicker4"> Answering Machine Retry</label>
							<div class="switch">
								<input id="datetimepicker4" class="cmn-toggle cmn-toggle-round"
									type="checkbox"> <label class="control-label"
									for="datetimepicker4"> Answering Machine Retry</label>
							</div>
						</div> -->
						<div class="form-group">
							<div class="switch">
								<label for="cmn-toggle-4">Answering Machine Retry</label> <input
									id="cmn-toggle-4" class="cmn-toggle cmn-toggle-round"
									type="checkbox"> <label for="cmn-toggle-4"></label>
									&nbsp;&nbsp;&nbsp;&nbsp;
							</div>
						</div>

						<div class='row'>&nbsp;</div>
						<label class="control-label" for="missedCallback">Missed
							Callback</label> <select id="missedCallbackOption"
							data-style="btn-facebook">
							<option value="NEXT_DAY">NEXT_DAY</option>
							<option value="RETRY">RETRY</option>
							<option value="CLOSE">CLOSE</option>
						</select>
						<div class='row'>&nbsp;</div>
						<label class="control-label" for="missedCallback">CSQ's</label> <select
							id="csqValues" data-style="btn-facebook">
						</select>
					</form>
				</div>
				<div class="col-md-3"></div>
				<div class="col-md-2">
					<a class='btn btn-primary' style='width: 125px'
						onclick='saveCampaign();'>Save</a>
				</div>
				<div class="col-md-2"></div>
				<div class="col-md-2">
					<a class='btn btn-primary' style='width: 125px'
						onclick='clearTable()'>Reset</a>
				</div>
				<div class="col-md-3"></div>
				<div class="col-md-3"></div>
			</div>
			<div class="col-md-2"></div>
		</div>
		<br> <br>
	</div>
</body>
