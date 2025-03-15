package com.radish.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.Board;
import com.radish.vo.Meet;

public class MeetDAO {
	private static MeetDAO instance;
	private MeetDAO() {}
	public static MeetDAO getInstance() {
		if(instance == null) instance = new MeetDAO();
		return instance;
	}
	public boolean hasNextList(int start) {
		try (SqlSession session = DBUtil.getInstance().openSession()){
			start += 30;
			if(session.selectOne("getCountMeetList", start) != null)
				return true;
		} catch (Exception e) {
			System.out.println("getCountMeetList fail");
			e.printStackTrace();
		}
		return false;
	}
	public List<Meet> getLimitedMeetList(int start) {
		List<Meet> list = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			list = session.selectList("getLimitedMeetList",start);
		} catch (Exception e) {
			System.out.println("getLimitedMeetList fail");
			e.printStackTrace();
		}
		return list;
	}
	public Meet getAMeetByMeetNo(int meet_no) {
		Meet meet = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			meet = session.selectOne("getAMeetByMeetNo", meet_no);
		} catch (Exception e) {
			System.out.println("getAMeetByMeetNo fail");
			e.printStackTrace();
		}
		return meet;
	}
	public boolean deleteMeet(int meet_no) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.delete("deleteMeet", meet_no);
			session.commit();
		} catch (Exception e) {
			System.out.println("deleteMeet fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	public boolean insertMeet(Meet meet) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.delete("insertMeet", meet);
			session.commit();
		} catch (Exception e) {
			System.out.println("insertMeet fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	public boolean updateMeet(Meet meet) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.delete("updateMeet", meet);
			session.commit();
		} catch (Exception e) {
			System.out.println("updateMeet fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	public int getLastMeetNo() {
		int meet_no = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			meet_no = session.selectOne("getLastMeetNo");
		} catch (Exception e) {
			System.out.println("getLastMeetNo fail");
			e.printStackTrace();
		}
		return meet_no;
	}
	public List<Meet> getAllMeetList() {
		List<Meet> list = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			list = session.selectList("getAllMeetList");
		} catch (Exception e) {
			System.out.println("getAllMeetList fail");
			e.printStackTrace();
		}
		return list;
	}
	
}
