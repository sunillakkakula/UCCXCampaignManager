package com.speechsoft.controller;

import java.util.List;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.speechsoft.processor.FTPServerConfguration;
import com.speechsoft.service.FTPFileService;
import com.speechsoft.bean.FTPFileCampaignBean;
import com.speechsoft.processor.FTPFileServerProcessor;

//@RequestMapping(value = "/Outbound")
@Controller
public class FTPFileController {

	@ModelAttribute("ftpCampaignCommandBean")
	public FTPFileCampaignBean construct(){
		return new FTPFileCampaignBean ();
	}

	@RequestMapping(value = "/ftpfileslist",method=RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<String> getFTPFilesList()
	{
		System.err.println("Inside getFTPFilesList..!");
		FTPClient ftpClient=null;
		List <String> ftpFilesList = null;

		ftpClient =FTPFileServerProcessor.getFTPClient();
		ftpFilesList =FTPFileServerProcessor.getFTPFilesList(ftpClient, FTPServerConfguration.ftpURL, FTPServerConfguration.ftpUser, FTPServerConfguration.ftpPwd);

		if(ftpFilesList !=null)
			System.err.println("FTPFilesList Size :--> "+ftpFilesList .size());
		else
			System.err.println("FTPFilesList Size is 0");

		System.err.println("Exiting getFTPFilesList..!");
		return ftpFilesList ;
	}

	/*@RequestMapping(value="/configureftppath",method=RequestMethod.GET)
	public ModelAndView configureFtpFileToCampaign(ModelMap map){
		System.err.println("Inside configureFtpFileToCampaign..!");
		String targetURL=null;
		ModelAndView model=new ModelAndView();
		logFilesList=UccxIOUtility.listUccxLogFiles("\\D:/Projects/UCCXOutbound_BackupFiles");
		model.addObject("LogFiles",logFilesList);
		try {
			targetURL="configureftppath";
		}
		catch(Exception e)
		{
			System.out.println("GENERIC Exception " +e);
			targetURL= "errorpage";
		}
		model.setViewName(targetURL);
		System.err.println("Exiting  configureFtpFileToCampaign..!");
		return model;
	}*/

	/*@RequestMapping(value="/mapftpfilecampaign/{ftpFileName}/{campaignName}/",method=RequestMethod.GET)
	public ModelAndView mapFTPFileCampaign(@PathVariable("ftpFileName") String ftpFileName,@PathVariable("campaignName") String campaignName,ModelMap modelMap,HttpServletRequest request){
		System.err.println("Inside mapFTPFileCampaign : campaignName:==> "+campaignName+", ftpFileName:"+ftpFileName);
		String targetURL="";
		ModelAndView model=new ModelAndView();
		//		System.out.println(" FTP File Name : " + bean.getFtpFileName()+", Campaign :"+bean.getCampaignName());
		FTPFileService ftpFileService=new FTPFileService();
				status=ftpFileService.mapFTPFileToCampaign(fileName, campaignName);
		System.err.println("Exiting  configureFtpFileToCampaign..! status:--> "+status);
		if(status)
			return "TRUE";
		else
			return "FALSE";
		targetURL="mapftpfilecampaign";
		model.setViewName(targetURL);
		System.err.println("Exiting  mapFTPFileCampaign..!");
		return model;
	}*/

	@ModelAttribute("ftpCampaignBean")
	public  FTPFileCampaignBean saveFileCampaign(FTPFileCampaignBean ftpFileCampaignBean ) {
		System.err.println("Inside saveFileCampaign..!");
		System.out.println(" FtpFileName: " + ftpFileCampaignBean.getFtpFileName()+", Campaign Name :"+ftpFileCampaignBean.getCampaignId());
		System.err.println("Exiting saveFileCampaign..!");
		return ftpFileCampaignBean;

	}

	@RequestMapping(value = "/configureftppath")
	public  FTPFileCampaignBean saveMappingInfo(@ModelAttribute("ftpCampaignCommandBean") FTPFileCampaignBean ftpFileCampaignBean ) {
		System.err.println("Inside saveMappingInfo..!");
		boolean status=false;
		String fileName,campaignName;
		fileName=campaignName=null;

		if(ftpFileCampaignBean!=null) {
			fileName=ftpFileCampaignBean.getFtpFileName();
			campaignName=ftpFileCampaignBean.getCampaignId();			
		}
		if(fileName!=null && fileName.length()>0 && campaignName!=null && campaignName.length()>0){
			System.err.println(" saveMappingInfo.--> FtpFileName: " + fileName+", :"+campaignName);
			FTPFileService ftpFileService=new FTPFileService();
			status=ftpFileService.mapFTPFileToCampaign(fileName, campaignName);
			return ftpFileCampaignBean;
		}else 
			System.err.println("This is the First Invocation...!");
		System.err.println("Exiting saveMappingInfo with Status..!"+status);
		return ftpFileCampaignBean;
	}
}
