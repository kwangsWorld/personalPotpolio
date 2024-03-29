package com.kh.app.board.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
//builder 어노테이션을 사용해서 생성자와 세터의 장점을 둘다 사용할 수 있다.
public class BoardVo {

	private String no;
	private String title;
	private String content;
	private String enrollDate;
	private String delYn;
	private String writerNo;
	private String writerNick;
}
