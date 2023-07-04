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
<h1>予約一覧ページ</h1>
<p><c:out value="${loginUser.name}" />さん、ログイン中<br>
<a href="/servlet-reservation/Logout">ログアウト</a></p>
<p>
予約登録はこちら<br>
<a href="/servlet-reservation/Reserve"><button type="button">予約登録</button></a>
</p>
<hr>
<h2>現在の予約状況</h2>
<c:if test="${not empty errorMsgUpdate}">
	<p class="caution">${errorMsgUpdate}</p>
</c:if>
<c:if test="${not empty errorMsgDel}">
	<p class="caution">${errorMsgDel}</p>
</c:if>
<table>
	<tr><th>利用年月日</th><th>予約者名</th><th>利用目的</th><th>利用開始時間</th><th>利用終了時間</th><th></th><th></th></tr>
	<c:forEach var="rb" items="${reserveList}">
	<tr><td>${rb.date}</td><td>${rb.userName}</td><td>${rb.text}</td><td>${rb.start}</td><td>${rb.end}</td>
	<td><a href="/servlet-reservation/UpdateReserve?id=${rb.id}&name=${rb.userName}">変更</a></td>
	<td><a href="/servlet-reservation/DeleteReserve?id=${rb.id}&name=${rb.userName}">削除</a></td></tr>
	</c:forEach>
</table>
</body>
</html>