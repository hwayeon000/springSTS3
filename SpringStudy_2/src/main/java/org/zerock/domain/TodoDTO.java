package org.zerock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	private String title;
	private Date dueDate;
	// @DateTimeFormat 사용하는 경우 InitBinder 필요하지 않음!
	// 문자열로 'yyyy/mm/dd' 형식이 맞다면 자동으로 날짜 타입으로 변환됨
//	@DateTimeFormat(pattern="yyyy/mm/dd")
//	private Date dueDate;
	
}
