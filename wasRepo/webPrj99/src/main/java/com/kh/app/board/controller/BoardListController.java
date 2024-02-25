package com.kh.app.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.page.vo.PageVo;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	
	// 게시글 목록 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			BoardService bs = new BoardService();
			
			// data
			int listCount = bs.selectBoardCount();		//전체 게시글 갯수
			String currentPage_ = req.getParameter("pno");
			if(currentPage_ == null) {
				currentPage_ = "1";
			}
			int currentPage = Integer.parseInt(currentPage_);	//현재 페이지
			int pageLimit = 5;
			int boardLimit = 10;
			PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
			// service
			List<BoardVo> boardVoList = bs.selectBoardList(pvo);
			
			// result (==view)
			req.setAttribute("boardVoList", boardVoList);
			req.setAttribute("pvo" , pvo);
			req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
			
		}catch(Exception e) {
			System.out.println("[ERROR-B001]게시글 목록 조회 중 에러 발생 ...");
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 목록 조회 에러");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}
	
}