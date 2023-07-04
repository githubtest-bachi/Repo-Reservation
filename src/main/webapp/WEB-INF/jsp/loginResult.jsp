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
<h1>予約管理システムログイン</h1>
<c:choose>
	<c:when test="${not empty loginUser && loginUser.userType == 1}">
		<p>ログインに成功しました</p>
		<p>ようこそ<c:out value="${loginUser.name}" />さん</p>
		<a href="/servlet-reservation/Main">予約一覧へ</a><br>
		<a href="/servlet-reservation/Register">ユーザー登録画面へ</a>
	</c:when>
	<c:when test="${not empty loginUser}">
		<p>ログインに成功しました</p>
		<p>ようこそ<c:out value="${loginUser.name}" />さん</p>
		<a href="/servlet-reservation/Main">予約一覧へ</a>
	</c:when>
	<c:otherwise>
		<p>ログインに失敗しました</p>
		<a href="/servlet-reservation/">トップへ</a>
	</c:otherwise>
</c:choose>
</body>
</html>