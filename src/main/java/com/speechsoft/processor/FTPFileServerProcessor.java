package com.speechsoft.processor;

import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import com.speechsoft.util.UccxUtility;

public class FTPFileServerProcessor {
	//	public static FTPClient ftpClient;
	public static String  ftpUser="ftpuser";
	public static String ftpPwd="ftpuser";
	public static String ftpURL="10.1.6.253";
	public static FTPClientConfig ftpClientConfig =null;
	private List<String> ftpFilesList=null;

	public static FTPClient getFTPClient(){
		FTPClient ftpClient=null;
		ftpClientConfig = new FTPClientConfig(FTPClientConfig.SYST_UNIX);
		ftpClient = new FTPClient();
		ftpClient.configure(ftpClientConfig);
		return ftpClient; 
	}

	public static List<String> getFTPFilesList(FTPClient ftpClient,String ftpServerURL,String ftpuser,String ftppassword){
		boolean statusCurrentDir=false;
		FTPFile[] uccxContactsFiles =null;
		List<String> ftpFilesList =null;
		String ftpFileName=null;

		try {
			ftpClient.connect(ftpServerURL);
			ftpClient.enterLocalPassiveMode();
			boolean login = ftpClient.login(ftpuser, ftppassword);

			UccxUtility.readFTPServerResponse(ftpClient);
			statusCurrentDir = ftpClient.changeWorkingDirectory("/ftproot/UCCX_Contacts/Data");
			UccxUtility.readFTPServerResponse(ftpClient);

			if (login) {
				System.err.println("Connection established...");
				uccxContactsFiles = ftpClient.listFiles("/ftproot/UCCX_Contacts/Data");

				if (uccxContactsFiles != null && uccxContactsFiles.length > 0){ 
					ftpFilesList=new ArrayList<String>();
					System.err.println("List of uccxContactsFiles Files :"+uccxContactsFiles.length);
					for(FTPFile ftpFile:uccxContactsFiles){
						ftpFileName=(ftpFile.getName()!=null?ftpFile.getName():"");
						ftpFilesList.add(ftpFileName);
					}
				}
				else
					System.err.println("No uccxContactsFiles Files  to Process..!  :)");
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				//				backupCSVFile(uccxContactsFiles, ftpClient);
				System.err.println("Disconnecting The FTP Connection");
				ftpClient.disconnect();
				ftpClient=null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ftpFilesList;
	}


}
