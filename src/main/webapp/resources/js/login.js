/**
 * 
 */
function setFocus() {
	document.getElementById("userName").focus();
}

function submitenter(myfield, e) {
	var keycode;
	if (window.event)
		keycode = window.event.keyCode;
	else if (e)
		keycode = e.which;
	else
		return true;

	return true;
}
function getdata() {
//	alert('Invoking getdata() ...!');
	var userName = $("#userName").val();
	var userPassword = $("#userPassword").val();
	if (userName == '' || userPassword == '') {
		$("#error").show();
		$('#error').html(
		"<font color='red'><b>Enter ur cradentials</b></font>");
//		return false;
	}
	return invokeTargetAction(userName,userPassword);
	//return invokeTargetAction(userName,userPassword);
//	return true;
}
function createJSONData(userName,userPwd){
//	var jsonData={};
	var jsonData={
			'userName':userName,
			'userPassword':userPwd
	};
	return JSON.stringify(jsonData);;
}

function invokeTargetAction(userName,userPassword) {
	//alert('Invoking invokeTargetAction(): userName:--> '+userName+', userPassword:--> '+userPassword);
	var jsonData='';
	debugger;
	jsonData=createJSONData(userName,userPassword);
	if(userName=="adminstrator"){
		document.loginForm.action = "http://192.168.0.108:8080/UCCXCampaignManager/Outbound/dashboard";
	}
	else
		document.loginForm.action = "http://192.168.0.108:8080/UCCXCampaignManager/Outbound/login";
	document.loginForm.submit();             // Submit the page
	return true;
	/*$
	.ajax({
		type : 'POST',
		url : 'http://192.168.0.101:8080/UCCXVerS3/Outbound/dashboard',
		data:jsonData,
		contentType : 'application/json',
		dataType : 'text',
		success : function(resp) {
			var xmlToJsonText = JSON
			.stringify(resp);
			xmlToJsonText=xmlToJsonText.replace(/['"]+/g, '');
//			var someStr = 'He said "Hello, my name is Foo"';
			console.log(xmlToJsonText.replace(/['"]+/g, ''));
			alert('xmlToJsonText :--> '+xmlToJsonText );
			if(xmlToJsonText=='dashboard'){
				debugger;
				document.loginForm.action = "http://google.co.in";
			}
			else{
				document.loginForm.action = "http://192.168.0.101:8080/UCCXVerS3/Outbound/login";
				//return false;
			}
			alert('document.loginForm.action'+document.loginForm.action);
			document.loginForm.submit();             // Submit the page
			return true;
		},
		error : function(req, status, err) {
			alert('Failure Error :--> ' + err
					+ ', status:--> ' + status);
			return false;
		}
	});*/
}