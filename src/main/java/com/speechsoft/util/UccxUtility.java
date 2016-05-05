package com.speechsoft.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import com.speechsoft.bean.FTPFileCampaignBean;
import com.speechsoft.service.FTPFileService;

public class UccxUtility {

	public static String baseFileName="D:\\/Projects/UCCXOutbound_BackupFiles/";

	public static String convertToBase64(String plainString){
		byte[] plainCredsBytes = plainString.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);
		return base64Creds;
	}
	public static String getTranformedXML(String campaignName,String refURL,String csvData){
		String headerXML,bodyXMLContent,footerXML,footerXML2;
		headerXML=bodyXMLContent=footerXML=footerXML2=null;
		//		campaignName=campaignName+"\"";

		headerXML="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
				+"<campaignContacts xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n"
				+" xsi:noNamespaceSchemaLocation=\"campaignContacts.xsd\">\n"
				+"<campaign name=\"";

		bodyXMLContent="><refURL>";
		footerXML="</refURL></campaign><csvdata>";
		footerXML2="</csvdata></campaignContacts>";
		headerXML=headerXML.concat(campaignName.concat("\"\n")).concat(bodyXMLContent).concat(refURL).concat(footerXML).concat(csvData).concat(footerXML2);
		System.err.println("Transformed XML with the Dynamic Values :--> "+headerXML);
		return headerXML;
	}

	public static String getStringFromInputStream(InputStream is) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		String line;
		try {
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append("\n"+line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
	public static Map<String,String> processCSVFile(FTPClient ftpClient,String ftpServerURL,String ftpuser,String ftppassword){
		boolean statusCurrentDir=false;
		String fmtCSVContent="";
		Map<String,String> ftpFileDetailsMap=null;
		FTPFile[] uccxContactsFiles =null;
		List<FTPFileCampaignBean> ftpFileCampaignBeanList=null;
		FTPFileService ftpFileService=null; 
		try {
			ftpClient.connect(ftpServerURL);
			ftpClient.enterLocalPassiveMode();
			boolean login = ftpClient.login(ftpuser, ftppassword);

			readFTPServerResponse(ftpClient);
			statusCurrentDir = ftpClient.changeWorkingDirectory("/ftproot/UCCX_Contacts/Data");
			readFTPServerResponse(ftpClient);

			if (login) {
				System.err.println("Connection established...");
				uccxContactsFiles = ftpClient.listFiles("/ftproot/UCCX_Contacts/Data");

				if (uccxContactsFiles != null && uccxContactsFiles.length > 0){ 
					System.err.println("List of uccxContactsFiles Files :"+uccxContactsFiles.length);

					// Passing the FTP File-Campaign ID Mapping List.!
					ftpFileService=new FTPFileService();
					ftpFileCampaignBeanList=ftpFileService.mappingFTPCampaignList();
					if(ftpFileCampaignBeanList!=null && ftpFileCampaignBeanList.size()>0){
						ftpFileDetailsMap=listFtpFileDetails(uccxContactsFiles, ftpClient,ftpFileCampaignBeanList);	
					}
				}
				else
					System.err.println("No uccxContactsFiles Files  to Process..!  :)");
			}
		} catch (SocketException e) {
			e.printStackTrace();
			ftpFileDetailsMap=null;
		} catch (IOException e) {
			e.printStackTrace();
			ftpFileDetailsMap=null;
		}
		catch (Exception e) {
			e.printStackTrace();
			ftpFileDetailsMap=null;
		}
		finally {
			try {
				//				backupCSVFile(uccxContactsFiles, ftpClient);
				System.err.println("Disconnecting The FTP Connection");
				ftpClient.disconnect();
				ftpClient=null;
				ftpFileService=null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ftpFileDetailsMap;
	}

	public static boolean  backupCSVFile(FTPClient ftpClient,String ftpServerURL,String ftpuser,String ftppassword ,String fileContent){
		System.err.println("Started doing backupCSVFile");
		String fileName=null;
		boolean backUpStatus=false;
		String [] fileNameDetails=null;
		FTPFile[] uccxContactsFiles=null;
		String newFileName=null;
		try {
			ftpClient.connect(ftpServerURL);
			ftpClient.enterLocalPassiveMode();
			boolean login = ftpClient.login(ftpuser, ftppassword);

			readFTPServerResponse(ftpClient);

			if (login) {
				System.err.println("Connection established...");
				uccxContactsFiles = ftpClient.listFiles("/ftproot/UCCX_Contacts/Data");

				if (uccxContactsFiles != null && uccxContactsFiles.length > 0){ 
					System.err.println("List of uccxContactsFiles Files :"+uccxContactsFiles.length);

					for(FTPFile ftpFile:uccxContactsFiles){
						System.err.println("List of Files :"+uccxContactsFiles.length);
						fileName=ftpFile.getName();
						System.err.println("File Name: "
								+ fileName
								+ " File Size: "
								+ FileUtils.byteCountToDisplaySize(ftpFile.getSize()));
						fileNameDetails= fileName.split("\\.");
						fileName = (fileNameDetails[0]!=null?fileNameDetails[0]:"");
						newFileName=fileName.concat(getCurrentTimestamp()).concat(".csv");
						//						newFileName=campaignName.concat("_").concat(campaignIDArray[0]).concat("_").concat(getCurrentTimestamp());
						System.err.println("Old fileName :-->"+fileName+", New Backup FileName:-->"+newFileName);

						if(fileContent!=null)
							backUpStatus=createFileOnServer(baseFileName,newFileName,fileContent);
						else
							System.err.println("Unable to Writethe BKP file as ftpFileContent is NULL..!!");

					}
				} 
			}
		}catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally{
			fileName=null;
			uccxContactsFiles=null;
			try {
				ftpClient.disconnect();
				ftpClient=null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.err.println("backupCSVFile Status: "+backUpStatus);
		return backUpStatus;
	}

	public static boolean createFileOnServer(String baseFileName,String newFileName,String ftpFileContent){
		//		System.err.println("Inside createFileOnServer : baseFileName-"+baseFileName+" , ftpFileContent:-->"+ftpFileContent.length()+" New File Name:"+newFileName);
		FileOutputStream fop = null;
		File file =null;
		byte[] contentInBytes =null;
		boolean status=false;
		try {
			baseFileName=baseFileName.concat(newFileName);
			file = new File(baseFileName);
			fop = new FileOutputStream(file);

			// if file doesnt exists, then create it
			if (!file.exists()) 
				file.createNewFile();

			// get the content in bytes
			contentInBytes = ftpFileContent.getBytes();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();
			System.out.println("Done Saving File using createFileOnServer , returning Status of Backup as :-->"+status);
			status=true;

		} catch (IOException e) {
			e.printStackTrace();
			status=false;
		}finally{
			if(fop!=null)
				fop=null;
			if(file!=null)
				file=null;

		}
		System.err.println("Exit createFileOnServer");
		return status;
	}
	public static Map<String,String> listFtpFileDetails(FTPFile[] uccxContactsFiles, FTPClient ftpClient,List<FTPFileCampaignBean> ftpFileCampaignBeanList){
		//		http://10.1.53.198/adminapi/campaign/3/contacts
		InputStream inputStream =null;
		String ftpFileContent,campaignName,refURL,campaignId,tranformXMLContent=null;
		String [] campaignDetails=null;
		//		String [] campaignIdArray=null;
		Writer writer=null;
		Map<String,String> ftpFileDetailsMap=new HashMap<String,String>();
		refURL="http://10.1.53.198/adminapi/campaign/";
		try{
			if (uccxContactsFiles != null && uccxContactsFiles.length > 0) { 
				for(FTPFile ftpFile:uccxContactsFiles){
					System.err.println("List of Files :"+uccxContactsFiles.length);
					String fileName=ftpFile.getName();
					/*System.err.println("File Name: "
							+ fileName
							+ " File Size: "
							+ FileUtils.byteCountToDisplaySize(ftpFile.getSize()));*/
					//campaignDetails=fileName.split("_");
					for(FTPFileCampaignBean ftpCampaignBean :ftpFileCampaignBeanList){
						System.err.println("Source File Name:"+fileName+", Length:"+fileName.length()+" | File from DB : "+ftpCampaignBean .getFtpFileName()+", Length : "+ftpCampaignBean .getFtpFileName().length());
						if(fileName.trim().equalsIgnoreCase(ftpCampaignBean .getFtpFileName().trim())){
							campaignName=ftpCampaignBean.getCampaignId();
							campaignDetails=campaignName.split("-");
							campaignName= (campaignDetails[0]!=null?campaignDetails[0]:"");
							campaignId= (campaignDetails[1]!=null?campaignDetails[1]:"");

							Pattern patern = Pattern.compile("\\[(.*?)\\]");
							Matcher matcher = patern.matcher(campaignId);

							if(matcher.find()) 
								campaignId=  matcher.group(1)!=null?matcher.group(1):"";
								System.err.println("Campaign Id :-->"+campaignId+",  campaignName:-->"+campaignName);
								ftpFileDetailsMap.put("CampaignName",campaignName );
								ftpFileDetailsMap.put("CampaignId",campaignId);
								refURL=refURL.concat(campaignId);
								System.err.println("campaignName: "+campaignName+" , campaignId:"+campaignId+" , refURL:"+refURL);
								inputStream =ftpClient.retrieveFileStream(fileName);
								System.err.println(" Reply Sring after Exe "+ftpClient.getReplyString()); 
								if(inputStream!=null){
									ftpFileContent=UccxUtility.getStringFromInputStream(inputStream);
									ftpFileDetailsMap.put("ftpFileContent",ftpFileContent);
									System.err.println("Converting Stream to String :--> "+ftpFileContent +"\n");
									tranformXMLContent=tranformXML(campaignName, refURL, ftpFileContent);
								}
								break;
						}else
							continue;
					}
					/*	//campaignName=campaignDetails[1];
					ftpFileDetailsMap.put("CampaignName",campaignName );
					campaignId=campaignDetails[2];
					campaignIdArray=campaignId.split("\\.");
					ftpFileDetailsMap.put("CampaignId",campaignIdArray[0]);
					refURL=refURL.concat(campaignIdArray[0]);
					System.err.println("campaignName: "+campaignName+" , campaignId:"+campaignIdArray[0]+" , refURL:"+refURL);
					inputStream =ftpClient.retrieveFileStream(fileName);
					System.err.println(" Reply Sring after Exe "+ftpClient.getReplyString()); 
					if(inputStream!=null){
						ftpFileContent=UccxUtility.getStringFromInputStream(inputStream);
						ftpFileDetailsMap.put("ftpFileContent",ftpFileContent);
						System.err.println("Converting Stream to String :--> "+ftpFileContent +"\n");
						tranformXMLContent=tranformXML(campaignName, refURL, ftpFileContent);
					}*/
				}
			}
			else
				System.err.println(".....  ");
		}catch(Exception e){
			System.err.println(e);
			tranformXMLContent= "";

		}finally {
			ftpFileContent=null;
			if(inputStream!=null){
				inputStream=null;
				try {
					ftpClient.completePendingCommand();
					ftpClient=null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(writer!=null){
				try {
					writer.close();
					writer=null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		ftpFileDetailsMap.put("csvFileContent",tranformXMLContent);
		return ftpFileDetailsMap;
	}

	public static void readFTPServerResponse(FTPClient ftpClient){
		String replyString=null;
		int replyCode=0;
		replyString =ftpClient.getReplyString();
		replyCode=ftpClient.getReplyCode();
		System.err.print("replyString:--> "+replyString+"\n ReplyCode:--> "+replyCode);
		if(!FTPReply.isPositiveCompletion(replyCode)) {
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.err.println("FTP server refused connection.");
			System.exit(1);
		}
	}
	public static void main(String[] args) {
		/*String str="administrator:Sp33chs0ft";
		System.err.println("Base64 :-- >"+convertToBase64(str));*/
		String xmlContent="Account Number, First Name, Last Name ,Phone1, Phone2, Phone3, Dial Time\nABCD1234, John , Doe, 1401111, 1402222, 1403333, 12:35\nABCD1235, Jane , Smith, 1504444, 1505555, 1506666, 12:35";
		PrintWriter writer=null;
		//		writeContentsToFile(xmlContent, "Camp1", "112");
	}

	public static String tranformXML(String campaignName, String refURL, String csvData) {
		String headerXML, bodyXMLContent, footerXML, footerXML2,newXMLContent,lineContent ;
		headerXML=bodyXMLContent=footerXML=footerXML2=lineContent=newXMLContent="";
		String [] csvRows=csvData.split("\\n");

		for (int i = 0; i < csvRows.length; i++) {
			lineContent = csvRows[i];
			newXMLContent = newXMLContent.concat(lineContent + '\n');
		}
		headerXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
				+ "<campaignContacts xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n"
				+" xsi:noNamespaceSchemaLocation=\"campaignContacts.xsd\">\n"
				+ "<campaign name=\"";

		bodyXMLContent="><refURL>";
		footerXML = "</refURL>\n</campaign>\n<csvdata>";
		footerXML2 = "</csvdata>\n</campaignContacts>";
		headerXML = headerXML.concat(campaignName.concat("\"")).concat(
				bodyXMLContent).concat(refURL).concat(footerXML).concat(
						newXMLContent).concat(footerXML2);
		return headerXML;
	}

	public static String getCurrentTimestamp(){
		String timeStamp=null;
		timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		System.err.println("timeStamp:--> "+timeStamp);
		return timeStamp ;
	}

	public static void writeContentsToFile(String fileContent,String campaignName,String campaignId ){
		System.err.println("Started Writing with writeContentsToFile");
		PrintWriter writer=null;
		String fileName=null;
		try {
			fileName=campaignName.concat("_").concat(campaignId).concat("_").concat(getCurrentTimestamp());
			System.err.println("fileName :-->"+fileName);
			writer = new PrintWriter(fileName, "UTF-8");
			writer.write(fileContent); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("Error While Writing File");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			System.err.println("Error While Writing File");
		}finally{
			writer.close();
			System.err.println("Done Writing File");
		}

	}

	public static Map<String,Boolean> deleteFTPFile(FTPClient ftpClient,String ftpServerURL,String ftpuser,String ftppassword){
		System.err.println("Inside deleteFTPFile()...!");
		boolean deleted=false;
		boolean statusCurrentDir=false;
		FTPFile [] uccxContactsFiles=null;
		String ftpFileName =null;
		Map<String,Boolean> deletedMapElements=new HashMap<String,Boolean>();

		try {
			ftpClient.connect(ftpServerURL);
			ftpClient.enterLocalPassiveMode();
			boolean login = ftpClient.login(ftpuser, ftppassword);

			readFTPServerResponse(ftpClient);
			statusCurrentDir = ftpClient.changeWorkingDirectory("/ftproot/UCCX_Contacts/Data");
			readFTPServerResponse(ftpClient);

			if (login) {
				System.err.println("Connection established...");
				uccxContactsFiles = ftpClient.listFiles("/ftproot/UCCX_Contacts/Data");

				if (uccxContactsFiles != null && uccxContactsFiles.length > 0){ 
					for(FTPFile ftpFile:uccxContactsFiles){
						ftpFileName = ftpFile.getName();
						deleted = ftpClient.deleteFile(ftpFileName);
						if (deleted) 
							System.err.println("The file "+ftpFileName+" was deleted successfully.");
						else 
							System.err.println("Could not delete the file : "+ftpFileName);
						deletedMapElements.put(ftpFileName, new Boolean(deleted ) );
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(ftpClient!=null){
					ftpClient.disconnect();
					ftpClient=null;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return deletedMapElements;
	}

}
