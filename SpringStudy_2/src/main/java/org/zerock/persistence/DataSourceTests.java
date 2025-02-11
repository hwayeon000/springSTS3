package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {

	@Setter(onMethod_= @Autowired)
	private DataSource dataSource;
	
	@Test
	public void testConnection() {
		try( Connection con = dataSource.getConnection(); ){
			log.info("con=" + con);
		}catch(Exception e) {
			fail(e.getMessage());
		}		
	}	
	
	@Setter(onMethod_=@Autowired)
	private SqlSessionFactory sqlFactory;
	
	//MyBatis와 Mysql 서버가 제대로 연결되었는지 Test
	@Test
	public void testMyBatis() throws Exception {
		try(SqlSession session = sqlFactory.openSession();
			Connection con = session.getConnection();) {
			log.info(session);
			log.info(con);
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	
}
