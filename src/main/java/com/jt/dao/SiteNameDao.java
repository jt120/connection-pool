package com.jt.dao;

import java.util.List;

import com.jt.model.SiteName;

/**
 * @author Liu Ze
 *
 * Create Date Mar 24, 2014 9:07:58 PM
 */

public class SiteNameDao extends BaseDao <SiteName> implements ISiteNameDao {

	@Override
	public void add(SiteName siteName) {
		super.add(siteName);
	}

	@Override
	public List<SiteName> list() {
		return null;
	}

	@Override
	public List<SiteName> loadByName(String siteName) {
		return super.load(SiteName.class.getName()+".loadByName", siteName);
	}

}
