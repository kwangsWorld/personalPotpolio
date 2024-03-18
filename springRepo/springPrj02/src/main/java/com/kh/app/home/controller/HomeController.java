package com.kh.app.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	// 홈페이지 보여주기
	@GetMapping("home")
	public String showHome() {
		System.out.println("home called ~~~ !");
		return "home";
	}
}
