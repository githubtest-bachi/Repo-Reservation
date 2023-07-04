<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>イベントスペース予約管理システム</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
<h1>予約変更ページ</h1>
<p>現在の予約内容：</p>
<!-- リクエストスコープのidと、reserveListのidが一致したものだけ表示する -->
<c:forEach var="rb" items="${reserveList}">
	<c:choose>		
		<c:when test="${loginUser.name.equals(rb.userName) && Integer.parseInt(id) == rb.id}">
		<p>利用年月日：<c:out value="${rb.date}" /><br>
		利用目的：<c:out value="${rb.text}" /><br>
		利用開始時間：<c:out value="${rb.start}" /><br>
		利用終了時間：<c:out value="${rb.end}" /></p>
		</c:when>
		<c:when test="${loginUser.userType == 1 && Integer.parseInt(id) == rb.id}">
		<p>利用年月日：<c:out value="${rb.date}" /><br>
		予約者名：<c:out value="${rb.userName}" /><br>
		利用目的：<c:out value="${rb.text}" /><br>
		利用開始時間：<c:out value="${rb.start}" /><br>
		利用終了時間：<c:out value="${rb.end}" /></p>
		</c:when>
	</c:choose>
</c:forEach>
<hr>
<c:if test="${not empty errorMsgUpdateReserve}">
	<p style="color:red;">
	<c:out value="${errorMsgUpdateReserve}" /></p>
</c:if>
<p>変更内容を以下にご入力ください。</p>
	<form action="/servlet-reservation/UpdateReserve" method="post">
	<input type="hidden" name="id" value="${id}">
	<dl>
		<dt>利用年月日</dt>
		<dd><input type="date" required name="date"></dd>
		<dt>利用目的</dt>
		<dd><textarea required name="text" cols="40" rows="5"></textarea></dd>
		<dt>利用開始時間</dt>
		<dd><input type="time" required name="start" list="data-list" step="3600">
		<datalist id="data-list">
			<option value="09:00"></option>
			<option value="10:00"></option>
			<option value="11:00"></option>
			<option value="12:00"></option>
			<option value="13:00"></option>
			<option value="14:00"></option>
			<option value="15:00"></option>
			<option value="16:00"></option>
			<option value="17:00"></option>
			<option value="18:00"></option>
			<option value="19:00"></option>
			<option value="20:00"></option>
			<option value="21:00"></option>
			<option value="22:00"></option>
		</datalist></dd>
		<dt>利用終了時間</dt>
		<dd><input type="time" required name="end" list="data-list" step="3600">
		<datalist id="data-list">	
			<option value="10:00"></option>
			<option value="11:00"></option>
			<option value="12:00"></option>
			<option value="13:00"></option>
			<option value="14:00"></option>
			<option value="15:00"></option>
			<option value="16:00"></option>
			<option value="17:00"></option>
			<option value="18:00"></option>
			<option value="19:00"></option>
			<option value="20:00"></option>
			<option value="21:00"></option>
			<option value="22:00"></option>
			<option value="23:00"></option>
		</datalist></dd>
		</dl>
		<p><input type="submit" value="変更"></p>
	</form>
</body>
</html>