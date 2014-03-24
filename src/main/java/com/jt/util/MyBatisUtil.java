package com.jt.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory;
	
	private static SqlSession session;
	static {
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession createSession() {
		if(session!=null) return session;
		session = factory.openSession();
		PooledDataSource dataSource = (PooledDataSource) session.getConfiguration().getEnvironment().getDataSource();
		System.out.println(dataSource.getPoolState());
		return session;
	}
	
	public static void closeSession(SqlSession session) {
		PooledDataSource dataSource = (PooledDataSource) session.getConfiguration().getEnvironment().getDataSource();
		System.out.println(dataSource.getPoolState());
		if(session!=null) session.close();
	}

}
