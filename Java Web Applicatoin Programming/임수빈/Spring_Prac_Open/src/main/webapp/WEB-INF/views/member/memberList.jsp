<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 리스트</title>
<style>
</style>
</head>
<body>

	<h3>회원 리스트</h3>


	<table border="1">
		<tr>
			<td>인덱스</td>
			<td>아이디</td>
			<td>이름</td>
			<td>사진</td>
			<td>관리</td>
		</tr>

		<c:forEach var="memberView" items="${members}">
			<tr>
				<td>${member.idx}</td>
				<td>${member.memberId}</td>
				<td>${member.memberName}</td>
				<td><c:if test="${member.memberPhoto != null}">
						<img src="../uploadfile/memberPhoto/${member.memberPhoto}"
							width="100">
					</c:if></td>
				<td><a href="view?=memberId=${member.memerId}">보기</a></td>
			</tr>
		</c:forEach>

	</table>


</body>
</html>