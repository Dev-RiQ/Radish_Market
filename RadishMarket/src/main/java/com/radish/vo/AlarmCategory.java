package com.radish.vo;

public class AlarmCategory {
	private int alarm_category_no;
	private String alarm_category_name;
	private String alarm_category_content;

	public AlarmCategory(int alarm_category_no, String alarm_category_name, String alarm_category_content) {
		super();
		this.alarm_category_no = alarm_category_no;
		this.alarm_category_name = alarm_category_name;
		this.alarm_category_content = alarm_category_content;
	}

	public int getAlarm_category_no() {
		return alarm_category_no;
	}

	public void setAlarm_category_no(int alarm_category_no) {
		this.alarm_category_no = alarm_category_no;
	}

	public String getAlarm_category_name() {
		return alarm_category_name;
	}

	public String getAlarm_category_content() {
		return alarm_category_content;
	}

	public void setAlarm_category_content(String alarm_category_content) {
		this.alarm_category_content = alarm_category_content;
	}

	public void setAlarm_category_name(String alarm_category_name) {
		this.alarm_category_name = alarm_category_name;
	}
}
