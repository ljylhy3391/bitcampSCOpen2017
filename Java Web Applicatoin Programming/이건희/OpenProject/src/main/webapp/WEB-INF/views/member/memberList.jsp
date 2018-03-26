<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
</style>
<body>

	<table border="1">
		<tr>
			<td>번호</td>
			<td>아이디</td>
			<td>이름</td>
			<td>사진</td>
			<td>관리</td>
		</tr>
		<!-- 회원정보 반복 시작  -->
		<c:forEach var="member" items="${list}">
			
			<tr>
				<td>${member.idx}</td>
				<td>${member.member_id}</td>
				<td>${member.member_name}</td>
				<td><img src="../uploadfile/memberphoto/${member.photo}" width="50"></td>
				<td><a href="example?idx=${member.idx}">보기</a><a href="updateform?idx=${member.idx}">수정</a><a href="deleteidx?idx=${member.idx}">삭제</a></td>
			</tr>
		</c:forEach>
		<!-- 회원 정보 출력 반복 끝 -->

	</table>




</body>
</html>