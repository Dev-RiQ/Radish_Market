package com.radish.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.Alarm;

public class AlarmDAO {
	private static AlarmDAO instance;
	private AlarmDAO() {}
	public static AlarmDAO getInstance() {
		if(instance == null) instance = new AlarmDAO();
		return instance;
	}
	public boolean insertAAlarm(Alarm alarm) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.insert("insertAAlarm", alarm);
			session.commit();
		} catch (Exception e) {
			System.out.println("insertAAlarm fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	public List<Alarm> getAlarmListByUserNo(int user_no) {
		List<Alarm> list = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			list = session.selectList("getAlarmListByUserNo", user_no);
		} catch (Exception e) {
			System.out.println("getAlarmListByUserNo fail");
			e.printStackTrace();
		}
		return list;
	}
	public boolean deleteAAlarm(int alarm_no) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.delete("deleteAAlarm", alarm_no);
			session.commit();
		} catch (Exception e) {
			System.out.println("deleteAAlarm fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	public int getAlarmNo(Alarm alarm) {
		int alarm_no = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			alarm_no = session.selectOne("getAlarmNo", alarm);
		} catch (Exception e) {
			System.out.println("getAlarmNo fail");
			e.printStackTrace();
		}
		return alarm_no;
	}
	public boolean setAlarmCheck(int alarm_no) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.update("setAlarmCheck", alarm_no);
			session.commit();
		} catch (Exception e) {
			System.out.println("setAlarmCheck fail");
			e.printStackTrace();
		}
		return action != 0;
	}
}
