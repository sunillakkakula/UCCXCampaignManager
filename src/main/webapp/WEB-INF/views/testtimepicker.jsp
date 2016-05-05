<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Bootstrap-Material DateTimePicker</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />"
	rel="stylesheet" />
<link rel="stylesheet"
	href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css" />"
	rel="stylesheet" />


<!-- <link rel="stylesheet"
	href="https://rawgit.com/FezVrasta/bootstrap-material-design/master/dist/css/material.min.css" /> -->
<%-- <link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap-material-datetimepicker.css" />"
	rel="stylesheet" /> 
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap-datetimepicker.css" />"
	rel="stylesheet" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/prettify-1.0.css" />"
	rel="stylesheet" />
	 --%>
<%--
<script src="https://code.jquery.com/jquery-1.12.3.min.js"
	integrity="sha256-aaODHAgvwQW1bFOGXMeX+pC4PZIPsvn2h1sArYOhgXQ="
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
 <script type="text/javascript"
	src="https://rawgit.com/FezVrasta/bootstrap-material-design/master/dist/js/material.min.js"></script>
<script type="text/javascript"
	src="http://momentjs.com/downloads/moment-with-locales.min.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap-material-datetimepicker.js" />"></script>
 --%>
<!-- <script type="text/javascript" src="/path/to/jquery.js"></script>
<script type="text/javascript" src="/path/to/moment.js"></script>
<script type="text/javascript" src="/path/to/bootstrap/js/transition.js"></script>
<script type="text/javascript" src="/path/to/bootstrap/js/collapse.js"></script>
<script type="text/javascript" src="/path/to/bootstrap/dist/bootstrap.min.js"></script>
<script type="text/javascript" src="/path/to/bootstrap-datetimepicker.min.js"></script> 

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/moment.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/testtimepicker.js" />"></script>
<%-- <script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap-datetimepicker.js" />"></script> --%>
<script type="text/javascript"
	src="<c:url value="/resources/js/moment.js" />"></script>
<style>

/* -------------------- Page Styles (not required) */
div {
	margin: 20px;
}
/* -------------------- Page Styles (not required) */
div {
	margin: 20px;
}

/* -------------------- Select Box Styles: bavotasan.com Method (with special adaptations by ericrasch.com) */
/* -------------------- Source: http://bavotasan.com/2011/style-select-box-using-only-css/ */
.styled-select {
	background: url(http://i62.tinypic.com/15xvbd5.png) no-repeat 96% 0;
	height: 29px;
	overflow: hidden;
	width: 240px;
}

.styled-select select {
	background: transparent;
	border: none;
	font-size: 14px;
	height: 29px;
	padding: 5px;
	/* If you add too much padding here, the options won't show in IE */
	width: 268px;
}

.styled-select.slate {
	background: url(http://i62.tinypic.com/2e3ybe1.jpg) no-repeat right
		center;
	height: 34px;
	width: 240px;
}

.styled-select.slate select {
	border: 1px solid #ccc;
	font-size: 16px;
	height: 34px;
	width: 268px;
}

/* -------------------- Rounded Corners */
.rounded {
	-webkit-border-radius: 20px;
	-moz-border-radius: 20px;
	border-radius: 20px;
}

.semi-square {
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
}

/* -------------------- Colors: Background */
.slate {
	background-color: #ddd;
}

.green {
	background-color: #779126;
}

.blue {
	background-color: #3b8ec2;
}

.yellow {
	background-color: #eec111;
}

.black {
	background-color: #000;
}

/* -------------------- Colors: Text */
.slate select {
	color: #000;
}

.green select {
	color: #fff;
}

.blue select {
	color: #fff;
}

.yellow select {
	color: #000;
}

.black select {
	color: #fff;
}

/* -------------------- Select Box Styles: bavotasan.com Method (with special adaptations by ericrasch.com) */
/* -------------------- Source: http://bavotasan.com/2011/style-select-box-using-only-css/ */
.
styled-select {
	background: url(http://i62.tinypic.com/15xvbd5.png) no-repeat 96% 0;
	height: 29px;
	overflow: hidden;
	width: 240px;
}

.styled-select select {
	background: transparent;
	border: none;
	font-size: 14px;
	height: 29px;
	padding: 5px;
	width: 268px;
}

.styled-select.slate {
	background: url(http://i62.tinypic.com/2e3ybe1.jpg) no-repeat right
		center;
	height: 34px;
	width: 240px;
}

.styled-select.slate select {
	border: 1px solid #ccc;
	font-size: 16px;
	height: 34px;
	width: 268px;
}

.rounded {
	-webkit-border-radius: 20px;
	-moz-border-radius: 20px;
	border-radius: 20px;
}

/* -------------------- Colors: Background */

/* -------------------- Select Box Styles: danielneumann.com Method */
/* -------------------- Source: http://danielneumann.com/blog/how-to-style-dropdown-with-css-only/ */
#mainselection select {
	border: 0;
	color: #3B5998;
	background: transparent;
	font-size: 13px;
	font-weight: bold;
	padding: 2px 10px;
	width: 378px;
	*width: 350px;
	*background: #DFE3EE;
	-webkit-appearance: none;
}

#mainselection {
	overflow: hidden;
	width: 350px;
	font-size: 13px;
	font-weight: bold;
	padding: 2px 10px;
	font-color: #3B5998;
	-moz-border-radius: 9px 9px 9px 9px;
	-webkit-border-radius: 9px 9px 9px 9px;
	border-radius: 9px 9px 9px 9px;
	box-shadow: 1px 1px 11px #330033;
	background: #DFE3EE no-repeat scroll 319px center;
}

/* -------------------- Select Box Styles: stackoverflow.com Method */
/* -------------------- Source: http://stackoverflow.com/a/5809186 */
select#soflow, select#soflow-color {
	-webkit-appearance: button;
	-webkit-border-radius: 2px;
	-webkit-box-shadow: 0px 1px 3px rgba(0, 0, 0, 0.1);
	-webkit-padding-end: 20px;
	-webkit-padding-start: 2px;
	-webkit-user-select: none;
	background-image: url(http://i62.tinypic.com/15xvbd5.png),
		-webkit-linear-gradient(#FAFAFA, #F4F4F4 40%, #E5E5E5);
	background-position: 97% center;
	background-repeat: no-repeat;
	border: 1px solid #AAA;
	color: #555;
	font-size: inherit;
	margin: 20px;
	overflow: hidden;
	padding: 5px 10px;
	text-overflow: ellipsis;
	white-space: nowrap;
	width: 300px;
}

select#soflow-color {
	color: #fff;
	background-image: url(http://i62.tinypic.com/15xvbd5.png),
		-webkit-linear-gradient(#779126, #779126 40%, #779126);
	background-color: #779126;
	-webkit-border-radius: 20px;
	-moz-border-radius: 20px;
	border-radius: 20px;
	padding-left: 15px;
}

table {
	width: 100%;
}

thead, tbody, tr, td, th {
	display: block;
}

tr:after {
	content: ' ';
	display: block;
	visibility: hidden;
	clear: both;
}

thead th {
	height: 30px;

	/*text-align: left;*/
}

tbody {
	overflow: auto;
	height: 100px;
	overflow-x: hidden;
}

thead {
	/* fallback */
	
}

div.tableContainer {
	width: 90%; /* table width will be 99% of this*/
	height: 320px; /* must be greater than tbody*/
	overflow: auto;
	margin: 0 auto;
}

table {
	width: 97%; /*100% of container produces horiz. scroll in Mozilla*/
	border: none;
	border-spacing: 0px;
	background-color: transparent;
}

table>tbody {
	overflow: auto;
	height: 280px;
	overflow-x: hidden;
}

table>tbody tr {
	height: auto;
}

thead th {
	width: 50%;
	float: left;
}

table>thead tr {
	position: relative;
	top: 0px; /*expression(offsetParent.scrollTop); IE5+ only*/
}

.header-fixed {
	width: 100%
}

.header-fixed>thead, .header-fixed>tbody, .header-fixed>thead>tr,
	.header-fixed>tbody>tr, .header-fixed>thead>tr>th, .header-fixed>tbody>tr>td
	{
	display: block;
}

.header-fixed>tbody>tr:after, .header-fixed>thead>tr:after {
	content: ' ';
	display: block;
	visibility: hidden;
	clear: both;
}

.header-fixed>tbody {
	overflow-y: auto;
	height: 150px;
}

.header-fixed>tbody>tr>td, .header-fixed>thead>tr>th {
	width: 20%;
	float: left;
}

.cmn-toggle {
	position: absolute;
	margin-left: -9999px;
	visibility: hidden;
}

.cmn-toggle+label {
	display: block;
	position: relative;
	cursor: pointer;
	outline: none;
	user-select: none;
}

body {
	background: #555;
}

h1 {
	color: #eee;
	font: 30px Arial, sans-serif;
	-webkit-font-smoothing: antialiased;
	text-shadow: 0px 1px black;
	text-align: center;
	margin-bottom: 50px;
}

input[type=checkbox] {
	visibility: hidden;
}

/* SLIDE THREE */
.slideThree {
	width: 80px;
	height: 26px;
	background: #333;
	margin: 20px auto;
	-webkit-border-radius: 50px;
	-moz-border-radius: 50px;
	border-radius: 50px;
	position: relative;
	-webkit-box-shadow: inset 0px 1px 1px rgba(0, 0, 0, 0.5), 0px 1px 0px
		rgba(255, 255, 255, 0.2);
	-moz-box-shadow: inset 0px 1px 1px rgba(0, 0, 0, 0.5), 0px 1px 0px
		rgba(255, 255, 255, 0.2);
	box-shadow: inset 0px 1px 1px rgba(0, 0, 0, 0.5), 0px 1px 0px
		rgba(255, 255, 255, 0.2);
}

.slideThree:after {
	content: 'OFF';
	font: 12px/26px Arial, sans-serif;
	color: #000;
	position: absolute;
	right: 5px;
	z-index: 0;
	font-weight: bold;
	text-shadow: 1px 1px 0px rgba(255, 255, 255, .15);
}

.slideThree:before {
	content: 'ON';
	font: 12px/26px Arial, sans-serif;
	color: #00bf00;
	position: absolute;
	left: 5px;
	z-index: 0;
	font-weight: bold;
}

.slideThree label {
	display: block;
	width: 24px;
	height: 20px;
	-webkit-border-radius: 50px;
	-moz-border-radius: 50px;
	border-radius: 50px;
	-webkit-transition: all .4s ease;
	-moz-transition: all .4s ease;
	-o-transition: all .4s ease;
	-ms-transition: all .4s ease;
	transition: all .4s ease;
	cursor: pointer;
	position: absolute;
	top: 3px;
	left: 3px;
	z-index: 1;
	-webkit-box-shadow: 0px 2px 5px 0px rgba(0, 0, 0, 0.3);
	-moz-box-shadow: 0px 2px 5px 0px rgba(0, 0, 0, 0.3);
	box-shadow: 0px 2px 5px 0px rgba(0, 0, 0, 0.3);
	background: #fcfff4;
	background: -webkit-linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	background: -moz-linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	background: -o-linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	background: -ms-linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	background: linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#fcfff4',
		endColorstr='#b3bead', GradientType=0);
}

.slideThree input[type=checkbox]:checked+label {
	left: 53px;
}

/* ROUNDED ONE */
.roundedOne {
	width: 28px;
	height: 28px;
	background: #fcfff4;
	background: -webkit-linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	background: -moz-linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	background: -o-linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	background: -ms-linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	background: linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#fcfff4',
		endColorstr='#b3bead', GradientType=0);
	margin: 20px auto;
	-webkit-border-radius: 50px;
	-moz-border-radius: 50px;
	border-radius: 50px;
	-webkit-box-shadow: inset 0px 1px 1px white, 0px 1px 3px
		rgba(0, 0, 0, 0.5);
	-moz-box-shadow: inset 0px 1px 1px white, 0px 1px 3px rgba(0, 0, 0, 0.5);
	box-shadow: inset 0px 1px 1px white, 0px 1px 3px rgba(0, 0, 0, 0.5);
	position: relative;
}

.roundedOne label {
	cursor: pointer;
	position: absolute;
	width: 20px;
	height: 20px;
	-webkit-border-radius: 50px;
	-moz-border-radius: 50px;
	border-radius: 50px;
	left: 4px;
	top: 4px;
	-webkit-box-shadow: inset 0px 1px 1px rgba(0, 0, 0, 0.5), 0px 1px 0px
		rgba(255, 255, 255, 1);
	-moz-box-shadow: inset 0px 1px 1px rgba(0, 0, 0, 0.5), 0px 1px 0px
		rgba(255, 255, 255, 1);
	box-shadow: inset 0px 1px 1px rgba(0, 0, 0, 0.5), 0px 1px 0px
		rgba(255, 255, 255, 1);
	background: -webkit-linear-gradient(top, #222 0%, #45484d 100%);
	background: -moz-linear-gradient(top, #222 0%, #45484d 100%);
	background: -o-linear-gradient(top, #222 0%, #45484d 100%);
	background: -ms-linear-gradient(top, #222 0%, #45484d 100%);
	background: linear-gradient(top, #222 0%, #45484d 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#222',
		endColorstr='#45484d', GradientType=0);
}

.roundedOne label:after {
	-ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=0)";
	filter: alpha(opacity = 0);
	opacity: 0;
	content: '';
	position: absolute;
	width: 16px;
	height: 16px;
	background: #00bf00;
	background: -webkit-linear-gradient(top, #00bf00 0%, #009400 100%);
	background: -moz-linear-gradient(top, #00bf00 0%, #009400 100%);
	background: -o-linear-gradient(top, #00bf00 0%, #009400 100%);
	background: -ms-linear-gradient(top, #00bf00 0%, #009400 100%);
	background: linear-gradient(top, #00bf00 0%, #009400 100%);
	-webkit-border-radius: 50px;
	-moz-border-radius: 50px;
	border-radius: 50px;
	top: 2px;
	left: 2px;
	-webkit-box-shadow: inset 0px 1px 1px white, 0px 1px 3px
		rgba(0, 0, 0, 0.5);
	-moz-box-shadow: inset 0px 1px 1px white, 0px 1px 3px rgba(0, 0, 0, 0.5);
	box-shadow: inset 0px 1px 1px white, 0px 1px 3px rgba(0, 0, 0, 0.5);
}

.roundedOne label:hover::after {
	-ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=30)";
	filter: alpha(opacity = 30);
	opacity: 0.3;
}

.roundedOne input[type=checkbox]:checked+label:after {
	-ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=100)";
	filter: alpha(opacity = 100);
	opacity: 1;
}

/* ROUNDED TWO */
.roundedTwo {
	width: 28px;
	height: 28px;
	background: #fcfff4;
	background: -webkit-linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	background: -moz-linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	background: -o-linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	background: -ms-linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	background: linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#fcfff4',
		endColorstr='#b3bead', GradientType=0);
	margin: 20px auto;
	-webkit-border-radius: 50px;
	-moz-border-radius: 50px;
	border-radius: 50px;
	-webkit-box-shadow: inset 0px 1px 1px white, 0px 1px 3px
		rgba(0, 0, 0, 0.5);
	-moz-box-shadow: inset 0px 1px 1px white, 0px 1px 3px rgba(0, 0, 0, 0.5);
	box-shadow: inset 0px 1px 1px white, 0px 1px 3px rgba(0, 0, 0, 0.5);
	position: relative;
}

.roundedTwo label {
	cursor: pointer;
	position: absolute;
	width: 20px;
	height: 20px;
	-webkit-border-radius: 50px;
	-moz-border-radius: 50px;
	border-radius: 50px;
	left: 4px;
	top: 4px;
	-webkit-box-shadow: inset 0px 1px 1px rgba(0, 0, 0, 0.5), 0px 1px 0px
		rgba(255, 255, 255, 1);
	-moz-box-shadow: inset 0px 1px 1px rgba(0, 0, 0, 0.5), 0px 1px 0px
		rgba(255, 255, 255, 1);
	box-shadow: inset 0px 1px 1px rgba(0, 0, 0, 0.5), 0px 1px 0px
		rgba(255, 255, 255, 1);
	background: -webkit-linear-gradient(top, #222 0%, #45484d 100%);
	background: -moz-linear-gradient(top, #222 0%, #45484d 100%);
	background: -o-linear-gradient(top, #222 0%, #45484d 100%);
	background: -ms-linear-gradient(top, #222 0%, #45484d 100%);
	background: linear-gradient(top, #222 0%, #45484d 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#222',
		endColorstr='#45484d', GradientType=0);
}

.roundedTwo label:after {
	-ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=0)";
	filter: alpha(opacity = 0);
	opacity: 0;
	content: '';
	position: absolute;
	width: 9px;
	height: 5px;
	background: transparent;
	top: 5px;
	left: 4px;
	border: 3px solid #fcfff4;
	border-top: none;
	border-right: none;
	-webkit-transform: rotate(-45deg);
	-moz-transform: rotate(-45deg);
	-o-transform: rotate(-45deg);
	-ms-transform: rotate(-45deg);
	transform: rotate(-45deg);
}

.roundedTwo label:hover::after {
	-ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=30)";
	filter: alpha(opacity = 30);
	opacity: 0.3;
}

/* .roundedTwo input[type=checkbox]:checked + label:after {
	-ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=100)";
	filter: alpha(opacity=100);
	opacity: 1;
} */

/* SQUARED ONE */
.squaredOne {
	width: 28px;
	height: 28px;
	background: #fcfff4;
	background: -webkit-linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	background: -moz-linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	background: -o-linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	background: -ms-linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	background: linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#fcfff4',
		endColorstr='#b3bead', GradientType=0);
	margin: 20px auto;
	-webkit-box-shadow: inset 0px 1px 1px white, 0px 1px 3px
		rgba(0, 0, 0, 0.5);
	-moz-box-shadow: inset 0px 1px 1px white, 0px 1px 3px rgba(0, 0, 0, 0.5);
	box-shadow: inset 0px 1px 1px white, 0px 1px 3px rgba(0, 0, 0, 0.5);
	position: relative;
}

.squaredOne label {
	cursor: pointer;
	position: absolute;
	width: 20px;
	height: 20px;
	left: 4px;
	top: 4px;
	-webkit-box-shadow: inset 0px 1px 1px rgba(0, 0, 0, 0.5), 0px 1px 0px
		rgba(255, 255, 255, 1);
	-moz-box-shadow: inset 0px 1px 1px rgba(0, 0, 0, 0.5), 0px 1px 0px
		rgba(255, 255, 255, 1);
	box-shadow: inset 0px 1px 1px rgba(0, 0, 0, 0.5), 0px 1px 0px
		rgba(255, 255, 255, 1);
	background: -webkit-linear-gradient(top, #222 0%, #45484d 100%);
	background: -moz-linear-gradient(top, #222 0%, #45484d 100%);
	background: -o-linear-gradient(top, #222 0%, #45484d 100%);
	background: -ms-linear-gradient(top, #222 0%, #45484d 100%);
	background: linear-gradient(top, #222 0%, #45484d 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#222',
		endColorstr='#45484d', GradientType=0);
}

.squaredOne label:after {
	-ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=0)";
	filter: alpha(opacity = 0);
	opacity: 0;
	content: '';
	position: absolute;
	width: 16px;
	height: 16px;
	background: #00bf00;
	background: -webkit-linear-gradient(top, #00bf00 0%, #009400 100%);
	background: -moz-linear-gradient(top, #00bf00 0%, #009400 100%);
	background: -o-linear-gradient(top, #00bf00 0%, #009400 100%);
	background: -ms-linear-gradient(top, #00bf00 0%, #009400 100%);
	background: linear-gradient(top, #00bf00 0%, #009400 100%);
	top: 2px;
	left: 2px;
	-webkit-box-shadow: inset 0px 1px 1px white, 0px 1px 3px
		rgba(0, 0, 0, 0.5);
	-moz-box-shadow: inset 0px 1px 1px white, 0px 1px 3px rgba(0, 0, 0, 0.5);
	box-shadow: inset 0px 1px 1px white, 0px 1px 3px rgba(0, 0, 0, 0.5);
}

.squaredOne label:hover::after {
	-ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=30)";
	filter: alpha(opacity = 30);
	opacity: 0.3;
}

.squaredOne input[type=checkbox]:checked+label:after {
	-ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=100)";
	filter: alpha(opacity = 100);
	opacity: 1;
}

/* SQUARED TWO */
.squaredTwo {
	width: 28px;
	height: 28px;
	background: #fcfff4;
	background: -webkit-linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	background: -moz-linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	background: -o-linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	background: -ms-linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	background: linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#fcfff4',
		endColorstr='#b3bead', GradientType=0);
	margin: 20px auto;
	-webkit-box-shadow: inset 0px 1px 1px white, 0px 1px 3px
		rgba(0, 0, 0, 0.5);
	-moz-box-shadow: inset 0px 1px 1px white, 0px 1px 3px rgba(0, 0, 0, 0.5);
	box-shadow: inset 0px 1px 1px white, 0px 1px 3px rgba(0, 0, 0, 0.5);
	position: relative;
}

.squaredTwo label {
	cursor: pointer;
	position: absolute;
	width: 20px;
	height: 20px;
	left: 4px;
	top: 4px;
	-webkit-box-shadow: inset 0px 1px 1px rgba(0, 0, 0, 0.5), 0px 1px 0px
		rgba(255, 255, 255, 1);
	-moz-box-shadow: inset 0px 1px 1px rgba(0, 0, 0, 0.5), 0px 1px 0px
		rgba(255, 255, 255, 1);
	box-shadow: inset 0px 1px 1px rgba(0, 0, 0, 0.5), 0px 1px 0px
		rgba(255, 255, 255, 1);
	background: -webkit-linear-gradient(top, #222 0%, #45484d 100%);
	background: -moz-linear-gradient(top, #222 0%, #45484d 100%);
	background: -o-linear-gradient(top, #222 0%, #45484d 100%);
	background: -ms-linear-gradient(top, #222 0%, #45484d 100%);
	background: linear-gradient(top, #222 0%, #45484d 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#222',
		endColorstr='#45484d', GradientType=0);
}

.squaredTwo label:after {
	-ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=0)";
	filter: alpha(opacity = 0);
	opacity: 0;
	content: '';
	position: absolute;
	width: 9px;
	height: 5px;
	background: transparent;
	top: 4px;
	left: 4px;
	border: 3px solid #fcfff4;
	border-top: none;
	border-right: none;
	-webkit-transform: rotate(-45deg);
	-moz-transform: rotate(-45deg);
	-o-transform: rotate(-45deg);
	-ms-transform: rotate(-45deg);
	transform: rotate(-45deg);
}

.squaredTwo label:hover::after {
	-ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=30)";
	filter: alpha(opacity = 30);
	opacity: 0.3;
}

.squaredTwo input[type=checkbox]:checked+label:after {
	-ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=100)";
	filter: alpha(opacity = 100);
	opacity: 1;
}

/* SQUARED THREE */
.squaredThree {
	width: 20px;
	margin: 20px auto;
	position: relative;
}

.squaredThree label {
	cursor: pointer;
	position: absolute;
	width: 20px;
	height: 20px;
	top: 0;
	border-radius: 4px;
	-webkit-box-shadow: inset 0px 1px 1px rgba(0, 0, 0, 0.5), 0px 1px 0px
		rgba(255, 255, 255, .4);
	-moz-box-shadow: inset 0px 1px 1px rgba(0, 0, 0, 0.5), 0px 1px 0px
		rgba(255, 255, 255, .4);
	box-shadow: inset 0px 1px 1px rgba(0, 0, 0, 0.5), 0px 1px 0px
		rgba(255, 255, 255, .4);
	background: -webkit-linear-gradient(top, #222 0%, #45484d 100%);
	background: -moz-linear-gradient(top, #222 0%, #45484d 100%);
	background: -o-linear-gradient(top, #222 0%, #45484d 100%);
	background: -ms-linear-gradient(top, #222 0%, #45484d 100%);
	background: linear-gradient(top, #222 0%, #45484d 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#222',
		endColorstr='#45484d', GradientType=0);
}

.squaredThree label:after {
	-ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=0)";
	filter: alpha(opacity = 0);
	opacity: 0;
	content: '';
	position: absolute;
	width: 9px;
	height: 5px;
	background: transparent;
	top: 4px;
	left: 4px;
	border: 3px solid #fcfff4;
	border-top: none;
	border-right: none;
	-webkit-transform: rotate(-45deg);
	-moz-transform: rotate(-45deg);
	-o-transform: rotate(-45deg);
	-ms-transform: rotate(-45deg);
	transform: rotate(-45deg);
}

.squaredThree label:hover::after {
	-ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=30)";
	filter: alpha(opacity = 30);
	opacity: 0.3;
}

.squaredThree input[type=checkbox]:checked+label:after {
	-ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=100)";
	filter: alpha(opacity = 100);
	opacity: 1;
}

/* SQUARED FOUR */
.squaredFour {
	width: 20px;
	margin: 20px auto;
	position: relative;
}

.squaredFour label {
	cursor: pointer;
	position: absolute;
	width: 20px;
	height: 20px;
	top: 0;
	border-radius: 4px;
	-webkit-box-shadow: inset 0px 1px 1px white, 0px 1px 3px
		rgba(0, 0, 0, 0.5);
	-moz-box-shadow: inset 0px 1px 1px white, 0px 1px 3px rgba(0, 0, 0, 0.5);
	box-shadow: inset 0px 1px 1px white, 0px 1px 3px rgba(0, 0, 0, 0.5);
	background: #fcfff4;
	background: -webkit-linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	background: -moz-linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	background: -o-linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	background: -ms-linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	background: linear-gradient(top, #fcfff4 0%, #dfe5d7 40%, #b3bead 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#fcfff4',
		endColorstr='#b3bead', GradientType=0);
}

.squaredFour label:after {
	-ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=0)";
	filter: alpha(opacity = 0);
	opacity: 0;
	content: '';
	position: absolute;
	width: 9px;
	height: 5px;
	background: transparent;
	top: 4px;
	left: 4px;
	border: 3px solid #333;
	border-top: none;
	border-right: none;
	-webkit-transform: rotate(-45deg);
	-moz-transform: rotate(-45deg);
	-o-transform: rotate(-45deg);
	-ms-transform: rotate(-45deg);
	transform: rotate(-45deg);
}

.squaredFour label:hover::after {
	-ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=30)";
	filter: alpha(opacity = 30);
	opacity: 0.5;
}

.squaredFour input[type=checkbox]:checked+label:after {
	-ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=100)";
	filter: alpha(opacity = 100);
	opacity: 1;
}
</style>
</head>
<body>

	<!-- <div class="container well">
		<div class="row">
			<div class="col-md-6">
				<h2>Time Picker</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="form-control-wrapper">
					<input type="text" id="time" class="form-control floating-label"
						placeholder="Time">
				</div>
			</div>
			<div class="col-md-6">
		
		</div>
	</div>
 -->


	<!-- <script type="text/javascript">
		$(document).ready(function() {

			$('#time').bootstrapMaterialDatePicker({
				date : false,
				shortTime : false,
				format : 'HH:mm'
			});

			$.material.init()
		});
	</script> -->
	<div class="container">
		<div class="row">
			<div class='col-sm-6'>
				<div class="form-group">
					<div class='input-group date' id='datetimepicker3'>
						<input type='text' class="form-control" /> <span
							class="input-group-addon"> <span
							class="glyphicon glyphicon-time"></span>
						</span>
					</div>
				</div>
			</div>
			<script type="text/javascript">
				$(function() {
					$('#datetimepicker3').datetimepicker({
						format : 'LT'
					});
				});
			</script>
		</div>
	</div>
</body>
</html>
