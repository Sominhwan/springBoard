//package com.example.vue.module.board.dto;
//
//import com.example.vue.module.board.model.BoardVO;
//
//import lombok.Builder;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//
//@RequiredArgsConstructor
//public class BoardDTO {
//	
//    @Data
//    @Builder
//    public static class ReqBoard{
//    	private String title;
//    	private String contents;
//    	private String writer;
//    	private String pwd;	
//
//        public BoardVO boardInsert() {
//        	
//            return BoardVO.builder() 
//            		.writer(writer)
//            		.title(title)
//            		.contents(contents)	
//            		.pwd(pwd)
//            		.build();
//        }
//    }   
//}
