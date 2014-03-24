package com.jt.model;

/**
 * @author Liu Ze
 *
 * Create Date Mar 7, 2014 2:21:12 PM
 */

public class User {
	
	private String id;
	//机构名称
	private String nickname;
	//机构类型
	private String orgType;
	//机构地址
	private String orgAddress;
	//机构介绍
	private String orgProfile;
	//机构职能
	private String orgFunction;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getOrgAddress() {
		return orgAddress;
	}

	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}

	public String getOrgFunction() {
		return orgFunction;
	}

	public void setOrgFunction(String orgFunction) {
		this.orgFunction = orgFunction;
	}

	public String getOrgProfile() {
		return orgProfile;
	}

	public void setOrgProfile(String orgProfile) {
		this.orgProfile = orgProfile;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nickname=" + nickname + ", orgType="
				+ orgType + ", orgAddress=" + orgAddress + ", orgProfile="
				+ orgProfile + ", orgFunction=" + orgFunction + "]";
	}
}
