package com.speechsoft.util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestXMLWriter {
	public static void main(String[] args) {
		String fileName=null;
		String xmlContent="Account Number, First Name, Last Name ,Phone1, Phone2, Phone3, Dial Time\nABCD1234, John , Doe, 1401111, 1402222, 1403333, 12:35\nABCD1235, Jane , Smith, 1504444, 1505555, 1506666, 12:35";
		PrintWriter writer=null;
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		System.err.println("timeStamp:--> "+timeStamp);
		 fileName="C1".concat("_").concat("111").concat("_".concat(timeStamp)).concat(".txt");
		try {
			System.err.println("Started Writing with TestXMLWriter");
			writer = new PrintWriter(fileName, "UTF-8");
			writer.write(xmlContent);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			writer.println("The first line");
			writer.println("The second line");
			writer.close();
			System.err.println("Done Writing File");
		}
	}
}
