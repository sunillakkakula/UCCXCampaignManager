var gblCampaignId,gblCampaignName,gblCampaignType,gblEnabled,gblDescription,gblStartTime,gblEndTime,gblCampaignType,gblDialerType,gblPendingContacts,gblCampaignCallingNum,gblTriggerName,gblMaxDialAttempts,gblCurrentTime;
var xmlToJson ;
var gblCampaignDetails={};
var validCSQArray=[];
var currentTime=undefined;

function getCurrentTime(){
	debugger;
	var currentdate = new Date();
	var hrs= String(currentdate.getHours());
	var mints= String(currentdate.getMinutes());
	console.log('Length of Hrs: '+hrs.length);
	if(hrs.length==1){
		console.log('Length of Hrs: '+hrs.length);
		hrs='0'+hrs;
	}
	console.log('Length of mints: '+mints.length);
	if(mints.length==1){
		console.log('Length of mints: '+mints.length);
		mints='0'+mints;
	}

	gblCurrentTime=hrs + ":"+ mints ;
	console.log('currentTime :'+gblCurrentTime);
	return gblCurrentTime;
}

function populateCSQList(){
	debugger;
	var $select = $('select#csqValues');
	$select.html('');
	var csqList='';
	var csqNameIdPairList='';
	var csqNameIdPair;
	if(validCSQArray.length>0){
		for (var i = 0; i < validCSQArray.length; i++){
			csqNameIdPair=	validCSQArray[i].split(':');
			csqNameIdPairList += '<option value=' + csqNameIdPair[0]+ '">' + csqNameIdPair[1]+ '</option>';
		}
		$("select#csqValues").html(csqNameIdPairList);	
	} 
}

function filterQuotes(text){
	var ret = "";

	if ( /"/.test( text ) ){
		ret = text.match( /"(.*?)"/ )[1];
	} else {
		ret = "";
	}
	return ret;
}
xmlToJson = function(xml) {
	var obj = {};
	if (xml.nodeType == 1) {
		if (xml.attributes.length > 0) {
			obj["@attributes"] = {};
			for (var j = 0; j < xml.attributes.length; j++) {
				var attribute = xml.attributes.item(j);
				obj["@attributes"][attribute.nodeName] = attribute.nodeValue;
			}
		}
	} else if (xml.nodeType == 3) {
		obj = xml.nodeValue;
	}
	if (xml.hasChildNodes()) {
		for (var i = 0; i < xml.childNodes.length; i++) {
			var item = xml.childNodes.item(i);
			var nodeName = item.nodeName;
			if (typeof (obj[nodeName]) == "undefined") {
				obj[nodeName] = xmlToJson(item);
			} else {
				if (typeof (obj[nodeName].push) == "undefined") {
					var old = obj[nodeName];
					obj[nodeName] = [];
					obj[nodeName].push(old);
				}
				obj[nodeName].push(xmlToJson(item));
			}
		}
	}
	return obj;
}

//Changes XML to JSON
function convertXMLToJSONContent(xml) {
	debugger;
	// Create the return object
	var obj = {};

	if (xml.nodeType == 1) { // element
		// do attributes
		if (xml.attributes.length > 0) {
			obj["@attributes"] = {};
			for (var j = 0; j < xml.attributes.length; j++) {
				var attribute = xml.attributes.item(j);
				obj["@attributes"][attribute.nodeName] = attribute.nodeValue;
			}
		}
	} else if (xml.nodeType == 3) { // text
		obj = xml.nodeValue;
	}

	// do children
	if (xml.hasChildNodes()) {
		for(var i = 0; i < xml.childNodes.length; i++) {
			var item = xml.childNodes.item(i);
			var nodeName = item.nodeName;
			if (typeof(obj[nodeName]) == "undefined") {
				obj[nodeName] = xmlToJson(item);
			} else {
				if (typeof(obj[nodeName].push) == "undefined") {
					var old = obj[nodeName];
					obj[nodeName] = [];
					obj[nodeName].push(old);
				}
				obj[nodeName].push(xmlToJson(item));
			}
		}
	}
	return obj;
};
function loadInitialState(){
	debugger;
	$('#campaignTypeOption').val(gblCampaignDetails['campaignType']);
	$('#dialerTypeOption').val(gblCampaignDetails['dialerType']);
	$('#cmn-toggle-3').val(gblCampaignDetails['enabled']);
	$('#startTime').val(gblCampaignDetails['startTime']);
	$('#endTime').val(gblCampaignDetails['endTime']);
	$('#maxDialAttempts').val(gblCampaignDetails['maxDialAttempts']);
	$('.ansMachineRetry:checked').val(gblCampaignDetails['ansMachineRetry']);
	$('#missedCallbackOption').val(gblCampaignDetails['missedCallback']);
//	$("[name=myRadio]").val(["myValue"]);
	$("#cmn-toggle-3").prop("checked", gblCampaignDetails['enabled']);
//	$('#dimension-switch').bootstrapSwitch('setSizeClass', 'switch-small');
	// Enables animation for the selected item
//	$('#animated-switch').bootstrapSwitch('setAnimated', true);
	// Disables animation for the selected item
//	$('#animated-switch').bootstrapSwitch('setAnimated', false);
	/*$('input:radio[name=enabled]:checked').val();
	$('#dialerTypeOption option:selected').val();
	$(startTime).val();
	$(endTime).val();
	$(maxDialAttempts).val();
	debugger;
	$('#missedCallbackOption option:selected').val()
	$('.ansMachineRetry:checked').val();
	$('#csqValues option:selected').val()*/
}
function parsingCSQJSONList(csqlistJSON){
	debugger;
	var assignedCSQArray,startTime,JSONObj;
	var csqs = csqlistJSON.csqs;
	var csqArray = csqs.csq;
	
	/*
	 * 
	var csqArray=assignedCsqs.csq;
	var baseURL='http://10.1.53.198/adminapi/csq/';
	var baseURLLength=baseURL.length;
	var refURL;
	 */
	
	console.log('csqArray  Length '+csqArray.length);
	var csqID,csqName;
	for (var i=0; i<csqArray.length; i++){
		csqID=csqArray[i].id["#text"];
		csqName=csqArray[i].name["#text"];
		console.log("csqArray[i] : "+csqID+" ,  csqName:"+csqName);
		validCSQArray[i]=csqID+':'+csqName;
	}
	
	return validCSQArray;
}
function populateCampaignJSON(eachCampaign){
//	debugger;
	var campaignNameVal;
	campaignNameVal = eachCampaign.campaignName['#text'];
//	debugger;
	console.log('campaignNameVal '+campaignNameVal );
	var campaignIdVal = eachCampaign.campaignId["#text"];
	var campaignTypeVal= eachCampaign.campaignType["#text"];
	var dialerTypeVal= eachCampaign.dialerType["#text"];
	var pendingContactsVal= eachCampaign.pendingContacts["#text"];
	var enabledVal= eachCampaign.enabled["#text"];
	var startTimeVal= eachCampaign.startTime["#text"];
	var endTimeVal= eachCampaign.endTime["#text"];
	var descriptionVal= eachCampaign.description["#text"];
//	gblCampaignId,gblCampaignName,gblCampaignType,gblEnabled,gblDescription,gblStartTime,gblEndTime,gblCampaignType,gblDialerType,gblPendingContacts,gblCampaignCallingNum,gblTriggerName,gblMaxDialAttempts;

	gblCampaignDetails['campaignName'] = campaignNameVal;
	gblCampaignDetails['campaignId'] = campaignIdVal;
	gblCampaignDetails['campaignType'] = campaignTypeVal;
	gblCampaignDetails['dialerType'] = dialerTypeVal;
	gblCampaignDetails['description'] = dialerTypeVal;
	gblCampaignDetails['pendingContacts'] = pendingContactsVal;
	gblCampaignDetails['enabled'] = enabledVal;
	gblCampaignDetails['startTime'] = startTimeVal;
	gblCampaignDetails['endTime'] = endTimeVal;
	return gblCampaignDetails;
}

$(document)
.ready(
		function() {
			debugger;
			var campaignId= getParameterByName('campaignId');
			gblCampaignId=campaignId;
			$("#wait").css("display", "block");
			$
			.ajax({
				type : 'GET',
				url : 'http://10.1.53.198/adminapi/campaign/'+campaignId,
				headers : {
					'username' : 'administrator',
					'password' : 'Sp33chs0ft',
					'Authorization' : 'Basic YWRtaW5pc3RyYXRvcjpTcDMzY2hzMGZ0',
					'contentType' : 'text/xml'
				},
				success : function(resp) {
//					debugger;
					var xmlToJsonText = JSON
					.stringify(xmlToJson(resp));
//					console.log('xmlToJsonText : --> '+xmlToJsonText );
					var eachCampaign = jQuery
					.parseJSON(xmlToJsonText);
//					console.log('eachCampaign  : --> '+eachCampaign );
//					debugger;
					var campaignData =eachCampaign.campaign;
//					console.log('campaignData: --> '+campaignData);
					populateCampaignJSON(campaignData);
//					gblCampaignDetails=populateCampaignJSON(campaignData);
					debugger;
//					console.log('campaignDetails: --> campaignId:--> '+campaignDetails['campaignId']+",campaignName :-->"+campaignDetails['campaignName']);
					loadInitialState();
					$("#wait").css("display", "none");
				},
				error : function(req, status, err) {
//					debugger;
					alert('Failure Error :--> ' + err
							+ ', status:--> ' + status);
					$("#wait").css("display", "none");
				}
			});
		}
);

function populateCSQNamesList(validCSQArray){
	$
	.ajax({
		type : 'GET',
		url : 'http://10.1.53.198/adminapi/generalobconfig',
		headers : {
			'username' : 'administrator',
			'password' : 'Sp33chs0ft',
			'Authorization' : 'Basic YWRtaW5pc3RyYXRvcjpTcDMzY2hzMGZ0',
			'contentType' : 'application/xml'
		},
		success : function(resp) {
			debugger;
			var xmlToJsonText = JSON
			.stringify(convertXMLToJSONContent(resp));
			//var jsonText=xmlToJsonText .substring(2, xmlToJsonText .length);					
			var csqList = jQuery
			.parseJSON(xmlToJsonText);
			debugger;
			console.log('csqList  '+csqList );
			validCSQArray=parsingCSQJSONList(csqList );
			populateCSQNamesList(validCSQArray);
			populateCSQList(validCSQArray);
			$("#wait").css("display", "none");
		},
		error : function(req, status, err) {
			debugger;
			alert('Failure Error :--> ' + err
					+ ', status:--> ' + status);
			$("#wait").css("display", "none");
		}
	});
}
$(document)
.ready(
		function() {/*
		TESTING FOR CSQ NAMES ,CSQ ID'S
		
			$
			.ajax({
				type : 'GET',
				url : 'http://10.1.53.198/adminapi/generalobconfig',
				headers : {
					'username' : 'administrator',
					'password' : 'Sp33chs0ft',
					'Authorization' : 'Basic YWRtaW5pc3RyYXRvcjpTcDMzY2hzMGZ0',
					'contentType' : 'application/xml'
				},
				success : function(resp) {
					debugger;
					var xmlToJsonText = JSON
					.stringify(convertXMLToJSONContent(resp));
					//var jsonText=xmlToJsonText .substring(2, xmlToJsonText .length);					
					var csqList = jQuery
					.parseJSON(xmlToJsonText);
					debugger;
					console.log('csqList  '+csqList );
					validCSQArray=parsingCSQJSONList(csqList );
					populateCSQNamesList(validCSQArray);
					populateCSQList(validCSQArray);
					$("#wait").css("display", "none");
				},
				error : function(req, status, err) {
					debugger;
					alert('Failure Error :--> ' + err
							+ ', status:--> ' + status);
					$("#wait").css("display", "none");
				}
			});
		*/
			$
			.ajax({
				type : 'GET',
				url : 'http://10.1.53.198/adminapi/csq',
				headers : {
					'username' : 'administrator',
					'password' : 'Sp33chs0ft',
					'Authorization' : 'Basic YWRtaW5pc3RyYXRvcjpTcDMzY2hzMGZ0',
					'contentType' : 'application/xml'
				},
				success : function(resp) {
					debugger;
					var xmlToJsonText = JSON
					.stringify(convertXMLToJSONContent(resp));
					//var jsonText=xmlToJsonText .substring(2, xmlToJsonText .length);					
					var csqList = jQuery
					.parseJSON(xmlToJsonText);
					debugger;
					console.log('csqList  '+csqList );
					validCSQArray=parsingCSQJSONList(csqList );
			/*		populateCSQNamesList(validCSQArray);*/
					populateCSQList(validCSQArray);
					$("#wait").css("display", "none");
				},
				error : function(req, status, err) {
					debugger;
					alert('Failure Error :--> ' + err
							+ ', status:--> ' + status);
					$("#wait").css("display", "none");
				}
			});
	
		}
);

function prepareXML(campDetails){

//	debugger;
	var campType,dialerType,xmlContent,campId;
	campType= campDetails.campaignType;
	dialerType=campDetails.dialerType;
	console.log('campDetails.campaignType:'+campType+',dialerType: '+dialerType);
	if(dialerType=='PROGRESSIVE'){
		xmlContent=prepareProgessiveXML(campDetails);
	}
	else if(dialerType=='PREDICTIVE'){
		xmlContent=preparePredictiveXML(campDetails);
	}
	else if(dialerType	=='DIRECT_PREVIEW'){
		xmlContent=prepareDirectPreviewXML(campDetails);
	}
	if(xmlContent!=undefined){
//		debugger;
		$.ajax({
			type : 'PUT',
			url : 'http://10.1.53.198/adminapi/campaign/'+gblCampaignId,
			data : xmlContent,
			contentType : 'text/xml',
			dataType : 'text',
			headers : {
				'username' : 'administrator',
				'password' : 'Sp33chs0ft',
				'Authorization' : 'Basic YWRtaW5pc3RyYXRvcjpTcDMzY2hzMGZ0'

			},
			success : function(resp) {
				alert('Successfully Modified.!');
			},
			error : function(req, status, err) {
				debugger;
				alert('Failure Error :--> ' + err + ', status:--> ' + status);
			}
		});		
	}
}
function convertStringToBoolean(string){
	switch(string.toLowerCase().trim()){
	case "true": case "yes": case "1": return true;
	case "false": case "no": case "0": case null: return false;
	default: return Boolean(string);
	}
}
function prepareProgessiveXML(campaignObj){
	var campaignID,campaignName,campaignType,enabled,description,startTime,endTime,campaignType,dialerType,pendingContacts,campaignCallingNum,triggerName,maxDialAttempts;
	/*campaignID=campaignObj.campaignId;
	campaignName=campaignObj.campaignName;*/
	campaignID=gblCampaignDetails.campaignId;
	campaignName=gblCampaignDetails.campaignName;

	enabled=campaignObj.enabled;
	var enabledBoolVal=convertStringToBoolean(enabled);
//	description=campaignObj.description;
	description=gblCampaignDetails.description;

	startTime=campaignObj.startTime;
	endTime=campaignObj.endTime;
	campaignType=campaignObj.campaignType;
	dialerType=campaignObj.dialerType;
//	pendingContacts=campaignObj.pendingContacts;
	pendingContacts=gblCampaignDetails.pendingContacts;
	//campaignCallingNum=campDetails.campaignCallingNum;
//	triggerName=campaignObj.triggerName;
	triggerName=gblCampaignDetails.triggerName;
	maxDialAttempts=campaignObj.maxDialAttempts;


	var entireXmlContent= "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
	"<campaign>\n"+
	"<self>https://uccx-server/adminapi/campaign/"+campaignID+"</self>\n"+
	"<campaignId>"+campaignID+"</campaignId>\n"+	
	"<campaignName>"+campaignName+"</campaignName>\n"+
	"<enabled>true</enabled>\n"+
	"<description>"+description+"</description>\n"+
	"<startTime>"+startTime+"</startTime>\n"+
	"<endTime>"+endTime+"</endTime>\n"+
	"<timeZone>India Standard Time</timeZone>\n"+
	"<campaignType>"+campaignType+"</campaignType>\n"+
	"<dialerType>"+dialerType+"</dialerType>\n"+
	"<pendingContacts>"+pendingContacts+"</pendingContacts>\n"+
	"<typeSpecificInfo>	<obIvrProgressive>\n"+
	"<campaignCallingNum>12345</campaignCallingNum>\n"+
	"<applicationTrigger name=\"5657656\">\n"+
	"<refURL>https://uccx-server/adminapi/trigger/5657656</refURL>\n"+
	"</applicationTrigger>\n"+
	"<maxDialAttempts>"+maxDialAttempts+"</maxDialAttempts>\n"+
	"<callbackTimeLimit>15</callbackTimeLimit>\n"+
	"<numDedicatedPorts>0</numDedicatedPorts>\n"+
	"<linesPerPort>1.0</linesPerPort>\n"+
	"<treatLowVolAsVoice>true</treatLowVolAsVoice>\n"+
	"<ansMachineTreatment>TRANSFER_TO_IVR</ansMachineTreatment>\n"+
	"<noAnswerRingLimit>15</noAnswerRingLimit>\n"+
	"<abandonedCallWaitTime>2</abandonedCallWaitTime>\n"+
	"<retryNoAnswerDelay>60</retryNoAnswerDelay>\n" +
	"<retryBusySignalDelay>60</retryBusySignalDelay>\n"+
	"<retryCustAbandonedDelay>30</retryCustAbandonedDelay>\n" +
	"<retryDialerAbandonedDelay>60</retryDialerAbandonedDelay>\n" +
	"</obIvrProgressive>\n" +
	"</typeSpecificInfo>\n" +
	"</campaign>";
	return entireXmlContent;

}

function preparePredictiveXML(campaignObj){
	console.log('From preparePredictiveXML');
	debugger;
	var campaignID,campaignName,campaignType,enabled,description,startTime,endTime,campaignType,dialerType,pendingContacts,campaignCallingNum,triggerName,maxDialAttempts;

	/*campaignID=campaignObj.campaignId;
	campaignName=campaignObj.campaignName;*/
	campaignID=gblCampaignDetails.campaignId;
	campaignName=gblCampaignDetails.campaignName;

	enabled=campaignObj.enabled;
//	description=campaignObj.description;
	description=gblCampaignDetails.description;

	startTime=campaignObj.startTime;
	endTime=campaignObj.endTime;
	campaignType=campaignObj.campaignType;
	dialerType=campaignObj.dialerType;
//	pendingContacts=campaignObj.pendingContacts;
	pendingContacts=gblCampaignDetails.pendingContacts;

	maxDialAttempts=campaignObj.maxDialAttempts;
	debugger;
	var entireXmlContent= "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
	"<campaign>\n"+
	"<self>https://uccx-server/adminapi/campaign/"+campaignID+"</self>\n"+
	"<campaignId>"+campaignID+"</campaignId>\n"+	
	"<campaignName>"+campaignName+"</campaignName>\n"+
	"<enabled>true</enabled>\n"+
	"<description>"+description+"</description>\n"+
	"<startTime>"+startTime+"</startTime>\n"+
	"<endTime>"+endTime+"</endTime>\n"+
	"<timeZone>India Standard Time</timeZone>\n"+
	"<campaignType>"+campaignType+"</campaignType>\n"+
	"<dialerType>"+dialerType+"</dialerType>\n"+
	"<pendingContacts>"+pendingContacts+"</pendingContacts>\n"+
	"<typeSpecificInfo>\n" +
	"<obIvrPredictive>\n" +
	"<campaignCallingNum>112233</campaignCallingNum>\n" +
	"<applicationTrigger name=\"464355\">\n" +
	"<refURL>https://uccx-server/adminapi/trigger/464355</refURL>\n" +
	"</applicationTrigger>\n"+
	"<maxDialAttempts>"+maxDialAttempts+"</maxDialAttempts>\n" +
	"<callbackTimeLimit>15</callbackTimeLimit>\n" +
	"<numDedicatedPorts>0</numDedicatedPorts>\n" +
	"<linesPerPort>1.5</linesPerPort>\n" +
	"<treatLowVolAsVoice>true</treatLowVolAsVoice>\n"+
	"<ansMachineTreatment>TRANSFER_TO_IVR</ansMachineTreatment>\n" +
	"<noAnswerRingLimit>15</noAnswerRingLimit>\n" +
	"<abandonedCallWaitTime>2</abandonedCallWaitTime>\n" +
	"<retryNoAnswerDelay>60</retryNoAnswerDelay>\n"+
	"<retryBusySignalDelay>60</retryBusySignalDelay>\n" +
	"<retryCustAbandonedDelay>30</retryCustAbandonedDelay>\n" +
	"<retryDialerAbandonedDelay>60</retryDialerAbandonedDelay>\n"+
	"<maxLinesPerPort>3.0</maxLinesPerPort>\n" +
	"<predictiveCorrectionPace>100</predictiveCorrectionPace>\n" +
	"<predictiveGain>1.0</predictiveGain>\n" +
	"<callAbandonLimit>3.0</callAbandonLimit>\n"+
	"</obIvrPredictive>\n" +
	"</typeSpecificInfo>\n" +
	"</campaign>";
	return entireXmlContent;

}

function prepareDirectPreviewXML(campaignObj){
	debugger;
	console.log('From prepareDirectPreviewXML');
	var campaignID,campaignName,campaignType,enabled,description,startTime,endTime,campaignType,dialerType,pendingContacts,campaignCallingNum,triggerName,maxDialAttempts,ansMachineRetry,missedCallbackAction,csq,txfCSQ,remCSQ;
	campaignID=campaignObj.campaignId;
	campaignName=gblCampaignDetails.campaignName;
	enabled=campaignObj.enabled;
	description=gblCampaignDetails.description;
	startTime=campaignObj.startTime;
	endTime=campaignObj.endTime;
	campaignType=campaignObj.campaignType;
	dialerType=campaignObj.dialerType;
	pendingContacts=gblCampaignDetails.pendingContacts;
	maxDialAttempts=campaignObj.maxDialAttempts;
	ansMachineRetry=campaignObj.ansMachineRetry;
	missedCallbackAction=campaignObj.missedCallback;
	csq=campaignObj.csq;
	remCSQ=csq.substring(0,csq.length-1);
//	csq="\""+csq;
	txfCSQ="\""+csq;
	var entireXmlContent= "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
	"<campaign>\n"+
	"<self>http://10.1.53.198/adminapi/campaign/"+campaignID+"</self>\n"+
	"<campaignId>"+campaignID+"</campaignId>\n"+	
	"<campaignName>"+campaignName+"</campaignName>\n"+
	"<enabled>true</enabled>\n"+
	"<description>"+description+"</description>\n"+
	"<startTime>"+startTime+"</startTime>\n"+
	"<endTime>"+endTime+"</endTime>\n"+
	"<timeZone>India Standard Time</timeZone>\n"+
	"<campaignType>"+campaignType+"</campaignType>\n"+
	"<dialerType>"+dialerType+"</dialerType>\n"+
	"<pendingContacts>"+pendingContacts+"</pendingContacts>\n"+
	"<typeSpecificInfo>\n" +
	"<obPreview>\n" +
	"<maxDialAttempts>"+maxDialAttempts+"</maxDialAttempts>\n" +
	"<cacheSize>20</cacheSize>\n" +
	"<ansMachineRetry>true</ansMachineRetry>\n"+
	"<callbackTimeLimit>15</callbackTimeLimit>\n" +
	"<missedCallbackAction>"+missedCallbackAction+"</missedCallbackAction>\n" +
	"<assignedCSQs>\n" +
	"<csq name="+txfCSQ+">\n" +
	"<refURL>http://10.1.53.198/adminapi/csq/"+remCSQ+"</refURL>\n" +
	"</csq>\n"+
	"</assignedCSQs>\n" +
	"</obPreview>\n" +
	"</typeSpecificInfo>\n" +
	"</campaign>";
	return entireXmlContent;
}
function validateByStartTimeRules(campaignObject){
//	var currentTime=currentTime();
	var tempCampaignId = campaignObject['campaignId'];
	var tempCampaignName = campaignObject['campaignName'];
	var tempDescription= campaignObject['Description'];
	var tempCampaignType= campaignObject['campaignType'];
	var tempEnabledStatus= campaignObject['enabledStatus'];
	var tempDialerType = campaignObject['dialerType'];
	var tempStartTime= campaignObject['startTime'];
	var tempEndTime= campaignObject['endTime'];
	var tempPendingContactsId = campaignObject['pendingContacts'];
	var tempAnsMachineretry = campaignObject['ansMachineretry'];
	var tempMaxDialAttempts = campaignObject['maxDialAttempts'];
	var tempMissedCallback = campaignObject['missedCallback'];
	var tempCsq = campaignObject['csq'];
	gblCurrentTime= getCurrentTime();
	var currTimeArray=gblCurrentTime.split();
	/*
	var startTimeArray=tempStartTime.split();
	var endTimeArray=tempEndTime.split();
	 */
	console.log('Current Time: --> '+gblCurrentTime+', Start Time :-->'+tempStartTime+', End Time :--> '+tempEndTime);
	if(!isStartTimeAfterEndTime(tempStartTime, tempEndTime)){
		if(!isStartTimePriorCurrentTime(tempStartTime, gblCurrentTime)){
			alert('Yes Start Time is Prior to Current Time');
			console.log('Yes Start Time is Prior to Current Time');
			return false;
		}
		else {
//			alert('Start Time cant be Prior to Current Time');
			console.log('Start Time is not Prior to Current Time');
			return true;
		}
	}else {
//		alert('Start Time cant be After End Time');
		console.log('Start Time cant be After End Time');
		return false;
	}
}

function isStartTimeAfterEndTime(tempStartTime,tempEndTime){
	debugger;
	var startTimeArray=tempStartTime.split(':');
	var endTimeArray=tempEndTime.split(':');

	if(startTimeArray[0]<endTimeArray[0]){
		return false;
	}else if(startTimeArray[0]==endTimeArray[0]){
		if(startTimeArray[1]<endTimeArray[1]){
			return false;
		}else if(startTimeArray[1]==endTimeArray[1]){
			alert ('Start Time and End Time cant be the Same..!');
			console.log('Start Time and End Time cant be the Same..!');
			return false;
		}else if(startTimeArray[0]>endTimeArray[0]){
			return true;
		}
		return false;
	}else if(startTimeArray[0]>endTimeArray[0]){
		return true;
	}

}

function isStartTimePriorCurrentTime(tstartTime,gblCurrentTime){
	var startTimeArray=tstartTime.split();
	var currentTimeArray=gblCurrentTime.split();
	debugger;

	if(startTimeArray[0]<currentTimeArray[0]){
		return false;
	}else if(startTimeArray[0]==currentTimeArray[0]){
		if(startTimeArray[1]<currentTimeArray[1]){
			return false;
		}else if(startTimeArray[1]==currentTimeArray[1]){
			alert ('Start Time and currentTime cant be the Same..!');
			console.log('Start Time and currentTime cant be the Same..!');
			return false;
		}else if(startTimeArray[0]>currentTimeArray[0]){
			return true;
		}
		return false;
	}else if(startTimeArray[0]>currentTimeArray[0]){
		return true;
	}
}

function saveCampaign(){
	var campaignObject={};
	var campainTypeSelected;
	var enabledStatus;
	var dialerTypeOptionSelected;
	var startTimeSelected;
	var endTimeSelected;
	var maxDialAttemptsValue;
	var missedCallbackValue;
	var csqSelected;
	debugger;

	campainTypeSelected=$('#campaignTypeOption option:selected').val()
	enabledStatus=		$('input:radio[name=enabled]:checked').val();
	dialerTypeOptionSelected= $('#dialerTypeOption option:selected').val();
	startTimeSelected=$(startTime).val();
	endTimeSelected=$(endTime).val();
	maxDialAttemptsValue =$(maxDialAttempts).val();
	debugger;
	missedCallbackValue=$('#missedCallbackOption option:selected').val()
	ansMachineretry =$('.ansMachineRetry:checked').val();
	csqSelected=$('#csqValues option:selected').val()

	campaignObject['campaignId']=gblCampaignId;
	campaignObject['campaignName']=gblCampaignName;
	campaignObject['Description']=gblDescription;
	campaignObject['campaignType']=campainTypeSelected;
	campaignObject['enabledStatus']=enabledStatus;
	campaignObject['dialerType']=dialerTypeOptionSelected;
	campaignObject['startTime']=startTimeSelected;
	campaignObject['endTime']=endTimeSelected;
	campaignObject['pendingContacts']=gblPendingContacts;
	campaignObject['ansMachineretry']=ansMachineretry;
	campaignObject['maxDialAttempts']=maxDialAttemptsValue;
	campaignObject['missedCallback']=missedCallbackValue;
	campaignObject['csq']=csqSelected;

	if(validateByStartTimeRules(campaignObject)){
		debugger;
		console.log('CampainType : '+campaignObject.campaignType+', enabledStatus : '+campaignObject.enabledStatus+', dialerTypeOptionSelected: '+campaignObject.dialerType+', StartTime '+campaignObject.startTime+', endTimeSelected'+campaignObject.endTime+', maxDialAttemptsValue : '+campaignObject.maxDialAttempts );
		debugger;
//		var txfData = prepareXML(campaignObject);// Old Version
		prepareXML(campaignObject);

	}else{
		return false;
	}
	/*debugger;
	console.log('CampainType : '+campaignObject.campaignType+', enabledStatus : '+campaignObject.enabledStatus+', dialerTypeOptionSelected: '+campaignObject.dialerType+', StartTime '+campaignObject.startTime+', endTimeSelected'+campaignObject.endTime+', maxDialAttemptsValue : '+campaignObject.maxDialAttempts );
	debugger;
	var txfData = prepareXML(campaignObject);
	debugger;*/
	/*,
			'http://10.1.53.198/adminapi/campaign/'+gblCampaignId, actData);
	 */
	/*$.ajax({
		type : 'PUT',
		url : 'http://10.1.53.198/adminapi/campaign/'+gblCampaignId,
		contentType : 'text/xml',
		dataType : 'text',
		headers : {
			'username' : 'administrator',
			'password' : 'Sp33chs0ft',
			'Authorization' : 'Basic YWRtaW5pc3RyYXRvcjpTcDMzY2hzMGZ0'
		},
		success : function(resp) {
			var campaignStatus='';
			campaignStatus = $(resp).find("enabled").text();
			console.log('Disabling the Campaign State for Campaign ID :'+gblCampaignId);
		},
		error : function(req, status, err) {
			alert('Failure Error :--> ' + err + ', status:--> ' + status);
		}
	});*/
}

var actData = '';

function loadByCampaignName(campaignId) {

}
function getParameterByName(name) {
	name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"), results = regex
	.exec(location.search);
	return results === null ? "" : decodeURIComponent(results[1].replace(
			/\+/g, " "));
}
var gblCampaignName;
var gblCampaignId;
$(document)
.ready(
		function() {
			var campaignName = getParameterByName('campaignName');
			gblCampaignName=campaignName;

			var campaignId = getParameterByName('campaignId');
			gblCampaignId=campaignId;

			$('#campaignName').text(campaignName);
			$('#campaignId').text(campaignId);

		});
