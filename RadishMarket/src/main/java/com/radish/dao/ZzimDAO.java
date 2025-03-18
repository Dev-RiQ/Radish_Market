package com.radish.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.Zzim;

public class ZzimDAO {
	private static ZzimDAO instance;
	private ZzimDAO() {}
	public static ZzimDAO getInstance() {
		if(instance == null) instance = new ZzimDAO();
		return instance;
	}
	
	public boolean insertZzim(Zzim zzim) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.insert("insertZzim", zzim);
			session.commit();
		} catch (Exception e) {
			System.out.println("insertZzim fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	
	public boolean deleteZzim(Zzim zzim) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.delete("deleteZzim", zzim);
			session.commit();
		} catch (Exception e) {
			System.out.println("deleteZzim fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	
	public int getCountZzimByItemNo(int item_no) {
		int zzimCount = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			zzimCount = session.selectOne("getCountZzimByItemNo", item_no);
		} catch (Exception e) {
			System.out.println("getCountZzimByItemNo fail");
			e.printStackTrace();
		}
		return zzimCount;
	}
	
	public int isZzimInItemNoByLog(int item_no, int user_no) {
		int count = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			count = session.selectOne("isZzimInItemNoByLog", new Zzim(item_no, user_no));
		} catch (Exception e) {
			System.out.println("isZzimInItemNoByLog fail");
			e.printStackTrace();
		}
		return count;
	}
	
	public List<Integer> getAUserZzimItemNoList(int user_no) {
			List<Integer> list = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			list = session.selectList("getAUserZzimItemNoList", user_no);
		} catch (Exception e) {
			System.out.println("getAUserZzimItemNoList fail");
			e.printStackTrace();
		}
		return list;
	}
	public List<Integer> getZzimCountListByItemNoList(List<Integer> itemNoList) {
		List<Integer> list = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()){
			for(Integer item_no : itemNoList) {
				list.add(session.selectOne("getZzimCountListByItemNoList", item_no));
			}
		} catch (Exception e) {
			System.out.println("getZzimCountListByItemNoList fail");
			e.printStackTrace();
		}
		return list;
	}
}
