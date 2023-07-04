<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>イベントスペース予約管理システム</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<h1>予約管理システムへようこそ</h1>
	<p>ログイン情報を入力してください</p>
	<form action="/servlet-reservation/Login" method="post">
		<dl>
		<dt>メールアドレス</dt>
		<dd><input type="text" name="mail"></dd>
		<dt>パスワード</dt>
		<dd><input type="password" name="pass"></dd>
		</dl>
		<p><input type="submit" value="ログイン"></p>
	</form>
</body>
</html>