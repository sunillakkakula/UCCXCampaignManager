package com.speechsoft.bean;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CampaignDetails {
	@JsonProperty("self")
	private String self;
	@JsonProperty("campaignId")
	private String campaignId;
	@JsonProperty("campaignName")
	private String campaignName;
	@JsonProperty("enabled")
	private String enabled;
	@JsonProperty("description")
	private String description;
	@JsonProperty("startTime")
	private String startTime;
	@JsonProperty("endTime")
	private String endTime;
	@JsonProperty("timeZone")
	private String timeZone;
	@JsonProperty("campaignType")
	private String campaignType;
	@JsonProperty("dialerType")
	private String dialerType;
	@JsonProperty("pendingContacts")
	private String pendingContacts;
	public String getSelf() {
		return self;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	public String getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	public String getCampaignType() {
		return campaignType;
	}
	public void setCampaignType(String campaignType) {
		this.campaignType = campaignType;
	}
	public String getDialerType() {
		return dialerType;
	}
	public void setDialerType(String dialerType) {
		this.dialerType = dialerType;
	}
	public String getPendingContacts() {
		return pendingContacts;
	}
	public void setPendingContacts(String pendingContacts) {
		this.pendingContacts = pendingContacts;
	}
	@Override
	public String toString() {
		return "CampaignDetails [self=" + self + ", campaignId=" + campaignId + ", campaignName=" + campaignName
				+ ", startTime=" + startTime + ", campaignType=" + campaignType + "]";
	}


}
