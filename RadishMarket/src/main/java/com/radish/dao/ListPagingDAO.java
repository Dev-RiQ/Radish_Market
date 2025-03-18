package com.radish.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.Board;
import com.radish.vo.Cart;
import com.radish.vo.Filter;
import com.radish.vo.Item;
import com.radish.vo.Letter;
import com.radish.vo.Meet;
import com.radish.vo.Review;
import com.radish.vo.User;
import com.radish.vo.Zzim;

public class ListPagingDAO {
	private static ListPagingDAO instance;
	private ListPagingDAO() {}
	public static ListPagingDAO getInstance() {
		if(instance == null) instance = new ListPagingDAO();
		return instance;
	}
	public List<?> getListByFilter(String type, Filter filter) {
		List<?> list = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			switch(type) {
			case "item": list = session.selectList("getItemListByFilter", filter); break;
			case "board": list = session.selectList("getBoardListByFilter", filter); break;
			case "meetBoard": list = session.selectList("getMeetBoardListByFilter", filter); break;
			case "meet": list = session.selectList("getMeetListByFilter", filter); break;
			case "receiveLetter": list = session.selectList("getReceiveLetterListByFilter", filter); break;
			case "sendLetter": list = session.selectList("getSendLetterListByFilter", filter); break;
			case "zzim": list = session.selectList("getZzimListByFilter", filter); break;
			case "cart": list = session.selectList("getCartListByFilter", filter); break;
			case "myItem": list = session.selectList("getMyItemListByFilter", filter); break;
			case "review": list = session.selectList("getReviewListByFilter", filter); break;
			case "myBoard": list = session.selectList("getMyBoardListByFilter", filter); break;
			case "hostMeet": list = session.selectList("getHostMeetListByFilter", filter); break;
			case "myMeet": list = session.selectList("getMyMeetListByFilter", filter); break;
			}
		} catch (Exception e) {
			System.out.println("getListByFilter fail");
			e.printStackTrace();
		}
		return list;
	}
	public List<User> getUserListByList(List<?> list, String type) {
		List<User> userList = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()){
			for(Object value : list) {
				int user_no = 0;
				switch(type) {
				case "item": user_no = ((Item) value).getUser_no(); break;
				case "board": user_no = ((Board) value).getUser_no(); break;
				case "meetBoard":user_no = ((Board) value).getUser_no(); ; break;
				case "meet": user_no = ((Meet) value).getHost_user_no(); break;
				case "receiveLetter": user_no = ((Letter) value).getReceive_user_no(); break;
				case "sendLetter": user_no = ((Letter) value).getSend_user_no(); break;
				case "zzim": user_no = ((Zzim) value).getUser_no(); break;
				case "cart": user_no = ((Cart) value).getUser_no(); break;
				case "myItem": user_no = ((Item) value).getUser_no(); break;
				case "review": user_no = ((Review) value).getSell_user_no(); break;
				case "myBoard": user_no = ((Board) value).getUser_no(); break;
				case "hostMeet": user_no = ((Meet) value).getHost_user_no(); break;
				case "myMeet": user_no = ((Meet) value).getHost_user_no(); break;
				}
				userList.add(session.selectOne("getUserListByList", user_no));
			}
		} catch (Exception e) {
			System.out.println("getUserListByList fail");
			e.printStackTrace();
		}
		return userList;
	}
}
