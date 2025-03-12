package com.radish.vo;

public class Review {
	private int sell_user_no;
	private int buy_user_no;
	private int item_no;
	private int review_deg;
	private String review_content;

	public Review(int sell_user_no, int buy_user_no, int item_no, int review_deg, String review_content) {
		super();
		this.sell_user_no = sell_user_no;
		this.buy_user_no = buy_user_no;
		this.item_no = item_no;
		this.review_deg = review_deg;
		this.review_content = review_content;
	}

	public int getSell_user_no() {
		return sell_user_no;
	}

	public void setSell_user_no(int sell_user_no) {
		this.sell_user_no = sell_user_no;
	}

	public int getBuy_user_no() {
		return buy_user_no;
	}

	public void setBuy_user_no(int buy_user_no) {
		this.buy_user_no = buy_user_no;
	}

	public int getItem_no() {
		return item_no;
	}

	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}

	public int getReview_deg() {
		return review_deg;
	}

	public void setReview_deg(int review_deg) {
		this.review_deg = review_deg;
	}

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

}
