package com.speechsoft.bean;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CampaignBean {
	/*@JsonProperty("type")
	private String type;*/

	@JsonProperty("campaign")
	private List<CampaignDetails> campaignDetailsList;

	public List<CampaignDetails> getCampaignDetailsList() {
		return campaignDetailsList;
	}

	public void setCampaignDetailsList(List<CampaignDetails> campaignDetailsList) {
		this.campaignDetailsList = campaignDetailsList;
	}
	
/*	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}*/


	@Override
	public String toString() {
		return "CampaignBean [CampaignDetailsList=" + this.campaignDetailsList + "]";
	}
	
	
	
}
