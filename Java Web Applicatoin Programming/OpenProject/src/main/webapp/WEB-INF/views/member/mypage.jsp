<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MY PAGE</title>
<style>
/* div {
	width: 200px;
	height: 230px;
	border-radius: 100px;
	background-image:
		url('../uploadfile/memberphoto/${member.member_photo }');
	background-size: 100%;
} */

</style>
</head>
<body>
	<!-- <div id="my"></div> -->
	<%-- ${member.member_name }/${member.member_id }/${member.member_photo } --%>
	<%-- <img src="../uploadfile/memberphoto/${member.member_photo }"> --%>
	<table border='1' bordercolor="white"style="text-align:center" >
		<tr bgColor=#fcf1f4>
		<td colspan="3"> ♡회원♡</td>
		<tr>
		<tr>
		<td colspan="3"><img src="../uploadfile/memberphoto/${member.member_photo }"
				width="200px" height="230px"> 
		<tr>
		<tr bgColor=pink>
			<td>회원 번호</td>
			<td>이름</td>
			<td>ID</td>
			<td>가입 날짜</td>
		</tr>
		<tr bgColor=#fcf1f4>
			<td>${member.idx }</td>
			<td>${member.member_name }</td>
			<td>${member.member_id }</td>
			<td>${member.member_date }</td>
			<%-- <td><img src="../uploadfile/memberphoto/${member.member_photo }"
				width="100px" height="100px"> 
			 --%>
			<%-- <td><input type = "image" width="100px" height="100px" src="../uploadfile/memberphoto/${member.member_photo }"></td> --%>
		</tr>
	</table>
</body>
</html>