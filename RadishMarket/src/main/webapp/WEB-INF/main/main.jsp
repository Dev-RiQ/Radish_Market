<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<<<<<<< HEAD <%@ taglib uri="jakarta.tags.core" prefix="c" %>
		=======

		<%@ include file="./header.jsp" %>
			>>>>>>> Dev-LJH
			<c:choose>
				<c:when test="${ section eq null }">
					<%@ include file="../main/header.jsp" %>
						<%@ include file="../main/footer.jsp" %>
				</c:when>
				<c:otherwise>
					<jsp:include page="${ section }"></jsp:include>
				</c:otherwise>
			</c:choose>