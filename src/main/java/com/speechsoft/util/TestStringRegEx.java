package com.speechsoft.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestStringRegEx {
	public static String campaignId=null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		campaignId="[Sunil]";
		Pattern patern = Pattern.compile("\\[(.*?)\\]");

		Matcher matcher = patern.matcher(campaignId);

		if(matcher.find()) 
			campaignId=  matcher.group(1)!=null?matcher.group(1):"";
			System.err.println("campaignId:"+matcher.group(1));


			String in = "Item(s): [item1.test],[item2.qa],[item3.production]";

			Pattern p = Pattern.compile("\\[(.*?)\\]");
			Matcher m = p.matcher(in);

			while(m.find()) {
				System.out.println(m.group(1));
			}

			String str="\\{testholger272016_02_03_21_57_36}\\";
			Pattern p1 = Pattern.compile("\\{([^}]*)\\}");
			Matcher m1 = p1.matcher(str);
			while (m1.find()) {
				System.out.println(m1.group(1));
			}
			String fileNm="{SUNIL}";
			int startIndex= fileNm.indexOf("{");
			int endIndex= fileNm.indexOf("}");
			startIndex=(startIndex>=0)?startIndex+1:0;
			endIndex=(endIndex>=0)?fileNm.length()-1:fileNm.length();
			
			System.err.println("startIndex : "+startIndex+",endIndex"+endIndex);
			fileNm = fileNm.substring(startIndex, endIndex);
//			fileNm = fileNm.substring(fileNm.indexOf("{") + 1, fileNm.indexOf("}"));
			System.err.println("fileName : "+fileNm);
	}

}
