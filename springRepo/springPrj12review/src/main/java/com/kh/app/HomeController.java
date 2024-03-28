package com.kh.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("home")
	public void m01(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		
		req.getRequestDispatcher("/WEB-INF/views/abc.jsp").forward(req, resp);

	}
}
