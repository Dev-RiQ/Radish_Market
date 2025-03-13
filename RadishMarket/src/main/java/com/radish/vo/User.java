package com.radish.vo;

public class User {
	private int user_no;
	private String user_id;
	private String user_pw;
	private String user_name;
	private int user_age;
	private String user_email;
	private String user_nickname;
	private String user_address;
	private String user_img;
	private String user_phone;
	private String user_reg_datetime;
	private String user_dir_x;
	private String user_dir_y;
	private String user_city;
	private String user_gu;
	private String user_dong;
	private int user_deg;

	@Override
	public String toString() {
		return "User [user_no=" + user_no + ",\n user_id=" + user_id + ",\n user_pw=" + user_pw + ",\n user_name=" + user_name
				+ ",\n user_age=" + user_age + ",\n user_email=" + user_email + ",\n user_nickname=" + user_nickname
				+ ",\n user_address=" + user_address + ",\n user_img=" + user_img + ",\n user_phone=" + user_phone
				+ ",\n user_reg_datetime=" + user_reg_datetime + ",\n user_dir_x=" + user_dir_x + ",\n user_dir_y="
				+ user_dir_y + ",\n user_city=" + user_city + ",\n user_gu=" + user_gu + ",\n user_dong=" + user_dong
				+ ",\n user_deg=" + user_deg + "]";
	}

	public User(String user_id, String user_pw, String user_name, int user_age, String user_email,
			String user_nickname, String user_address, String user_img, String user_phone, String user_reg_datetime,
			String user_dir_x, String user_dir_y, String user_city, String user_gu, String user_dong, int user_deg) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_age = user_age;
		this.user_email = user_email;
		this.user_nickname = user_nickname;
		this.user_address = user_address;
		this.user_img = user_img;
		this.user_phone = user_phone;
		this.user_reg_datetime = user_reg_datetime;
		this.user_dir_x = user_dir_x;
		this.user_dir_y = user_dir_y;
		this.user_city = user_city;
		this.user_gu = user_gu;
		this.user_dong = user_dong;
		this.user_deg = user_deg;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getUser_age() {
		return user_age;
	}

	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_img() {
		return user_img;
	}

	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_reg_datetime() {
		return user_reg_datetime;
	}

	public void setUser_reg_datetime(String user_reg_datetime) {
		this.user_reg_datetime = user_reg_datetime;
	}

	public String getUser_dir_x() {
		return user_dir_x;
	}

	public void setUser_dir_x(String user_dir_x) {
		this.user_dir_x = user_dir_x;
	}

	public String getUser_dir_y() {
		return user_dir_y;
	}

	public void setUser_dir_y(String user_dir_y) {
		this.user_dir_y = user_dir_y;
	}

	public String getUser_city() {
		return user_city;
	}

	public void setUser_city(String user_city) {
		this.user_city = user_city;
	}

	public String getUser_gu() {
		return user_gu;
	}

	public void setUser_gu(String user_gu) {
		this.user_gu = user_gu;
	}

	public String getUser_dong() {
		return user_dong;
	}

	public void setUser_dong(String user_dong) {
		this.user_dong = user_dong;
	}

	public int getUser_deg() {
		return user_deg;
	}

	public void setUser_deg(int user_deg) {
		this.user_deg = user_deg;
	}

}
