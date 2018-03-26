<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ include file="./layouts/header.jspf" %>

<!-- ${pageContext.request.contextPath} -->
<div class="card">
	<div class="card-body text-center">
		<div class="list-group text-left">
			<a href="${pageContext.request.contextPath}/member/list" class="list-group-item list-group-item-action">회원 목록</a>
			<a href="downloadXls" class="list-group-item list-group-item-action">엑셀 다운로드</a>
			<a href="${pageContext.request.contextPath}/member/memberlist.xml" class="list-group-item list-group-item-action">xml로 보기</a>
		</div>
	</div>
</div>

<%@ include file="./layouts/footer.jspf" %>