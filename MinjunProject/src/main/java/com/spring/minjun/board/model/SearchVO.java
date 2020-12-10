package com.spring.minjun.board.model;

public class SearchVO {

	private Integer page;
	private Integer counterPerPage;
	private String keyword;
	private String condition;
	
	
	
	
	public SearchVO(Integer page, Integer counterPerPage, String keyword, String condition) {
	
		this.page = 1;
		this.counterPerPage = 10;
		this.keyword = "";
		this.condition = "";
	}
	
	public Integer getPageStart() {
		
		return (this.page - 1) * this.counterPerPage;
		
	}
	
	public Integer getPage() {
		
		
		return page;
	
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getCounterPerPage() {
		return counterPerPage;
	}
	public void setCounterPerPage(Integer counterPerPage) {
		this.counterPerPage = counterPerPage;
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
