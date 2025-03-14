package com.radish.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.Meet;
import com.radish.vo.MeetCategory;

public class MeetCategoryDAO {
	private static MeetCategoryDAO instance;
	private MeetCategoryDAO() {}
	public static MeetCategoryDAO getInstance() {
		if(instance == null) instance = new MeetCategoryDAO();
		return instance;
	}
	public List<String> getMeetCategoryListByMeetNo(List<Meet> meetList) {
		List<String> list = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()){
			for(Meet meet : meetList) {
				int meet_category_no = meet.getMeet_category();
				list.add(session.selectOne("getMeetCategoryListByMeetNo", meet_category_no));
			}
		} catch (Exception e) {
			System.out.println("getMeetCategoryListByMeetNo fail");
			e.printStackTrace();
		}
		return list;
	}
	public List<MeetCategory> getAllMeetCategoryList() {
		List<MeetCategory> list = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			list = session.selectList("getAllMeetCategoryList");
		} catch (Exception e) {
			System.out.println("getAllMeetCategoryList fail");
			e.printStackTrace();
		}
		return list;
	}
	public String getAMeetCategoryName(int meet_category) {
		String category = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			category = session.selectOne("getAMeetCategoryName", meet_category);
		} catch (Exception e) {
			System.out.println("getAMeetCategoryName fail");
			e.printStackTrace();
		}
		return category;
	}
}
