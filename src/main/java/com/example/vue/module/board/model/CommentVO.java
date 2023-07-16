package com.example.vue.module.board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CommentVO {
	private int cid;
	private int id;
	private String writer;
	private String comment;
	private String ip;
	private String insert_date;
}
