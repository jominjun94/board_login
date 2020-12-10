package com.spring.board.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.board.board.commons.PageCreator;
import com.spring.board.board.model.BoardVO;
import com.spring.board.board.model.PageVO;
import com.spring.board.board.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private IBoardService service;
	
	//4개받고 
	@GetMapping
	public String list(PageVO pagevo , Model model) {
		
		
		PageCreator pc  = new PageCreator();
		pc.setPageVO(pagevo);
		pc.setArticleTotalCount(service.getTotalCount(pagevo));
		List<BoardVO> articles = service.getArticleList(pagevo);
		
		model.addAttribute("pc",pc);
		model.addAttribute("articles",articles);
		
		
		
		
		
		return "/board/list";
		
	}
	
	
}
