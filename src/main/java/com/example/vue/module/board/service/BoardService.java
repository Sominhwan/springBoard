package com.example.vue.module.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
    
    public List<BoardVO> boardList(){
    	String page = null;
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		
		int rowSize=10;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;   
		
		List<BoardVO> list = boardDAO.boardListData(start, end);
		//int totaloage = boardDAO.boardTotalPage();
		
		
		return list;

    }
}
