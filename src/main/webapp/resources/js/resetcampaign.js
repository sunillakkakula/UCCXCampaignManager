/**
 * 
 */
function uploadCampaign(id) {
		alert('Clicked Upload Campaign for ID:--> ' + id);
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
				var campaignId='';
				var campaignName='';
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
						var campaigns = obj['campaigns'];
						var eachCampaign = campaigns['campaign'];
						var campaignsCount = eachCampaign.length;

						$(function() {
							var tr;
							for (var i = 0; i < campaignsCount; i++) {
								var campaignNameVal = JSON
								.stringify(eachCampaign[i].campaignName["#text"]);
								campaignName=filterQuotes(campaignNameVal);
								var campaignIdVal = JSON
								.stringify(eachCampaign[i].campaignId["#text"]);
								campaignId=filterQuotes(campaignIdVal);
								fetchContactDetails(campaignName,campaignId);
							}
						});
					},
					error : function(req, status, err) {
						alert('Failure Error :--> ' + err
								+ ', status:--> ' + status);
					}
				});
			});
	
	
	function resetContacts(campaignName,campaignId){
		var targetUrl ='http://10.1.53.198/adminapi/campaign/';
//		alert('resetContacts campaignName: '+campaignName+', campaignId: '+campaignId);
		targetUrl = targetUrl .concat(campaignId).concat('/contacts');
//		alert('targetUrl'+targetUrl  );
		$
		.ajax({
			type : 'DELETE',
			url : targetUrl,
			headers : {
				'username' : 'administrator',
				'password' : 'Sp33chs0ft',
				'Authorization' : 'Basic YWRtaW5pc3RyYXRvcjpTcDMzY2hzMGZ0',
				'contentType' : 'application/xml'
			},
			success : function(resp) {
				alert('Successfuly Deleted !');
				window.location.reload();
			},
			error : function(req, status, err) {
				alert('Failure Error :--> ' + err
						+ ', status:--> ' + status);
			}
		});
	}
	function fetchContactDetails(campaignName,campaignId){
		var targetUrl ='http://10.1.53.198/adminapi/campaign/';
		targetUrl = targetUrl .concat(campaignId).concat('/contacts');
		$
		.ajax({
			type : 'GET',
			url : targetUrl,
			headers : {
				'username' : 'administrator',
				'password' : 'Sp33chs0ft',
				'Authorization' : 'Basic YWRtaW5pc3RyYXRvcjpTcDMzY2hzMGZ0',
				'contentType' : 'text/xml'
			},
			success : function(response) {
				var xmlToJsonValue= JSON
				.stringify(xmlToJson(response));
				var jsonObject = jQuery
				.parseJSON(xmlToJsonValue);
				var campaignContacts = jsonObject['campaignContacts'];
				var eachCampaignCSVData = campaignContacts['csvdata'];
				var csvData = eachCampaignCSVData["#text"];
				var contacts=csvData.split('\n');
				var contactsCount=contacts.length;
				/*alert('contactsCount:'+contactsCount);*/
				if(contactsCount>0)
					contactsCount=contactsCount-3;
				$(function() {
					var tr;
					tr = $('<tr/>');
					tr.append("<td>"
							+ campaignName
							+ "</td>");
					tr.append("<td>"
							+ campaignId
							+ "</td>");
					tr.append("<td>"
							+ contactsCount
							+ "</td>");
					tr.append("<td>"
							+"<button onclick=resetContacts('"+campaignName+"'"+",'"+campaignId+"') id='resetClass'>Reset</button></td>");
					$('table').append(tr);
				});
			},
			error : function(req, status, err) {
				alert('Failure Error :--> ' + err
						+ ', status:--> ' + status);
			}
		});
	}


	// Method that checks that the browser supports the HTML5 File API
	function browserSupportFileUpload() {
		var isCompatible = false;
		if (window.File && window.FileReader && window.FileList && window.Blob) {
			isCompatible = true;
		}
		return isCompatible;
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
