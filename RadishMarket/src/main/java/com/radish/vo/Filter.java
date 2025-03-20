package com.radish.vo;

public class Filter {
	int start;
	int item_status;
	int category_no;
	int price_min;
	int price_max;
	String gu;
	String dong;
	int order_by;
	int user_no;
	int meet_no;
	
	public Filter(int start) {
		this.start = start;
	}
	public Filter(int start, int category_no, String dong, int order_by) {
		super();
		this.start = start;
		this.category_no = category_no;
		this.dong = dong;
		this.order_by = order_by;
	}
	
	public Filter(int start, int item_status, int category_no, int price_min, int price_max, String dong, int order_by) {
		super();
		this.start = start;
		this.item_status = item_status;
		this.category_no = category_no;
		this.price_min = price_min;
		this.price_max = price_max;
		this.dong = dong;
		this.order_by = order_by;
	}

	public Filter(int start, int item_status, int category_no, int price_min, int price_max, String gu, String dong,
			int order_by, int user_no, int meet_no) {
		super();
		this.start = start;
		this.item_status = item_status;
		this.category_no = category_no;
		this.price_min = price_min;
		this.price_max = price_max;
		this.gu = gu;
		this.dong = dong;
		this.order_by = order_by;
		this.user_no = user_no;
		this.meet_no = meet_no;
	}
	public String getGu() {
		return gu;
	}
	public void setGu(String gu) {
		this.gu = gu;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public int getPrice_min() {
		return price_min;
	}
	public void setPrice_min(int price_min) {
		this.price_min = price_min;
	}
	public int getPrice_max() {
		return price_max;
	}
	public void setPrice_max(int price_max) {
		this.price_max = price_max;
	}
	public int getItem_status() {
		return item_status;
	}
	public void setItem_status(int item_status) {
		this.item_status = item_status;
	}
	public int getCategory_no() {
		return category_no;
	}
	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}
	public int getOrder_by() {
		return order_by;
	}
	public void setOrder_by(int order_by) {
		this.order_by = order_by;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public int getMeet_no() {
		return meet_no;
	}
	public void setMeet_no(int meet_no) {
		this.meet_no = meet_no;
	}
	
}
