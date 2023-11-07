package com.cherry.member.service;

import java.sql.*;
import java.util.*;

import com.cherry.jdbc.JDBCTemplate;
import com.cherry.main.Main;
import com.cherry.member.dao.MemberDao;
import com.cherry.member.vo.MemberVo;
import com.cherry.trade.vo.TradeVo;

public class MemberService {
	
	private final MemberDao dao;
	
	public MemberService() {
		dao = new MemberDao();
	}

	public int join(MemberVo vo) throws Exception{
		
		Connection conn = JDBCTemplate.getConnection();
		
		String code = dao.codeMake(conn,vo.getAddress());
		if(code == null) {
			throw new Exception("주소를 잘못 입력하셨습니다. 다시 입력해주세요");
		}
		vo.setAreasCode(code);
		int result = dao.join(conn,vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}


	public MemberVo login(MemberVo vo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		MemberVo userdb = dao.login(conn,vo);
		
		JDBCTemplate.close(conn);
		return userdb;
	}

	public int quit(String no) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.quit(conn,no);
		if(result == 1 ) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int changePwd(HashMap<String, String> map) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.changePwd(conn,map);
		if(result == 1 ) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		
		return result;
	}

	public int changeNick(MemberVo vo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.changeNick(conn,vo);
		if(result == 1 ) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int changeAddress(MemberVo vo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		
		String code = dao.codeMake(conn,vo.getAddress());
		if(code == null) {
			throw new Exception("주소를 잘못 입력하셨습니다. 다시 입력해주세요");
		}
		vo.setAreasCode(code);
		int result = dao.changeAddress(conn,vo);
		vo = dao.login(conn,vo);
		Main.loginMember.setAreasName(vo.getAreasName());
		
		if(result == 1 ) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int changePhone(MemberVo vo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.changePhone(conn,vo);
		if(result == 1 ) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public List<TradeVo> purchaseList(String no) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		List<TradeVo> voList = dao.purchaseList(conn,no);
		
		JDBCTemplate.close(conn);
		
		return voList;
	}

	public List<TradeVo> wishList(String no) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		List<TradeVo> voList = dao.wishList(conn,no);
		
		JDBCTemplate.close(conn);
		
		return voList;
	}

	public int wishDelete(String memberNo, String boardNo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.wishDelete(conn,memberNo,boardNo);
		if(result == 1 ) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public String score(String no) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		String score = dao.score(conn,no);
		
		JDBCTemplate.close(conn);
		
		return score;
	}

	public String findId(MemberVo vo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		String userId = dao.findId(conn,vo);
		
		JDBCTemplate.close(conn);
		
		return userId;
	}

	public String findPwd(MemberVo vo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		MemberVo userVo = dao.findPwd(conn,vo);
		if(userVo == null) {
			throw new Exception("값을 잘못 입력하셨습니다. 다시 시도해주세요");
		}
		
		int result = dao.pwdReset(conn,userVo);
		String newPwd = null;
		
		if(result == 1) {
			newPwd = dao.newPwd(conn,userVo);
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return newPwd;
	}

	public int writeReview(String purchaseNo,String manner, String content) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.writeReview(purchaseNo, manner, content, conn);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public String ReviewValidation(String purchaseNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		String rv = dao.ReviewValidation(purchaseNo, conn);
		
		JDBCTemplate.close(conn);
		
		return rv;
	}
}
