package com.speechsoft.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class TestFTPClientWriter {
	private static void readFTPServerResponse(FTPClient ftpClient){
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
		String ftpServerURL = "10.1.6.253";
		int port = 21;
		String ftpuser = "ftpuser";
		String ftppassword = "ftpuser";
		boolean statusCurrentDir=false;
		boolean successFlag=false;
		boolean deleteFlag=false;
		FTPClient ftpClient = new FTPClient();
		FTPFile[] uccxContactsFiles=null; 
		try {

			ftpClient.connect(ftpServerURL);
			ftpClient.enterLocalPassiveMode();
			boolean login = ftpClient.login(ftpuser, ftppassword);

			readFTPServerResponse(ftpClient);
			statusCurrentDir = ftpClient.changeWorkingDirectory("/ftproot/UCCX_Contacts/Data");
			readFTPServerResponse(ftpClient);
			uccxContactsFiles = ftpClient.listFiles("/ftproot/UCCX_Contacts/Data");

			if (uccxContactsFiles != null && uccxContactsFiles.length > 0){ 
				System.err.println("List of uccxContactsFiles Files :"+uccxContactsFiles.length);
//				backupCSVFile(uccxContactsFiles, ftpClient);
				for(FTPFile ftpFile:uccxContactsFiles){
					System.err.println("List of Files :"+uccxContactsFiles.length);
					String fileName=ftpFile.getName();
					deleteFlag=deleteFTPFile(ftpClient, fileName);
					System.err.println("DElete Status:--> "+deleteFlag);
				}
//				deleteFTPFile(ftpClient, ftpFileName)
			}

			// Creates a directory
			/*String dirToCreate = "/ftproot/UCCX_Contacts/backup";
			successFlag = ftpClient.makeDirectory(dirToCreate);
			readFTPServerResponse(ftpClient);
			if (successFlag) {
				System.out.println("Successfully created directory: " + dirToCreate);
			} else {
				System.out.println("Failed to create directory. See server's reply.");
			}*/
			ftpClient.logout();
			ftpClient.disconnect();
		} catch (IOException ex) {
			System.out.println("Oops! Something wrong happened");
			ex.printStackTrace();
		}
	} 
	public static boolean  backupCSVFile(FTPFile[] uccxContactsFiles, FTPClient ftpClient){
		System.err.println("Started doing backupCSVFile");
		String fileName=null;
		boolean status=false;
		String campaignName,campaignId=null;
		boolean statusCurrentDir=false;
		String [] campaignDetails=null;
		InputStream inputStream=null;
		String ftpFileContent=null;
		try {

			if (uccxContactsFiles != null && uccxContactsFiles.length > 0) { 
				for(FTPFile ftpFile:uccxContactsFiles){
					System.err.println("List of Files :"+uccxContactsFiles.length);
					fileName=ftpFile.getName();
					System.err.println("File Name: "
							+ fileName
							+ " File Size: "
							+ FileUtils.byteCountToDisplaySize(ftpFile.getSize()));
					campaignDetails=fileName.split("_");
					campaignName=campaignDetails[1];
					campaignId=campaignDetails[2];
					System.err.println("campaignName: "+campaignName+" , campaignId:"+campaignId);
					inputStream =ftpClient.retrieveFileStream(fileName);
					ftpFileContent=UccxUtility.getStringFromInputStream(inputStream);
					fileName=campaignName.concat("_").concat(campaignId).concat("_").concat(getCurrentTimestamp());
					System.err.println("fileName :-->"+fileName);

/*					try (Writer writer = new BufferedWriter(new OutputStreamWriter(
							new FileOutputStream(fileName), "utf-8"))) {
						writer.write(ftpFileContent);

					}catch (Exception e) {
						// TODO: handle exception
					}*/
//					System.err.println(" Reply Sring after Exe "+ftpClient.getReplyString());

					/*if(inputStream!=null){
						ftpClient.setFileType(FTP.LOCAL_FILE_TYPE);//binary files
						statusCurrentDir = ftpClient.changeWorkingDirectory("/ftproot/UCCX_Contacts/Data_BKP");
						readFTPServerResponse(ftpClient);
						fileName=campaignName.concat("_").concat(campaignId).concat("_").concat(getCurrentTimestamp());
						System.err.println("fileName :-->"+fileName);
						status=ftpClient.storeFile("sample_bkp", inputStream);
					}*/
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.err.println("backupCSVFile Status: "+status);
		return status;
	}
	public static String getCurrentTimestamp(){
		String timeStamp=null;
		timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		System.err.println("timeStamp:--> "+timeStamp);
		return timeStamp ;
	}

	public static void backupLocally(String content){

		/*try (Writer writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("filename.txt"), "utf-8"))) {
			writer.write(content);

		}catch (Exception e) {
			// TODO: handle exception
		}*/
	}
	
	public static boolean deleteFTPFile(FTPClient ftpClient,String ftpFileName){
		boolean deleted=false;
		try {
			deleted = ftpClient.deleteFile(ftpFileName);
			if (deleted) {
				System.out.println("The file was deleted successfully.");
			} else {
				System.out.println("Could not delete the file.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return deleted;
	}
}

