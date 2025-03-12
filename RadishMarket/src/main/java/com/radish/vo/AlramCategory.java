package com.radish.vo;

public class AlramCategory {
	private int alram_category_no;
	private String alram_category_name;

	public AlramCategory(int alram_category_no, String alram_category_name) {
		super();
		this.alram_category_no = alram_category_no;
		this.alram_category_name = alram_category_name;
	}

	public int getAlram_category_no() {
		return alram_category_no;
	}

	public void setAlram_category_no(int alram_category_no) {
		this.alram_category_no = alram_category_no;
	}

	public String getAlram_category_name() {
		return alram_category_name;
	}

	public void setAlram_category_name(String alram_category_name) {
		this.alram_category_name = alram_category_name;
	}
}
