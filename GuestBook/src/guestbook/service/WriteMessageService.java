package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

public class WriteMessageService {
	
	// 싱글톤 패턴 적용
	private WriteMessageService() {}
	private static WriteMessageService service = new WriteMessageService();
	public static WriteMessageService getInstance() {
		return service;
	} 
	
	// 메시지 객체를 받고 
	// 커넥션 객체를 생성
	// 메시지dao객체를 생성
	// insertMessage
	public int writeMessage(Message message) {
		int resultFCnt = 0;
		
		Connection conn = null;
		MessageDao dao = null;
		try {
			conn = ConnectionProvider.getConnection();
			dao = MessageDao.getInstance();			
			resultFCnt = dao.insertMessage(conn, message);
			
			JdbcUtil.close(conn);		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);			
		}
		
		return resultFCnt;				
	}
	
}
