package com.radish.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.Comment;
import com.radish.vo.Item;
import com.radish.vo.Meet;
import com.radish.vo.User;

public class UserDAO {
	private static UserDAO instance;
	private UserDAO() {}
	public static UserDAO getInstance() {
		if(instance == null) instance = new UserDAO();
		return instance;
	}
	
	/** 
	 회원가입 SQL users 테이블 Insert
	 */
	public boolean userInsert(User user) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.insert("userInsert", user);
			session.commit();
		} catch (Exception e) {
			System.out.println("userInsert fail");
			e.printStackTrace();
		}
		return action != 0;
	}

	public int isLoginSuccess(String user_id, String user_pw) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.selectOne("isLoginSuccess", new User(user_id,user_pw));
		} catch (Exception e) {
			System.out.println("isLoginSuccess fail");
			e.printStackTrace();
		}
		return action;
	}
	
	public User getAUserByLog(int log) {
		User action = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.selectOne("getAUserByLog", log);
		} catch (Exception e) {
			System.out.println("getAUserByLog fail");
			e.printStackTrace();
		}
		return action;
	}
	
	public boolean userUpdate(User user) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.update("userUpdate", user);
			session.commit();
		} catch (Exception e) {
			System.out.println("userUpdate fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	
	public boolean deleteAUser(int log) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.delete("deleteAUser", log);
			session.commit();
		} catch (Exception e) {
			System.out.println("deleteAUser fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	
	public ArrayList<String> getLimitUserDongByItemList(ArrayList<Item> itemList) {
		ArrayList<String> userDongList = new ArrayList<>();
		int user_no = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			for(Item item : itemList) {
				user_no = item.getUser_no();
				userDongList.add(session.selectOne("getLimitUserDongByItemList", user_no));
			}
		} catch (Exception e) {
			System.out.println("getLimitUserDongByItemList fail");
			e.printStackTrace();
		}
		return userDongList;
	}
	
	public List<String> getHotItemSortUserNicknameList(List<Item> hotItemSortList) {
        List<String> list = new ArrayList<>();
        int user_no = 0;
        try (SqlSession session = DBUtil.getInstance().openSession()){
            for(Item hotItem : hotItemSortList) {
                user_no = hotItem.getUser_no();
                list.add(session.selectOne("getHotItemSortUserNicknameList", user_no));
            }
        } catch (Exception e) {
            System.out.println("getHotItemSortUserNicknameList fail");
            e.printStackTrace();
        }
        return list;
    }
    public String getAUserDongByUserNo(int user_no) {
        String user_dong = "";
        try (SqlSession session = DBUtil.getInstance().openSession()){
                user_dong = session.selectOne("getAUserDongByUserNo", user_no);
        } catch (Exception e) {
            System.out.println("getAUserDongByUserNo fail");
            e.printStackTrace();
        }
        return user_dong;
    }
    public String getAUserNicnameByUserNo(int user_no) {
        String user_nickname = "";
        try (SqlSession session = DBUtil.getInstance().openSession()){
            user_nickname = session.selectOne("getAUserNicnameByUserNo", user_no);
        } catch (Exception e) {
            System.out.println("getAUserNicnameByUserNo fail");
            e.printStackTrace();
        }
        return user_nickname;
    }
	public User getAUserPortionInfo(int user_no) {
        User user = null;
        try (SqlSession session = DBUtil.getInstance().openSession()){
            user = session.selectOne("getAUserPortionInfo", user_no);
        } catch (Exception e) {
            System.out.println("getAUserPortionInfo fail");
            e.printStackTrace();
        }
        return user;
    }

    public List<String> getCommentedUserNickname(List<Comment> commentList) {
        List<String> list = new ArrayList<>();
        int user_no = 0;
        try (SqlSession session = DBUtil.getInstance().openSession()){
            for(Comment comment : commentList) {
                user_no = comment.getUser_no();
                list.add(session.selectOne("getCommentedUserNickname", user_no));
            }
        } catch (Exception e) {
            System.out.println("getCommentedUserNickname fail");
            e.printStackTrace();
        }
        return list;
    }

    public List<String> getDongListByMeetHostUserNo(List<Meet> meetList) {
        List<String> list = new ArrayList<>();
        int user_no = 0;
        try (SqlSession session = DBUtil.getInstance().openSession()){
            for(Meet meet : meetList) {
                user_no = meet.getHost_user_no();
                list.add(session.selectOne("getLimitUserDongByItemList", user_no));
            }
        } catch (Exception e) {
            System.out.println("getLimitUserDongByItemList fail");
            e.printStackTrace();
        }
        return list;
    }
    public List<User> getMeetUserList(List<Integer> meetUserList) {
        List<User> list = new ArrayList<>();
        try (SqlSession session = DBUtil.getInstance().openSession()){
            for(int user_no : meetUserList) {
                list.add(session.selectOne("getMeetUserList", user_no));
            }
        } catch (Exception e) {
            System.out.println("getMeetUserList fail");
            e.printStackTrace();
        }
        return list;
    }
}
