package com.radish.vo;

public class Calendar {
	private int calendar_no;
	private int main_user_no;
	private int sub_user_no;
	private int meet_no;
	private String address;
	private String calendar_dir_x;
	private String calendar_dir_y;
	private String calendar_datetime;
	private String calendar_title;
	private String calendar_content;

	public Calendar(int calendar_no, int main_user_no, int sub_user_no, int meet_no, String address,
			String calendar_dir_x, String calendar_dir_y, String calendar_datetime, String calendar_title,
			String calendar_content) {
		super();
		this.calendar_no = calendar_no;
		this.main_user_no = main_user_no;
		this.sub_user_no = sub_user_no;
		this.meet_no = meet_no;
		this.address = address;
		this.calendar_dir_x = calendar_dir_x;
		this.calendar_dir_y = calendar_dir_y;
		this.calendar_datetime = calendar_datetime;
		this.calendar_title = calendar_title;
		this.calendar_content = calendar_content;
	}

	public int getCalendar_no() {
		return calendar_no;
	}

	public void setCalendar_no(int calendar_no) {
		this.calendar_no = calendar_no;
	}

	public int getMain_user_no() {
		return main_user_no;
	}

	public void setMain_user_no(int main_user_no) {
		this.main_user_no = main_user_no;
	}

	public int getSub_user_no() {
		return sub_user_no;
	}

	public void setSub_user_no(int sub_user_no) {
		this.sub_user_no = sub_user_no;
	}

	public int getMeet_no() {
		return meet_no;
	}

	public void setMeet_no(int meet_no) {
		this.meet_no = meet_no;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCalendar_dir_x() {
		return calendar_dir_x;
	}

	public void setCalendar_dir_x(String calendar_dir_x) {
		this.calendar_dir_x = calendar_dir_x;
	}

	public String getCalendar_dir_y() {
		return calendar_dir_y;
	}

	public void setCalendar_dir_y(String calendar_dir_y) {
		this.calendar_dir_y = calendar_dir_y;
	}

	public String getCalendar_datetime() {
		return calendar_datetime;
	}

	public void setCalendar_datetime(String calendar_datetime) {
		this.calendar_datetime = calendar_datetime;
	}

	public String getCalendar_title() {
		return calendar_title;
	}

	public void setCalendar_title(String calendar_title) {
		this.calendar_title = calendar_title;
	}

	public String getCalendar_content() {
		return calendar_content;
	}

	public void setCalendar_content(String calendar_content) {
		this.calendar_content = calendar_content;
	}

}
