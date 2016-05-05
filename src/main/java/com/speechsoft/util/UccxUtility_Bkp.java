package com.speechsoft.util;

import org.apache.commons.codec.binary.Base64;

public class UccxUtility_Bkp {
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

}
