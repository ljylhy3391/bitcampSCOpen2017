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
	width:200px;
	height:200px;
	background-image: url('../../uploadfile/memberphoto/${member.photo}');
	background-size: 100%;
	border: 1px solid #DDDDDD;
}
</style>
<body>
<div id="my">

</div>

${member.member_id} / ${member.member_name} 
${member.photo} <!-- name값 안찍히는이류 -->
</body>
</html>