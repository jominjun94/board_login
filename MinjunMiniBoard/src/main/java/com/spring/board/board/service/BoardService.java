package com.spring.board.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.board.model.BoardVO;
import com.spring.board.board.model.PageVO;
import com.spring.board.board.repository.IBoardMapper;



@Service
public class BoardService implements IBoardService {

	@Autowired
	private IBoardMapper mapper;
	
	
	
	@Override
	public List<BoardVO> getArticleList(PageVO pagevo) {
		
		return mapper.getArticleList(pagevo);
	}



	@Override
	public Integer getTotalCount(PageVO pagevo) {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(pagevo);
	}

}
