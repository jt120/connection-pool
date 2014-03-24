package com.jt.test.pool;

import java.io.IOException;
import java.util.List;

import com.jt.dao.SiteNameDao;
import com.jt.model.SiteName;

/**
 * @author Liu Ze
 * 
 *         Create Date Mar 20, 2014 8:22:24 PM
 */

public class TestConnection {

	static SiteNameDao siteNameDao = new SiteNameDao();

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			OpenThread o = new OpenThread();
			Thread t = new Thread(o);
			t.start();
			System.out.println("thread " + i + " is start...");
		}
	}

	static class OpenThread implements Runnable {

		@Override
		public void run() {
			SiteName siteName = new SiteName("北京汽车", "qiche.com", "北京",
					"2014-3-24");
			siteNameDao.add(siteName);
			List s2 = siteNameDao.loadByName("北京汽车");
		}
	}
}
