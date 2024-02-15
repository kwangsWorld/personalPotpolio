package com.kh.app.board;

import java.sql.Connection;

import com.kh.app.db.util.JDBCTemplate;

public class BoardService {
	
	//게시글 작성
	public int write(BoardVo vo) throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//DAO 호출
		BoardDao dao = new BoardDao();
		int result = dao.write(conn, vo);
		
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

}
