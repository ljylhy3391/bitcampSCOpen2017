<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" style="height:200px" >

      <tr height="60px">
        <h4> <td>번호</td>
         <td>아이디 </td>
         <td>이름 </td>
         <td>사진</td>
      </tr>
           <tr height="60px">
        <h4> <td>${member.idx }</td>
         <td>${member.member_id } </td>
         <td>${member.member_name } </td>
         <td><input type="image" src="../uploadfile/memberphoto/${member.photo }"></td>
      </tr>


</body>
</html>