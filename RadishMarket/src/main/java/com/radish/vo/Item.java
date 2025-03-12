package com.radish.vo;

public class Item {
	private int item_no;
	private int user_no;
	private int item_category_no;
	private String item_name;
	private String item_content;
	private int item_price;
	private String item_reg_datetime;
	private String item_update_datetime;
	private int item_status;
	private int item_hits;

	public Item(int item_no, int user_no, int item_category_no, String item_name, String item_content, int item_price,
			String item_reg_datetime, String item_update_datetime, int item_status, int item_hits) {
		super();
		this.item_no = item_no;
		this.user_no = user_no;
		this.item_category_no = item_category_no;
		this.item_name = item_name;
		this.item_content = item_content;
		this.item_price = item_price;
		this.item_reg_datetime = item_reg_datetime;
		this.item_update_datetime = item_update_datetime;
		this.item_status = item_status;
		this.item_hits = item_hits;
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

	public int getItem_category_no() {
		return item_category_no;
	}

	public void setItem_category_no(int item_category_no) {
		this.item_category_no = item_category_no;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_content() {
		return item_content;
	}

	public void setItem_content(String item_content) {
		this.item_content = item_content;
	}

	public int getItem_price() {
		return item_price;
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	public String getItem_reg_datetime() {
		return item_reg_datetime;
	}

	public void setItem_reg_datetime(String item_reg_datetime) {
		this.item_reg_datetime = item_reg_datetime;
	}

	public String getItem_update_datetime() {
		return item_update_datetime;
	}

	public void setItem_update_datetime(String item_update_datetime) {
		this.item_update_datetime = item_update_datetime;
	}

	public int getItem_status() {
		return item_status;
	}

	public void setItem_status(int item_status) {
		this.item_status = item_status;
	}

	public int getItem_hits() {
		return item_hits;
	}

	public void setItem_hits(int item_hits) {
		this.item_hits = item_hits;
	}

}
