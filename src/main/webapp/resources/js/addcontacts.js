/**
 * 
 */

var actData = '';
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
			$('#results').hide();
			$('#csvContent').hide();
			$('#dialog').hide();
			var campaignName = getParameterByName('campaignName');
			gblCampaignName=campaignName;

			var campaignId = getParameterByName('campaignId');
			gblCampaignId=campaignId;

			$('#campaignName').text(campaignName);
			$('#campaignId').text(campaignId);
			//alert('CampaignName :-->'+campaignName);
			// The event listener for the file upload
			document.getElementById('txtFileUpload')
			.addEventListener('change', upload, false);
			// Method that checks that the browser supports the HTML5 File API
			function browserSupportFileUpload() {
				var isCompatible = false;
				if (window.File && window.FileReader
						&& window.FileList && window.Blob) {
					isCompatible = true;
				}
				return isCompatible;
			}

			function hasMandatoryFieldsInCSV(content) {
//				alert('hasMandatoryFieldsInCSV : content:--> '+content);
				var mandatoryFields=new Array();
				var missingFields=new Array();
				var returnValue =0;
				mandatoryFields=['Account Number', 'First Name', 'Last Name' ,'Phone1'];
				var tempArray = new Array();
				tempArray = content.toString().split(',');
				debugger;
//				var returnValue = $.inArray('Sunil', tempArray);
				for (var i = 0; i < mandatoryFields.length; i++) {
					returnValue = $.inArray(mandatoryFields[i].toString().trim(), tempArray);
					if(returnValue==-1){
//						alert('Mandatory Fields '+mandatoryFields[i].toString().trim()+' were missing..!');
						missingFields.push(mandatoryFields[i].toString().trim());
//						return returnValue;
						continue;
					}
					else{
						continue;
					}
				}
				if(missingFields.length>0){
					var tempVar='';
					for (var i = 0; i < missingFields.length; i++) {
						tempVar=tempVar.concat(' '+missingFields[i]);
					}
					alert('Mandatory Fields '+tempVar.trim()+' were missing..!');
					return -1;
				}else
					return 0;
			}
//			alert('returnValue :--> '+returnValue );
			/*for (var i = 0; i < mandatoryFields.length; i++) {
//					if(mandatoryFields[i]===;
					for (var j = 0; j < tempArray.length; j++) {
						if(mandatoryFields[i].toString()===tempArray[j].toString())
							continue;
						else
							reu
					}
				}*/
			//	}

			function upload(evt) {
				if (!browserSupportFileUpload()) {
					alert('The File APIs are not fully supported in this browser!');
				} else {
					$('#csvContent').show();
					$('#results').show();
					var data = null;
					var file = evt.target.files[0];
					var reader = new FileReader();
					reader.readAsText(file);
					reader.onload = function(event) {
						var csvData = event.target.result;
						data = $.csv.toArrays(csvData);
						actData = data;
					//	debugger;
						console.log('actData:--> '+actData);
						if(hasMandatoryFieldsInCSV(data[0])==-1){
							$('#csvContent').hide();
							$('#results').hide();
							return -1;
						}else{
							for (var i = 1; i < data.length; i++) {
								var lineContent = data[i];
								/* 	alert('Line ' + i + ' , Content : '
														+ lineContent); */
								var tempArray = new Array();
								tempArray = data[i].toString().split(
								',');
								var tr;
								tr = $('<tr/>');
								tr.append("<td>" + tempArray[0]
								+ "</td>");
								tr.append("<td>" + tempArray[1]
								+ "</td>");
								tr.append("<td>" + tempArray[2]
								+ "</td>");
								tr.append("<td>" + tempArray[3]
								+ "</td>");
								$('#uploadedcontacts').append(tr);
							}

						}
					};
					/* 								$('#csvContent').show(); */
					reader.onerror = function() {
						alert('Unable to read ' + file.fileName);
					};
				}
			}

		});

function clearTable() {
	$("#uploadedcontacts").empty();
	$('#csvContent').hide();	
	$('#results').hide();
}

function save() {
//	debugger;
	var txfData = tranformXML(gblCampaignName,
			'http://10.1.53.198/adminapi/campaign/'+gblCampaignId, actData);
	// Read the Status of Campaign..!
//	debugger;
	$.ajax({
		type : 'GET',
		url : 'http://10.1.53.198/adminapi/campaign/'+gblCampaignId,
		contentType : 'text/xml',
		dataType : 'text',
		headers : {
			'username' : 'administrator',
			'password' : 'Sp33chs0ft',
			'Authorization' : 'Basic YWRtaW5pc3RyYXRvcjpTcDMzY2hzMGZ0'
		},
		success : function(resp) {
			//alert('resp'+resp);
			var campaignStatus='';
			campaignStatus = $(resp).find("enabled").text();
			if(campaignStatus =='false'){
				$.ajax({
					type : 'POST',
					url : 'http://10.1.53.198/adminapi/campaign/'+gblCampaignId+'/contacts',
					data : txfData,
					contentType : 'text/xml',
					dataType : 'text',
					headers : {
						'username' : 'administrator',
						'password' : 'Sp33chs0ft',
						'Authorization' : 'Basic YWRtaW5pc3RyYXRvcjpTcDMzY2hzMGZ0'

					},
					success : function(resp) {
						alert('Successfully Uploaded.!');
						$("#uploadedcontacts").empty();
						$('#csvContent').hide();
//						debugger;
//						window.location = 'http://10.1.6.196:8080/UCCXVerS3/Outbound/listcampaigns';
//						---- Live Version  ---- 
//						document.fileupload.action = 'http://10.1.6.196:8080/UCCXVerS3/Outbound/listcampaigns';

//						---- Local Version  ----
						document.fileupload.action = 'http://localhost:8080/UCCXCampaignManager/listcampaigns';
						document.fileupload.submit();     
					},
					error : function(req, status, err) {
//						debugger;
						alert('Failure Error :--> ' + err + ', status:--> ' + status);
					}
				});

			}else{
				//Service Call to Disable the Campaign.
				console.log('Disabling the Campaign State for Campaign ID :'+gblCampaignId);
				$.ajax({
					type : 'PUT',
//					http://uccx-server/adminapi/campaign/200/state/disable
					url : 'http://10.1.53.198/adminapi/campaign/'+gblCampaignId+'/state/disable',
					data : txfData,
					contentType : 'text/xml',
					dataType : 'text',
					headers : {
						'username' : 'administrator',
						'password' : 'Sp33chs0ft',
						'Authorization' : 'Basic YWRtaW5pc3RyYXRvcjpTcDMzY2hzMGZ0'

					},
					success : function(resp) {
						alert('Successfully Uploaded.!');
						$("#uploadedcontacts").empty();
						$('#csvContent').hide();
						
						/*	window.location = 'http://localhost:8080/UCCXVerS3/Outbound/listcampaignstest';	*/
						$.ajax({
							type : 'POST',
							url : 'http://10.1.53.198/adminapi/campaign/'+gblCampaignId+'/contacts',
							data : txfData,
							contentType : 'text/xml',
							dataType : 'text',
							headers : {
								'username' : 'administrator',
								'password' : 'Sp33chs0ft',
								'Authorization' : 'Basic YWRtaW5pc3RyYXRvcjpTcDMzY2hzMGZ0'

							},
							success : function(resp) {
								alert('Successfully Uploaded.!');
								$("#uploadedcontacts").empty();
								$('#csvContent').hide();
//								debugger;
//								window.location = 'http://10.1.6.196:8080/UCCXVerS3/Outbound/listcampaigns';
								//-- Live Version
//								document.fileupload.action = 'http://10.1.6.196:8080/UCCXVerS3/Outbound/listcampaigns';
								//-- Local Version
								document.fileupload.action = 'http://localhost:8080/UCCXCampaignManager/listcampaigns';
								document.fileupload.submit();     
								
							},
							error : function(req, status, err) {
//								debugger;
								alert('Failure Error :--> ' + err + ', status:--> ' + status);
							}
						});
					},
					error : function(req, status, err) {
//						debugger;
						alert('Failure Error :--> ' + err + ', status:--> ' + status);
					}
				});
			}
//			alert('campaignStatus :--> '+campaignStatus );
		},
		error : function(req, status, err) {
//			debugger;
			alert('Failure Error :--> ' + err + ', status:--> ' + status);
		}
	});

	/*$.ajax({
		type : 'POST',
		url : 'http://10.1.53.198/adminapi/campaign/'+gblCampaignId+'/contacts',
		data : txfData,
		contentType : 'text/xml',
		dataType : 'text',
		headers : {
			'username' : 'administrator',
			'password' : 'Sp33chs0ft',
			'Authorization' : 'Basic YWRtaW5pc3RyYXRvcjpTcDMzY2hzMGZ0'

		},
		success : function(resp) {
			alert('Successfully Uploaded.!');
			$("#uploadedcontacts").empty();
			$('#csvContent').hide();
			window.location = 'http://localhost:8080/UCCXVerS3/Outbound/listcampaignstest';	
		},
		error : function(req, status, err) {
			debugger;
			alert('Failure Error :--> ' + err + ', status:--> ' + status);
		}
	});
	 */}

function tranformXML(campaignName, refURL, csvData) {
	var headerXML, bodyXMLContent, footerXML, footerXML2;
	//campaignName=campaignName;
	var newXMLContent = '';
	for (var i = 0; i < csvData.length; i++) {
		var lineContent = csvData[i];
		newXMLContent = newXMLContent.concat(lineContent + '\n');
		//alert('Inside tranformXML :-->  Line ' + i + ' , Content : ' + lineContent);
	}
	//alert('newXMLContentL :-->  ' + newXMLContent);
	headerXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
		+ "<campaignContacts xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n"
		+" xsi:noNamespaceSchemaLocation=\"campaignContacts.xsd\">\n"
		+ "<campaign name=\"";

	bodyXMLContent="><refURL>";
	footerXML = "</refURL>\n</campaign>\n<csvdata>\n";
	footerXML2 = "</csvdata>\n</campaignContacts>";
	headerXML = headerXML.concat(campaignName.concat("\"")).concat(
			bodyXMLContent).concat(refURL).concat(footerXML).concat(
					newXMLContent).concat(footerXML2);
	//alert('Transformed XML with the Dynamic Values :--> ' + headerXML);
	return headerXML;
}