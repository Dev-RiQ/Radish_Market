package com.radish.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.Calendar;
import com.radish.vo.Letter;

public class CalendarDAO {
	private static CalendarDAO instance;
	private CalendarDAO() {}
	public static CalendarDAO getInstance() {
		if(instance == null) instance = new CalendarDAO();
		return instance;
	}
	
	public boolean insertACalenadr(Calendar calendar) {
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
	public List<Letter> getCalendarListByUserNo(int user_no) {
		List<Letter> list = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			list = session.selectList("getLetterListByUserNo", user_no);
		} catch (Exception e) {
			System.out.println("getLetterListByUserNo fail");
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
}
