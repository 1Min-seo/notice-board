package kr.co.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.service.BoardService;
import kr.co.vo.BoardVO;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService service;
	
	//게시판 글 작성 화면
	@GetMapping("/board/writeView")
	public void writeView() throws Exception{
		logger.info("writeView");
	}
	
	//게시판 글 작성
	@PostMapping("/board/write")
	public String write(BoardVO boardVO)throws Exception{
		logger.info("write");
		
		service.write(boardVO);
		
		return "redirect:/list";
	}
	
	//게시판 목록
	@GetMapping("/list")
	public String list(Model model) throws Exception{
		logger.info("list");
		
		model.addAttribute("list",service.list());
		
		return "board/list";
	}
	
	//게시글 조회
	@GetMapping("/readView")
	public String read(Model model, BoardVO boardVO) throws Exception{
		logger.info("read");
		
		model.addAttribute("read",service.read(boardVO.getBno()));
		
		return "board/readView";
	}
	
	
}
