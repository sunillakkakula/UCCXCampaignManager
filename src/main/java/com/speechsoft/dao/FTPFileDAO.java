package com.speechsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.speechsoft.bean.FTPFileCampaignBean;
import com.speechsoft.processor.FTPServerConfguration;

public class FTPFileDAO extends AbstractDAO {

	public boolean createFTPFileCampaignMapping(String ftpFileName,String campaignName ){
		System.err.println("Inside createFTPFileCampaignMapping()..!!");
		Connection con=null;
		PreparedStatement pst=null;
		String createMappingQuery=FTPServerConfguration.CREATE_FTP_CAMPAIGN_MAPPING_QUERY;
		boolean operationStatus=false;
		try{
			con=getConnection();
			if(con!=null){
				pst=getPreparedStatement(con, createMappingQuery);
				if(pst!=null){
					pst.setString(1, ftpFileName);
					pst.setString(2, campaignName);
					operationStatus=pst.execute();
					con.commit();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			/*try {
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
		}finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				con=null;
			}
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pst=null;
			}
		}
		System.err.println("The Status from createFTPFileCampaignMapping()-->  "+operationStatus);
		return operationStatus;
	}
	public List<FTPFileCampaignBean> getAllFTPFileCampaignMappingInfo( ){
		System.err.println("Inside getAllFTPFileCampaignMappingInfo()..!!");
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet resultSet=null;
		List<FTPFileCampaignBean>  mappingFTPFileCampaignList =null;
		String getAllMappingQuery=FTPServerConfguration.GET_ALL_FTP_CAMPAIGN_MAPPING_QUERY;
		try{
			con=getConnection();
			if(con!=null){
				pst=getPreparedStatement(con, getAllMappingQuery);
				resultSet = pst.executeQuery();

				mappingFTPFileCampaignList=new ArrayList<FTPFileCampaignBean> ();
				while(resultSet !=null && resultSet .next())
				{
					FTPFileCampaignBean ftpFileCampaignBean=new FTPFileCampaignBean();
					ftpFileCampaignBean.setFtpFileName(resultSet.getString(1));
					ftpFileCampaignBean.setCampaignId(resultSet.getString(2));
					mappingFTPFileCampaignList.add(ftpFileCampaignBean);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				con=null;
			}
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pst=null;
			}
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				resultSet=null;
			}
		}
		System.err.println("The mappingFTPFileCampaignList Size is "+mappingFTPFileCampaignList.size());
		return mappingFTPFileCampaignList;
	}
}
