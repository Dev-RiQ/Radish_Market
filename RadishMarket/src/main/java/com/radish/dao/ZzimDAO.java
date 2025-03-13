package com.radish.dao;

public class ZzimDAO {
	private static ZzimDAO instance;
	private ZzimDAO() {}
	public static ZzimDAO getInstance() {
		if(instance == null) instance = new ZzimDAO();
		return instance;
	}
}
