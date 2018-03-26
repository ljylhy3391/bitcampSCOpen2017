<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 리스트</title>
</head>
<body>
	<h1>회원 리스트</h1>
	<table border='1' bordercolor="white"style="text-align:center">
		<tr bgColor=pink>
			<td>회원 번호</td>
			<td>이름</td>
			<td>ID</td>
			<td>회원사진</td>
			<td colspan="3">관리</td>
		</tr>

		<c:forEach var="member" items="${memberlist}">
			<tr bgColor=#fcf1f4>
				<td>${member.idx }</td>
				<td>${member.member_name }</td>
				<td>${member.member_id }</td>
				<td><img src="../uploadfile/memberphoto/${member.member_photo }"width="100px" height="100px"></td>
				<td><a href="memberInfo?member_id=${member.member_id }">보기</a></td>
				<td><a href="memberUpdate?member_id=${member.member_id }">수정</a></td>
				<td><a href="memberDelete?member_id=${member.member_id }">삭제</a></td>
				<%-- <td><input type = "image" width="100px" height="100px" src="../uploadfile/memberphoto/${member.member_photo }"></td> --%>
			</tr>
		</c:forEach>
	</table>
	<ul>
	<li><a href="downloadXls">XLS 다운로드</a><br></li>
	<li><a href="downloadXml/list.xml" target="blank">XML 다운로드</a><br></li>
	</ul>
</body>
</html>