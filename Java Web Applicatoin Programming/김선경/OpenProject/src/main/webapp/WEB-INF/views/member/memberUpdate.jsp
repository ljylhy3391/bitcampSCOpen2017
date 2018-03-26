<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

</style>
</head>
<body>

<form action="${pageContext.request.contextPath }/member/memberUpdate" method="post" enctype="multipart/form-data">
<input type="hidden" name="idx" value="${member.idx }">
<input type="hidden" name="password" value="${member.password }">
<table>
	<tr>
		<td>아이디</td>
		<td><input type="text" name="member_id" value="${member.member_id }" readonly="readonly"></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="member_name" value="${member.member_name }"></td>
	</tr>
	<tr>
		<td>사진</td>
		<td><input type="file" name="photofile"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="수정"><input type="reset" value="취소"></td>
	</tr>
</table>
</form>

<br><br>
<a href="memberList">회원 리스트</a>

</body>
</html>



