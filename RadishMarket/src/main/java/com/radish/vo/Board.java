package com.radish.vo;

public class Board {
	private int board_no;
	private int user_no;
	private int board_category_no;
	private int meet_no;
	private String board_title;
	private String board_content;
	private String board_reg_datetime;
	private String board_update_datetime;
	private String board_img;
	private int board_hits;

	public Board(int board_no, int board_hits) {
		super();
		this.board_no = board_no;
		this.board_hits = board_hits;
	}
	public Board(int board_no, int board_category_no, String board_title,
			String board_content, String board_update_datetime, String board_img) {
		super();
		this.board_no = board_no;
		this.board_category_no = board_category_no;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_update_datetime = board_update_datetime;
		this.board_img = board_img;
	}
	public Board(int user_no, int board_category_no, int meet_no, String board_title,
			String board_content, String board_reg_datetime, String board_update_datetime, String board_img) {
		super();
		this.user_no = user_no;
		this.board_category_no = board_category_no;
		this.meet_no = meet_no;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_reg_datetime = board_reg_datetime;
		this.board_update_datetime = board_update_datetime;
		this.board_img = board_img;
	}
	public Board(int board_no, int user_no, int board_category_no, int meet_no, String board_title,
			String board_content, String board_reg_datetime, String board_update_datetime, String board_img,
			int board_hits) {
		super();
		this.board_no = board_no;
		this.user_no = user_no;
		this.board_category_no = board_category_no;
		this.meet_no = meet_no;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_reg_datetime = board_reg_datetime;
		this.board_update_datetime = board_update_datetime;
		this.board_img = board_img;
		this.board_hits = board_hits;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public int getBoard_category_no() {
		return board_category_no;
	}

	public void setBoard_category_no(int board_category_no) {
		this.board_category_no = board_category_no;
	}

	public int getMeet_no() {
		return meet_no;
	}

	public void setMeet_no(int meet_no) {
		this.meet_no = meet_no;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public String getBoard_reg_datetime() {
		return board_reg_datetime;
	}

	public void setBoard_reg_datetime(String board_reg_datetime) {
		this.board_reg_datetime = board_reg_datetime;
	}

	public String getBoard_update_datetime() {
		return board_update_datetime;
	}

	public void setBoard_update_datetime(String board_update_datetime) {
		this.board_update_datetime = board_update_datetime;
	}

	public String getBoard_img() {
		return board_img;
	}

	public void setBoard_img(String board_img) {
		this.board_img = board_img;
	}

	public int getBoard_hits() {
		return board_hits;
	}

	public void setBoard_hits(int board_hits) {
		this.board_hits = board_hits;
	}

}
