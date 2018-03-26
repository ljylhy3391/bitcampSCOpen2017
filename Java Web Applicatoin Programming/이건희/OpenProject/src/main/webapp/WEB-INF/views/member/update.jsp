<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
</style>
<body>
	<table>
		<tr>
			<td>idx</td>
			<td>${member.idx }</td>
		</tr>
		<tr>
			<td>member_id</td>
			<td>${member.member_id}</td>
		</tr>
		<tr>
			<td>member_name</td>
			<td>${member.member_name}</td>
		</tr>
		<tr>
			<td>password</td>
			<td>${member.password}</td>
		</tr>
		<tr>
			<td>regdate</td>
			<td><fmt:formatDate value="${member.regdate}" pattern="yyyy-MM-dd hh:mm"/>


			</td>
		</tr>
		<tr>
			<td>photo</td>
			<td><img src="../uploadfile/memberphoto/${member.photo}"
				width="50"></td>
		</tr>

	</table>
</body>
</html>