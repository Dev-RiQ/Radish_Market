package com.radish.vo;

public class MeetUser {
	private int meet_no;
	private int user_no;

	public MeetUser(int meet_no, int user_no) {
		super();
		this.meet_no = meet_no;
		this.user_no = user_no;
	}

	public int getMeet_no() {
		return meet_no;
	}

	public void setMeet_no(int meet_no) {
		this.meet_no = meet_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

}
