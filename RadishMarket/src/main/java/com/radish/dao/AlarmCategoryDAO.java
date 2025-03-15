package com.radish.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.AlarmCategory;

public class AlarmCategoryDAO {
	private static AlarmCategoryDAO instance;
	private AlarmCategoryDAO() {}
	public static AlarmCategoryDAO getInstance() {
		if(instance == null) instance = new AlarmCategoryDAO();
		return instance;
	}
	public List<AlarmCategory> getAllAlarmCategoryList() {
		List<AlarmCategory> list = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			list = session.selectList("getAllAlarmCategoryList");
		} catch (Exception e) {
			System.out.println("getAllAlarmCategoryList fail");
			e.printStackTrace();
		}
		return list;
	}
	public String getAAlarmCategoryName(int alarm_category_no) {
		String name = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			name = session.selectOne("getAAlarmCategoryName", alarm_category_no);
		} catch (Exception e) {
			System.out.println("getAAlarmCategoryName fail");
			e.printStackTrace();
		}
		return name;
	}
	public boolean insertAlarmCategory(String alarm_category_name) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action= session.insert("insertAlarmCategory", alarm_category_name);
			session.commit();
		} catch (Exception e) {
			System.out.println("insertAlarmCategory fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	public boolean updateAlarmCategory(AlarmCategory alarmCategory) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action= session.update("updateAlarmCategory", alarmCategory);
			session.commit();
		} catch (Exception e) {
			System.out.println("updateAlarmCategory fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	public boolean deleteAlarmCategory(int alarm_category_no) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action= session.delete("deleteAlarmCategory", alarm_category_no);
			session.commit();
		} catch (Exception e) {
			System.out.println("deleteAlarmCategory fail");
			e.printStackTrace();
		}
		return action != 0;
	}
}
