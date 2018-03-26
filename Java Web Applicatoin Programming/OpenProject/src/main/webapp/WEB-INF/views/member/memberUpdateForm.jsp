<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보 수정</h1>
	<form action="memberUpdate" method="post" enctype="multipart/form-data">
	<input type="hidden" name="${member.member_id}" value="${member.member_id}">
		<table>
			<tr>
				<td>아이디(이메일)</td>
				<td><input type="text" name="member_id" value="${member.member_id }"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="member_name"></td>
			</tr>
			<tr>
				<td>회원사진</td>
				<td><input type="file" name="photofile"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="수정 완료"><input
					type="reset"></td>
			</tr>
		</table>

	</form>
</body>
</html>