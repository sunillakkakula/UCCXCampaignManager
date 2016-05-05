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
	function fetchContactDetails(campaignName,campaignId){
		var targetUrl ='http://10.1.53.198/adminapi/campaign/';
		targetUrl = targetUrl .concat(campaignId).concat('/contacts');
//		alert('targetUrl:-->'+targetUrl);
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
							+ ""
							+ "</td>");
					tr.append("<td>"
							+"<a href ='addcontacts?campaignName="+campaignName+"&campaignId="+campaignId+"'>Add</a></td>");
					$('table').append(tr);
				});
			},
			error : function(req, status, err) {
				alert('Failure Error :--> ' + err
						+ ', status:--> ' + status);
			}
		});
	}

/*	$(document)
			.ready(
					function() {
						$
								.ajax({
									type : 'GET',
									url : 'http://198.18.133.19/adminapi/campaign',
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
										//alert('Response:--> ' + xmlToJsonText);
										//var obj = jQuery.parseJSON( '{"campaign":[{"self":{"#text":"http://198.18.133.19/adminapi/campaign/15"},"campaignId":{"#text":"15"},"campaignName":{"#text":"vinod"},"enabled":{"#text":"true"},"description":{"#text":"Call back testing Campaign"},"startTime":{"#text":"04:00"},"endTime":{"#text":"21:00"},"timeZone":{"#text":"Coordinated Universal Time"},"campaignType":{"#text":"AGENT"},"dialerType":{"#text":"DIRECT_PREVIEW"},"pendingContacts":{"#text":"0"}},{"self":{"#text":"http://198.18.133.19/adminapi/campaign/11"},"campaignId":{"#text":"11"},"campaignName":{"#text":"Recall_Outbound"},"enabled":{"#text":"true"},"description":{"#text":"Recall_Outbound Campaign"},"startTime":{"#text":"05:00"},"endTime":{"#text":"23:59"},"timeZone":{"#text":"Coordinated Universal Time"},"campaignType":{"#text":"AGENT"},"dialerType":{"#text":"DIRECT_PREVIEW"},"pendingContacts":{"#text":"0"}}]}');
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
												var campaignIdVal = JSON
														.stringify(eachCampaign[i].campaignId["#text"]);
												var startTimeVal = JSON
														.stringify(eachCampaign[i].startTime["#text"]);
												tr = $('<tr/>');
												tr.append("<td>"
														+ filterQuotes(campaignNameVal)
														+ "</td>");
												tr.append("<td>"
														+ "1"
														+ "</td>");
												tr.append("<td>"
														+ filterQuotes(campaignIdVal)
														+ "</td>");
												tr.append("<td>" + filterQuotes(startTimeVal)
														+ "</td>");
												//tr.append("<td><a href ='uploadContacts' onclick='uploadCampaign("+campaignIdVal+")'>Edit</a></td>");
												 arts += "<td>"+artist.credits+"&nbsp;&nbsp;<a onclick='addcredits("+artist.id+")'>Edit</a></td>"; 
												
												tr.append("<td><a href ='addcontacts?campaignName="+filterQuotes(campaignNameVal)+"'>Add</a></td>");
												tr.append("<td><a href ='resetcontacts?campaignName="+filterQuotes(campaignNameVal)+"'>Reset</a></td>");
												$('table').append(tr);
											}
										});

									},
									error : function(req, status, err) {
										alert('Failure Error :--> ' + err
												+ ', status:--> ' + status);
									}
								});
					});
*/
	// document.getElementById('fileUpload1').addEventListener('change', upload, false);

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
	// Method that reads and processes the selected file
	function upload(evt) {
		if (!browserSupportFileUpload()) {
			alert('The File APIs are not fully supported in this browser!');
		} else {
			var data = null;
			var file = evt.target.files[0];
			var reader = new FileReader();
			reader.readAsText(file);
			reader.onload = function(event) {
				var csvData = event.target.result;
				data = $.csv.toArrays(csvData);
				/* alert('data Length:-->' + data.length); */
				for (var i = 0; i < data.length; i++) {
					var lineContent = data[i];
					console.log('Line ' + i + ' , Content : ' + lineContent);
				}
				if (data && data.length > 0) {
					alert('Imported -' + data.length + '- rows successfully!');
				} else {
					alert('No data to import!');
				}
			};
			reader.onerror = function() {
				alert('Unable to read ' + file.fileName);
			};
		}
	}
