package com.spring.minjun.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.minjun.board.model.BoardVO;
import com.spring.minjun.board.model.SearchVO;
import com.spring.minjun.board.repository.IBoardMapper;


@Service
public class BoardService implements IBoardService {

	@Autowired
	IBoardMapper mapper;
	
	@Override
	public void insert(BoardVO article) {
		
mapper.insert(article);
	}

	@Override
	public BoardVO getArticle(Integer boardNo) {
		// TODO Auto-generated method stub
		mapper.updateViewCnt(boardNo);
		return mapper.getArticle(boardNo);
	}

	@Override
	public void update(BoardVO article) {
	 
mapper.update(article);
	}

	@Override
	public void delete(Integer boardNo) {
		// TODO Auto-generated method stub
mapper.delete(boardNo);
	}

	@Override
	public List<BoardVO> getArticleList(SearchVO search) {
		// TODO Auto-generated method stub
		return mapper.getArticleList(search);
	}

	@Override
	public Integer countArticles(SearchVO search) {
		// TODO Auto-generated method stub
		return mapper.countArticles(search);
	}

}
