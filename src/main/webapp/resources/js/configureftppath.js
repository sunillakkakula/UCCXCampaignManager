/**
 * 
 */

function filterQuotes(text){
	var ret = "";

	if ( /"/.test( text ) ){
		ret = text.match( /"(.*?)"/ )[1];
	} else {
		ret = str;
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

function getParameterByName(name) {
	name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"), results = regex
	.exec(location.search);
	return results === null ? "" : decodeURIComponent(results[1].replace(
			/\+/g, " "));
}

$(document)
.ready(
		function() {
			debugger;
			var campaignName = getParameterByName('campaignName');
			var campaignId = getParameterByName('campaignId');

			$('#campaignName').text(campaignName);
			$('#campaignId').text(campaignId);
			
			debugger;
			$.ajax({
				type : 'GET',
				url : '/UCCXCampaignManager/ftpfileslist',
				dataType:'JSON',
				/*headers : {
					'contentType' : 'application/json'
				},*/
				/*beforeSend: function () {
                    $(".modal").show();
                },*/
				success : function(resp) {
					debugger;
					if(!resp.length>0){ 
						console.log('Empty List of FTP Files at the FTP Server Location');
					}else{
						debugger;
						var xmlToJsonText = JSON
						.stringify(resp);
						var obj = jQuery
						.parseJSON(xmlToJsonText);
						console.log('Obj Response :--> '+obj);
						var $select = $('select#ftpFileName');

						//request the JSON data and parse into the select element
						$select.html('');
						//iterate over the data and append a select option
						$.each(obj, function(key, val){
							$select.append('<option id="' + val + '">' + val+ '</option>');
						})
					}
				},
				error : function(req, status, err) {
					debugger;
					alert('Failure Error in doc Ready While Loading FTP Files :--> ' + err
							+ ', status:--> ' + status);
				}
			});


			/*	$('#saveMappingForm').submit(function (e){
				debugger;
				$.post('/UCCXVerS3/Outbound/savemappinginfo');
			});
			 */
			// Below code to Load the Campaign ID's
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
					debugger;
					if(resp.childNodes.length== 0){ 
						console.log('Empty List of Campaign IDs');
					}else{
						debugger;
						var xmlToJsonText = JSON
						.stringify(xmlToJson(resp));
						var obj = jQuery
						.parseJSON(xmlToJsonText);
						var campaigns = obj['campaigns'];
						var eachCampaign = campaigns['campaign'];
						var campaignsCount = eachCampaign.length;

						var tr;
						for (var i = 0; i < campaignsCount; i++) {
							var campaignNameVal = JSON
							.stringify(eachCampaign[i].campaignName["#text"]);
							campaignName=filterQuotes(campaignNameVal);
							var campaignIdVal = JSON
							.stringify(eachCampaign[i].campaignId["#text"]);
							campaignId=filterQuotes(campaignIdVal);
							console.log('campaignName:--> '+campaignName+' , campaignId'+campaignIdVal);
							var $select = $('select#campaignId');
							$select.append('<option id="' + campaignName+'-['+campaignId + ']">' + campaignName+'-['+campaignId +']</option>');
						}	
					}
				},
				error : function(req, status, err) {
					alert('Erorr While Loading Campaign IDs Failure Error :--> ' + err
							+ ', status:--> ' + status);
				}
			});

		}
);
$('#saveMappingForm').submit(function (e){
	debugger;
	$.post('/UCCXCampaignManager/savemappinginfo',function(data, status){
        alert('Succesfully Saved Mapping Information');
    });
});


function clearTable() {

}

function validateform() {
	var ftpFileName = document.getElementById("ftpFileName");
	var ftpFileNameValue= ftpFileName.options[ftpFileName.selectedIndex].value;
	var campaignName = document.getElementById("campaignName").value;
	console.log('ftpFileNameValue:--> '+ftpFileNameValue+", campaignName :-->"+campaignName);
	return true;
}
