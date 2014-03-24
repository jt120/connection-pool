package com.jt.test;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Liu Ze
 *
 * Create Date Mar 10, 2014 10:14:43 AM
 * 构造数据库初始数据
 */

public class InitSql {
	
	Random r = new Random();
	List<String> list = new ArrayList<String>();
	static String sql_head = "insert into t_sitename "
			+ "(SITE_NAME, SITE_URL, SITE_ADDRESS, CREATE_DATE, UPDATE_DATE) values (";
	
	static String sql_end = ");";
	File file = new File("src/main/resources/sql/init.sql");
	
	@Before
	public void init() throws IOException {
	}

	
	public void write(String s) throws IOException {
		PrintWriter writer = null;
		try {

			writer = new PrintWriter(file);
			writer.append(s+"\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}
	
	
	@Test
	public void test02() throws Exception {
		File file = new File("src/main/resources/sql/user_domain.txt");
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file));
			String s = "";
			while((s=br.readLine())!=null) {
				String[] line = s.split("\t");
				String r = line[1]+"\t"+line[2];
				list.add(r);
			}
//			for(String tmp:list) {
//				System.out.println(tmp);
//			}
		} finally {
			br.close();
		}
		
	}
	/**
	 * "(ID, ORG_NAME, SITE_NAME, SITE_URL, SITE_ADDRESS, "
			+ "IP, REG_ID, REG_DATE, USER_ID, STATUS, "
			+ "AUDIT_STATUS, PIWIK_ID, NOTE, MARKED, CREATE_DATE, "
			+ "UPDATE_DATE, CREATE_USERID, UDATE_USERID, TYPE)
	 * 	//19
	/**
	 * marked:0:未挂表，1：已挂标
	   status:W:未提交、A：申请中、B变更申请中、S：申请成功
	   audit_status:0:待审核、1：编办审核通过、2：未通过 3：CONAC审核通过、4：CONAC审核未通过
	 */
	String[] STATUS = {"W","A","B","S"};
	String[] AUDIT_STATUS = {"0","1","2","3","4"};
	String[] MARKED = {"0","1"};

	String[] org1 = {"北京","上海","广州","深圳","天津","成都","重庆","南京"};
	String[] org2 = {"服装","电脑","食品","化妆品","家电","汽车","飞机","房地产","建材","卫浴","餐具"};
	String[] org3 = {"公司","单位","办事处","企业","集团"};
	

	
	@Test
	public void test03() throws Exception {
		test02();

		String insert = "'SITE_NAME', 'SITE_URL', 'SITE_ADDRESS', 'CREATE_DATE', 'UPDATE_DATE'";
		PrintWriter writer = null;
		try {

			writer = new PrintWriter(file);
		
		for (int i = 0; i < 1000; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(sql_head);
			String tmp = list.get(r.nextInt(list.size()));
			String[] tmp1 = tmp.split("\t");
			String userId = tmp1[0];
			String domainId = tmp1[1];
			String or = getOrg();
			String s = insert.replaceAll("ORG_NAME", or);
			s = s.replaceAll("SITE_NAME", or);
			s =s.replaceAll("SITE_URL", getUrl());
			s =s.replaceAll("SITE_ADDRESS", org1[r.nextInt(org1.length)]);
			
			s =s.replaceAll("IP", "1.1.1.1");
			//s =s.replaceAll("REG_ID", "111");
			s =s.replaceAll("REG_DATE", "");
			s =s.replaceAll("USER_ID", userId);
			s =s.replaceAll("MySTATUS", STATUS[r.nextInt(STATUS.length)]);
			
			s =s.replaceAll("AUDIT_STATUS", AUDIT_STATUS[r.nextInt(AUDIT_STATUS.length)]);
			//s =s.replaceAll("PIWIK_ID", "PIWIK_ID");
		//	s =s.replaceAll("NOTE", org1[r.nextInt(org1.length)]);
			s =s.replaceAll("MARKED", Integer.toString(r.nextInt(1)));
			s =s.replaceAll("CREATE_DATE", getDate());
			
			s =s.replaceAll("UPDATE_DATE", getDate());
//			s =s.replaceAll("CREATE_USERID", org1[r.nextInt(org1.length)]);
			//s =s.replaceAll("UDATE_USERID", org1[r.nextInt(org1.length)]);
			//s =s.replaceAll("TYPE", org1[r.nextInt(org1.length)]);
			
			System.out.println(s);
			sb.append(s);
			sb.append(sql_end);
			writer.append(sb.toString()+"\n");
		}} catch(Exception e) {
			
		} finally {
			writer.close();
		}
		
	}
	//随机生成org
	public String getOrg(){
		StringBuilder sb = new StringBuilder();
		String o1 = org1[r.nextInt(org1.length)];
		String o2 = org2[r.nextInt(org2.length)];
		String o3 = org3[r.nextInt(org3.length)];
		return sb.append(o1).append(o2).append(o3).toString();
	}
	
	@Test
	public void testUrl() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 97; i < 123; i++) {
			char a = (char) i;
			sb.append("'"+a+"',");
		}
		sb.append("}");
		System.out.println(sb.toString());
	}
	
	//随机生成url
	char[] url_start = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	String[] url_end = {"com","cn","org","gov","biz"};
	public String getUrl() throws Exception {
		int a = r.nextInt(url_start.length);
		StringBuilder sb = new StringBuilder();
		sb.append("www.");
		for (int i = 0; i < a; i++) {
			char c1 = url_start[r.nextInt(url_start.length)];
			sb.append(c1);
		}
		sb.append(".").append(url_end[r.nextInt(url_end.length)]);
		return sb.toString();
	}
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	public String getDate() {
		Date d = Calendar.getInstance().getTime();
		long delta = (long) r.nextInt(1000000000);
		long d2 = d.getTime()-delta;
		String s = format.format(new Date(d2));
		return s;
	}
	

	public long testLong() {
		long l = r.nextLong();
		if(l>0&&l<1394423974791L) {
			return l;
		} else {
			l = testLong();
		}
		return 0L;
	}
	
	@Test
	public void testDate() throws Exception {
		String s = getDate();
		System.out.println(s);
	}
}
