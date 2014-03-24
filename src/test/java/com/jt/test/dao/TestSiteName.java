package com.jt.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.jt.dao.ISiteNameDao;
import com.jt.dao.SiteNameDao;
import com.jt.model.SiteName;

/**
 * @author Liu Ze
 *
 * Create Date Mar 24, 2014 9:12:26 PM
 */

public class TestSiteName {
	
	ISiteNameDao siteNameDao = new SiteNameDao();
	
	@Test
	public void testAdd() throws Exception {
		SiteName siteName = new SiteName("北京汽车","qiche.com","北京","2014-3-24");
		siteNameDao.add(siteName);
		List s2 = siteNameDao.loadByName("北京汽车");
		assertNotNull(s2);
	}

}
