package com.radish.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.util.DateUtil;
import com.radish.vo.Board;
import com.radish.vo.BoardCategory;
import com.radish.vo.Cart;
import com.radish.vo.Filter;
import com.radish.vo.Item;
import com.radish.vo.ItemCategory;
import com.radish.vo.ItemImg;
import com.radish.vo.Letter;
import com.radish.vo.Meet;
import com.radish.vo.MeetCategory;
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
	public Filter setFilter(int queryStartIndex, Map<String, String[]> queryCategory) {
		Filter filter = new Filter(queryStartIndex);
		if(queryCategory.size() > 2) {
			for(String key : queryCategory.keySet()) {
				switch(key) {
				case "item_status": filter.setItem_status(Integer.parseInt(queryCategory.get(key)[0])); break;
				case "category_no": filter.setCategory_no(Integer.parseInt(queryCategory.get(key)[0])); break;
				case "price_min": filter.setPrice_min(Integer.parseInt(queryCategory.get(key)[0])); break;
				case "price_max": filter.setPrice_max(Integer.parseInt(queryCategory.get(key)[0])); break;
				case "gu": filter.setGu(queryCategory.get(key)[0]); break;
				case "dong": filter.setDong(queryCategory.get(key)[0]); break;
				case "order_by": filter.setOrder_by(Integer.parseInt(queryCategory.get(key)[0])); break;
				case "meet_no": filter.setMeet_no(Integer.parseInt(queryCategory.get(key)[0])); break;
				}
			}
		}
		return filter;
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
			default: return null;
			}
		} catch (Exception e) {
			System.out.println("getListByFilter fail");
			e.printStackTrace();
		}
		return list;
	}
	public List<User> getUserListByList(List<?> list, String type) {
		if(list == null) return null;
		List<User> userList = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()){
			for(Object value : list) {
				int user_no = 0;
				switch(type) {
				case "receiveLetter", "sendLetter": user_no = ((Letter) value).getReceive_user_no(); break;
				case "cart": user_no = ((Cart) value).getUser_no(); break;
				case "review": user_no = ((Review) value).getBuy_user_no(); break;
				default: return null;
				}
				userList.add(session.selectOne("getUserListByList", user_no));
			}
		} catch (Exception e) {
			System.out.println("getUserListByList fail");
			e.printStackTrace();
		}
		return userList;
	}
	public List<Item> getItemListByList(List<?> list, String type) {
		if(list == null) return null;
		List<Item> itemList = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()){
			for(Object value : list) {
				int item_no = 0;
				switch(type) {
				case "zzim": item_no = ((Zzim) value).getItem_no(); break;
				case "cart": item_no = ((Cart) value).getItem_no(); break;
				case "review": item_no = ((Review) value).getItem_no(); break;
				default: return null;
				}
				itemList.add(session.selectOne("getItemListByList", item_no));
			}
		} catch (Exception e) {
			System.out.println("getItemListByList fail");
			e.printStackTrace();
		}
		return itemList;
	}
	public List<BoardCategory> getBoardCategoryListByList(List<?> list, String type) {
		if(list == null) return null;
		List<BoardCategory> boardCategoryList = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()){
			for(Object value : list) {
				int board_category_no = 0;
				switch(type) {
				case "board", "meetBoard", "myBoard": board_category_no = ((Board) value).getBoard_category_no(); break;
				default: return null;
				}
				boardCategoryList.add(session.selectOne("getBoardCategoryListByList", board_category_no));
			}
		} catch (Exception e) {
			System.out.println("getBoardCategoryListByList fail");
			e.printStackTrace();
		}
		return boardCategoryList;
	}
	public List<ItemCategory> getItemCategoryListByList(List<?> list, String type) {
		if(list == null) return null;
		List<ItemCategory> itemCategoryList = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()){
			for(Object value : list) {
				int item_category_no = 0;
				switch(type) {
				case "item", "myItem": item_category_no = ((Item) value).getItem_category_no(); break;
				default: return null;
				}
				itemCategoryList.add(session.selectOne("getItemCategoryListByList", item_category_no));
			}
		} catch (Exception e) {
			System.out.println("getItemCategoryListByList fail");
			e.printStackTrace();
		}
		return itemCategoryList;
	}
	public List<MeetCategory> getMeetCategoryListByList(List<?> list, String type) {
		if(list == null) return null;
		List<MeetCategory> meetCategoryList = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()){
			for(Object value : list) {
				int meet_category_no = 0;
				switch(type) {
				case "meet", "hostMeet", "myMeet": meet_category_no = ((Meet) value).getMeet_category_no(); break;
				default: return null;
				}
				meetCategoryList.add(session.selectOne("getMeetCategoryListByList", meet_category_no));
			}
		} catch (Exception e) {
			System.out.println("getMeetCategoryListByList fail");
			e.printStackTrace();
		}
		return meetCategoryList;
	}
	
	public List<ItemImg> getItemImgListByList(List<?> list, List<Item> itemList, String type) {
		if(list == null || (!type.contains("tem") && itemList == null)) return null;
		List<ItemImg> itemImgList = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()){
			for(Object value : type.contains("tem") ? list : itemList) {
				int item_no = 0;
				switch(type) {
				case "item", "myItem", "zzim", "cart", "review": item_no = ((Item) value).getItem_no(); break;
				default: return null;
				}
				itemImgList.add(session.selectOne("getItemImgListByList", item_no));
			}
		} catch (Exception e) {
			System.out.println("getItemImgListByList fail");
			e.printStackTrace();
		}
		return itemImgList;
	}
	public List<Integer> getLikeCountListByList(List<?> list, String type) {
		if(list == null) return null;
		List<Integer> likeCountList = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()){
			for(Object value : list) {
				int board_no = 0;
				switch(type) {
				case "board", "meetBoard", "myBoard": board_no = ((Board) value).getBoard_no(); break;
				default: return null;
				}
				likeCountList.add(session.selectOne("getLikeCountListByList", board_no));
			}
		} catch (Exception e) {
			System.out.println("getLikeCountListByList fail");
			e.printStackTrace();
		}
		return likeCountList;
	}
	public List<Integer> getCommentCountListByList(List<?> list, String type) {
		if(list == null) return null;
		List<Integer> commentCountList = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()){
			for(Object value : list) {
				int board_no = 0;
				switch(type) {
				case "board", "meetBoard", "myBoard": board_no = ((Board) value).getBoard_no(); break;
				default: return null;
				}
				commentCountList.add(session.selectOne("getCommentCountListByList", board_no));
			}
		} catch (Exception e) {
			System.out.println("getCommentCountListByList fail");
			e.printStackTrace();
		}
		return commentCountList;
	}
	public List<Integer> getMemberCountListByList(List<?> list, String type) {
		if(list == null) return null;
		List<Integer> memberCountList = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()){
			for(Object value : list) {
				int meet_no = 0;
				switch(type) {
				case "meet", "hostMeet", "myMeet": meet_no = ((Meet) value).getMeet_no(); break;
				default: return null;
				}
				memberCountList.add(session.selectOne("getMemberCountListByList", meet_no));
			}
		} catch (Exception e) {
			System.out.println("getMemberCountListByList fail");
			e.printStackTrace();
		}
		return memberCountList;
	}
	public StringBuilder getPrintListData(String type, List<?> list, List<User> userList, List<Item> itemList,
			List<BoardCategory> boardCategoryList, List<ItemCategory> itemCategoryList,
			List<MeetCategory> meetCategoryList, List<ItemImg> itemImgList, List<Integer> likeCountList,
			List<Integer> commentCountList, List<Integer> memberCountList) {
		StringBuilder sb = null;
		switch(type) {
		case "item", "myItem": sb = getPrintItemListData(list, itemImgList); break;
		case "board", "meetBoard", "myBoard": sb = getPrintBoardListData(list, boardCategoryList, likeCountList, commentCountList); break;
		case "meet", "hostMeet", "myMeet": sb = getPrintMeetListData(list, meetCategoryList, memberCountList); break;
		case "receiveLetter", "sendLetter": sb = getPrintLetterListData(list, userList); break;
		case "zzim": sb = getPrintZzimListData(list, itemList, itemImgList); break;
		case "cart": sb = getPrintCartListData(list, userList, itemList, itemCategoryList, itemImgList); break;
		case "review": sb = getPrintReviewListData(list, userList, itemList, itemCategoryList, itemImgList); break;
		}
		return sb;
	}
	private StringBuilder getPrintItemListData(List<?> list, List<ItemImg> itemImgList) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < list.size() ; i++) {
			int item_no = ((Item) list.get(i)).getItem_no();
			String item_img = "defaultItemImg.jpg";
			if(itemImgList != null && itemImgList.size() > 0)
				item_img = itemImgList.get(i).getItem_img();
			String item_name = ((Item) list.get(i)).getItem_name();
			int item_status = ((Item) list.get(i)).getItem_status();
			String status = item_status == 2 ? "예약중 " : item_status == 3 ? "판매완료 " : "";
			int item_price= ((Item) list.get(i)).getItem_price();
			String price = getPrintPrice(item_price);
			String item_dong = ((Item) list.get(i)).getItem_dong();
			
			sb.append("<div>");
			sb.append("<div style=\"cursor: pointer;\" onclick=\"location.href='/infoItem.do?item_no="+item_no+"'\">");
			sb.append("<p><img alt=\"대표 이미지\" src=\"/images/"+item_img+"\"/></p>");
			sb.append("<p>"+item_name+"</p>");
			sb.append("<p><span>"+status+"</span> "+price+"</p>");
			sb.append("<p>"+item_dong+"</p>");
			sb.append("</div>");
			sb.append("</div>");
		}
		return sb;
	}
	private String getPrintPrice(int item_price) {
		StringBuilder sb = new StringBuilder();
		sb.append("원");
		int devider = 10;
		int devideCount = 0;
		while(true) {
			sb.append(item_price % devider);
			item_price /= devider;
			if(item_price == 0) break;
			devideCount++;
			if(devideCount == 3) {
				sb.append(",");
				devideCount = 0;
			}
		}
		return sb.reverse().toString();
	}
	private StringBuilder getPrintBoardListData(List<?> list, List<BoardCategory> boardCategoryList,
			List<Integer> likeCountList, List<Integer> commentCountList) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < list.size() ; i++) {
			int board_no = ((Board) list.get(i)).getBoard_no();
			String board_img = ((Board) list.get(i)).getBoard_img();
			String board_title = ((Board) list.get(i)).getBoard_title();
			String board_content = ((Board) list.get(i)).getBoard_content();
			String board_dong = ((Board) list.get(i)).getBoard_dong();
			String board_category_name = boardCategoryList.get(i).getBoard_category_name();
			String board_reg_datetime = DateUtil.getInstance().getCalcDateAgo(((Board) list.get(i)).getBoard_reg_datetime());
			int likeCount = likeCountList.get(i);
			int commentCount = commentCountList.get(i);
			
			sb.append("<div>");
			sb.append("<div style=\"cursor: pointer;\" onclick=\"location.href='/infoBoard.do?board_no="+board_no+"'\">");
			if(board_img != null)
				sb.append("<p><img alt=\"대표 이미지\" src=\"/images/"+board_img+"\"/></p>");
			sb.append("<p>"+board_title+"</p>");
			sb.append("<p>"+board_content+"</p>");
			sb.append("<div>");
			sb.append("<span>"+board_dong+"</span>");
			sb.append("<span> / "+board_category_name+"</span>");
			sb.append("<span> / "+board_reg_datetime+"</span>");
			sb.append("</div>");
			sb.append("<div>");
			sb.append("<span>"+"종아요 : "+likeCount+"</span>");
			sb.append("<span>"+" / 댓글 : "+commentCount+"</span>");
			sb.append("</div>");
			sb.append("</div>");
			sb.append("</div>");
		}
		return sb;
	}
	private StringBuilder getPrintMeetListData(List<?> list, 
			List<MeetCategory> meetCategoryList, List<Integer> memberCountList) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < list.size() ; i++) {
			int meet_no = ((Meet) list.get(i)).getMeet_no();
			String meet_img = ((Meet) list.get(i)).getMeet_img();
			if(meet_img.isBlank())
				meet_img = "meetsDefaultImg.png";
			String meet_title = ((Meet) list.get(i)).getMeet_title();
			String meet_content = ((Meet) list.get(i)).getMeet_content();
			String meet_dong = ((Meet) list.get(i)).getMeet_dong();
			int memberCount = memberCountList.get(i);
			String meet_category_name = meetCategoryList.get(i).getMeet_category_name();
			
			sb.append("<div>");
			sb.append("<div style=\"cursor: pointer;\" onclick=\"location.href='/infoMeet.do?meet_no="+meet_no+"&meet_dong="+meet_dong+"&meet_user_count="+memberCount+"&meet_category_name="+meet_category_name+"'\">");
			sb.append("<img alt=\"대표 이미지\" src=\"/images/"+meet_img+"\"/>");
			sb.append("<br><p>"+meet_title+"</p>");
			sb.append("<p>"+meet_content+"</p>");
			sb.append("<span>"+meet_dong+"</span>");
			sb.append("<span> / "+"회원수 : "+memberCount+"</span>");
			sb.append("<span> / "+meet_category_name+"</span>");
			sb.append("</div>");
			sb.append("</div>");
		}
		return sb;
	}
	private StringBuilder getPrintLetterListData(List<?> list, List<User> userList) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < list.size() ; i++) {
			int letter_no = ((Letter) list.get(i)).getLetter_no();
			int letter_check = ((Letter) list.get(i)).getLetter_check();
			String check = letter_check == 0? "안읽음" : "읽음";
			String user_nickname = userList.get(i).getUser_nickname();
			String letter_title = ((Letter) list.get(i)).getLetter_title();
			String letter_reg_datetime = ((Letter) list.get(i)).getLetter_reg_datetime();
			
			sb.append("<div>");
			sb.append("<div id=\"show-letter"+letter_no+"\" style=\"cursor: pointer;\" onclick=\"openPop('read')\">");
			sb.append("<span>"+check+" </span>");
			sb.append("<span> "+user_nickname+" </span>");
			sb.append("<span> "+letter_title+" </span>");
			sb.append("<span> "+letter_reg_datetime+" </span>");
			sb.append("</div>");
			sb.append("<button onclick=\"location.href='deleteLetter.do?letter_no="+letter_no+"'\">삭제</button>");
			sb.append("</div>");
		}
		return sb;
	}
	private StringBuilder getPrintZzimListData(List<?> list, List<Item> itemList, List<ItemImg> itemImgList) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < list.size() ; i++) {
			int item_no = ((Zzim) list.get(i)).getItem_no();
			String item_img = "defaultItemImg.jpg";
			if(itemImgList != null && itemImgList.size() > 0)
				item_img = itemImgList.get(i).getItem_img();
			String item_name = itemList.get(i).getItem_name();
			int item_price = itemList.get(i).getItem_price();
			String price = getPrintPrice(item_price);
			String item_dong = itemList.get(i).getItem_dong();
			
			sb.append("<div>");
			sb.append("<div style=\"cursor: pointer;\" onclick=\"location.href='/infoItem.do?item_no="+item_no+"'\">");
			sb.append("<img alt=\"대표 이미지\" src=\"/images/"+item_img+"\"");
			sb.append("<br><p>"+item_name+"</p>");
			sb.append("<p>"+price+"</p>");
			sb.append("<p>"+item_dong+"</p>");
			sb.append("</div>");
			sb.append("</div>");
		}
		return sb;
	}
	private StringBuilder getPrintCartListData(List<?> list, List<User> userList, List<Item> itemList,
			List<ItemCategory> itemCategoryList, List<ItemImg> itemImgList) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < list.size() ; i++) {
			int item_no = ((Cart) list.get(i)).getItem_no();
			String item_img = "defaultItemImg.jpg";
			if(itemImgList != null && itemImgList.size() > 0)
				item_img = itemImgList.get(i).getItem_img();
			String item_name = itemList.get(i).getItem_name();
			int item_price = itemList.get(i).getItem_price();
			String price = getPrintPrice(item_price);
			String user_nickname = userList.get(i).getUser_nickname();
			String item_dong = itemList.get(i).getItem_dong();
			int check_reviewed = ((Cart) list.get(i)).getCheck_reviewed();
			
			sb.append("<div>");
			sb.append("<div style=\"cursor: pointer;\" onclick=\"location.href='/infoItem.do?item_no="+item_no+"'\">");
			sb.append("<img alt=\"대표 이미지\" src=\"/images/"+item_img+"\"");
			sb.append("<br><p>"+item_name+"</p>");
			sb.append("<p>"+price+"</p>");
			sb.append("<p>"+user_nickname+"</p>");
			sb.append("<p>"+item_dong+"</p>");
			sb.append("</div>");
			sb.append("<div>");
			if(check_reviewed == 0) {
				sb.append("<button onclick=\"location.href='/insertReview.do?item_no="+item_no+"'\">리뷰 작성하기</button>");
			}else {
				sb.append("<button>리뷰 작성완료</button>");
			}
			sb.append("</div>");
			sb.append("</div>");
		}
		return sb;
	}
	private StringBuilder getPrintReviewListData(List<?> list, List<User> userList, List<Item> itemList,
			List<ItemCategory> itemCategoryList, List<ItemImg> itemImgList) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < list.size() ; i++) {
			String buy_user_img = userList.get(i).getUser_img();
			String buy_user_nickname = userList.get(i).getUser_nickname();
			String buy_user_dong = userList.get(i).getUser_dong();
			String review_content = ((Review) list.get(i)).getReview_content();
			String item_img = "defaultItemImg.jpg";
			if(itemImgList != null && itemImgList.size() > 0)
				item_img = itemImgList.get(i).getItem_img();
			
			sb.append("<div>");
			sb.append("<img alt=\"대표 이미지\" src=\"/images/"+buy_user_img+"\"");
			sb.append("<br><span>"+buy_user_nickname+"</span>");
			sb.append("<span>"+buy_user_dong+"</span>");
			sb.append("<p>"+review_content+"</p>");
			sb.append("<img alt=\"대표 이미지\" src=\"/images/"+item_img+"\"");
			sb.append("</div>");
		}
		return sb;
	}
}
