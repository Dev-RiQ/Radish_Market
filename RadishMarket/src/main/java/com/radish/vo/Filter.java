package com.radish.vo;

public class Filter {
	int start;
	int item_status;
	int category_no;
	int price_min;
	int price_max;
	String user_dong;
	int order_by;
	
	public Filter(int start, int category_no, String user_dong, int order_by) {
		super();
		this.start = start;
		this.category_no = category_no;
		this.user_dong = user_dong;
		this.order_by = order_by;
	}
	
	public Filter(int start, int item_status, int category_no, int price_min, int price_max, String user_dong, int order_by) {
		super();
		this.start = start;
		this.item_status = item_status;
		this.category_no = category_no;
		this.price_min = price_min;
		this.price_max = price_max;
		this.user_dong = user_dong;
		this.order_by = order_by;
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
	public String getUser_dong() {
		return user_dong;
	}
	public void setUser_dong(String user_dong) {
		this.user_dong = user_dong;
	}
	public int getOrder_by() {
		return order_by;
	}
	public void setOrder_by(int order_by) {
		this.order_by = order_by;
	}
	
}
