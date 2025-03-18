package com.radish.vo;

public class Cart {
	private int item_no;
	private int user_no;
	private int check_reviewed;
	public Cart(int item_no, int user_no, int check_reviewed) {
		super();
		this.item_no = item_no;
		this.user_no = user_no;
		this.check_reviewed = check_reviewed;
	}
	public int getItem_no() {
		return item_no;
	}
	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public int getCheck_reviewed() {
		return check_reviewed;
	}
	public void setCheck_reviewed(int check_reviewed) {
		this.check_reviewed = check_reviewed;
	}
	
	
}
