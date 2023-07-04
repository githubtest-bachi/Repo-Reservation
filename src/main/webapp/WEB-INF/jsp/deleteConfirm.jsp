<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
String id = (String)request.getAttribute("id");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>イベントスペース予約管理システム</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
<h1>予約削除確認</h1>
<p>予約の削除を行います。よろしいですか？</p>
<form action="/servlet-reservation/DeleteReserve" method="post">
<input type="hidden" name="id" value=<%=id%>>
<input type="submit" value="削除">
</form>
</body>
</html>