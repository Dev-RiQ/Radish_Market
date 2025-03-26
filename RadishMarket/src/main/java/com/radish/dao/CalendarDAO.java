package com.radish.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.Calendar;

public class CalendarDAO {
	private static CalendarDAO instance;
	private CalendarDAO() {}
	public static CalendarDAO getInstance() {
		if(instance == null) instance = new CalendarDAO();
		return instance;
	}
	
	public boolean insertACalendar(Calendar calendar) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.insert("insertACalenadr", calendar);
			session.commit();
		} catch (Exception e) {
			System.out.println("insertACalenadr fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	public List<Calendar> getCalendarListByUserNo(int user_no, String date_num) {
		List<Calendar> list = null;
		Map<String, Object> param = new HashMap<>();
		param.put("user_no", user_no);
		param.put("date_num", date_num);
		try (SqlSession session = DBUtil.getInstance().openSession()){
			list = session.selectList("getCalendarListByUserNo", param);
		} catch (Exception e) {
			System.out.println("getCalendarListByUserNo fail");
			e.printStackTrace();
		}
		return list;
	}
	public boolean deleteACalendarByCalendarNo(int calendar_no) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.delete("deleteACalendarByCalendarNo", calendar_no);
			session.commit();
		} catch (Exception e) {
			System.out.println("deleteACalendarByCalendarNo fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	public boolean updateACalendar(Calendar calendar) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.update("updateACalendar", calendar);
			session.commit();
		} catch (Exception e) {
			System.out.println("updateACalendar fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	public Calendar getACalendarByCalendarNo(int calendar_no) {
		Calendar calendar = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			calendar = session.selectOne("getACalendarByCalendarNo", calendar_no);
		} catch (Exception e) {
			System.out.println("getACalendarByCalendarNo fail");
			e.printStackTrace();
		}
		return calendar;
	}
	public List<Calendar> getMeetCalendarLimitList(int meet_no) {
		List<Calendar> calendarList = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			calendarList = session.selectList("getMeetCalendarLimitList", meet_no);
		} catch (Exception e) {
			System.out.println("getMeetCalendarLimitList fail");
			e.printStackTrace();
		}
		return calendarList;
	}
	public int getMeetCalendarCount(int meet_no) {
		int count = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			count = session.selectOne("getMeetCalendarCount", meet_no);
		} catch (Exception e) {
			System.out.println("getMeetCalendarCount fail");
			e.printStackTrace();
		}
		return count;
	}
}
