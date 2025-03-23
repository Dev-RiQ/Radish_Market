package com.radish.frontController;

import java.util.HashMap;

import com.radish.controller.admin.BoardManageController;
import com.radish.controller.admin.ItemManageController;
import com.radish.controller.admin.MeetManageController;
import com.radish.controller.admin.SiteInfoController;
import com.radish.controller.admin.UserManageController;
import com.radish.controller.ajax.FileUploadAjaxController;
import com.radish.controller.ajax.ListPagingAjaxController;
import com.radish.controller.ajax.MainAjaxController;
import com.radish.controller.alarm.DeleteAlarmAjaxController;
import com.radish.controller.alarm.InsertAlarmAjaxController;
import com.radish.controller.alarm.ListAlarmAjaxController;
import com.radish.controller.alarmCategory.DeleteAlarmCategoryController;
import com.radish.controller.alarmCategory.InsertAlarmCategoryController;
import com.radish.controller.alarmCategory.ListAlarmCategoryController;
import com.radish.controller.alarmCategory.UpdateAlarmCategoryController;
import com.radish.controller.board.DeleteBoardController;
import com.radish.controller.board.InfoBoardController;
import com.radish.controller.board.InsertBoardController;
import com.radish.controller.board.ListBoardController;
import com.radish.controller.board.UpdateBoardController;
import com.radish.controller.boardCategory.DeleteBoardCategoryController;
import com.radish.controller.boardCategory.InsertBoardCategoryController;
import com.radish.controller.boardCategory.ListBoardCategoryController;
import com.radish.controller.boardCategory.UpdateBoardCategoryController;
import com.radish.controller.calendar.DeleteCalendarController;
import com.radish.controller.calendar.InfoCalendarAjaxController;
import com.radish.controller.calendar.InsertCalendarController;
import com.radish.controller.calendar.ListCalendarAjaxController;
import com.radish.controller.calendar.UpdateCalendarController;
import com.radish.controller.comment.DeleteCommentController;
import com.radish.controller.comment.InsertCommentController;
import com.radish.controller.comment.ListCommentController;
import com.radish.controller.comment.UpdateCommentController;
import com.radish.controller.item.DeleteItemController;
import com.radish.controller.item.InfoItemController;
import com.radish.controller.item.InsertItemController;
import com.radish.controller.item.ListItemController;
import com.radish.controller.item.UpdateItemController;
import com.radish.controller.itemCategory.DeleteItemCategoryController;
import com.radish.controller.itemCategory.InsertItemCategoryController;
import com.radish.controller.itemCategory.ListItemCategoryController;
import com.radish.controller.itemCategory.UpdateItemCategoryController;
import com.radish.controller.letter.DeleteLetterController;
import com.radish.controller.letter.InfoLetterAjaxController;
import com.radish.controller.letter.InsertLetterController;
import com.radish.controller.letter.ListLetterController;
import com.radish.controller.like.DeleteLikeController;
import com.radish.controller.like.InsertLikeController;
import com.radish.controller.meet.DeleteMeetController;
import com.radish.controller.meet.InfoMeetController;
import com.radish.controller.meet.InsertMeetController;
import com.radish.controller.meet.ListMeetController;
import com.radish.controller.meet.UpdateMeetController;
import com.radish.controller.meetCategory.DeleteMeetCategoryController;
import com.radish.controller.meetCategory.InsertMeetCategoryController;
import com.radish.controller.meetCategory.ListMeetCategoryController;
import com.radish.controller.meetCategory.UpdateMeetCategoryController;
import com.radish.controller.meetJoin.DeleteMeetJoinController;
import com.radish.controller.meetJoin.InsertMeetJoinController;
import com.radish.controller.meetJoin.ListMeetJoinController;
import com.radish.controller.meetUser.DeleteMeetUserController;
import com.radish.controller.meetUser.InsertMeetUserController;
import com.radish.controller.meetUser.ListMeetUserController;
import com.radish.controller.myPage.boardListUserController;
import com.radish.controller.myPage.cartListUserController;
import com.radish.controller.myPage.itemListUserController;
import com.radish.controller.myPage.meetListUserController;
import com.radish.controller.myPage.mypageUserController;
import com.radish.controller.myPage.sellListUserController;
import com.radish.controller.myPage.zzimListUserController;
import com.radish.controller.review.InsertReviewController;
import com.radish.controller.review.ListReviewController;
import com.radish.controller.user.DeleteUserController;
import com.radish.controller.user.InsertUserAjaxController;
import com.radish.controller.user.InsertUserController;
import com.radish.controller.user.LoginController;
import com.radish.controller.user.LogoutController;
import com.radish.controller.user.UpdateUserController;
import com.radish.controller.zzim.DeleteZzimController;
import com.radish.controller.zzim.InsertZzimController;
import com.radish.controller.zzim.ListZzimController;


public class HandlerMapping {
	private HashMap<String, Controller> mappings;
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		
		// User
		mappings.put("/insertUser.do", new InsertUserController());
		mappings.put("/deleteUser.do", new DeleteUserController());
		mappings.put("/updateUser.do", new UpdateUserController());
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
		
		// MyPage
		mappings.put("/mypageUser.do", new mypageUserController());
		mappings.put("/itemListUser.do", new itemListUserController());
		mappings.put("/boardListUser.do", new boardListUserController());
		mappings.put("/meetListUser.do", new meetListUserController());
		mappings.put("/zzimListUser.do", new zzimListUserController());
		mappings.put("/cartListUser.do", new cartListUserController());
		mappings.put("/sellListUser.do", new sellListUserController());
		
		// Item
		mappings.put("/insertItem.do", new InsertItemController());
		mappings.put("/deleteItem.do", new DeleteItemController());
		mappings.put("/updateItem.do", new UpdateItemController());
		mappings.put("/listItem.do", new ListItemController());
		mappings.put("/infoItem.do", new InfoItemController());
		
		// Board
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/listBoard.do", new ListBoardController());
		mappings.put("/infoBoard.do", new InfoBoardController());
		
		// Meet
		mappings.put("/insertMeet.do", new InsertMeetController());
		mappings.put("/deleteMeet.do", new DeleteMeetController());
		mappings.put("/updateMeet.do", new UpdateMeetController());
		mappings.put("/listMeet.do", new ListMeetController());
		mappings.put("/infoMeet.do", new InfoMeetController());
		
		// Review
		mappings.put("/insertReview.do", new InsertReviewController());
		mappings.put("/listReview.do", new ListReviewController());
		
		// Comment
		mappings.put("/insertComment.do", new InsertCommentController());
		mappings.put("/deleteComment.do", new DeleteCommentController());
		mappings.put("/updateComment.do", new UpdateCommentController());
		mappings.put("/listComment.do", new ListCommentController());
		
		// Letter
		mappings.put("/insertLetter.do", new InsertLetterController());
		mappings.put("/deleteLetter.do", new DeleteLetterController());
		mappings.put("/listLetter.do", new ListLetterController());
		
		// Zzim
		mappings.put("/insertZzim.do", new InsertZzimController());
		mappings.put("/deleteZzim.do", new DeleteZzimController());
		mappings.put("/listZzim.do", new ListZzimController());
		
		// Like
		mappings.put("/insertLike.do", new InsertLikeController());
		mappings.put("/deleteLike.do", new DeleteLikeController());
		
		// MeetJoin
		mappings.put("/insertMeetJoin.do", new InsertMeetJoinController());
		mappings.put("/deleteMeetJoin.do", new DeleteMeetJoinController());
		mappings.put("/listMeetJoin.do", new ListMeetJoinController());
		
		// MeetUser
		mappings.put("/insertMeetUser.do", new InsertMeetUserController());
		mappings.put("/deleteMeetUser.do", new DeleteMeetUserController());
		mappings.put("/listMeetUser.do", new ListMeetUserController());
		
		// Alarm
		mappings.put("/insertAlarmAjax.do", new InsertAlarmAjaxController());
		mappings.put("/deleteAlarmAjax.do", new DeleteAlarmAjaxController());
		
		// Calendar
		mappings.put("/insertCalendar.do", new InsertCalendarController());
		mappings.put("/deleteCalendar.do", new DeleteCalendarController());
		mappings.put("/updateCalendar.do", new UpdateCalendarController());
		
		// Admin
		mappings.put("/siteInfo.do", new SiteInfoController());
		mappings.put("/userManage.do", new UserManageController());
		mappings.put("/boardManage.do", new BoardManageController());
		mappings.put("/itemManage.do", new ItemManageController());
		mappings.put("/meetManage.do", new MeetManageController());
		
		// Ajax
		mappings.put("/insertUserAjax.do", new InsertUserAjaxController());
		mappings.put("/listAlarmAjax.do", new ListAlarmAjaxController());
		mappings.put("/infoLetterAjax.do", new InfoLetterAjaxController());
		mappings.put("/listCalendarAjax.do", new ListCalendarAjaxController());
		mappings.put("/infoCalendarAjax.do", new InfoCalendarAjaxController());
		mappings.put("/listPagingAjax.do", new ListPagingAjaxController());
		mappings.put("/fileUploadAjax.do", new FileUploadAjaxController());
		mappings.put("/main.do", new MainAjaxController());
		
		// BoardCategory
		mappings.put("/listBoardCategory.do", new ListBoardCategoryController());
		mappings.put("/insertBoardCategory.do", new InsertBoardCategoryController());
		mappings.put("/updateBoardCategory.do", new UpdateBoardCategoryController());
		mappings.put("/deleteBoardCategory.do", new DeleteBoardCategoryController());
		
		// AlarmCategory
		mappings.put("/listAlarmCategory.do", new ListAlarmCategoryController());
		mappings.put("/insertAlarmCategory.do", new InsertAlarmCategoryController());
		mappings.put("/updateAlarmCategory.do", new UpdateAlarmCategoryController());
		mappings.put("/deleteAlarmCategory.do", new DeleteAlarmCategoryController());
		
		// ItemCategory
		mappings.put("/listItemCategory.do", new ListItemCategoryController());
		mappings.put("/insertItemCategory.do", new InsertItemCategoryController());
		mappings.put("/updateItemCategory.do", new UpdateItemCategoryController());
		mappings.put("/deleteItemCategory.do", new DeleteItemCategoryController());
		
		// MeetCategory
		mappings.put("/listMeetCategory.do", new ListMeetCategoryController());
		mappings.put("/insertMeetCategory.do", new InsertMeetCategoryController());
		mappings.put("/updateMeetCategory.do", new UpdateMeetCategoryController());
		mappings.put("/deleteMeetCategory.do", new DeleteMeetCategoryController());
	}
	
	public Controller getController(String key) {
		return mappings.get(key);
	}
}
