package com.jt.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jt.util.MyBatisUtil;

/**
 * @author Liu Ze
 *
 * Create Date Mar 24, 2014 9:08:11 PM
 */

public class BaseDao <T> {

	public void add(T t) {
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			session.insert(t.getClass().getName()+".add", t);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}
	
	public List<T> load(String sql, String param) {
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			List<T> l = session.selectList(sql, param);
			return l;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSession(session);
		}
		return null;
	}
}
