package com.kh.app.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class BoardController {
   
   @GetMapping("board/list")
   @ResponseBody
   public String m01() {
      String vo1 = "{\"title\":\"hello111\",\"content\":\"world111\"}";
      String vo2 = "{\"title\":\"hello222\",\"content\":\"world222\"}";
      String vo3 = "{\"title\":\"hello333\",\"content\":\"world333\"}";
      String str = "[ " + vo1 + "," + vo2 +"," + vo3 + "]";
      return str;
   }

}





