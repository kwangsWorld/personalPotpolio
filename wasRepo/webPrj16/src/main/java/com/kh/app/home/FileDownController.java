package com.kh.app.home;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/file/download")
public class FileDownController extends HttpServlet{

	//다운로듣 요청 처리할 메소드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getServletContext().getRealPath("/resources/profile");
		//경로 준비
		String fileName = "/abc.png";
		//파일 이름준비
		File f = new File(path + fileName);
		//setHeader는 문자열만 가능하고 아래 세개는 약속되어져있는 형태임
		//다운로드 세팅?
		resp.setHeader("Content-Type", "application/octet-stream");
		//파일 이름 지정하기
		resp.setHeader("Content-Disposition", "attachment; filename = zzz.png");
		//브라우저가 전체 다운로드 시간 계산을 위해
		resp.setHeader("Content-Length", String.valueOf(f.length()));
		
		//input
		FileInputStream is = new FileInputStream(f);
		
		//output
		ServletOutputStream out = resp.getOutputStream();
		
		byte[] buf = new byte[1024];
		int size = 0;
		while((size = is.read(buf)) != -1) {
			out.write(buf, 0, size);
		}
	}
}
