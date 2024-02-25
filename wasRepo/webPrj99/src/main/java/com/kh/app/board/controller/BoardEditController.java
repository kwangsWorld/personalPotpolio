package com.kh.app.board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.board.vo.CategoryVo;

@WebServlet("/board/edit")
public class BoardEditController extends HttpServlet {
	
	// 게시글 수정 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//data
			String no = req.getParameter("no");
			
			//service
			BoardService bs = new BoardService();
			Map<String, Object> m = bs.edit(no);
			BoardVo vo = (BoardVo) m.get("vo");
			List<CategoryVo> categoryVoList = (List<CategoryVo>) m.get("categoryVoList");
			
			//result
			if(vo == null) {
				throw new Exception();
			}
			req.setAttribute("categoryVoList", categoryVoList);
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/views/board/edit.jsp").forward(req, resp);
		}catch(Exception e) {
			System.out.println("게시글 수정하기 화면 조회 에러 ...");
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 수정 화면 조회 에러 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
	
	// 게시글 수정
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			//data
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String category = req.getParameter("category");
			String no = req.getParameter("no");
			
			BoardVo vo = new BoardVo();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setCategoryNo(category);
			vo.setNo(no);
			
			//service
			BoardService bs = new BoardService();
			int result = bs.edit(vo);
			
			//result
			if(result != 1) {
				throw new Exception();
			}
			resp.sendRedirect("/app99/board/detail?no=" + no);
			
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 수정 실패 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}

}//class