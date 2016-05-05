package com.speechsoft.processor;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import com.speechsoft.util.UccxUtility;

public class UccxContactsProcessor {

	public void doAddContactsAsCron(Map<String,String> csvMapContent,FTPClient ftpClient,String ftpURL,String  ftpUser,String ftpPwd){
		System.err.println("Inside doAddContactsAsCron()..!");
		String targetURL="http://10.1.53.198/adminapi/campaign/";
		String campaignName,campaignId,csvFileContent=null;
		String fileContent=null;
		
		try {
			if(csvMapContent!=null){
				campaignName=csvMapContent.get("CampaignName");
				campaignId=csvMapContent.get("CampaignId");
				csvFileContent=csvMapContent.get("csvFileContent");
				if(csvFileContent!=null && csvFileContent.length()>0){
					targetURL=targetURL.concat(campaignId).concat("/contacts");
					RestTemplate restTemplate = new RestTemplate();

					String base64Creds = UccxUtility.convertToBase64("administrator:Sp33chs0ft");
					System.err.println("base64Creds:--> "+base64Creds+"\n csvFileContent: "+csvFileContent);
					Map<String, String> mvm = new HashMap<String, String>();
					mvm.put("data", csvFileContent);

					HttpHeaders headersObj = new HttpHeaders();
					headersObj.setContentType(MediaType.APPLICATION_XML);
					headersObj.set("dataType", "text");
					headersObj.add("Authorization", "Basic " + base64Creds);

					HttpEntity<String> requestStringEntity = new HttpEntity<String>(csvFileContent, headersObj);
					String response = restTemplate.postForObject(targetURL, requestStringEntity, String.class);
					System.err.println("response:-->"+response);

					fileContent = csvMapContent.get("ftpFileContent");
					//Doing backup
					if(UccxUtility.backupCSVFile(ftpClient, ftpURL, ftpUser, ftpPwd, fileContent)){
						//Deleting FTP File
						UccxUtility.deleteFTPFile(ftpClient, ftpURL,ftpUser,ftpPwd);
					}
				}
				else
					System.err.println("Unable to Exec doAddContactsAsCron() as csvFileContent is Empty/Null...!");
			}
		}
		catch(Exception e)
		{
			System.out.println("GENERIC Exception " +e);
		}
		System.err.println("exit  doAddContactsAsCron()..!");
	}
}
