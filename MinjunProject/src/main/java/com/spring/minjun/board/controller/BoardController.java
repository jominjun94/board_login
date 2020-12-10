package com.spring.minjun.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.minjun.board.commons.PageCreator;
import com.spring.minjun.board.model.BoardVO;
import com.spring.minjun.board.model.SearchVO;
import com.spring.minjun.board.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	IBoardService service;
	
	@GetMapping("/list")
	public String list(SearchVO search, Model model) {
		
		

		PageCreator pc = new PageCreator();
		
		
		pc.setPasing(search);
		List<BoardVO> articles = service.getArticleList(search);
		pc.setArticleTotalCount(service.countArticles(search));
		
		
		
		
	
		model.addAttribute("articles",articles); // 
		model.addAttribute("search",search);
		model.addAttribute("pc", pc);
		return "board/list";
		
		
	}
	// 이 부분을 인터센터가 처리하게 해주자 
	@GetMapping("/write")
	public String write(HttpSession session) {
		
		
		//if(session.getAttribute("login") == null) {
		//	return "redirect:/";
		//}
		return "board/write";
		
	}
	
	@PostMapping("/write")
	public String write(BoardVO article, RedirectAttributes ra) {
		
		service.insert(article);
		ra.addFlashAttribute("msg", "regSuccess");
		return "redirect:/board/list";
		
		
	}
	
	@GetMapping("/content/{boardNo}")
	public String content(@PathVariable Integer boardNo, Model model) {
		
	
		model.addAttribute("article",service.getArticle(boardNo));
		
		return "board/content";
	}
	
	@PostMapping("/delete")
	public String delete(Integer boardNo,RedirectAttributes ra) {
		
		service.delete(boardNo);
		ra.addFlashAttribute("msg", "delSuccess");
		return "redirect:/board/list";
	}
	
	@PostMapping("/modify")
	public String modify(Integer boardNo ,Model model) {
		
	
		model.addAttribute("article", 	service.getArticle(boardNo));
		return "/board/modify";
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
