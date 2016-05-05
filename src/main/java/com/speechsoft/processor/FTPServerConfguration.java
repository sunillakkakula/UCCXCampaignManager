package com.speechsoft.processor;

public interface FTPServerConfguration {
	public String  ftpUser="ftpuser";
	public String ftpPwd="ftpuser";
	public String ftpURL="10.1.6.253";
	public String CREATE_FTP_CAMPAIGN_MAPPING_QUERY="INSERT INTO UCCX_Outbound.dbo.FTPFILE_CAMPAIGN_MAPPER_TAB VALUES (?,?)";
	public String READ_FTP_CAMPAIGN_MAPPING_QUERY="SELECT * FROM UCCX_Outbound.dbo.FTPFILE_CAMPAIGN_MAPPER_TAB  WHERE ftpFileName LIKE '?%'";
	public String GET_ALL_FTP_CAMPAIGN_MAPPING_QUERY="SELECT * FROM UCCX_Outbound.dbo.FTPFILE_CAMPAIGN_MAPPER_TAB";
	
}
