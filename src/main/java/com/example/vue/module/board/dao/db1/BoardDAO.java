package com.example.vue.module.board.dao.db1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.vue.module.board.model.BoardVO;
import com.example.vue.module.board.model.CommentVO;

@Repository
@Mapper
public interface BoardDAO {
	List<BoardVO> boardListData(@Param("offset") int offset, @Param("rowSize") int rowSize);
	
	int boardTotalPage();
	
	Integer boardInsert(BoardVO boardVO);
	
	void boardViewsCount(@Param("id") int id);
	
	List<BoardVO> boardDetailData(@Param("id") int id);
	
	String boardGetPwd(@Param("id") int id);
	
	Integer boardDelete(@Param("id") int id);
	
	List<BoardVO> boardUpdateData(@Param("id") int id);
	
	Integer boardUpdate(BoardVO boardVO);
	
	List<CommentVO> commentListData(@Param("id") int id);
	
	Integer commentInsert(CommentVO commentVO);
	
	List<BoardVO> boardMainListData(@Param("data") int data);
}
