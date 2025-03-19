package com.radish.vo;

public class Zzim {
	private int user_no;
	private int item_no;


	public Zzim(int user_no, int item_no) {
		super();
		this.user_no = user_no;
		this.item_no = item_no;
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

}
