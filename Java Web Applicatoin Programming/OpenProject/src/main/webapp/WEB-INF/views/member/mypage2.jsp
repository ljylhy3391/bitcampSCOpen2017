<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MY PAGE</title>
<style>
div {
	width: 200px;
	heigh: 200px;
	border-radius: 100px;
	border: 1px solid #DDDDDD;
	background-image:
		url('../../uploadfile/memberphoto/${member.member_photo }');
	background-size: 100%;
}
</style>
</head>
<body>
	<div id="my">${member.member_name }/${member.member_id }/${member.member_photo }
	</div>
</body>
</html>