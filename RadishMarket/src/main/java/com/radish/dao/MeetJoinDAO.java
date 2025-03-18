package com.radish.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.MeetJoin;

public class MeetJoinDAO {
	private static MeetJoinDAO instance;
	private MeetJoinDAO() {}
	public static MeetJoinDAO getInstance() {
		if(instance == null) instance = new MeetJoinDAO();
		return instance;
	}
	public List<MeetJoin> getMeetJoinListByMeetNo(int meet_no) {
		List<MeetJoin> list = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			list = session.selectList("getMeetJoinListByMeetNo", meet_no);
		} catch (Exception e) {
			System.out.println("getMeetJoinListByMeetNo fail");
			e.printStackTrace();
		}
		return list;
	}
	public boolean hasMeetJoin(MeetJoin meetJoin) {
		try (SqlSession session = DBUtil.getInstance().openSession()){
			if(session.selectOne("hasMeetJoin", meetJoin) != null)
				return true;
		} catch (Exception e) {
			System.out.println("hasMeetJoin fail");
			e.printStackTrace();
		}
		return false;
	}
	public boolean insertMeetJoin(MeetJoin meetJoin) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.insert("insertMeetJoin", meetJoin);
			session.commit();
		} catch (Exception e) {
			System.out.println("insertMeetJoin fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	public boolean deleteMeetJoin(int meet_join_no) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.delete("deleteMeetJoin", meet_join_no);
			session.commit();
		} catch (Exception e) {
			System.out.println("deleteMeetJoin fail");
			e.printStackTrace();
		}
		return action != 0;
	}
}
