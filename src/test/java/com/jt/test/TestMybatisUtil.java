package com.jt.test;


import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.datasource.pooled.PoolState;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.jt.util.MyBatisUtil;
/**
 * @author Liu Ze
 *
 * Create Date Mar 4, 2014 4:14:48 PM
 */

public class TestMybatisUtil {
	
	@Test
	public void test01() {
		SqlSession session = MyBatisUtil.createSession();
		assertNotNull(session);
		MyBatisUtil.closeSession(session);
	}
	
	@Test
	public void testPool() throws Exception {
		SqlSession session = MyBatisUtil.createSession();
		PooledDataSource pool = (PooledDataSource) session.getConfiguration().getEnvironment().getDataSource();
		PoolState state = pool.getPoolState();
		System.out.println(state);
	}

}
