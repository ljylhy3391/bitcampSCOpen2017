<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보 상세 페이지</title>
</head>

<style>

</style>
<body>
<h2>회원 정보 상세</h2>
<form name="form1" method="post">
<table border = "1" width = "400px">
    <tr>
      <td>회원번호</td>
      <td><input name = "idx" value ="${member.idx}" readonly = "readonly"> </td> 
    </tr>
    <tr>
      <td>아이디</td>
      <td><input name = "member_id" value = "${member.member_id}"readonly = "readonly"></td> 
    </tr>
    <tr>
      <td>비밀번호</td>
      <td><input name = "password" value = "${member.password}"readonly = "readonly"></td> 
    </tr>
    <tr>
      <td>이름</td>
      <td><input name = "member_name" value = "${member.member_name}"></td> 
    </tr>
    <tr>
      <td>사진</td>
      <td>
      <img src="../uploadfile/memberphoto/${member.photo}" width="50"/>
      </td> 
    </tr>
    <tr>
      <td>회원가입일자</td>
      <td>
      <fmt:formatDate value = "${member.regdate}" type="date" pattern = "yyyy.MM.dd hh:MM"/>
      </td> 
    </tr>
</table>
 </form>

</body>
</html>