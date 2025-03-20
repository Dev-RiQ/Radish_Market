package com.radish.vo;

public class Letter {
	private int letter_no;
	private int send_user_no;
	private int receive_user_no;
	private int item_no;
	private String letter_title;
	private String letter_content;
	private String letter_reg_datetime;
	private int letter_check;

	public Letter(int letter_no, int send_user_no, int receive_user_no, int item_no, String letter_title,
			String letter_content, String letter_reg_datetime, int letter_check) {
		super();
		this.letter_no = letter_no;
		this.send_user_no = send_user_no;
		this.receive_user_no = receive_user_no;
		this.item_no = item_no;
		this.letter_title = letter_title;
		this.letter_content = letter_content;
		this.letter_reg_datetime = letter_reg_datetime;
		this.letter_check = letter_check;
	}
	public Letter(int send_user_no, int receive_user_no, String letter_title, String letter_reg_datetime, int letter_no,
			String letter_content, int letter_check, int item_no) {
		super();
		this.send_user_no = send_user_no;
		this.receive_user_no = receive_user_no;
		this.letter_title = letter_title;
		this.letter_reg_datetime = letter_reg_datetime;
		this.letter_no = letter_no;
		this.letter_content = letter_content;
		this.letter_check = letter_check;
		this.item_no = item_no;
	}
	public Letter(int letter_no, int receive_user_no, int send_user_no, String letter_title, String letter_content,
			String letter_reg_datetime, int letter_check, int item_no) {
		super();
		this.letter_no = letter_no;
		this.receive_user_no = receive_user_no;
		this.send_user_no = send_user_no;
		this.letter_title = letter_title;
		this.letter_content = letter_content;
		this.letter_reg_datetime = letter_reg_datetime;
		this.letter_check = letter_check;
		this.item_no = item_no;
	}
	public Letter(int letter_no, int receive_user_no, int send_user_no,  int item_no, String letter_title, String letter_content,
			 int letter_check) {
		super();
		this.letter_no = letter_no;
		this.receive_user_no = receive_user_no;
		this.send_user_no = send_user_no;
		this.item_no = item_no;
		this.letter_title = letter_title;
		this.letter_content = letter_content;
		this.letter_check = letter_check;
	}
	public Letter(int send_user_no, int receive_user_no, String letter_title, String letter_reg_datetime,
			String letter_content, int letter_check, int item_no) {
		super();
		this.send_user_no = send_user_no;
		this.receive_user_no = receive_user_no;
		this.letter_title = letter_title;
		this.letter_reg_datetime = letter_reg_datetime;
		this.letter_content = letter_content;
		this.letter_check = letter_check;
		this.item_no = item_no;
	}

	public int getLetter_no() {
		return letter_no;
	}

	public void setLetter_no(int letter_no) {
		this.letter_no = letter_no;
	}

	public int getReceive_user_no() {
		return receive_user_no;
	}

	public void setReceive_user_no(int receive_user_no) {
		this.receive_user_no = receive_user_no;
	}

	public int getSend_user_no() {
		return send_user_no;
	}

	public void setSend_user_no(int send_user_no) {
		this.send_user_no = send_user_no;
	}

	public String getLetter_title() {
		return letter_title;
	}

	public void setLetter_title(String letter_title) {
		this.letter_title = letter_title;
	}

	public String getLetter_content() {
		return letter_content;
	}

	public void setLetter_content(String letter_content) {
		this.letter_content = letter_content;
	}

	public String getLetter_reg_datetime() {
		return letter_reg_datetime;
	}

	public void setLetter_reg_datetime(String letter_reg_datetime) {
		this.letter_reg_datetime = letter_reg_datetime;
	}

	public int getLetter_check() {
		return letter_check;
	}

	public void setLetter_check(int letter_check) {
		this.letter_check = letter_check;
	}

	public int getItem_no() {
		return item_no;
	}

	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}

}
