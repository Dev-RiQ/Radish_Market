package com.radish.vo;

public class Like {

	private int board_no;
	private int user_no;

	public Like(int board_no, int user_no) {
		super();
		this.board_no = board_no;
		this.user_no = user_no;
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

}
