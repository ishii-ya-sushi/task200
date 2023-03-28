<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="model.User"%>
<%
// 新しいｾｯｼｮﾝｽｺｰﾌﾟに保存されている入力されたﾕｰｻﾞ情報ﾃﾞｰﾀ（Userｲﾝｽﾀﾝｽ）を取得
// Objectｸﾗｽの型で戻ってくるのでUserｸﾗｽの型に(ｷｬｽﾄ)する 
User newLoginUser = (User) session.getAttribute("newLoginUser");
%>

<!-- 現在の（ﾛｸﾞｲﾝ前の）ｾｯｼｮﾝIDを取得する -->
<!-- ﾛｸﾞｲﾝ前のｾｯｼｮﾝIDを新しいｾｯｼｮﾝｽｺｰﾌﾟに属性名"oldSessionId"で保存する  -->
<% String oldSessionId = session.getId(); %>
<% session.setAttribute("oldSessionId", oldSessionId); %>

<!-- ﾛｸﾞｲﾝ後の新しいｾｯｼｮﾝIDを取得する -->
<% String newSessionId = (String) session.getAttribute("newSessionId"); %>

<!-- POSTの前に生成したﾄｰｸﾝ -->
<% String csrfToken = (String) session.getAttribute("csrfToken"); %>
<!-- （ﾌｫｰﾑから）POST時に送ったﾄｰｸﾝ -->
<% String formToken = (String) session.getAttribute("formToken"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>演習２</title>
</head>
<body>
	<h2>演習02</h2>
	<h5>ログイン機能とログアウト機能<br> （セッション情報を利用すること）</h5>
	<p>
		ログイン前の セッションIDは　 <%= oldSessionId %><br>
		ログイン後の セッションIDは　 <%= newSessionId %><br>
		POST前の　　csrfトークンは　 <%= csrfToken %><br>
		フォームからの　 トークンは　 <%= formToken %>
	</p>
	
<p>ログアウトしました</p>
<a href="Index">トップへ</a>
</body>
</html>