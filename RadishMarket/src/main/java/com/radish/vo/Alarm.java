package com.radish.vo;

public class Alarm {
	private int alarm_no;
	private int user_no;
	private int alarm_category_no;
	private int link_no;
	private String alarm_reg_datetime;
	private int alarm_check;

	public Alarm(int user_no, int link_no, int alarm_category_no) {
		super();
		this.user_no = user_no;
		this.link_no = link_no;
		this.alarm_category_no = alarm_category_no;
	}
	public Alarm(int user_no, int alarm_category_no, int link_no, String alarm_reg_datetime,
			int alarm_check) {
		super();
		this.user_no = user_no;
		this.alarm_category_no = alarm_category_no;
		this.link_no = link_no;
		this.alarm_reg_datetime = alarm_reg_datetime;
		this.alarm_check = alarm_check;
	}
	public Alarm(int alarm_no, int user_no, int alarm_category_no, int link_no, String alarm_reg_datetime,
			int alarm_check) {
		super();
		this.alarm_no = alarm_no;
		this.user_no = user_no;
		this.alarm_category_no = alarm_category_no;
		this.link_no = link_no;
		this.alarm_reg_datetime = alarm_reg_datetime;
		this.alarm_check = alarm_check;
	}

	public int getAlarm_no() {
		return alarm_no;
	}

	public void setAlarm_no(int alarm_no) {
		this.alarm_no = alarm_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public int getAlarm_category_no() {
		return alarm_category_no;
	}

	public void setAlarm_category_no(int alarm_category_no) {
		this.alarm_category_no = alarm_category_no;
	}

	public int getLink_no() {
		return link_no;
	}

	public void setLink_no(int link_no) {
		this.link_no = link_no;
	}

	public String getAlarm_reg_datetime() {
		return alarm_reg_datetime;
	}

	public void setAlarm_reg_datetime(String alarm_reg_datetime) {
		this.alarm_reg_datetime = alarm_reg_datetime;
	}

	public int getAlarm_check() {
		return alarm_check;
	}

	public void setAlarm_check(int alarm_check) {
		this.alarm_check = alarm_check;
	}

	
}
