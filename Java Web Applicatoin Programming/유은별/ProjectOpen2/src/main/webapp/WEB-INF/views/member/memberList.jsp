<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 리스트</title>
<style>

</style>
</head>
<body>

<h3>회원리스트</h3>
<table border="1">
	<tr>
		<td>번호</td>
		<td>아이디</td>
		<td>이름</td>
		<td>사진</td>
		<td>관리</td>
	</tr>
	
	<!-- 회원 정보 출력 반복 시작 -->
	<c:forEach var="member" items="${members}">
	<tr>
		<td>${member.idx}</td>
		<td>${member.member_id}</td>
		<td>${member.member_name}</td>
		<td>
		<c:if test="${member.photo != null}">
		<img src="../uploadfile/memberphoto/${member.photo}" width="100">
		</c:if>
		</td>
		<td><a href="${pageContext.request.contextPath}/member/memberView?member_id=${member.member_id}">보기</a>
		<a href="${pageContext.request.contextPath}/member/memberUpdate?member_id=${member.member_id}">수정</a>
		<a href="${pageContext.request.contextPath}/member/memberDelete?member_id=${member.member_id}">삭제</a>
		</td>
	</tr>
	</c:forEach>
	<!-- 회원 정보 출력 반복 끝 -->	
	
</table>












</body>
</html>