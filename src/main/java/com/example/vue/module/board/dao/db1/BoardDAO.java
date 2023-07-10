package com.example.vue.module.board.dao.db1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.vue.module.board.model.BoardVO;

@Repository
@Mapper
public interface BoardDAO {
	List<BoardVO> getSearch();
	List<BoardVO> boardListData(@Param("start") int start, @Param("end") int end);
	int boardTotalPage();

}
