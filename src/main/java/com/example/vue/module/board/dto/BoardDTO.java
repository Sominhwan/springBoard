package com.example.vue.module.board.dto;

import com.example.vue.module.board.model.BoardVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BoardDTO {
	
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReqBoard{
    	private int id;
    	private String title;
    	private int cnt;
    	private String contents;
    	private String writer;
    	private String insert_date;
    	private String update_date;	
    	private String pwd;

        public BoardVO boardDelete() {   	
            return BoardVO.builder() 
            		.id(id)
            		.pwd(pwd)
            		.build();
        }  
        
        public BoardVO boardUpdate() {   	
            return BoardVO.builder() 
            		.id(id)
            		.writer(writer)
            		.title(title)
            		.contents(contents)
            		.pwd(pwd)
            		.build();
        }    
    }   
}
