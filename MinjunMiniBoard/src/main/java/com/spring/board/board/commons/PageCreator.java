package com.spring.board.board.commons;

import com.spring.board.board.model.PageVO;

public class PageCreator {
	
	
	
	//객체 생성 전에 객체에 4개를 pagevo  안에 보내줄거다 - + totalcount는 db에서 뺴온다
	
	//일단 게시글 가져올때는 이거 4개 보내준다 1.page 2.countperpage 3.keyword 4.condition
	private PageVO pageVO;
	private Integer articleTotalCount; // db처리
	private Integer beginPage;
	private Integer endPage;
	private boolean prev;
	private boolean next;
	
	
	
	//페이징 알고리즘을 수행할 메서드 선언.
	private void calcDataOfPage() {
		
		//보정 전 끝 페이지 구하기
		endPage = (int)Math.ceil(pageVO.getPage() 
						/ (double)displayPageNum)
				  		* displayPageNum;
		
		//시작 페이지 번호 구하기
		beginPage = (endPage - displayPageNum) + 1;
		
		//현재 시작페이지가 1이라면 이전버튼 활성화 여부를 false로 지정
		prev = (beginPage == 1) ? false : true;
		
		//마지막 페이지인지 여부 확인 후 다음 버튼 비활성.
		next = (articleTotalCount <= (endPage * pageVO.getCountPerPage())) ? false : true;
		
		//재보정 여부 판단하기
		if(!isNext()) {
			//끝 페이지 재보정하기
			endPage = (int)Math.ceil(articleTotalCount / (double)pageVO.getCountPerPage());
		}
	}
	
	
	
	public PageVO getPageVO() {
		return pageVO;
	}

	public void setPageVO(PageVO pageVO) {
		this.pageVO = pageVO;
	}

	public Integer getArticleTotalCount() {
		return articleTotalCount;
	}

	public void setArticleTotalCount(Integer articleTotalCount) {
		this.articleTotalCount = articleTotalCount;
		calcDataOfPage();
	}

	public Integer getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(Integer beginPage) {
		this.beginPage = beginPage;
	}

	public Integer getEndPage() {
		return endPage;
	}

	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public Integer getDisplayPageNum() {
		return displayPageNum;
	}

	private final Integer displayPageNum = 10;
	

}
