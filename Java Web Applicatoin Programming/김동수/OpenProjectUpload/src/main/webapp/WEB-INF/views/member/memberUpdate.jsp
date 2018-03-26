<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 수정</title>
<style>
table {
	width: 80%;
}

td {
	padding: 0px 10px;
}
</style>
</head>
<body>

	<h3>회원정보 수정</h3>
	<form action="${pageContext.request.contextPath}/member/memberUpdate"
		method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>가입일자</td>
				<td>사진</td>
			</tr>

			<!-- 회원 정보 출력 반복 시작 -->

			<tr>
				<td>${members.idx}</td>
				<td><input name="member_name" value="${members.member_name}"></td>
				<td><fmt:formatDate value="${members.regdate}" type="date"
						pattern="yyyy.MM.dd hh:MM" /></td>

				<td><input type="file" name="photofile"><img
					src="../uploadfile/memberphoto/${members.photo}" width="50" /></td>
			</tr>

			<!-- 회원 정보 출력 반복 끝 -->
		</table>
		<table>
			<tr>
				<td align="center"><input type="submit" value="수정"></td>
				<td><input type="reset" value="취소"></td>
			</tr>
		</table>
	</form>










</body>
</html>