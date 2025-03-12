package com.radish.vo;

public class ItemImg {
	private int item_no;
	private String item_img;

	public ItemImg(int item_no, String item_img) {
		super();
		this.item_no = item_no;
		this.item_img = item_img;
	}

	public int getItem_no() {
		return item_no;
	}

	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}

	public String getItem_img() {
		return item_img;
	}

	public void setItem_img(String item_img) {
		this.item_img = item_img;
	}

}
