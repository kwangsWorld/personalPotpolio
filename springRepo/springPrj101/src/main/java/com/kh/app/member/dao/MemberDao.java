package com.kh.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.member.vo.MemberVo;

public class MemberDao {

	public int memberJoin(Connection conn, MemberVo vo) throws Exception{
		
		//sql
		String sql = "INSERT INTO MEMBER_TEMP(ID, PWD)  VALUES(?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		
		int result = pstmt.executeUpdate();
		
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
		
	}

}
