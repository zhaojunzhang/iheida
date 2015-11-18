package com.iheida.domin;

import java.util.List;

public class PageBean {
	public static final int NUMPERPAGE=10;//每条多少页
	private int pNum;//当前第几页
	private int totalPageNum;//总页数
	private int totalRecordNum;//总记录数
	private List<User> user;
	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	public int getTotalPageNum() {
		return totalPageNum;
	}
	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public int getTotalRecordNum() {
		return totalRecordNum;
	}
	public void setTotalRecordNum(int totalRecordNum) {
		this.totalRecordNum = totalRecordNum;
	}
	

}
