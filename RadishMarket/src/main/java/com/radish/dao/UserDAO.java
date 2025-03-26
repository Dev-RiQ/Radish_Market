package com.radish.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.Comment;
import com.radish.vo.Item;
import com.radish.vo.Letter;
import com.radish.vo.Meet;
import com.radish.vo.MeetJoin;
import com.radish.vo.Review;
import com.radish.vo.User;

public class UserDAO {
	private static UserDAO instance;

	private UserDAO() {
	}

	public static UserDAO getInstance() {
		if (instance == null)
			instance = new UserDAO();
		return instance;
	}

	/**
	 * 회원가입 SQL users 테이블 Insert
	 */
	public boolean userInsert(User user) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
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
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			action = session.selectOne("isLoginSuccess", new User(user_id, user_pw));
		} catch (Exception e) {
			System.out.println("isLoginSuccess fail");
			e.printStackTrace();
		}
		return action;
	}

	public User getAUserByLog(int log) {
		User action = null;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			action = session.selectOne("getAUserByLog", log);
		} catch (Exception e) {
			System.out.println("getAUserByLog fail");
			e.printStackTrace();
		}
		return action;
	}

	public boolean userUpdate(User user) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
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
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			action = session.delete("deleteAUser", log);
			session.commit();
		} catch (Exception e) {
			System.out.println("deleteAUser fail");
			e.printStackTrace();
		}
		return action != 0;
	}

	public List<String> getLimitUserDongByItemList(List<Item> itemList) {
		List<String> userDongList = new ArrayList<>();
		int user_no = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for (Item item : itemList) {
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
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for (Item hotItem : hotItemSortList) {
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
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			user_dong = session.selectOne("getAUserDongByUserNo", user_no);
		} catch (Exception e) {
			System.out.println("getAUserDongByUserNo fail");
			e.printStackTrace();
		}
		return user_dong;
	}

	public String getAUserNicnameByUserNo(int user_no) {
		String user_nickname = "";
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			user_nickname = session.selectOne("getAUserNicnameByUserNo", user_no);
		} catch (Exception e) {
			System.out.println("getAUserNicnameByUserNo fail");
			e.printStackTrace();
		}
		return user_nickname;
	}

	public User getAUserPortionInfo(int user_no) {
		User user = null;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
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
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for (Comment comment : commentList) {
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
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for (Meet meet : meetList) {
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
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for (int user_no : meetUserList) {
				list.add(session.selectOne("getMeetUserList", user_no));
			}
		} catch (Exception e) {
			System.out.println("getMeetUserList fail");
			e.printStackTrace();
		}
		return list;
	}

	public List<User> getAllUserList() {
		List<User> list = null;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			list = session.selectList("getAllUserList");
		} catch (Exception e) {
			System.out.println("getAllUserList fail");
			e.printStackTrace();
		}
		return list;
	}

	public boolean hasId(String user_id) {
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			if (session.selectOne("hasId", user_id) != null)
				return true;
		} catch (Exception e) {
			System.out.println("hasId fail");
			e.printStackTrace();
		}
		return false;
	}

	public List<User> getLetterUserList(List<Letter> letterList) {
		List<User> list = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for (Letter letter : letterList) {
				int user_no = letter.getReceive_user_no();
				list.add(session.selectOne("getLetterUserList", user_no));
			}
		} catch (Exception e) {
			System.out.println("getLetterUserList fail");
			e.printStackTrace();
		}
		return list;
	}

	public List<User> getReviewedUserList(List<Review> reviewList) {
		List<User> list = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for (Review review : reviewList) {
				int user_no = review.getSell_user_no();
				list.add(session.selectOne("getReviewedUserList", user_no));
			}
		} catch (Exception e) {
			System.out.println("getReviewedUserList fail");
			e.printStackTrace();
		}
		return list;
	}

	public Object getAllUserByMeetJoinList(List<MeetJoin> meetJoinList) {
		List<User> list = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for (MeetJoin meetJoin : meetJoinList) {
				int user_no = meetJoin.getUser_no();
				list.add(session.selectOne("getReviewedUserList", user_no));
			}
		} catch (Exception e) {
			System.out.println("getReviewedUserList fail");
			e.printStackTrace();
		}
		return list;
	}

	public List<User> getCartUserList(List<Integer> buyUserNoList) {
		List<User> list = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for (Integer user_no : buyUserNoList) {
				list.add((session.selectOne("getCartUserInfoList", user_no)));
			}
		} catch (Exception e) {
			System.out.println("getCartUserInfoList fail");
			e.printStackTrace();
		}
		return list;
	}

	public void setReviewDegree(User user) {
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			session.update("setReviewDegree", user);
			session.commit();
		} catch (Exception e) {
			System.out.println("setReviewDegree fail");
			e.printStackTrace();
		}
	}

	public List<User> getUserListByUserNoList(List<Integer> memberUserNoList, int host_user_no) {
		List<User> list = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for (Integer user_no : memberUserNoList) {
				if (host_user_no != user_no) {
					list.add((session.selectOne("getUserListByUserNoList", user_no)));
				}
			}
		} catch (Exception e) {
			System.out.println("getUserListByUserNoList fail");
			e.printStackTrace();
		}
		return list;
	}

	public List<String> getUserNicknameList(List<Integer> boardUserNoList) {
		List<String> list = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for (Integer user_no : boardUserNoList) {
				list.add((session.selectOne("getUserNicknameList", user_no)));
			}
		} catch (Exception e) {
			System.out.println("getUserNicknameList fail");
			e.printStackTrace();
		}
		return list;
	}

	public List<String> getUserDongListByUserNoList(List<Integer> commentUserNoList) {
		List<String> list = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for (Integer user_no : commentUserNoList) {
				list.add((session.selectOne("getUserDongListByUserNoList", user_no)));
			}
		} catch (Exception e) {
			System.out.println("getUserDongListByUserNoList fail");
			e.printStackTrace();
		}
		return list;
	}

	public List<String> getUserImgList(List<Integer> commentUserNoList) {
		List<String> list = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for (Integer user_no : commentUserNoList) {
				list.add((session.selectOne("getUserImgList", user_no)));
			}
		} catch (Exception e) {
			System.out.println("getUserImgList fail");
			e.printStackTrace();
		}
		return list;
	}

}
