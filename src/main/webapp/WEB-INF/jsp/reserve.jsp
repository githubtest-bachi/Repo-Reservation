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
<h1>予約登録ページ</h1>
<c:if test="${not empty errorMsgReserve}">
	<p style="color:red;">
	<c:out value="${errorMsgReserve}" /></p>
</c:if>
<p>予約内容を以下にご入力ください。</p>
	<form action="/servlet-reservation/Reserve" method="post">
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
	<p><input type="submit" value="登録"></p>
	</form>
</body>
</html>