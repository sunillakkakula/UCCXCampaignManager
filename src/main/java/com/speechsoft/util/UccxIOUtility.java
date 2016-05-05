package com.speechsoft.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.speechsoft.bean.LogFile;

public class UccxIOUtility {
	private static final Logger logger = Logger.getLogger(UccxIOUtility.class);
	public static void main(String[] args) {
		listUccxLogFiles("\\D:/Projects/UCCXOutbound_BackupFiles");
	}
	public static List<LogFile>  listUccxLogFiles(String dirPath){
		logger.info("Exec.. IN listUccxLogFiles() , dirPath:--> "+dirPath);
		File folder = null;
		File[] listOfFiles = null;
		//		Map<String, File> uccxLogFilesMap=new HashMap<String,File>();
		List<LogFile> uccxLogFiles=new ArrayList<LogFile>();
		LogFile logFile=null;
		try{
			System.err.println("Inside listTheFiles..!");
			folder = new File(dirPath);
			listOfFiles = folder.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				logFile=new LogFile();
				if (listOfFiles[i].isFile()) {
					System.err.println("File " + listOfFiles[i].getName());
					logFile.setFileName(listOfFiles[i].getName());
					logFile.setLogFile(listOfFiles[i]);
				} else if (listOfFiles[i].isDirectory()) {
					System.err.println("Directory " + listOfFiles[i].getName());
				}
				uccxLogFiles.add(logFile);
			}
			logger.info("Exec.. OUT listUccxLogFiles() , uccxLogFiles:--> "+uccxLogFiles);
			return uccxLogFiles;
		}catch(Exception e){
			logger.info("Exec.. CATCG listUccxLogFiles() ");
			return null;
		}
	}
}