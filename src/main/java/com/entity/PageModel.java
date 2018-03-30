package com.entity;

import java.io.Serializable;
import java.util.List;

public class PageModel<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -533800512030468705L;
	private  List<T> data;
	//总共有多少页
	private  int  totalPage;
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public PageModel(List<T> data, int totalPage) {
		super();
		this.data = data;
		this.totalPage = totalPage;
	}
	public PageModel() {
		super();
	}
}
