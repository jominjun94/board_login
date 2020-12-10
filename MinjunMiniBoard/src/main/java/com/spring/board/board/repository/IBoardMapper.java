package com.spring.board.board.repository;

import java.util.List;

import com.spring.board.board.model.BoardVO;
import com.spring.board.board.model.PageVO;

public interface IBoardMapper {
	
	//crud
	//
	//list 게시판 가져오기
	//총 갯수 가져오기 
	
	List<BoardVO> getArticleList(PageVO pagevo);
	Integer getTotalCount(PageVO pagevo);

}
