package com.example.vue.module.board.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vue.module.board.model.BoardVO;
import com.example.vue.module.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
public class BoardController {
	private final BoardService boardService;
	
	@GetMapping("/page")
	public List<BoardVO> index() {
		return boardService.boardSearch();
	}

	@GetMapping("/all")
	public String boardList(@RequestParam("page") String page){
		return boardService.boardList(page);	
	}
}

