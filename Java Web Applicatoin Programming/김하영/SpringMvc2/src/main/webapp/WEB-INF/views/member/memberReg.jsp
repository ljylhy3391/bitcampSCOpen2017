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
div{
	height:100px;
	width:100px;
	background-image: url('../uploadfile/memberphoto/${member.photo}');
	background-size: 100%;
}

</style>
<body>
<div>

	${member.photo }
</div>
	<a href="../">home로 이동</a>
</body>
</html>