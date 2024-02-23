package com.kh.app.filter.admin;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/admin/*")
public class CheckAdminFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//자식은 부모의 것을 사용해도 부모는 자식의 것을 사용하지 못함..
		HttpServletRequest req = (HttpServletRequest)request;
		
		if(req.getSession().getAttribute("adminInfo") == null) {
			req.getRequestDispatcher("errorPage ~~~").forward(request, response);
		}else {
			//다음단계 ㄱㄱ
			chain.doFilter(req, response);
		}
	}
}
