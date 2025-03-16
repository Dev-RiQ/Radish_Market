package com.radish.controller.letter;

import java.io.IOException;

import com.radish.dao.LetterDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteLetterController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int letter_no = Integer.parseInt(request.getParameter("letter_no"));
		if(LetterDAO.getInstance().deleteALetterByLetterNo(letter_no))
			AlertUtil.getInstance().goHomeWithAlert(response, "쪽지 삭제 완료");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 쪽지 삭제에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
