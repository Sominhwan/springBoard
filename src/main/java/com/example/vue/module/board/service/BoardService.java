package com.example.vue.module.board.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.vue.module.board.dao.db1.BoardDAO;
import com.example.vue.module.board.dto.BoardDTO;
import com.example.vue.module.board.dto.CommentDTO;
import com.example.vue.module.board.dto.ResDTO;
import com.example.vue.module.board.model.BoardVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
//@Transactional(readOnly = false) // readOnly = true 경우 db 접근시 select 만 가능
public class BoardService {
	private final BoardDAO boardDAO;

    // 게시글 목록 불러오기(페이징 처리)
    public String boardList(String page){
		if(page==null)
			page="1";
		int curPage=Integer.parseInt(page);
		int rowSize=10;
		int offset = (curPage-1) * rowSize;
		
		List<BoardVO> boardlist = boardDAO.boardListData(offset, rowSize);
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
    
    // 게시글 작성
    public HttpEntity<?> boardWrtie(BoardVO vo){
    	boardDAO.boardInsert(vo);
    	return new ResponseEntity<>(
    				ResDTO.builder()
    							.code(0)
    							.message("게시물이 올라갔습니다.")
    							.build(),
    				HttpStatus.OK);  	   	
    }
    
    // 게시물 상세정보 불러오기
    public List<BoardVO> boardRead(String id){
    	int boardId=Integer.parseInt(id);
    	boardDAO.boardViewsCount(boardId);
    	return boardDAO.boardDetailData(boardId);
    }
    
    // 게시글 삭제
    public HttpEntity<?> boarDelete(int id, String pwd){
    	String boardPwd = boardDAO.boardGetPwd(id);
    	if(boardPwd.equals(pwd)) {
        	boardDAO.boardDelete(id);
        	return new ResponseEntity<>(
        			ResDTO.builder()
    							.code(0)
    							.message("게시물이 삭제되었습니다.")
    							.build(),
    				HttpStatus.OK);  
    	} else {
        	return new ResponseEntity<>(
    				ResDTO.builder()
    							.code(-1)
    							.message("비밀번호가 틀렸습니다.")
    							.build(),
    				HttpStatus.BAD_REQUEST);      		
    	}  	
    }
    
    // 게시글 수정 비밀번호 확인
    public HttpEntity<?> boardPassword(int id, String pwd){
    	String boardPwd = boardDAO.boardGetPwd(id);
    	if(boardPwd.equals(pwd)) {
        	return new ResponseEntity<>(
        			ResDTO.builder()
    							.code(0)
    							.message("올바른 비밀번호입니다.")
    							.build(),
    				HttpStatus.OK);  
    	} else {
        	return new ResponseEntity<>(
    				ResDTO.builder()
    							.code(-1)
    							.message("비밀번호가 틀렸습니다.")
    							.build(),
    				HttpStatus.BAD_REQUEST);      		
    	}  	
    }
    
    // 게시글 수정 데이터 가져오기
    public HttpEntity<?> boardData(String id){
    	return new ResponseEntity<>(
    				ResDTO.builder()
    							.code(0)
    							.message("수정 게시물 데이터를 불러왔습니다.")
    							.data(boardDAO.boardUpdateData(Integer.parseInt(id)))
    							.build(),
    				HttpStatus.OK);  	   	
    }    
    
    // 게시글 수정하기
    public HttpEntity<?> boardUpdate(BoardDTO.ReqBoard reqDTO){
    	boardDAO.boardUpdate(reqDTO.boardUpdate());
    	return new ResponseEntity<>(		
    				ResDTO.builder()
    							.code(0)
    							.message("게시물을 수정하였습니다.")
    							.build(),
    				HttpStatus.OK);  	   	
    }  
    
    // 게시물 댓글 작성
    public HttpEntity<?> commentList(String id){
    	return new ResponseEntity<>(
    				ResDTO.builder()
    							.code(0)
    							.message("댓글이 올라갔습니다.")
    							.data(boardDAO.commentListData(Integer.parseInt(id)))
    							.build(),
    				HttpStatus.OK);  	   	
    }     
    
    // 게시물 댓글 작성
    public HttpEntity<?> commentWrite(CommentDTO.ReqComment reqDTO){
    	boardDAO.commentInsert(reqDTO.commentWrite());
    	return new ResponseEntity<>(
    				ResDTO.builder()
    							.code(0)
    							.message("댓글이 올라갔습니다.")
    							.build(),
    				HttpStatus.OK);  	   	
    }   
    
    // 최신 게시물 5개 가져오기
    public HttpEntity<?> boardMainList(int data){	
    	return new ResponseEntity<>(
    				ResDTO.builder()
    							.code(0)
    							.message("게시물을 불러왔습니다.")
    							.data(boardDAO.boardMainListData(data))
    							.build(),
    				HttpStatus.OK);  	   	
    }
}
