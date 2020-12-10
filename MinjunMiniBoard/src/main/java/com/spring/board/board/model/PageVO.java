package com.spring.board.board.model;

public class PageVO {

	
	private Integer page;
	private Integer countPerPage;
	private String keyword;
	private String condition;
	
	
	
	
	public PageVO(Integer page, Integer countPerPage, String keyword, String condition) {
	
		page = 1;
		this.countPerPage = 10;
		this.keyword = "";
		this.condition = "";
	}
	
	
	public Integer getPageStart() {
		return (this.page - 1) * this.countPerPage;
}
	
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getCountPerPage() {
		return countPerPage;
	}
	public void setCountPerPage(Integer countPerPage) {
		this.countPerPage = countPerPage;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	
	

	
}
