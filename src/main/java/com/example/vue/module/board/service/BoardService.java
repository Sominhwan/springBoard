package com.example.vue.module.board.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
    // 페이징 처리
    public String boardList(String page){
		if(page==null)
			page="1";
		int curPage=Integer.parseInt(page);
		int rowSize=10;
		int startPage=(rowSize*curPage)-(rowSize-1);
		int endPage=rowSize*curPage;
		
		List<BoardVO> boardlist = boardDAO.boardListData(startPage, endPage);
		int totalPage = boardDAO.boardTotalPage();
		
		String result = "";
		JSONArray arr=new JSONArray();
		int k=0;
		for(BoardVO vo : boardlist)
		{
			JSONObject obj=new JSONObject();
			obj.put("id", vo.getId());
			obj.put("title", vo.getTitle());
			obj.put("writer", vo.getWriter());
			obj.put("insert_date", vo.getInsert_date());
			obj.put("cnt", vo.getCnt());
			if(k==0)
			{
				obj.put("curPage", curPage);
				obj.put("totalPage",totalPage);
			}
			arr.add(obj);
			k++;
		}	
		result = arr.toJSONString();

		return result;
    }
}
