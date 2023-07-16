package com.example.vue.module.board.dto;

import com.example.vue.module.board.model.CommentVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommentDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReqComment{
    	private int cid;
    	private int id;
    	private String writer;
    	private String comment;
    	private String ip;
    	private String insert_date;

    	public CommentVO commentWrite() {
    		return CommentVO.builder()
    				.id(id)
    				.writer(writer)
    				.comment(comment)
    				.ip(ip)
    				.build();
    	}
    }  
}
