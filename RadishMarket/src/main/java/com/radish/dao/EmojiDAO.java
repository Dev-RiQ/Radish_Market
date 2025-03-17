package com.radish.dao;

import org.apache.ibatis.session.SqlSession;
import com.radish.util.DBUtil;

public class EmojiDAO {
	private static EmojiDAO instance;
	private EmojiDAO() {}
	public static EmojiDAO getInstance() {
		if(instance == null) instance = new EmojiDAO();
		return instance;
	}
	
	public String getEmoji(int user_deg) {
		String emoji = "";
		try (SqlSession session = DBUtil.getInstance().openSession()){
			emoji = session.selectOne("getEmoji", user_deg);
		} catch (Exception e) {
			System.out.println("getEmoji fail");
			e.printStackTrace();
		}
		return emoji;
	}
}
