package com.radish.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.util.DateUtil;
import com.radish.vo.Alarm;
import com.radish.vo.AlarmCategory;
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

	private ListPagingDAO() {
	}

	public static ListPagingDAO getInstance() {
		if (instance == null)
			instance = new ListPagingDAO();
		return instance;
	}

	public Filter setFilter(int queryStartIndex, Map<String, String[]> queryCategory) {
		Filter filter = new Filter(queryStartIndex);
		if (queryCategory.size() > 2) {
			for (String key : queryCategory.keySet()) {
				switch (key) {
				case "item_status":
					filter.setItem_status(Integer.parseInt(queryCategory.get(key)[0]));
					break;
				case "category_no":
					filter.setCategory_no(Integer.parseInt(queryCategory.get(key)[0]));
					break;
				case "price_min":
					filter.setPrice_min(Integer.parseInt(queryCategory.get(key)[0]));
					break;
				case "price_max":
					filter.setPrice_max(Integer.parseInt(queryCategory.get(key)[0]));
					break;
				case "gu":
					filter.setGu(queryCategory.get(key)[0]);
					break;
				case "dong":
					filter.setDong(queryCategory.get(key)[0]);
					break;
				case "order_by":
					filter.setOrder_by(Integer.parseInt(queryCategory.get(key)[0]));
					break;
				case "meet_no":
					filter.setMeet_no(Integer.parseInt(queryCategory.get(key)[0]));
					break;
				case "search_value":
					filter.setSearch_value(queryCategory.get(key)[0]);
					break;
				}
			}
		}
		return filter;
	}

	public List<?> getListByFilter(String type, Filter filter) {
		List<?> list = null;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			switch (type) {
			case "adminUser":
				list = session.selectList("getUserListByFilter", filter);
				break;
			case "item", "adminItem":
				list = session.selectList("getItemListByFilter", filter);
				break;
			case "board", "meetBoard", "adminBoard":
				list = session.selectList("getBoardListByFilter", filter);
				break;
			case "meet", "adminMeet":
				list = session.selectList("getMeetListByFilter", filter);
				break;
			case "receiveLetter":
				list = session.selectList("getReceiveLetterListByFilter", filter);
				break;
			case "sendLetter":
				list = session.selectList("getSendLetterListByFilter", filter);
				break;
			case "zzim":
				list = session.selectList("getZzimListByFilter", filter);
				break;
			case "cart":
				list = session.selectList("getCartListByFilter", filter);
				break;
			case "myItem":
				list = session.selectList("getMyItemListByFilter", filter);
				break;
			case "review":
				list = session.selectList("getReviewListByFilter", filter);
				break;
			case "myBoard":
				list = session.selectList("getMyBoardListByFilter", filter);
				break;
			case "hostMeet":
				list = session.selectList("getHostMeetListByFilter", filter);
				break;
			case "myMeet":
				list = session.selectList("getMyMeetListByFilter", filter);
				break;
			case "alarm":
				list = session.selectList("getAlarmList", filter);
				break;
			default:
				return null;
			}
		} catch (Exception e) {
			System.out.println("getListByFilter fail");
			e.printStackTrace();
		}
		return list;
	}

	public List<User> getUserListByList(List<?> list, String type) {
		if (list == null)
			return null;
		List<User> userList = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for (Object value : list) {
				int user_no = 0;
				switch (type) {
				case "receiveLetter":
					user_no = ((Letter) value).getSend_user_no();
					break;
				case "sendLetter":
					user_no = ((Letter) value).getReceive_user_no();
					break;
				case "cart":
					user_no = ((Cart) value).getUser_no();
					break;
				case "review":
					user_no = ((Review) value).getBuy_user_no();
					break;
				default:
					return null;
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
		if (list == null)
			return null;
		List<Item> itemList = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for (Object value : list) {
				int item_no = 0;
				switch (type) {
				case "zzim":
					item_no = ((Zzim) value).getItem_no();
					break;
				case "cart":
					item_no = ((Cart) value).getItem_no();
					break;
				case "review":
					item_no = ((Review) value).getItem_no();
					break;
				default:
					return null;
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
		if (list == null)
			return null;
		List<BoardCategory> boardCategoryList = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for (Object value : list) {
				int board_category_no = 0;
				switch (type) {
				case "board", "meetBoard", "myBoard", "adminBoard":
					board_category_no = ((Board) value).getBoard_category_no();
					break;
				default:
					return null;
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
		if (list == null)
			return null;
		List<ItemCategory> itemCategoryList = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for (Object value : list) {
				int item_category_no = 0;
				switch (type) {
				case "item", "myItem":
					item_category_no = ((Item) value).getItem_category_no();
					break;
				default:
					return null;
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
		if (list == null)
			return null;
		List<MeetCategory> meetCategoryList = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for (Object value : list) {
				int meet_category_no = 0;
				switch (type) {
				case "meet", "hostMeet", "myMeet", "adminMeet":
					meet_category_no = ((Meet) value).getMeet_category_no();
					break;
				default:
					return null;
				}
				meetCategoryList.add(session.selectOne("getMeetCategoryListByList", meet_category_no));
			}
		} catch (Exception e) {
			System.out.println("getMeetCategoryListByList fail");
			e.printStackTrace();
		}
		return meetCategoryList;
	}

	public List<AlarmCategory> getAlarmCategoryListByList(List<?> list, String type) {
		if (list == null)
			return null;
		List<AlarmCategory> alarmCategoryList = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for (Object value : list) {
				int alarm_category_no = 0;
				switch (type) {
				case "alarm":
					alarm_category_no = ((Alarm) value).getAlarm_category_no();
					break;
				default:
					return null;
				}
				alarmCategoryList.add(session.selectOne("getAlarmCategoryListByList", alarm_category_no));
			}
		} catch (Exception e) {
			System.out.println("getAlarmCategoryListByList fail");
			e.printStackTrace();
		}
		return alarmCategoryList;
	}

	public List<ItemImg> getItemImgListByList(List<?> list, List<Item> itemList, String type) {
		if (list == null || (!type.contains("tem") && itemList == null))
			return null;
		List<ItemImg> itemImgList = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for (Object value : type.contains("tem") ? list : itemList) {
				int item_no = 0;
				switch (type) {
				case "item", "myItem", "zzim", "cart", "review":
					item_no = ((Item) value).getItem_no();
					break;
				default:
					return null;
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
		if (list == null)
			return null;
		List<Integer> likeCountList = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for (Object value : list) {
				int board_no = 0;
				switch (type) {
				case "board", "meetBoard", "myBoard", "adminBoard":
					board_no = ((Board) value).getBoard_no();
					break;
				default:
					return null;
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
		if (list == null)
			return null;
		List<Integer> commentCountList = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for (Object value : list) {
				int board_no = 0;
				switch (type) {
				case "board", "meetBoard", "myBoard", "adminBoard":
					board_no = ((Board) value).getBoard_no();
					break;
				default:
					return null;
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
		if (list == null)
			return null;
		List<Integer> memberCountList = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for (Object value : list) {
				int meet_no = 0;
				switch (type) {
				case "meet", "hostMeet", "myMeet", "adminMeet":
					meet_no = ((Meet) value).getMeet_no();
					break;
				default:
					return null;
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
			List<Integer> commentCountList, List<Integer> memberCountList, List<AlarmCategory> alarmCategoryList) {
		StringBuilder sb = null;
		switch (type) {
		case "item", "myItem":
			sb = getPrintItemListData(list, itemImgList);
			break;
		case "board", "meetBoard", "myBoard":
			sb = getPrintBoardListData(list, boardCategoryList, likeCountList, commentCountList);
			break;
		case "meet", "hostMeet", "myMeet":
			sb = getPrintMeetListData(list, meetCategoryList, memberCountList);
			break;
		case "receiveLetter", "sendLetter":
			sb = getPrintLetterListData(list, userList);
			break;
		case "zzim":
			sb = getPrintZzimListData(list, itemList, itemImgList);
			break;
		case "cart":
			sb = getPrintCartListData(list, userList, itemList, itemCategoryList, itemImgList);
			break;
		case "review":
			sb = getPrintReviewListData(list, userList, itemList, itemCategoryList, itemImgList);
			break;
		case "adminUser":
			sb = getPrintAdminUserListData(list);
			break;
		case "adminBoard":
			sb = getPrintAdminBoardListData(list, boardCategoryList, likeCountList, commentCountList);
			break;
		case "adminItem":
			sb = getPrintAdminItemListData(list);
			break;
		case "adminMeet":
			sb = getPrintAdminMeetListData(list, meetCategoryList, memberCountList);
			break;
		case "alarm":
			sb = getPrintAlarmListData(list, alarmCategoryList);
			break;
		}
		return sb;
	}

	private StringBuilder getPrintItemListData(List<?> list, List<ItemImg> itemImgList) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			int item_no = ((Item) list.get(i)).getItem_no();
			String item_img = "defaultItemImg.jpg";
			if (itemImgList != null && itemImgList.size() > 0 && itemImgList.get(i).getItem_img() != null
					&& !itemImgList.get(i).getItem_img().isBlank())
				item_img = itemImgList.get(i).getItem_img();
			String item_name = ((Item) list.get(i)).getItem_name();
			int item_status = ((Item) list.get(i)).getItem_status();
			String status = item_status == 2 ? "예약중" : item_status == 3 ? "판매완료" : "";
			int item_price = ((Item) list.get(i)).getItem_price();
			String price = getPrintPrice(item_price);
			String item_dong = ((Item) list.get(i)).getItem_dong();

			sb.append("<div class=\"child\" onclick=\"location.href='/infoItem.do?item_no=" + item_no + "'\">");
			sb.append("<div class=\"itemimg\"><img src=\"/images/" + item_img + "\" alt=\"이미지\" /></div>");
			sb.append(" <div class=\"itemtxt\">");
			sb.append("<p class=\"item-name\" style=\"font-size:16px;\">" + item_name + "</p>");
			sb.append("<h4 class=\"item-price\" style=\"font-size:16px;\"> " + price + "</h4>");
			sb.append("<span class=\"item-dong\">" + item_dong + "</span> <span class=\"item-status\">" + status
					+ "</span>");
			sb.append("</div>");
			sb.append("</div>");
		}
		return sb;
	}

	private StringBuilder getPrintCartListData(List<?> list, List<User> userList, List<Item> itemList,
			List<ItemCategory> itemCategoryList, List<ItemImg> itemImgList) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			int item_no = ((Cart) list.get(i)).getItem_no();
			String item_img = "defaultItemImg.jpg";
			if (itemImgList != null && itemImgList.size() > 0 && itemImgList.get(i).getItem_img() != null
					&& !itemImgList.get(i).getItem_img().isBlank())
				item_img = itemImgList.get(i).getItem_img();
			String item_name = itemList.get(i).getItem_name();
			int item_price = itemList.get(i).getItem_price();
			String price = getPrintPrice(item_price);
			String item_dong = itemList.get(i).getItem_dong();
			int check_reviewed = ((Cart) list.get(i)).getCheck_reviewed();

			sb.append("<div class=\"bought-box\">");
			sb.append("<div class=\"child\" onclick=\"location.href='/infoItem.do?item_no=" + item_no + "'\">");
			sb.append("<div class=\"itemimg\"><img src=\"/images/" + item_img + "\" alt=\"이미지\" /></div>");
			sb.append(" <div class=\"itemtxt\">");
			sb.append("<p class=\"item-name\" style=\"font-size:16px;\">" + item_name + "</p>");
			sb.append("<h4 class=\"item-price\" style=\"font-size:16px;\"> " + price + "</h4>");
			sb.append("<span class=\"item-dong\">" + item_dong + "</span> ");
			sb.append("</div>");
			sb.append("</div>");
			sb.append("<div class=\"review-btn-box\">");
			if (check_reviewed == 0) {
				sb.append("<button class=\"btn-reviewing\" onclick=\"location.href='/insertReview.do?item_no=" + item_no
						+ "'\">리뷰 작성하기</button>");
			} else {
				sb.append("<button class=\"btn-reviewed\">리뷰 작성완료</button>");
			}
			sb.append("</div>");
			sb.append("</div>");
		}
		return sb;
	}

	private StringBuilder getPrintZzimListData(List<?> list, List<Item> itemList, List<ItemImg> itemImgList) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			int item_no = ((Zzim) list.get(i)).getItem_no();
			String item_img = "defaultItemImg.jpg";
			if (itemImgList != null && itemImgList.size() > 0 && itemImgList.get(i).getItem_img() != null
					&& !itemImgList.get(i).getItem_img().isBlank())
				item_img = itemImgList.get(i).getItem_img();
			String item_name = itemList.get(i).getItem_name();
			int item_price = itemList.get(i).getItem_price();
			String price = getPrintPrice(item_price);
			String item_dong = itemList.get(i).getItem_dong();

			sb.append("<div class=\"child\" onclick=\"location.href='/infoItem.do?item_no=" + item_no + "'\">");
			sb.append("<div class=\"itemimg\"><img src=\"/images/" + item_img + "\" alt=\"이미지\" /></div>");
			sb.append(" <div class=\"itemtxt\">");
			sb.append("<p class=\"item-name\" style=\"font-size:16px;\">" + item_name + "</p>");
			sb.append("<h4 class=\"item-price\" style=\"font-size:16px;\"> " + price + "</h4>");
			sb.append("<span class=\"item-dong\">" + item_dong + "</span>");
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
		while (true) {
			sb.append(item_price % devider);
			item_price /= devider;
			if (item_price == 0)
				break;
			devideCount++;
			if (devideCount == 3) {
				sb.append(",");
				devideCount = 0;
			}
		}
		return sb.reverse().toString();
	}

	private StringBuilder getPrintBoardListData(List<?> list, List<BoardCategory> boardCategoryList,
			List<Integer> likeCountList, List<Integer> commentCountList) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			int board_no = ((Board) list.get(i)).getBoard_no();
			String board_img = ((Board) list.get(i)).getBoard_img();
			String board_title = ((Board) list.get(i)).getBoard_title();
			String board_content = ((Board) list.get(i)).getBoard_content();
			String board_dong = ((Board) list.get(i)).getBoard_dong();
			String board_category_name = boardCategoryList.get(i).getBoard_category_name();
			String board_reg_datetime = DateUtil.getInstance()
					.getCalcDateAgo(((Board) list.get(i)).getBoard_reg_datetime());
			int likeCount = likeCountList.get(i);
			int commentCount = commentCountList.get(i);

			sb.append("<div class=\"txtcald\">");
			sb.append(
					"<div class=\"txtbox\" style=\"cursor: pointer;\" onclick=\"location.href='/infoBoard.do?board_no="
							+ board_no + "&filter=true&dong=" + board_dong + "&category_no="
							+ ((Board) list.get(i)).getBoard_category_no() + "&order_by=" + 0 + "'\">");
			sb.append("<h3>" + board_title + "</h3>");
			sb.append("<p>" + board_content + "</p>");
			sb.append("<div>");
			sb.append("<span>" + board_dong + "</span>");
			sb.append("<span> · " + board_category_name + "</span>");
			sb.append("<span> · " + board_reg_datetime + "</span>");
			sb.append("</div>");
			sb.append("<pre>");
			sb.append("<span>" + "<i class=\"fa-solid fa-heart\" style=\"color: red;\"></i> " + likeCount + "</span>");
			sb.append("<span>" + " · <i class=\"fa-solid fa-comment\"></i> " + commentCount + "</span>");
			sb.append("</pre>");
			sb.append("</div>");
			if (board_img != null && !board_img.isBlank())
				sb.append("<div class=\"imgbox\"><img alt=\"대표 이미지\" src=\"/images/" + board_img + "\"/></div>");
			sb.append("</div>");
		}
		return sb;
	}

	private StringBuilder getPrintMeetListData(List<?> list, List<MeetCategory> meetCategoryList,
			List<Integer> memberCountList) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			int meet_no = ((Meet) list.get(i)).getMeet_no();
			String meet_img = ((Meet) list.get(i)).getMeet_img();
			if (meet_img == null || meet_img.isBlank())
				meet_img = "meetsDefaultImg.png";
			String meet_title = ((Meet) list.get(i)).getMeet_title();
			String meet_content = ((Meet) list.get(i)).getMeet_content();
			String meet_dong = ((Meet) list.get(i)).getMeet_dong();
			int memberCount = memberCountList.get(i);
			String meet_category_name = meetCategoryList.get(i).getMeet_category_name();

			sb.append("<div class=\"txtcald\" style=\"cursor: pointer;\" onclick=\"location.href='/infoMeet.do?meet_no="
					+ meet_no + "&meet_dong=" + meet_dong + "&meet_user_count=" + memberCount + "&meet_category_name="
					+ meet_category_name + "'\">");
			sb.append("<div class=\"imgbox\"><img src=\"/images/" + meet_img + "\" alt=\"대표이미지\" /></div>");
			sb.append("<div class=\"txtbox\">");
			sb.append("<h3>" + meet_title + "</h3>");
			sb.append("<span>" + meet_content + "</span>");
			sb.append("<pre> <i class=\"fa-solid fa-location-dot\"></i> " + meet_dong + " · " 
					+ "  <i class=\"fa-solid fa-user\"></i> " + memberCount + " · " + meet_category_name + "</pre>");
			sb.append("</div>");
			sb.append("</div>");
		}
		return sb;
	}

	private StringBuilder getPrintLetterListData(List<?> list, List<User> userList) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			int letter_no = ((Letter) list.get(i)).getLetter_no();
			int letter_check = ((Letter) list.get(i)).getLetter_check();
			String user_nickname = userList.get(i).getUser_nickname();
			String letter_title = ((Letter) list.get(i)).getLetter_title();
			String letter_reg_datetime = ((Letter) list.get(i)).getLetter_reg_datetime();

			sb.append("<div class=\"mail\">");
			sb.append("<div id=\"show-letter" + letter_no + "\" style=\"cursor: pointer;\" class=\"" + letter_check
					+ "\" onclick=\"openPop('read')\">");
			if (letter_check == 0)
				sb.append("<strong><i class=\"fa-solid fa-envelope\" style=\"color: greenyellow\"></i>");
			else
				sb.append("</strong><i class=\"fa-solid fa-envelope-open\" style=\"color: rgb(148, 140, 140)\"></i>");
			sb.append("<p class=\"letter-nickname\"> " + user_nickname + " </p>");
			sb.append("<p class=\"letter-title\"> " + letter_title + " </p>");
			sb.append("<p class=\"letter-reg-datetime\"> " + letter_reg_datetime + " </p>");
			if (letter_check == 0)
				sb.append("</strong>");
			sb.append("</div>");
			if (((Letter) list.get(i)).getReceive_user_no() != userList.get(i).getUser_no())
				sb.append("<button onclick=\"location.href='deleteLetter.do?letter_no=" + letter_no + "'\">X</button>");
			sb.append("</div>");
		}
		return sb;
	}

	private StringBuilder getPrintReviewListData(List<?> list, List<User> userList, List<Item> itemList,
			List<ItemCategory> itemCategoryList, List<ItemImg> itemImgList) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			String buy_user_img = userList.get(i).getUser_img();
			if (buy_user_img == null || buy_user_img.isBlank())
				buy_user_img = "usersDefaultImg.jpg";
			String buy_user_nickname = userList.get(i).getUser_nickname();
			String buy_user_dong = userList.get(i).getUser_dong();
			String review_content = ((Review) list.get(i)).getReview_content();
			String item_img = "defaultItemImg.jpg";
			if (itemImgList != null && itemImgList.size() > 0 && itemImgList.get(i).getItem_img() != null
					&& !itemImgList.get(i).getItem_img().isBlank())
				item_img = itemImgList.get(i).getItem_img();

			sb.append("<div class=\"review-content\">");
			sb.append("<div class=\"review-table\">");
			sb.append("<table style=\"margin-left: 15px\">");
			sb.append("<tr><td rowspan=\"2\"><div class=\"review-user-img\">");
			sb.append("<img alt=\"대표이미지\" src=\"/images/" + buy_user_img + "\"></div></td>");
			sb.append("<td><span style=\"font-size: 15px; margin-left: 5px\">" + buy_user_nickname + "</span>");
			sb.append("<span style=\"font-size: 13px; color: #5a5656; margin-left: 9px\">" + buy_user_dong
					+ "</span></td></tr>");
			sb.append("<tr><td><span class=\"review-content-box\">" + review_content + "</span></td></tr></table>");
			sb.append("</div>");
			sb.append("<div class=\"review-item-img\">");
			sb.append("<img alt=\"대표 이미지\" src=\"/images/" + item_img + "\">");
			sb.append("</div>");
			sb.append("</div>");
			sb.append("<hr class=\"review-hr\">");
		}
		return sb;
	}

	private StringBuilder getPrintAdminUserListData(List<?> list) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			int user_no = ((User) list.get(i)).getUser_no();
			String user_name = ((User) list.get(i)).getUser_name();
			String nickname = ((User) list.get(i)).getUser_nickname();
			int age = ((User) list.get(i)).getUser_age();
			String email = ((User) list.get(i)).getUser_email();
			String address = ((User) list.get(i)).getUser_address();
			String phone = ((User) list.get(i)).getUser_phone();
			int deg = ((User) list.get(i)).getUser_deg();

			sb.append("<div class=\"user\">");
			sb.append("<table>");
			sb.append("<tr>");
			sb.append("<th class=\"no\">" + user_no + " </th>");
			sb.append("<th class=\"name\">" + user_name + " </th>");
			sb.append("<th class=\"nickname\">" + nickname + " </th>");
			sb.append("<th class=\"age\">" + age + "세 </th>");
			sb.append("<th class=\"email\">" + email + " </th>");
			sb.append("<th class=\"address\">" + address + " </th>");
			sb.append("<th class=\"phone\">" + phone + " </th>");
			sb.append("<th class=\"temp\">" + deg + "°C </th>");
			sb.append("<th class=\"delete\"><button class=\"delete\"> X </button></th>");
			sb.append("</tr>");
			sb.append("</table>");
			sb.append("</div>");
		}
		return sb;
	}

	private StringBuilder getPrintAdminBoardListData(List<?> list, List<BoardCategory> boardCategoryList,
			List<Integer> likeCountList, List<Integer> commentCountList) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			int board_no = ((Board) list.get(i)).getBoard_no();
			String board_title = ((Board) list.get(i)).getBoard_title();
			String board_content = ((Board) list.get(i)).getBoard_content();
			String board_dong = ((Board) list.get(i)).getBoard_dong();
			String board_category_name = boardCategoryList.get(i).getBoard_category_name();
			String board_reg_datetime = DateUtil.getInstance()
					.getCalcDateAgo(((Board) list.get(i)).getBoard_reg_datetime());
			int likeCount = likeCountList.get(i);
			int commentCount = commentCountList.get(i);

			sb.append("<div class=\"board\">");
			sb.append("<table>");
			sb.append("<tr>");
			sb.append("<th class=\"no\">" + board_no + "</th>");
			sb.append("<th class=\"title\"> " + board_title + "</th>");
			sb.append("<th class=\"content\">" + board_content + "</th>");
			sb.append("<th class=\"dong\">" + board_dong + "</th>");
			sb.append("<th class=\"category\">" + board_category_name + "</th>");
			sb.append("<th class=\"reg-datetime\">" + board_reg_datetime + "</th>");
			sb.append("<th class=\"like\">" + likeCount + "</th>");
			sb.append("<th class=\"comment\">" + commentCount + " | </th>");
			sb.append("<th class=\"delete\" ><button  class=\"delete\" onclick=\"location.href='deleteBoard.do?board_no=" + board_no + "'\"> X </button><th>");
			sb.append("</tr>");
			sb.append("</table>");
			sb.append("</div>");
		}
		return sb;
	}

	private StringBuilder getPrintAdminItemListData(List<?> list) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			int item_no = ((Item) list.get(i)).getItem_no();
			String item_name = ((Item) list.get(i)).getItem_name();
			String item_content = ((Item) list.get(i)).getItem_content();
			int item_status = ((Item) list.get(i)).getItem_status();
			String status = item_status == 2 ? "예약중 " : item_status == 3 ? "판매완료 " : "";
			int item_price = ((Item) list.get(i)).getItem_price();
			String price = getPrintPrice(item_price);
			String item_dong = ((Item) list.get(i)).getItem_dong();

			sb.append("<div class=\"item\">");
			sb.append("<table>");
			sb.append("<tr>");
			sb.append("<th class=\"no\">" + item_no + "</th>");
			sb.append("<th class=\"title\">" + item_name + "</th>");
			sb.append("<th class=\"content\">" + item_content + "</th>");
			sb.append("<th class=\"status\">" + status + "</th>");
			sb.append("<th class=\"price\">" + price + "</th>");
			sb.append("<th class=\"dong\">" + item_dong + "</th>");
			sb.append("<th class=\"delete\"><button class=\"delete\" onclick=\"location.href='deleteItem.do?item_no=" + item_no + "'\">X</button></th>");
			sb.append("</tr>");
			sb.append("</table>");
			sb.append("</div>");
			
		}
		return sb;
	}

	private StringBuilder getPrintAdminMeetListData(List<?> list, List<MeetCategory> meetCategoryList,
			List<Integer> memberCountList) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			int meet_no = ((Meet) list.get(i)).getMeet_no();
			String meet_title = ((Meet) list.get(i)).getMeet_title();
			String meet_content = ((Meet) list.get(i)).getMeet_content();
			String meet_dong = ((Meet) list.get(i)).getMeet_dong();
			int memberCount = memberCountList.get(i);
			String meet_category_name = meetCategoryList.get(i).getMeet_category_name();

			sb.append("<div class=\"meet\">");
			sb.append("<table>");
			sb.append("<tr>");
			sb.append("<th class=\"no\">" + meet_no + "</span>");
			sb.append("<th class=\"title\">" + meet_title + "</span>");
			sb.append("<th class=\"content\">" + meet_content + "</span>");
			sb.append("<th class=\"dong\">" + meet_dong + "</span>");
			sb.append("<th class=\"member\">" + memberCount + "명</span>");
			sb.append("<th class=\"category\">" + meet_category_name + "</span>");
			sb.append("<th class=\"delete\"><button  class=\"delete\" onclick=\"location.href='deleteMeet.do?meet_no=" + meet_no + "'\">X</button></th>");
			sb.append("</tr>");
			sb.append("</table>");
			sb.append("</div>");
		}
		return sb;
	}

	private StringBuilder getPrintAlarmListData(List<?> list, List<AlarmCategory> alarmCategoryList) {
		List<String> alarmLocationList = getAlarmLocationList(list);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			String alarm_location = alarmLocationList.get(i);
			int alarm_no = ((Alarm) list.get(i)).getAlarm_no();
			String alarm_category_content = alarmCategoryList.get(i).getAlarm_category_content();
			String alarm_date_ago = DateUtil.getInstance()
					.getCalcDateAgo(((Alarm) list.get(i)).getAlarm_reg_datetime());
			int alarm_check = ((Alarm) list.get(i)).getAlarm_check();
			sb.append("<div>");
			sb.append("<div class=\"bell\" onclick=\"location.href='"+alarm_location+"'\">");
			if(alarm_check == 1) {
				sb.append("<div>");
				sb.append("<span>"+alarm_category_content+" </span>");
				sb.append("</div>");
				sb.append("<div>");
				sb.append("<span> "+alarm_date_ago+"</span><br>");
				sb.append("</div>");
			}else {
				sb.append("<div>");
				sb.append("<span><strong>"+alarm_category_content+" </strong></span>");
				sb.append("</div>");
				sb.append("<div>");
				sb.append("<span><strong> "+alarm_date_ago+"</strong></span><br>");
				sb.append("</div>");
			}
			sb.append("</div>");
			sb.append("<button id=\"btn-deleteAlarm"+alarm_no+"\"onclick=\"deleteAlarm()\">X</button>");
			sb.append("</div>");
		}
		return sb;
	}

	private List<String> getAlarmLocationList(List<?> list) {
		List<String> alarmLocationList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			int alarm_category_no = ((Alarm) list.get(i)).getAlarm_category_no();
			int link_no = ((Alarm) list.get(i)).getLink_no();
			int alarm_no = ((Alarm) list.get(i)).getAlarm_no();
			switch (alarm_category_no) {
			case 1, 2:
				alarmLocationList.add("/infoBoard.do?board_no=" + link_no + "&alarm_no=" + alarm_no);
				break; // 게시판 이동
			case 3:
				alarmLocationList.add("/infoItem.do?item_no=" + link_no + "&alarm_no=" + alarm_no);
				break; // 아이템 이동
			case 4:
				alarmLocationList.add("/itemListUser.do?alarm_no=" + alarm_no);
				break; // 리뷰 리스트 이동
			case 5:
				alarmLocationList.add("/insertReview.do?item_no=" + link_no + "&alarm_no=" + alarm_no);
				break; // 리뷰 작성 페이지 이동
			case 6:
				alarmLocationList.add("/listLetter.do?alarm_no=" + alarm_no);
				break; // 쪽지함 이동
			case 7:
				alarmLocationList.add("/mypageUser.do?alarm_no=" + alarm_no);
				break; // 일정 보기 이동
			case 8:
				alarmLocationList.add("/listMeetJoin.do?meet_no=" + link_no + "&alarm_no=" + alarm_no);
				break; // 모임 가입 리스트 이동
			case 9:
				alarmLocationList.add("/infoMeet.do?meet_no=" + link_no + "&alarm_no=" + alarm_no);
				break; // 신청 모임으로 이동
			}
		}
		return alarmLocationList;
	}
}
