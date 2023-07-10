package com.example.vue.module.board.dto;

import java.util.Date;

import com.example.vue.module.board.model.BoardVO;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BoardDTO {
	
    @Data
    @Builder
    public static class ReqFindId{
    	private int id;
    	private String title;
    	private int cnt;
    	private String writer;
    	private Date insert_date;
    	private Date update_date;	

        public BoardVO toEntity() {
            return BoardVO.builder() 
            		.id(id)
            		.title(title)
            		.cnt(cnt)
            		.writer(writer)
            		.insert_date(insert_date)
            		.update_date(update_date)
            		.build();
        }
    }   
}
