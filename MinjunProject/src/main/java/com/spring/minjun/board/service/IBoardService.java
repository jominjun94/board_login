package com.spring.minjun.board.service;

import java.util.List;

import com.spring.minjun.board.model.BoardVO;
import com.spring.minjun.board.model.SearchVO;

public interface IBoardService {

	
	void insert(BoardVO article);
	//r
	BoardVO getArticle(Integer boardNo);
	//u
	void update(BoardVO article);
	//d
	void delete(Integer boardNo);
	
	
	List<BoardVO> getArticleList(SearchVO search);
	
	Integer countArticles(SearchVO search);
}
