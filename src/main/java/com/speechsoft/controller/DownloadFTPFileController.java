package com.speechsoft.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.speechsoft.bean.LogFile;
import com.speechsoft.util.UccxIOUtility;

//@RequestMapping("/Outbound")
@Controller
public class DownloadFTPFileController {

	@RequestMapping(value = "/downloadftpfile/{fileName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getUser(@PathVariable("fileName") String fileName,HttpServletResponse response) {
		System.out.println("Fetching FTP File with Name:--> " + fileName);
		File file = null;
		InputStream is = null;
		String baseFileName="D:\\Projects\\UCCXOutbound_BackupFiles\\";
		try {
			/*int startIndex= fileName.indexOf("{");
			int endIndex=fileName.indexOf("}");
			System.err.println("startIndex : "+startIndex+",endIndex"+endIndex);
			fileName = fileName.substring(fileName.indexOf("{") + 1, fileName.indexOf("}")-1);*/
			int startIndex= fileName.indexOf("{");
			int endIndex= fileName.indexOf("}");
			startIndex=(startIndex>=0)?startIndex+1:0;
			endIndex=(endIndex>=0)?fileName.length()-1:fileName.length();
			fileName = fileName.substring(startIndex, endIndex);
			
			fileName=baseFileName.concat(fileName).concat(".csv");
			file = new File(fileName);
			is = new FileInputStream(file);

			// MIME type of the file
		/*	response.setContentType("application/octet-stream");
			// Response header
			response.setHeader("Content-Disposition", "attachment; filename=\""
					+ file.getName() + "\"");
			// Read from the file and write into the response
			OutputStream os = response.getOutputStream();
			byte[] buffer = new byte[1024];
			int len;
			while ((len = is.read(buffer)) != -1) {
				os.write(buffer, 0, len);
			}
			os.flush();
			os.close();
			is.close();*/
			
			//response.setContentType("text/html");  
			/*String filename = "home.jsp";   
			String filepath = "e:\\";   */
			response.setContentType("application/octet-stream");
//			PrintWriter out = response.getWriter();
			response.setHeader("Content-Disposition", "attachment; filename=\""
					+ file.getName() + "\"");
			//response.setHeader("Content-Disposition","attachment; filename=\"" + fileName + "\"");   
			  
//			FileInputStream fileInputStream = new FileInputStream(fileName);  
			            
			OutputStream os = response.getOutputStream();
			byte[] buffer = new byte[1024];
			int len;
			while ((len = is.read(buffer)) != -1) {
				os.write(buffer, 0, len);
			}
			os.flush();
			os.close();
			is.close(); 
			System.err.println("Done with Writing the Content to OUTput Stream/ Download");
		}
		catch(Exception e)
		{
			System.out.println("GENERIC Exception " +e);
		}

		return new ResponseEntity<String>(fileName, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/downloadtest", method = RequestMethod.GET)
	public void download(HttpServletResponse response) throws IOException {

		File file = new File("D:\\Projects\\UCCXOutbound_BackupFiles\\test.txt");
		InputStream is = new FileInputStream(file);

		// MIME type of the file
		response.setContentType("application/octet-stream");
		// Response header
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ file.getName() + "\"");
		// Read from the file and write into the response
		OutputStream os = response.getOutputStream();
		byte[] buffer = new byte[1024];
		int len;
		while ((len = is.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}
		os.flush();
		os.close();
		is.close();
	}

}
