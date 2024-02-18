package com.kh.app.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


//파일 보내는것 세팅
@MultipartConfig(
			maxFileSize = 1024 * 1024 * 100   //파일 하나당 크기
			, maxRequestSize = 1024 * 1024 * 50 //리퀘스트 전체 크기
		)

@WebServlet("/file/insert")
public class FileUploadController extends HttpServlet{
	
	//파일 업로드 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("메소드 호출 ㅇㅋ");
		
		Part f = req.getPart("f");
		System.out.println(f);
		System.out.println(f.getSubmittedFileName());
		
		//읽기 준비
		InputStream in = f.getInputStream();
		
		
		//내보내기 준비
		String sep = File.separator; //구분자 대신
		String path = req.getServletContext().getRealPath(sep + "resources" + sep + "upload" + sep + "img");
		String fileName = sep + "abc.png";  //
		File target = new File(path + fileName);
		FileOutputStream out = new FileOutputStream(target);
		
		int data = 0;
		while((data = in.read()) != -1) {
			out.write(data);
		}
		
		byte[] buf = new byte[1024];
		int size = 0;
		// buf는 1100이라고 가정
		while( (size = in.read(buf)) != 1) {
//			int size = in.read(buf);
			//사이즈가 -1이라는 것은 더이상 읽을 것이 없다는 뜻
			//그냥 out.write(buf)일 경우 1024만큼 또 내보냄
			out.write(buf, 0, size);
		}
		//정리
		in.close();
		out.close();
	}
}
