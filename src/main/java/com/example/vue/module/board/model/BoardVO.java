package com.example.vue.module.board.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {
	private int id;
	private String title;
	private int cnt;
	private String writer;
	private Date insert_date;
	private Date update_date;		
}
