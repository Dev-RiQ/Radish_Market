package com.radish.vo;

public class ItemImg {
	private String item_img;
	private int item_no;


	public ItemImg(String item_img, int item_no) {
		super();
		this.item_img = item_img;
		this.item_no = item_no;
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
