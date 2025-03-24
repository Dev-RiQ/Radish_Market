package com.radish.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.Meet;
import com.radish.vo.User;

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
	public int getAUserHostTotalBoardCnt(int user_no) {
		int cnt = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			cnt = session.selectOne("getAUserHostTotalBoardCnt", user_no);
		} catch (Exception e) {
			System.out.println("getAUserHostTotalBoardCnt fail");
			e.printStackTrace();
		}
		return cnt;
	}
	public List<Meet> getAUserHostMeetListByUserNo(int user_no, int limit, int offset) {
		List<Meet> list = null;
		Map<String, Integer> param = new HashMap<>();
		param.put("user_no", user_no);
		param.put("limit", limit);
		param.put("offset", offset);
		try (SqlSession session = DBUtil.getInstance().openSession()){
			list = session.selectList("getAUserHostMeetListByUserNo", param);
		} catch (Exception e) {
			System.out.println("getAUserHostMeetListByUserNo fail");
			e.printStackTrace();
		}
		return list;
	}
	public List<Meet> getAUserAllMeetListByMeetNo(List<Integer> meetNoList, int limit, int offset, int user_no) {
		List<Meet> list = new ArrayList<>();
		Map <String, Object> param = new HashMap<>();
		param.put("meetNoList", meetNoList);
		param.put("limit", limit);
		param.put("offset", offset);
		param.put("user_no", user_no);
		try (SqlSession session = DBUtil.getInstance().openSession()){
				list = session.selectList("getAUserAllMeetListByMeetNo", param);
		} catch (Exception e) {
			System.out.println("getAUserAllMeetListByMeetNo fail");
			e.printStackTrace();
		}
		return list;
	}
	
	public int getHostMeetListSize(int user_no) {
		int size = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			size = session.selectOne("getHostMeetListSize", user_no);
		} catch (Exception e) {
			System.out.println("getHostMeetListSize fail");
			e.printStackTrace();
		}
		return size;
	}
	
	public int getHostUserNoByMeetNo(int meet_no) {
		int host_user_no = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			host_user_no = session.selectOne("getHostUserNoByMeetNo", meet_no);
		} catch (Exception e) {
			System.out.println("getHostUserNoByMeetNo fail");
			e.printStackTrace();
		}
		return host_user_no;
	}
	
}
