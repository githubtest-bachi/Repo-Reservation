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
<h1>新規登録画面</h1>
<c:if test="${not empty errorMsgRegister}">
	<p style="color:red;">
	<c:out value="${errorMsgRegister}" /></p>
</c:if>
<p>登録するユーザー情報を入力してください</p>
<form action="/servlet-reservation/Register" method="post">
	<dl>
	<dt>ユーザータイプ</dt>
	<dd><select required name="type">
	<option>1</option>
	<option>2</option>
	</select>※1が管理者、2が一般ユーザー</dd>
	<dt>ユーザー名</dt>
	<dd><input type="text" required name="name"></dd>
	<dt>メールアドレス</dt>
	<dd><input type="email" required name="mail"></dd>
	<dt>パスワード</dt>
	<dd><input type="password" required name="pass"></dd>
	</dl>
	<p><input type="submit" value="登録"></p>
</form>
</body>
</html>