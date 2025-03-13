package com.radish.vo;

/**
 * 
 */
public class Comment {
	private int comment_no;
	private int board_no;
	private int user_no;
	private String comment_content;
	private String comment_reg_datetime;
	private int check_update;

	public Comment(int board_no, int user_no, String comment_content, String comment_reg_datetime) {
		super();
		this.board_no = board_no;
		this.user_no = user_no;
		this.comment_content = comment_content;
		this.comment_reg_datetime = comment_reg_datetime;
	}
	public Comment(int comment_no, int board_no, int user_no, String comment_content, String comment_reg_datetime,
			int check_update) {
		super();
		this.comment_no = comment_no;
		this.board_no = board_no;
		this.user_no = user_no;
		this.comment_content = comment_content;
		this.comment_reg_datetime = comment_reg_datetime;
		this.check_update = check_update;
	}

	public int getComment_no() {
		return comment_no;
	}

	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
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

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public String getComment_reg_datetime() {
		return comment_reg_datetime;
	}

	public void setComment_reg_datetime(String comment_reg_datetime) {
		this.comment_reg_datetime = comment_reg_datetime;
	}

	public int getCheck_update() {
		return check_update;
	}

	public void setCheck_update(int check_update) {
		this.check_update = check_update;
	}

}
