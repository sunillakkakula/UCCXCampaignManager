var _getAllFilesFromFolder = function(dir) {

    var filesystem = require("fs");
    var results = [];

    filesystem.readdirSync(dir).forEach(function(file) {

        file = dir+'/'+file;
        var stat = filesystem.statSync(file);

        if (stat && stat.isDirectory()) {
            results = results.concat(_getAllFilesFromFolder(file))
        } else results.push(file);

    });

    return results;

};
function downloadfile(fileName){
	//alert('fileName :-->'+fileName);
	// Live FTP Server Location.
//	 var urlApp='http://192.168.0.108:8080/UCCXCampaignManager/downloadftpfile/{'+fileName+'}';
	//Local Testing 
	 var urlApp='http://localhost:8080/UCCXCampaignManager/downloadftpfile/{'+fileName+'}';
	  window.location = urlApp;
	
/*	$
	.ajax({
		type : 'GET',
//		url : 'http://192.168.1.3:8080/UCCXVerS3/Outbound/downloadftpfile/{'+fileName+'}',
		url : 'http://192.168.1.3:8080/UCCXVerS3/Outbound/downloadtest',
		dataType : 'text',
		data : fileName,
		contentType : 'text/json',
		success : function(resp) {
			alert('Response :--> '+resp);
				  $('#csvcontent').html(resp);
				  debugger;
				  var urlApp='http://192.168.1.3:8080/UCCXVerS3/Outbound/downloadftpfile/{'+fileName+'}';
				  window.location = urlApp;
		},
		error : function(req, status, err) {
			alert('Failure Error :--> ' + err
					+ ', status:--> ' + status);
		}
	});*/
}

//Method that reads and processes the selected file
function getContactsHistoryy(evt) {
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
