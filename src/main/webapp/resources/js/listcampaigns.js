var maxDialParentArray =[];

$(document)
.ready(
		function() {
			debugger;
			$("#wait").css("display", "block");
			console.log('Started the Spinner');
			debugger;
		}
);

function addContact(){
	alert('Clicked  addContact ...! campaignId : '+campaignId+',campaignName'+campaignName);		

}
function configureCron(campaignId,campaignName){
	alert('Clicked configureCron...! campaignId : '+campaignId+',campaignName'+campaignName);	

}

function filterQuotes(text){
	var ret = "";

	if ( /"/.test( text ) ){
		ret = text.match( /"(.*?)"/ )[1];
	} else {
		ret = str;
	}
	return ret;
}

function populateCampaignJSONArray(eachCampaign){
//	debugger;
	var campaignsCount = eachCampaign.length;
	for (var i = 0; i < campaignsCount; i++) {
		var campaignNameVal = JSON
		.stringify(eachCampaign[i].campaignName["#text"]);
		campaignName=filterQuotes(campaignNameVal);
		var campaignIdVal = JSON
		.stringify(eachCampaign[i].campaignId["#text"]);
		campaignId=filterQuotes(campaignIdVal);

		var campaignTypeVal= JSON
		.stringify(eachCampaign[i].campaignType["#text"]);
		campaignType=filterQuotes(campaignTypeVal);
		var dialerTypeVal= JSON
		.stringify(eachCampaign[i].dialerType["#text"]);
		dialerType=filterQuotes(dialerTypeVal);
		var pendingContactsVal= filterQuotes(JSON
				.stringify(eachCampaign[i].pendingContacts["#text"]));
		var enabledVal= JSON
		.stringify(eachCampaign[i].enabled["#text"]);
		enabledVal=filterQuotes(enabledVal);

		var startTimeVal= JSON
		.stringify(eachCampaign[i].startTime["#text"]);
		startTimeVal=filterQuotes(startTimeVal);

		var endTimeVal= JSON
		.stringify(eachCampaign[i].endTime["#text"]);
		endTimeVal=filterQuotes(endTimeVal);

		var dialerTypeVal= JSON
		.stringify(eachCampaign[i].dialerType["#text"]);
		dialerType=filterQuotes(dialerTypeVal);
//		debugger;
		campaignDetailsArray.push({
			'campaignName':campaignName ,
			'campaignId': campaignId,
			'campaignType':campaignType,
			'dialerType':dialerType,
			'pendingContacts':pendingContactsVal,
			'enabled':enabledVal,
			'startTime':startTimeVal,
			'endTime':endTimeVal
		});
	}
	console.log('campaignDetailsArray :--> '+campaignDetailsArray.length);
	return campaignDetailsArray;
}
var campaignDetailsArray =new Array();
function populateCampaignDetailJSONArray(srcCampgnArray,eachCampaign){
//	debugger;
	var campaignsCount = eachCampaign.length;
	for (var i = 0; i < campaignsCount; i++) {
		var campaignNameVal = JSON
		.stringify(eachCampaign[i].campaignName["#text"]);
		campaignName=filterQuotes(campaignNameVal);
		var campaignIdVal = JSON
		.stringify(eachCampaign[i].campaignId["#text"]);
		campaignId=filterQuotes(campaignIdVal);

//		populateMisdAnsCallBacByCampId(srcCampgnArray,campaignId);
	}
	console.log('campaignDetailsArray :--> '+campaignDetailsArray.length);
	return campaignDetailsArray;
}


function processMisdAnsCallAjaxResponse(misdAnsCallAjaxResponse,srcCampgnArray,campaignId){
	var maxDialChildArray =[];
	var xmlToJsonValue= JSON
	.stringify(xmlToJson(misdAnsCallAjaxResponse));
	var jsonObject = jQuery
	.parseJSON(xmlToJsonValue);
	var campaign = jsonObject['campaign'];
//	debugger;
	var campaignIdVal = JSON
	.stringify(campaign.campaignId["#text"]);
	campaignIdVal=filterQuotes(campaignIdVal);

	for(var i=0;i<srcCampgnArray.length;i++){
//		srcCampgnArray.
		console.log('srcCampgnArray[i].campaignId : --> '+srcCampgnArray[i].campaignId+', campaignIdVal :--> '+campaignIdVal);
		if(srcCampgnArray[i].campaignId==campaignIdVal){
			typeSpecificInfo= campaign['typeSpecificInfo'];
			obPreview= typeSpecificInfo['obPreview'];

			var campaignIdVal= JSON	
			.stringify(campaign.campaignId["#text"]);
			campaignIdVal=filterQuotes(campaignIdVal);

			var maxDialAttemptsVal= filterQuotes(JSON
					.stringify(obPreview.maxDialAttempts["#text"]));
			maxDialAttemptsValue=maxDialAttemptsVal;

			var ansMachineRetryValue= filterQuotes(JSON
					.stringify(obPreview.ansMachineRetry["#text"]));

			var missedCallbackActionValue= filterQuotes(JSON
					.stringify(obPreview.missedCallbackAction["#text"]));
			srcCampgnArray[i].maxDialAttempts=maxDialAttemptsVal;
			srcCampgnArray[i].ansMachineRetry=ansMachineRetryValue;
			srcCampgnArray[i].missedCallbackAction=missedCallbackActionValue;
			console.log('maxDialAttemptsValue: '+maxDialAttemptsValue +',ansMachineRetryValue:'+ansMachineRetryValue+'missedCallbackActionValue: '+missedCallbackActionValue);
			return srcCampgnArray[i];
		}else 
			continue;
	}
//	debugger;
	return srcCampgnArray[i];
}
function changeCampaignState(selUIStateValue,campaignID){
	/* Call to Disable/Enable the Campaign.
	 * 
	 *  http://uccx-server/adminapi/campaign/200/state/disable
		http://uccx-server/adminapi/campaign/200/state/enable
	 */debugger;
	 $("#wait").css("display", "block");
	 console.log('Started the Spinner');
	 var selectedState='';
	 selectedState=getSelectedState(selUIStateValue,campaignID);
	 console.log('Changing the Campaign State of Campaign ID :'+campaignID+' to state :'+selectedState);
	 $.ajax({
		 type : 'PUT',
		 url : 'http://10.1.53.198/adminapi/campaign/'+campaignID+'/state/'+selectedState,
		 /*data : txfData,*/
		 contentType : 'text/xml',
		 dataType : 'text',
		 headers : {
			 'username' : 'administrator',
			 'password' : 'Sp33chs0ft',
			 'Authorization' : 'Basic YWRtaW5pc3RyYXRvcjpTcDMzY2hzMGZ0'
		 },
		 success : function(resp) {
			 debugger;
			 alert('Successfully Modified the Campaign State.!');
			 $("#wait").css("display", "none");
			 console.log('Stopped the Spinner');
		 },
		 error : function(req, status, err) {
			 alert('Unable to Modify the campaign State :--> ' + err + ', state:--> ' + state);
			 $("#wait").css("display", "none");
			 console.log('Stopped the Spinner');
		 }
	 });
}

function getSelectedState(sel,campaignID) {
	debugger;
	var selectedState=sel.value;

	if(selectedState=='true')
		selectedState='enable';
	else
		selectedState='disable';
	console.log('Selected State :-->  '+selectedState+', campaignID : --> '+campaignID+', campaignName :--> '+campaignName);
	return selectedState;
}

function populateMisdAnsCallBacByCampId(srcCampgnArray,campaignId){
	console.log("campaignId  = " + campaignId);
	var targetUrl ='http://10.1.53.198/adminapi/campaign/';
	targetUrl = targetUrl .concat(campaignId);
	console.log('targetUrl'+targetUrl);
	$.ajax({
		type : 'GET',
		url : targetUrl,
		asyn:false,
		headers : {
			'username' : 'administrator',
			'password' : 'Sp33chs0ft',
			'Authorization' : 'Basic YWRtaW5pc3RyYXRvcjpTcDMzY2hzMGZ0',
			'contentType' : 'text/xml'
		},
		success : function(response) {
			var camp=processMisdAnsCallAjaxResponse(response,srcCampgnArray,campaignId)
			renderTableWithData(camp);
//			campaignDetailsArray=populateCampainMaxDialAnsMissedCallArray(campaignDetailsArray,maxDialParentArray);
//			renderTableWithData(srcCampgnArray);
			console.log('campaignDetailsArray:-->'+srcCampgnArray);
		},
		error : function(req, status, err) {
			alert('Failure Error :--> ' + err
					+ ', status:--> ' + status);
		}

	});	
	console.log('campaignDetailsArray :--> '+campaignDetailsArray.length);
	return campaignDetailsArray;
}
var trace =undefined;
function renderTableWithData(campaign){
	debugger;
	var campaignName=campaign.campaignName;
	var campaignId=campaign.campaignId;
	var pendingContacts=campaign.pendingContacts;
	var campaignType=campaign.campaignType;
	var dialerType=campaign.dialerType;

	var enabled=campaign.enabled;
	console.log('enabled :--> '+enabled);
	var startTim=campaign.startTime;
	var endTime=campaign.endTime;
	debugger
	var dialAttempts=campaign.maxDialAttempts;
	var ansMachineRetry=campaign.ansMachineRetry;
	var missedCallbackAction=campaign.missedCallbackAction;
	trace=endTime;
	var tr;
	debugger;
	tr = $("<tr/>");
	tr.append("<td>"
			+ "<b><a href ='modifycampaigndetails?campaignId="+campaignId+"'>"+campaignName+"</a></b></td>"
			+ "</td>");
	tr.append("<td>"
			+ pendingContacts
			+ "</td>");
	tr.append("<td>"
			+ startTim
			+ "</td>");
	tr.append("<td>"+trace+ "</td>");
	tr.append("<td>"+
			"<div class='styled-select blue semi-square'><select class=\"styled-select blue semi-square\" onchange=changeCampaignState(this,campaignId);> "+
			"<option selected value=\"+enabled+\">"+enabled+"</option>"+
			"<option value=\"true\">true</option>"+
			"<option value=\"false\">false</option>"+
	"</select></div></td>");

	/*tr.append("<td style='height:34px'><input type=submit class='btn-add-bg-img' onclick='addContact()';/> <input type=button class='btn-cron-bg-img' onclick='configureCron(campaignId,campaignName)';/></td>");*/
	tr.append("<td><a  href =addcontacts?campaignName="+campaignName+"&campaignId="+campaignId+"><img class=btn-add-bg-img></a>"+
			"<a  href =configureftppath?campaignName="+campaignName+"&campaignId="+campaignId+"><img class=btn-cron-bg-img></a></td>");
	$('#campaignresults').append(tr); 
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
$(document)
.ready(
		function() {
//			$("#wait").css("display", "block");
			var campaignId='';
			var campaignName='';
			var maxDialAttemptsValue='';
			var ansMachineRetryValue='';
			var missedCallbackActionValue='';
			debugger;
			$
			.ajax({
				type : 'GET',
				url : 'http://10.1.53.198/adminapi/campaign',
				headers : {
					'username' : 'administrator',
					'password' : 'Sp33chs0ft',
					'Authorization' : 'Basic YWRtaW5pc3RyYXRvcjpTcDMzY2hzMGZ0',
					'contentType' : 'text/xml'
				},
				success : function(resp) {
					var xmlToJsonText = JSON
					.stringify(xmlToJson(resp));
					var obj = jQuery
					.parseJSON(xmlToJsonText);
//					debugger;
					var campaigns = obj['campaigns'];
					var eachCampaign = campaigns['campaign'];

					var campaignsCount = eachCampaign.length;
					var srcCampgnArray=populateCampaignJSONArray(eachCampaign);
					var campgnArray=populateCampaignDetailJSONArray(srcCampgnArray,eachCampaign);
//					debugger;
					for(var i=0;i<campgnArray.length;i++){
						debugger;
						var srcCampId=campgnArray[i].campaignId;
						var transformedMaxDialCampArray =populateMisdAnsCallBacByCampId(campgnArray,srcCampId);
//						renderTableWithData(transformedMaxDialCampArray,srcCampId);
						console.log('campgnArray:==> '+campgnArray.length+'  maxDialParentArray : '+maxDialParentArray .length );
					}
					$("#wait").css("display", "none");
				},
				error : function(req, status, err) {
					alert('Failure Error :--> ' + err
							+ ', status:--> ' + status);
					$("#wait").css("display", "none");
				}
			});
		});




