<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="model.User"%>

<%@ page import="java.util.*,java.io.*"%>
<%@ page import="javax.servlet.*,javax.servlet.http.*"%>

<!-- ﾛｸﾞｲﾝ後の新しいｾｯｼｮﾝｽｺｰﾌﾟから入力ﾃﾞｰﾀ（Userｲﾝｽﾀﾝｽ）を取得。Objectｸﾗｽの型で戻ってくるのでUserｸﾗｽの型に(ｷｬｽﾄ)する -->
<%-- <% User newLoginUser = (User) session.getAttribute("oldLoginUser"); %> --%>

<!-- 現在の（ﾛｸﾞｲﾝ前の）ｾｯｼｮﾝIDを取得する -->
<% String oldSessionId = (String) session.getAttribute("oldSessionId"); %>

<!-- ﾛｸﾞｲﾝ後の新しいｾｯｼｮﾝIDを取得する -->
<% String newSessionId = (String) session.getAttribute("newSessionId"); %>

<!-- POSTの前に生成したﾄｰｸﾝ -->
<% String csrfToken = (String) session.getAttribute("csrfToken"); %>
<!-- （ﾌｫｰﾑから）POST時に送ったﾄｰｸﾝ -->
<% String formToken = (String) session.getAttribute("formToken"); %>

<!DOCTYPE html>
<html>
<head>
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
	<br>
	<form action="Login_check" method="post">
		ユーザー名：<input type="text" name="name">（『YA』で始まる6-8文字の英数字  例：YAsushi）<br>
		パスワード：<input type="password" name="pass">（1234）<br>
		<!-- 『${csrfToken}』でｽｺｰﾌﾟからcsrfﾄｰｸﾝを取得し、フォームに追加 -->
		<input type="hidden" name="formToken" value="${csrfToken}" /> <input type="submit" value="ログイン">
	</form>

</body>
</html>