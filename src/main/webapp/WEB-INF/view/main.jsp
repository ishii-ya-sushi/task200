<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="model.User"%>
<%
// 新しいｾｯｼｮﾝｽｺｰﾌﾟに保存されている入力されたﾕｰｻﾞ情報ﾃﾞｰﾀ（Userｲﾝｽﾀﾝｽ）を取得
// Objectｸﾗｽの型で戻ってくるのでUserｸﾗｽの型に(ｷｬｽﾄ)する 
User newLoginUser = (User) session.getAttribute("newLoginUser");
%>

<!-- ﾛｸﾞｲﾝ前のｾｯｼｮﾝIDを取得する -->
<% String oldSessionId = (String) session.getAttribute("oldSessionId"); %>
<!-- ﾛｸﾞｲﾝ後の新しいｾｯｼｮﾝIDを取得する -->
<% String newSessionId = (String) session.getAttribute("newSessionId"); %>

<!-- POSTの前に生成したﾄｰｸﾝ -->
<% String csrfToken = (String) session.getAttribute("csrfToken"); %>
<!-- （ﾌｫｰﾑから）POST時に送ったﾄｰｸﾝ -->
<% String formToken = (String) session.getAttribute("formToken"); %>
<%
// セッションスコープに保存されたユーザー情報（ﾕｰｻﾞｸﾗｽのｲﾝｽﾀﾝｽ）を取得
%>
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
	<p>
		<%=newLoginUser.getName()%>さん、ログイン中<br>
		<a href="Logout">ログアウトする</a>
	</p>
</body>
</html>