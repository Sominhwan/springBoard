package com.example.vue.module.board.service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.vue.module.board.dao.db1.BoardDAO;
import com.example.vue.module.board.model.BoardVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
//@Transactional(readOnly = false) // readOnly = true 경우 db 접근시 select 만 가능
public class BoardService {
	private final BoardDAO boardDAO;
    public List<BoardVO> boardSearch(){
        return boardDAO.getSearch(); 
    }
    public String boardSearch2(){
    	System.out.println("안녕");
;
    	return "sksmsa"; 
    }
}
