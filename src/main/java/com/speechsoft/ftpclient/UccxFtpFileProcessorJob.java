package com.speechsoft.ftpclient;

import java.util.Map;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.speechsoft.processor.UccxContactsProcessor;
import com.speechsoft.util.*;

public class UccxFtpFileProcessorJob implements Job{
	//	public static FTPClient ftpClient;
	public static String  ftpUser="ftpuser";
	public static String ftpPwd="ftpuser";
	public static String ftpURL="10.1.6.253";
	public static FTPClientConfig ftpClientConfig =null;

	private static FTPClient getFTPClient(){
		FTPClient ftpClient=null;
		ftpClientConfig = new FTPClientConfig(FTPClientConfig.SYST_UNIX);
		ftpClient = new FTPClient();
		ftpClient.configure(ftpClientConfig);
		return ftpClient; 
	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		Map<String,String> csvMapContent=null;
		System.err.println("Hi from Execute () of SSFtpFileProcessorJob...! ");
		FTPClient ftpClient=null;
		try {
			ftpClient=getFTPClient();
			csvMapContent=UccxUtility.processCSVFile(ftpClient,ftpURL,ftpUser,ftpPwd);
			if(csvMapContent!=null){
				UccxContactsProcessor uccxProcessor=new UccxContactsProcessor (); 
				uccxProcessor.doAddContactsAsCron(csvMapContent,ftpClient,ftpURL,ftpUser,ftpPwd);
			//	fileContent = csvMapContent.get("ftpFileContent");
			}
			/*//Doing backup
			UccxUtility.backupCSVFile(getFTPClient(), ftpURL, ftpUser, ftpPwd, fileContent);
			//Deleting FTP File
			UccxUtility.deleteFTPFile(getFTPClient(), ftpURL,ftpUser,ftpPwd);*/
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.err.println("Exit from Execute () of SSFtpFileProcessorJob...! ");
		}
	}

	public static void main(String args[]) {
		try {
			ftpClientConfig = new FTPClientConfig(FTPClientConfig.SYST_UNIX);
			/*	ftpClient = new FTPClient();
			ftpClient.configure(ftpClientConfig);
			UccxUtility.processCSVFile(ftpClient,ftpURL,ftpUser,ftpPwd);*/
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}




}

