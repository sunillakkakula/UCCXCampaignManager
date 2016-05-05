package com.speechsoft.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class FtpFileProcessor {
	private static final int BUFFER_SIZE = 4096;

	public static void main(String[] args) {
		String ftpUrl = "ftp://%s:%s@%s/%s;type=i";
		String host = "183.82.101.254";
		String user = "gvraju";
		String pass = "gvraju";
		String filePath = "testfiles/DATA_CSV.csv";

		ftpUrl = String.format(ftpUrl, user, pass, host, filePath);
		System.err.println("URL: " + ftpUrl);

		try {
			URL url = new URL(ftpUrl);
			URLConnection conn = url.openConnection();
			InputStream inputStream = conn.getInputStream();
			//FileOutputStream outputStream = new FileOutputStream(savePath);
			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead = -1;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				//  outputStream.write(buffer, 0, bytesRead);
				System.err.println(""+inputStream.read(buffer));
				//	            	System.out.println(""+new String(inputStream.read(buffer)));
			}
			//	            outputStream.close();
			inputStream.close();
			System.out.println("File downloaded");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		System.err.println("Done Processing : " );
	}
}
