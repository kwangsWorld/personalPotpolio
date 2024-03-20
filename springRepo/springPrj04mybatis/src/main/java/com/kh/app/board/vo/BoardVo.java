package com.kh.app.board.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data //Getter+Setter+ToString+RequiredArgsConstructor
//@NoArgsConstructor  기본 생성자
//@AllArgsConstructor 모든 아규먼트를 받는 생성자 
//@RequiredArgsConstructor  요청한 아규먼트만 받는 생성자

public class BoardVo {

	private String no;
	private String title;
	private String content;
	private String enrollDate;
}
