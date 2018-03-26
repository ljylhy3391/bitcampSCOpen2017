<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>div{

}

</style>
<body>
<h3>리스트 페이지</h3>

<table border="1" style="height:200px" >

      <tr height="60px">
        <h4> <td>번호</td>
         <td>아이디</td>
         <td>이름</td>
         <td>사진</td>
         <td>관리</td></h4>
      </tr>
      <c:forEach items="${list}" var="member">
         <tr height="60px">
            <td width="150px">${member.idx}</td>
            <td>${member.member_id}</td>
            <td>${member.member_name}</td>
            <td><input type="image" src="../uploadfile/memberphoto/${member.photo }" width="100px" height="100px"></td>
       		<td><a href="${pageContext.request.contextPath}/member/preview?member_id=${member.member_id}">보기</a></td>
       		<td><a href="${pageContext.request.contextPath}/member/updateForm?member_id=${member.member_id}">수정</a></td>
       		<td><a href="${pageContext.request.contextPath}/member/delete?member_id=${member.member_id}">삭제</a></td>
         </tr>
      </c:forEach>
   </table>
   
		




</body>
</html>