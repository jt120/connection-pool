package com.jt.model;

/**
 * @author Liu Ze
 *
 * Create Date Mar 7, 2014 10:17:21 AM
 */

public class SiteName {
	
	private String id;
	
	private String siteName;
	
	private String siteUrl;
	
	private String siteAddress;
	
	private String createDate;
	
	private String updateDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getSiteUrl() {
		return siteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	public String getSiteAddress() {
		return siteAddress;
	}

	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public SiteName(String siteName, String siteUrl, String siteAddress,
			String createDate) {
		super();
		this.siteName = siteName;
		this.siteUrl = siteUrl;
		this.siteAddress = siteAddress;
		this.createDate = createDate;
	}
	
	public SiteName() {}
}
