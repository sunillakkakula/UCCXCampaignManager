package com.speechsoft.bean;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Campaign {
	@JsonProperty("campaign")
	private Map<String,String> campaignMap;
	
	@JsonProperty("csvdata")
	private String csvData;
	
	
	public String getCsvData() {
		return csvData;
	}
	public void setCsvData(String csvData) {
		this.csvData = csvData;
	}
	public Map<String,String> getCampaign() {
		return campaignMap;
	}
	public void setCampaign(Map<String,String> campaignMap) {
		this.campaignMap = campaignMap;
	}
	
	
	@Override
	public String toString() {
		return "Campaign [campaignMap=" + campaignMap + ", csvData=" + csvData + "]";
	}
	
	
	
}
