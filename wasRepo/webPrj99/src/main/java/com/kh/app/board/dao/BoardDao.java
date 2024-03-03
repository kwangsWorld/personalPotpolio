package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.board.vo.CategoryVo;
import com.kh.app.board.vo.ReplyVo;
import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.page.vo.PageVo;

public class BoardDao {

   //게시글 목록 조회
   public List<BoardVo> selectBoardList(Connection conn, PageVo pvo) throws Exception{
      
      //SQL
      String sql = "SELECT * FROM    ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.NO ,B.CATEGORY_NO ,B.TITLE ,B.CONTENT ,B.WRITER_NO ,B.HIT ,B.ENROLL_DATE ,B.MODIFY_DATE ,B.STATUS ,M.NICK AS WRITER_NICK ,C.NAME AS CATEGORY_NAME FROM BOARD B JOIN MEMBER M ON B.WRITER_NO = M.NO JOIN CATEGORY C ON B.CATEGORY_NO = C.NO WHERE B.STATUS = 'O' ORDER BY NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, pvo.getStartRow());
      pstmt.setInt(2, pvo.getLastRow());
      ResultSet rs = pstmt.executeQuery();
      
      
      //rs
      List<BoardVo> boardVoList = new ArrayList<BoardVo>();
      while(rs.next()) {
         
         String no = rs.getString("NO");
         String categoryNo = rs.getString("CATEGORY_NO");
         String title = rs.getString("TITLE");
         String content = rs.getString("CONTENT");
         String writerNo = rs.getString("WRITER_NO");
         String writerNick = rs.getString("WRITER_NICK");
         String hit = rs.getString("HIT");
         String enrollDate = rs.getString("ENROLL_DATE");
         String modifyDate = rs.getString("MODIFY_DATE");
         String status = rs.getString("STATUS");
         String categoryName = rs.getString("CATEGORY_NAME");
         
         BoardVo vo = new BoardVo();
         vo.setNo(no);
         vo.setCategoryNo(categoryNo);
         vo.setTitle(title);
         vo.setContent(content);
         vo.setWriterNo(writerNo);
         vo.setWriterNick(writerNick);
         vo.setHit(hit);
         vo.setEnrollDate(enrollDate);
         vo.setModifyDate(modifyDate);
         vo.setStatus(status);
         vo.setCategoryName(categoryName);
         
         boardVoList.add(vo);
         
      }
      
      
      //close
      JDBCTemplate.close(pstmt);
      JDBCTemplate.close(rs);
      
      return boardVoList;
   }

   public int write(Connection conn, BoardVo vo) throws Exception {
      
      //SQL
      String sql = "INSERT INTO BOARD (NO, CATEGORY_NO, TITLE, CONTENT, WRITER_NO) VALUES ( SEQ_BOARD_NO.NEXTVAL, ?, ?, ?, ?)";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, vo.getCategoryNo());
      pstmt.setString(2, vo.getTitle());
      pstmt.setString(3, vo.getContent());
      pstmt.setString(4, vo.getWriterNo());
      int result = pstmt.executeUpdate();
      
      //close
      JDBCTemplate.close(pstmt);
      return result;
      
      
   }

   //게시글 번호로 게시글 1개 조회
   public BoardVo selectBoardByNo(Connection conn, String no) throws Exception{
      
      //SQL
      String sql = "SELECT B.NO ,B.CATEGORY_NO ,B.TITLE ,B.CONTENT ,B.WRITER_NO ,B.HIT ,B.ENROLL_DATE ,B.MODIFY_DATE ,B.STATUS ,M.NICK AS WRITER_NICK ,C.NAME AS CATEGORY_NAME FROM BOARD B JOIN MEMBER M ON B.WRITER_NO = M.NO JOIN CATEGORY C ON B.CATEGORY_NO = C.NO WHERE B.NO = ? AND B.STATUS = 'O'";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, no);
      ResultSet rs = pstmt.executeQuery();
      
      //rs
      BoardVo vo = null;
      if(rs.next()) {
         String title = rs.getString("TITLE");
         String categoryNo = rs.getString("CATEGORY_NO");
         String content = rs.getString("CONTENT");
         String writerNo = rs.getString("WRITER_NO");
         String writerNick = rs.getString("WRITER_NICK");
         String hit = rs.getString("HIT");
         String enrollDate = rs.getString("ENROLL_DATE");
         String modifyDate = rs.getString("MODIFY_DATE");
         String status = rs.getString("STATUS");
         String categoryName = rs.getString("CATEGORY_NAME");
         
         vo = new BoardVo();
         vo.setNo(no);
         vo.setTitle(title);
         vo.setCategoryNo(categoryNo);
         vo.setContent(content);
         vo.setWriterNo(writerNo);
         vo.setWriterNick(writerNick);
         vo.setHit(hit);
         vo.setEnrollDate(enrollDate);
         vo.setModifyDate(modifyDate);
         vo.setStatus(status);
         vo.setCategoryName(categoryName);
         
      }
      //close
      JDBCTemplate.close(rs);
      JDBCTemplate.close(pstmt);
      return vo;
   }

   //조회수 증가
   public int increaseHit(Connection conn, String no) throws Exception{
      
      //SQL
      String sql = "UPDATE BOARD SET HIT = HIT + 1 WHERE NO = ? AND STATUS = 'O'";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, no);
      int result = pstmt.executeUpdate();
      
      //close
      JDBCTemplate.close(pstmt);
      
      return result;
      
   }

   //게시글 삭제
   public int delete(Connection conn, String no, String memberNo) throws Exception {
      
      //SQL
      String sql = "UPDATE BOARD SET STATUS = 'X' WHERE NO = ? AND WRITER_NO = ?";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, no);
      pstmt.setString(2, memberNo);
      int result = pstmt.executeUpdate();
      
      //close
      JDBCTemplate.close(pstmt);
      
      return result;
   }//delete

   public int selectBoardCount(Connection conn) throws Exception{
      
      //SQL
      String sql = "SELECT COUNT(*) as cnt FROM BOARD WHERE STATUS = 'O'";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      
      ResultSet rs = pstmt.executeQuery();
      
      //rs
      int cnt = 0;
      if(rs.next()) {
//         int cnt = rs.getInt("cnt");
         cnt = rs.getInt(1); //첫번째 열을 가져오겠다 라는 뜻, 계산에 써야되기 때문에 String이 아닌 Int로 받아줌
      }
      
      //close
      JDBCTemplate.close(rs);
      JDBCTemplate.close(pstmt);
      
      return cnt;
         
   }
   
   //카테고리 리스트 조회
   public List<CategoryVo> getCategoryList(Connection conn) throws Exception {
	   //SQL
	   String sql = "SELECT * FROM CATEGORY ORDER BY NO";
	   PreparedStatement pstmt = conn.prepareStatement(sql);
	   ResultSet rs = pstmt.executeQuery();
	   //rs
	   List<CategoryVo> voList = new ArrayList<CategoryVo>();
	   while(rs.next()) {
		   String no = rs.getString("NO");
		   String name = rs.getString("NAME");
		   
		   CategoryVo vo = new CategoryVo();
		   vo.setNo(no);
		   vo.setName(name);
		   voList.add(vo);
	   }
	   //close
	   JDBCTemplate.close(rs);
	   JDBCTemplate.close(pstmt);
	   
	   return voList;
   }
   
   
   // 게시글 수정
   public int updateBoardByNo(Connection conn, BoardVo vo) throws Exception {
	   // SQL
	   String sql = "UPDATE BOARD SET TITLE = ? , CONTENT = ? , CATEGORY_NO = ? , MODIFY_DATE = SYSDATE WHERE NO = ? AND STATUS = 'O'";
	   PreparedStatement pstmt = conn.prepareStatement(sql);
	   pstmt.setString(1, vo.getTitle());
	   pstmt.setString(2, vo.getContent());
	   pstmt.setString(3, vo.getCategoryNo());
	   pstmt.setString(4, vo.getNo());
	   int result = pstmt.executeUpdate();
	   
	   // close
	   JDBCTemplate.close(pstmt);
	   
	   return result; 
   	}

	//게시글 검색
	public List<BoardVo> search(Connection conn, Map<String, String> m , PageVo pvo) throws Exception {
		
		String searchType = m.get("searchType");
		
		// SQL
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.NO , B.CATEGORY_NO , B.TITLE , B.CONTENT , B.WRITER_NO , B.HIT , B.ENROLL_DATE , B.MODIFY_DATE , B.STATUS , M.NICK AS WRITER_NICK , C.NAME AS CATEGORY_NAME FROM BOARD B JOIN MEMBER M ON B.WRITER_NO = M.NO JOIN CATEGORY C ON B.CATEGORY_NO = C.NO WHERE B.STATUS = 'O' AND " + searchType + " LIKE '%' || ?|| '%' ORDER BY NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, m.get("searchValue"));
		pstmt.setInt(2, pvo.getStartRow());
		pstmt.setInt(3, pvo.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		// rs
	      List<BoardVo> boardVoList = new ArrayList<BoardVo>();
	      while(rs.next()) {
	         String no = rs.getString("NO");
	         String categoryNo = rs.getString("CATEGORY_NO");
	         String title = rs.getString("TITLE");
	         String content = rs.getString("CONTENT");
	         String writerNo = rs.getString("WRITER_NO");
	         String writerNick = rs.getString("WRITER_NICK");
	         String hit = rs.getString("HIT");
	         String enrollDate = rs.getString("ENROLL_DATE");
	         String modifyDate = rs.getString("MODIFY_DATE");
	         String status = rs.getString("STATUS");
	         String categoryName = rs.getString("CATEGORY_NAME");
	         
	         BoardVo vo = new BoardVo();
	         vo.setNo(no);
	         vo.setCategoryNo(categoryNo);
	         vo.setTitle(title);
	         vo.setContent(content);
	         vo.setWriterNo(writerNo);
	         vo.setWriterNick(writerNick);
	         vo.setHit(hit);
	         vo.setEnrollDate(enrollDate);
	         vo.setModifyDate(modifyDate);
	         vo.setStatus(status);
	         vo.setCategoryName(categoryName);
	         
	         boardVoList.add(vo);
	      }
	
		// close
	    JDBCTemplate.close(rs);
	    JDBCTemplate.close(pstmt);
	      
	    return boardVoList;
	}

	// 게시글 갯수 조회 (검색값에 따라)
	public int getBoardCountBySearch(Connection conn, Map<String, String> m) throws Exception {
		
		// SQL
		String sql = "SELECT COUNT(*) FROM BOARD WHERE STATUS = 'O' AND " + m.get("searchType") + " LIKE '%' || ? || '%'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, m.get("searchValue"));
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		int cnt = 0;
		if(rs.next()) {
			cnt = rs.getInt(1);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return cnt;
	}

	
	//댓글 목록 조회
	public List<ReplyVo> getReplyList(Connection conn, String refNo) throws Exception{
		
		// SQL
		String sql = "SELECT NO ,REF_NO ,CONTENT ,WRITER_NO ,ENROLL_DATE ,STATUS FROM REPLY WHERE REF_NO = ? AND STATUS = 'O' ORDER BY NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, refNo);
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<ReplyVo> voList = new ArrayList<ReplyVo>();
		while(rs.next()) {
			String no = rs.getString("NO");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String enrollDate = rs.getString("ENROLL_DATE");
			String status = rs.getString("STATUS");
			
			ReplyVo vo = new ReplyVo(no, refNo, content, writerNo, enrollDate, status);
			voList.add(vo);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return voList;
	}
	
	//댓글 작성하기
	public int writeReply(Connection conn , ReplyVo replyVo) throws Exception {
		// SQL
		String sql = "INSERT INTO REPLY ( NO ,REF_NO ,CONTENT ,WRITER_NO ) VALUES ( SEQ_REPLY_NO.NEXTVAL , ? , ? , ? )";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, replyVo.getRefNo());
		pstmt.setString(2, replyVo.getContent());
		pstmt.setString(3, replyVo.getWriterNo());
		int result = pstmt.executeUpdate();
		
		// close
		JDBCTemplate.close(pstmt);
		
		return result;
	}
   
   
   
}//class


























