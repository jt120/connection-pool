package com.jt.dao;

import java.util.List;

import com.jt.model.SiteName;

/**
 * @author Liu Ze
 *
 * Create Date Mar 24, 2014 9:12:55 PM
 */

public interface ISiteNameDao {
	public void add(SiteName siteName);
	public List<SiteName> list();
	public List<SiteName> loadByName(String siteName);
}
