package com.example.vue.module.board.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vue.module.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
public class BoardController {
	private final BoardService boardService;
	
	@GetMapping("/page")
	public List<?> index() {
		return boardService.boardSearch();
	}
	@GetMapping("/test3")
	public String index3() {
		return boardService.boardSearch2();
	}
//	@PostMapping("/test")
//	public String index() {
//		return "zz";
//	}

	@GetMapping("/test2")
	public String index2() {
		return "그래서";
	}
}

