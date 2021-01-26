package com.aia.op;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

// 데이터 소스가 잘만들어지는지 sqlsession 이 잘 만들어지는지 테스트하기위한 페이지
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//@Log4j
public class DataSourceTest {
	
	@Autowired
	//@Setter(onMethod_ = {@Autowired})
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testMybatis() {
		try(
				SqlSession session = sqlSessionFactory.openSession(); 
				Connection con = session.getConnection();				){
			System.out.println("con = " + con);
			System.out.println("session = " + session);
		}catch (Exception e) {
			//fail(e.getMessage());
		}
	}
	
	@Test
	public void testConnection() {
		try(Connection con = dataSource.getConnection();){
			//log.info(con);
			System.out.println("!!!! connction = " + con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
