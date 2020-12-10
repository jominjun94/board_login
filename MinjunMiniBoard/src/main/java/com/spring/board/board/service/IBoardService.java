package com.spring.board.board.service;

import java.util.List;

import com.spring.board.board.model.BoardVO;
import com.spring.board.board.model.PageVO;

public interface IBoardService {

	
	
	
	
	List<BoardVO> getArticleList(PageVO pagevo);
	
	Integer getTotalCount(PageVO pagevo);
}
