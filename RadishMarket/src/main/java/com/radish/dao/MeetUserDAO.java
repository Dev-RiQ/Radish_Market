package com.radish.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.Meet;
import com.radish.vo.MeetUser;

public class MeetUserDAO {
	private static MeetUserDAO instance;
	private MeetUserDAO() {}
	public static MeetUserDAO getInstance() {
		if(instance == null) instance = new MeetUserDAO();
		return instance;
	}
	
	public List<Integer> getUserCountListByMeetNo(List<Meet> meetList) {
		List<Integer> list = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()){
			for(Meet meet : meetList) {
				int meet_no = meet.getMeet_no();
				list.add(session.selectOne("getUserCountListByMeetNo", meet_no));
			}
		} catch (Exception e) {
			System.out.println("getUserCountListByMeetNo fail");
			e.printStackTrace();
		}
		return list;
	}
	public boolean hasUser(int meet_no, int log) {
		try (SqlSession session = DBUtil.getInstance().openSession()){
			if(session.selectOne("hasUser", new MeetUser(meet_no, log)) != null)
				return true;
		} catch (Exception e) {
			System.out.println("hasUser fail");
			e.printStackTrace();
		}
		return false;
	}
	public List<Integer> getUserNoListByMeetNo(int meet_no) {
		List<Integer> list = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			list = session.selectList("getUserNoListByMeetNo", meet_no);
		} catch (Exception e) {
			System.out.println("getUserNoListByMeetNo fail");
			e.printStackTrace();
		}
		return list;
	}
	public boolean insertMeetUser(int meet_no, int user_no) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.insert("insertMeetUser", new MeetUser(meet_no, user_no));
			session.commit();
		} catch (Exception e) {
			System.out.println("insertMeetUser fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	public boolean deleteMeetUser(int meet_no, int log) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.delete("deleteMeetUser", new MeetUser(meet_no, log));
			session.commit();
		} catch (Exception e) {
			System.out.println("deleteMeetUser fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	public List<Integer> getMeetNoListByUserNo(int user_no) {
		List<Integer> list = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			list = session.selectList("getMeetNoListByUserNo", user_no);
		} catch (Exception e) {
			System.out.println("getMeetNoListByUserNo fail");
			e.printStackTrace();
		}
		return list;
	}
	public int getAUserMeetTotalCountByUserNo(int user_no) {
		int cnt = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			cnt = session.selectOne("getAUserMeetTotalCountByUserNo", user_no);
		} catch (Exception e) {
			System.out.println("getAUserMeetTotalCountByUserNo fail");
			e.printStackTrace();
		}
		return cnt;
	}
}
