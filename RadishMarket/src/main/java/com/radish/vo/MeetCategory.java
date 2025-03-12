package com.radish.vo;

public class MeetCategory {
	private int item_category_no;
	private String item_category_name;

	public MeetCategory(int item_category_no, String item_category_name) {
		super();
		this.item_category_no = item_category_no;
		this.item_category_name = item_category_name;
	}

	public int getItem_category_no() {
		return item_category_no;
	}

	public void setItem_category_no(int item_category_no) {
		this.item_category_no = item_category_no;
	}

	public String getItem_category_name() {
		return item_category_name;
	}

	public void setItem_category_name(String item_category_name) {
		this.item_category_name = item_category_name;
	}

}
