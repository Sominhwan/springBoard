package com.example.vue.module.board.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
	private int id;
	private String title;
	private int cnt;
	private String contents;
	private String writer;
	private String insert_date;
	private String update_date;	
	private String pwd;
}
