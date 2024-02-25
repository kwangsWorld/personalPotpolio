package com.kh.app.gallery.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.gallery.service.GalleryService;
import com.kh.app.gallery.vo.GalleryVo;

@WebServlet("/gallery/list")
public class GalleryListController extends HttpServlet {

	//갤러리 리스트 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// data
			
			// service
			GalleryService gs = new GalleryService();
			List<GalleryVo> galleryVoList = gs.getGalleryList();
			
			for (GalleryVo galleryVo : galleryVoList) {
				System.out.println(galleryVo);
			}
			
			// result
			req.setAttribute("galleryVoList", galleryVoList);
			req.getRequestDispatcher("/WEB-INF/views/gallery/list.jsp").forward(req, resp);
		}catch(Exception e) {
			System.out.println("[ERROR-G001] 갤러리 목록 조회 중 에러 발생 ...");
			e.printStackTrace();
			req.setAttribute("errorMsg", "갤러리 목록 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}
	
}