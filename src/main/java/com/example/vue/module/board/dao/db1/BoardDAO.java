package com.example.vue.module.board.dao.db1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.vue.module.board.model.BoardVO;

@Repository
@Mapper
public interface BoardDAO {
	List<BoardVO> getSearch();

}
