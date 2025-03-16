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
}
