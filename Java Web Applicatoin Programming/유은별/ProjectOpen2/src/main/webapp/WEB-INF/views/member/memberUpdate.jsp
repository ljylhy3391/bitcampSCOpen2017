<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<style>
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>업데이트 뷰 </title>
</head>
<body>

<h3>수정 완료!!!</h3>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>아이디</td>
			<td>이름</td>
			<td>비밀번호</td>
			<td>등록일</td>
			<td>사진</td>
		</tr>

		<tr>
			<td>${member.idx}</td>
			<td>${member.member_id}</td>
			<td>${member.member_name}</td>
			<td>${member.password}</td>
			<td><fmt:formatDate value="${member.regdate}" pattern="yyyy-MM-dd hh:mm"/></td>
			<td><c:if test="${member.photo != null}">
					<img src="../uploadfile/memberphoto/${member.photo}" width="50">
				</c:if></td>
		</tr>



</body>
</html>