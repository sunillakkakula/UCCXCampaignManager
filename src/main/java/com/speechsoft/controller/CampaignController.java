package com.speechsoft.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.speechsoft.bean.Campaign;
import com.speechsoft.bean.LogFile;
import com.speechsoft.bean.UserDetails;
import com.speechsoft.util.UccxIOUtility;

@Controller
public class CampaignController {
	private static final Logger logger = Logger.getLogger(CampaignController.class);
	@RequestMapping(value="/editcampaigns",method=RequestMethod.GET)//,produces = "application/xml")
	public ModelAndView editCampaigns(ModelMap map){
		logger.info("Exec.. IN editCampaigns()");
		String targetURL=null;
		ModelAndView model=new ModelAndView();

		System.err.println("Inside getCampaigns..!");
		try {
			targetURL="editcampaigns";
		}
		catch(Exception e)
		{
			System.out.println("GENERIC Exception " +e);
			targetURL= "errorpage";
		}
		model.setViewName(targetURL);
		logger.info("Exec.. OUT editCampaigns()");
		return model;
	}
	
	
	@RequestMapping(value="/editcampaigndetails",method=RequestMethod.GET)//,produces = "application/xml")
	public ModelAndView editCampaignDetails(@RequestParam String campaignId, Model model){
		String targetURL=null;
		
		ModelAndView mv=new ModelAndView();

		System.err.println("Inside editCampaignDetails..! campaignId :--> "+campaignId);
		try {
			targetURL="modifycampaigndetails";
		}
		catch(Exception e)
		{
			System.out.println("GENERIC Exception " +e);
			targetURL= "errorpage";
		}
		mv.setViewName(targetURL);
		return mv;
	}

	@RequestMapping(value="/modifycampaigndetails",method=RequestMethod.GET)//,produces = "application/xml")
	public ModelAndView modifyCampaignDetails(@RequestParam String campaignId, Model model){
		logger.info("Exec.. IN modifyCampaignDetails()");
		String targetURL=null;
		
		ModelAndView mv=new ModelAndView();

		System.err.println("Inside modifyCampaignDetails..! campaignId :--> "+campaignId);
		try {
			targetURL="modifycampaigndetails";
		}
		catch(Exception e)
		{
			System.out.println("GENERIC Exception " +e);
			targetURL= "errorpage";
		}
		mv.setViewName(targetURL);
		logger.info("Exec.. OUT  modifyCampaignDetails()");
		return mv;
	}


	@RequestMapping(value="/addcampaign",method=RequestMethod.GET)//,produces = "application/xml")
	public ModelAndView createCampaign(ModelMap map){
		String targetURL=null;
		ModelAndView model=new ModelAndView();

		System.err.println("Inside createCampaign..!");
		try {
			targetURL="addcampaign";
		}
		catch(Exception e)
		{
			System.out.println("GENERIC Exception " +e);
			targetURL= "errorpage";
		}
		model.setViewName(targetURL);
		return model;
	}

	@RequestMapping(value="/contactshistory",method=RequestMethod.GET)
	public ModelAndView contactsHistory(ModelMap map){
		logger.info("Exec.. IN contactsHistory()");
		String targetURL=null;
//		Map<String, File>  logFilesMap=null;
		List<LogFile> logFilesList=null;
		ModelAndView model=new ModelAndView();
		logFilesList=UccxIOUtility.listUccxLogFiles("\\E:/Projects/UCCXOutbound_BackupFiles");
		if(logFilesList!=null&& logFilesList.size()>0)
			logger.info("logFilesList is Not Empty : Size :--> "+logFilesList.size());
		else
			logger.info("logFilesList is NULL");
		
		model.addObject("LogFiles",logFilesList);
		System.err.println("Inside contactsHistory..!");
		try {
			targetURL="contactshistory";
		}
		catch(Exception e)
		{
			System.out.println("GENERIC Exception " +e);
			targetURL= "errorpage";
		}
		model.setViewName(targetURL);
		logger.info("Exec.. OUT contactsHistory()");
		return model;
	}

	@RequestMapping(value="/addcontacts",method=RequestMethod.GET)//,produces = "application/xml")
	public ModelAndView addcontacts(ModelMap map){
		String targetURL=null;
		ModelAndView model=new ModelAndView();

		System.err.println("Inside addcontacts..!");
		try {
			targetURL="addcontacts";
		}
		catch(Exception e)
		{
			System.out.println("GENERIC Exception " +e);
			targetURL= "errorpage";
		}
		model.setViewName(targetURL);
		return model;
	}

	@RequestMapping(value="listcampaigns",method=RequestMethod.GET)//,produces = "application/xml")
	public ModelAndView listCampaigns(ModelMap map){
		logger.info("Exec.. IN listcampaigns()");
		String targetURL=null;
		ModelAndView model=new ModelAndView();
		List<LogFile> logFilesList=null;

		System.err.println("Inside listCampaigns..!");
		try {
			targetURL="listcampaigns";
			logFilesList=UccxIOUtility.listUccxLogFiles("\\D:/Projects/UCCXOutbound_BackupFiles");
			model.addObject("LogFiles",logFilesList);
		}
		catch(Exception e)
		{
			System.out.println("GENERIC Exception " +e);
			targetURL= "errorpage";
		}
		model.setViewName(targetURL);
		logger.info("Exec.. OUT listcampaigns()");
		return model;
	}
	
	
	@RequestMapping(value="/resetcampaign",method=RequestMethod.GET)//,produces = "application/xml")
	public ModelAndView deleteCampaignContacts(ModelMap map){
		String targetURL=null;
		ModelAndView model=new ModelAndView();

		System.err.println("Inside deleteCampaignContacts..!");
		try {
			targetURL="resetcampaign";
		}
		catch(Exception e)
		{
			System.out.println("GENERIC Exception " +e);
			targetURL= "errorpage";
		}
		model.setViewName(targetURL);
		return model;
	}
	@RequestMapping(value="/testtimepicker",method=RequestMethod.GET)//,produces = "application/xml")
	public ModelAndView testTimePicker(ModelMap map){
		String targetURL=null;
		ModelAndView model=new ModelAndView();

		System.err.println("Inside testTimePicker..!");
		try {
			targetURL="testtimepicker";
		}
		catch(Exception e)
		{
			System.out.println("GENERIC Exception " +e);
			targetURL= "errorpage";
		}
		model.setViewName(targetURL);
		return model;
	}
	
}
