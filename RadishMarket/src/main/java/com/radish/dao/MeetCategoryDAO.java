package com.radish.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.MeetCategory;
import com.radish.vo.Meet;

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
				int meet_category_no = meet.getMeet_category_no();
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
	public String getAMeetCategoryName(int meet_category_no) {
		String category = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			category = session.selectOne("getAMeetCategoryName", meet_category_no);
		} catch (Exception e) {
			System.out.println("getAMeetCategoryName fail");
			e.printStackTrace();
		}
		return category;
	}
	
	public boolean insertMeetCategory(String meet_category_name) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action= session.insert("insertMeetCategory", meet_category_name);
			session.commit();
		} catch (Exception e) {
			System.out.println("insertMeetCategory fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	public boolean updateMeetCategory(MeetCategory meetCategory) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action= session.update("updateMeetCategory", meetCategory);
			session.commit();
		} catch (Exception e) {
			System.out.println("updateMeetCategory fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	public boolean deleteMeetCategory(int meet_category_no) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action= session.delete("deleteMeetCategory", meet_category_no);
			session.commit();
		} catch (Exception e) {
			System.out.println("deleteMeetCategory fail");
			e.printStackTrace();
		}
		return action != 0;
	}
}
