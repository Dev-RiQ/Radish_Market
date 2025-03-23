package com.radish.controller.item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.radish.dao.ItemCategoryDAO;
import com.radish.dao.ItemDAO;
import com.radish.dao.ItemImgDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.util.DateUtil;
import com.radish.vo.Item;
import com.radish.vo.ItemImg;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateItemController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int item_no = Integer.parseInt(request.getParameter("item_no"));
		int user_no = Integer.parseInt(request.getSession().getAttribute("log").toString());
		
		if(request.getParameter("item_name") == null) {
			request.setAttribute("user", UserDAO.getInstance().getAUserPortionInfo(user_no));
			request.setAttribute("item", ItemDAO.getInstance().getAItemByItemNo(item_no));
			request.setAttribute("itemImgList", ItemImgDAO.getInstance().getAllItemImgList(item_no));
			request.setAttribute("itemCategoryList", ItemCategoryDAO.getInstance().getAllItemCategoryList());
			return "item/itemUpdate";
		}
		
		String item_name = request.getParameter("item_name");
		int item_category_no = Integer.parseInt(request.getParameter("item_category_no"));
		int item_price = Integer.parseInt(request.getParameter("item_price"));
		String item_content = request.getParameter("item_content");
		String item_update_datetime = DateUtil.getInstance().getRegDatetime();
		int item_status = Integer.parseInt(request.getParameter("item_status"));

		Item item = new Item(item_no, user_no, item_category_no, item_name, item_content, item_price,
				item_update_datetime, item_status);
		
		String uploadFileNames = request.getParameter("user_item_img");
		String[] uploadFileName = uploadFileNames.split(", ");
		
		ItemImgDAO.getInstance().deleteItemImg(item_no);
		
		List<ItemImg> list = new ArrayList<>();
		for(String item_img : uploadFileName) {
			list.add(new ItemImg(item_img, item_no));
		}
		ItemImgDAO.getInstance().insertItemImg(list);
		
		if (ItemDAO.getInstance().updateItem(item)) {
			AlertUtil.getInstance().goUrlWithAlert(response, "상품 정보 수정 완료.", "mypageUser.do?item_no=" + item_no);
			return null;
		} else {
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 상품 정보 수정에 실패했습니다.\\n다시 시도해주세요.");
			return null;
		}

	}

}
