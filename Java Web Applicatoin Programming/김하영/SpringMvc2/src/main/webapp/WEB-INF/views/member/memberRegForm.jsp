<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
</style>
<body>
	<h1>회원가입 폼</h1>
	<form action="${pageContext.request.contextPath}/member/memberRegForm" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>아이디(이메일)</td>
				<td><input type="text" name="member_id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="member_name"></td>
			</tr>
			<tr>
				<td>파일등록</td>
				<td><input type="file" name="filename"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="가입"> <input type="reset"></td>
			</tr>
		</table>

	</form>


</body>
</html>