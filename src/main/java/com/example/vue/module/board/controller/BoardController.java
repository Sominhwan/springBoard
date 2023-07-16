package com.example.vue.module.board.controller;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vue.module.board.dto.BoardDTO;
import com.example.vue.module.board.dto.CommentDTO;
import com.example.vue.module.board.model.BoardVO;
import com.example.vue.module.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
public class BoardController {
	private final BoardService boardService;
	
	@GetMapping("/all")
	public String boardList(@RequestParam("page") String page){
		return boardService.boardList(page);	
	}	
	
	@PostMapping("/write")
	public HttpEntity<?> boardWrite(@RequestBody BoardVO vo){
		return boardService.boardWrtie(vo);
	}	
	
	@GetMapping("/read")
	public List<BoardVO> boardRead(@RequestParam("id") String id){
		return boardService.boardRead(id);
	}	
	
	@DeleteMapping("/delete")
	public HttpEntity<?> boardDelete(@RequestBody BoardDTO.ReqBoard reqDTO) {
		return boardService.boarDelete(reqDTO.getId(), reqDTO.getPwd());
	}
	
	@PostMapping("/password")
	public HttpEntity<?> boardPassword(@RequestBody BoardDTO.ReqBoard reqDTO) {
		return boardService.boardPassword(reqDTO.getId(), reqDTO.getPwd());
	}	
	// 수정하기 게시물 데이터 가져오기
	@GetMapping("/data")
	public HttpEntity<?> boardData(@RequestParam("id") String id){
		return boardService.boardData(id);
	}
	// 게시물 수정하기
	@PatchMapping("/update")
	public HttpEntity<?> boardUpdate(@RequestBody BoardDTO.ReqBoard reqDTO){
		return boardService.boardUpdate(reqDTO);
	}	
	// 게시물 댓글 가져오기
	@GetMapping("/comment/all")
	public HttpEntity<?> commentList(@RequestParam("id") String id){
		 return boardService.commentList(id);
	}
	// 게시물 댓글 작성하기
	@PostMapping("/comment/write")
	public HttpEntity<?> commentWrite(@RequestBody CommentDTO.ReqComment reqDTO){
		 return boardService.commentWrite(reqDTO);
	}
	// 메인화면 최신 게시물 5개 가져오기
	@GetMapping("/list")
	public HttpEntity<?> boardMainList(@RequestParam("data") int data){
		 return boardService.boardMainList(data);
	}
}

