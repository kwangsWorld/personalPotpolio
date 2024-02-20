package com.kh.app.home;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.home.vo.BoardVo;

@WebServlet("/home")
public class HomeController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("x", "안녕하세요");
		
		List<BoardVo> boardVoList = new ArrayList<BoardVo>();
		boardVoList.add(new BoardVo("제목01", "작성자01", "777"));
		boardVoList.add(new BoardVo("제목02", "작성자02", "123"));
		boardVoList.add(new BoardVo("제목03", "작성자03", "987"));
		boardVoList.add(new BoardVo("제목04", "작성자04", "333"));
		boardVoList.add(new BoardVo("제목05", "작성자05", "456"));
		
		
		req.setAttribute("voList", boardVoList);
		
		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
	}
}
