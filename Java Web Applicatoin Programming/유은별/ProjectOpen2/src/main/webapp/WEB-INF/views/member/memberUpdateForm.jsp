<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>업데이트 폼</title>
</head>
<body>

<h1>업데이트 해라</h1>
<form action="memberUpdate" method="post" enctype="multipart/form-data">
<table>
    <tr>
		<td>번호</td>
		<td><input type="number" name="idx" value="${member.idx}">  </td>
	</tr>
	<tr>
		<td>아이디(이메일)</td>
		<td><input type="text" name="member_id" value="${member.member_id}">  </td>
	</tr> 
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="password" value="${member.password}">  </td>
	</tr> 
	<tr>
		<td>이름</td>
		<td><input type="text" name="member_name" value="${member.member_name}">  </td>
	</tr>		 
	<tr>
		<td>사진</td>
		<td><input type="file" name="photofile" value="${member.photofile}">  </td>
		                  <!-- model/Member에 photofile로 되어있으니  이름 맞춰야짓  -->
	</tr> 
	<tr>
		<td></td>
		<td>
			<input type="submit" value="수정">
			<input type="reset">
		</td>
	</tr>
</table>

</form>

</body>
</html>