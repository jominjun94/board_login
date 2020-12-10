package com.spring.minjun.board.repository;

import java.util.List;

import com.spring.minjun.board.model.BoardVO;
import com.spring.minjun.board.model.SearchVO;

public interface IBoardMapper {

	
	
	//crud
	//c
	void insert(BoardVO article);
	//r
	BoardVO getArticle(Integer boardNo);
	//u
	void update(BoardVO article);
	//d
	void delete(Integer boardNo);
	
	List<BoardVO> getArticleList(SearchVO search);
	Integer countArticles(SearchVO search);
	
	void updateViewCnt(Integer boardNo);
	
	
	
}
