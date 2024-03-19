package com.kh.app.board.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BoardVo {

	private String no;
	private String title;
	private String content;
	private String enrollDate;
	
}
