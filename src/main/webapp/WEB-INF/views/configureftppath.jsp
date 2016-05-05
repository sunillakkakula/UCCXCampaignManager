
<%@page
	import="java.io.File,com.speechsoft.util.*,java.util.*,com.speechsoft.bean.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="header.jsp"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<link href="<c:url value="/resources/css/contactshistory.css" />"
	rel="stylesheet">
<script type="text/javascript"
	src="<c:url value="/resources/js/configureftppath.js" />"></script>
<style>
.modal {
	position: fixed;
	z-index: 999;
	height: 100%;
	width: 100%;
	top: 0;
	left: 0;
	background-color: Black;
	filter: alpha(opacity = 60);
	opacity: 0.6;
	-moz-opacity: 0.8;
}

.center {
	z-index: 1000;
	margin: 300px auto;
	padding: 10px;
	width: 130px;
	background-color: White;
	border-radius: 10px;
	filter: alpha(opacity = 100);
	opacity: 1;
	-moz-opacity: 1;
}

.center img {
	height: 128px;
	width: 128px;
}
</style>
</head>
<section id="configureftpfile-page">
	<div class="wrapper">
		<div class="container">
			<legend>
				<div class="main-heading text-center"
					style="font-family: BEBAS; font-size: 20px; margin-top: 43px; text-align: left; color: #000080;">
					Configure FTP File to Campaign</div>
			</legend>
			<div class="col-md-3">
				<!-- <div class="modal" style="display: none">
					<div class="center">
						<img alt="" src="/resources/images/spinner.gif" />
					</div>
				</div> -->
			</div>
			<div class="col-md-6">
				<form:form commandName="ftpCampaignCommandBean"
					class="form-horizontal">
					<div class="form-group">
						<label for="campaignId" class="col-sm-4 control-label">Campaign
							Id</label>
						<div class="col-sm-6">
							<div id='campaignId' class="pull-center" align='left'
								style="font-family: BEBAS; font-size: 20px; color: #3b5998;"></div>
						</div>
					</div>
					<div class="form-group">
						<label for="campaignName" class="col-sm-4 control-label">Campaign
							Name</label>
						<div class="col-sm-6">
							<div id='campaignName' class="pull-center" align='left'
								style="font-family: BEBAS; font-size: 20px; color: #3b5998;"></div>
						</div>
					</div>
					<div class="form-group">
						<label for="ftpFileName" class="col-sm-4 control-label">FTP
							File Name</label>
						<div class="col-sm-6">
							<form:select path="ftpFileName" id="ftpFileName"
								cssClass="form-control" />
						</div>
					</div>
					<%-- <div class="form-group">
						<label for="campaignId" class="col-sm-4 control-label">Campaign
							Id</label>
						<div class="col-sm-6">
							<form:select path="campaignId" id="campaignId"
								cssClass="form-control" />
						</div>
					</div>  --%>
				
				&nbsp;
				<div class="col-md-3"></div>
				&nbsp;
				<div class="col-md-3">
						<input type=submit class='btn btn-primary' value='Save'
							style="background-color: #286090; width: 125px" onclick='save();'>
					</div>
					<div class="col-md-3">
						<input type=submit class='btn btn-primary' value='Reset'
							style="background-color: #286090; width: 125px">
					</div>
					<div class="col-md-3"></div>
				</form:form>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>

</section>
<%@ include file="footer.jsp"%>
