package com.speechsoft.service;

import java.util.List;

import com.speechsoft.bean.FTPFileCampaignBean;
import com.speechsoft.dao.FTPFileDAO;

public class FTPFileService {

	public boolean mapFTPFileToCampaign(String ftpFileName,String campaignId){
		boolean flag=false;
		FTPFileDAO ftpFileDAO=new FTPFileDAO();
		flag= ftpFileDAO.createFTPFileCampaignMapping(ftpFileName, campaignId);
		return flag;
	}
	public List<FTPFileCampaignBean> mappingFTPCampaignList(){
		List<FTPFileCampaignBean> ftpFileCampaignBeanList=null;
		FTPFileDAO ftpFileDAO=new FTPFileDAO();
		ftpFileCampaignBeanList= ftpFileDAO.getAllFTPFileCampaignMappingInfo();
		return ftpFileCampaignBeanList;
	}

}
