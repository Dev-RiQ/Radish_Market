package com.radish.vo;

public class Emoji {
	private int min_deg;
	private int max_deg;
	private String emoji;
	
	public Emoji(int min_deg, int max_deg, String emoji) {
		super();
		this.min_deg = min_deg;
		this.max_deg = max_deg;
		this.emoji = emoji;
	}

	public int getMin_deg() {
		return min_deg;
	}
	public void setMin_deg(int min_deg) {
		this.min_deg = min_deg;
	}
	public int getMax_deg() {
		return max_deg;
	}
	public void setMax_deg(int max_deg) {
		this.max_deg = max_deg;
	}
	public String getEmoji() {
		return emoji;
	}
	public void setEmoji(String emoji) {
		this.emoji = emoji;
	}
}