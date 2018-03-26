<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 폼</title>
<style>
</style>
</head>
<body>
	<h1>회원가입 폼</h1>
	<form action="<%=request.getContextPath()%>/member/loginReg" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="memberId"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="memberPw"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="memberName"></td>
			</tr>
			<tr>
				<td>사진</td>
				<td><input type="file" name="photofile"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="회원가입">
					<input type="reset" value="초기화">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>