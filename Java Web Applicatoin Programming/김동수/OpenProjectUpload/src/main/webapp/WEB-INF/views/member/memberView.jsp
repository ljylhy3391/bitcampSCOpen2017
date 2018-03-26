<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보</title>
<style>
	table {
		width: 80%;		
	}
	td {
		padding : 0px 10px;
	}
</style>
</head>
<body>

<h3>회원정보</h3>
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
		<td>${members.member_name}</td>
		<td><fmt:formatDate value="${members.regdate}" type="date" pattern="yyyy.MM.dd hh:MM"/></td>
		
		<td>
			<img src = "../uploadfile/memberphoto/${members.photo}" width="50" />
		</td>
	</tr>
	<!-- 회원 정보 출력 반복 끝 -->	
</table>












</body>
</html>