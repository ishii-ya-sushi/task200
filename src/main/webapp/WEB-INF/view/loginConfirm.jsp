<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User"%>


<!-- ｾｯｼｮﾝｽｺｰﾌﾟから入力ﾃﾞｰﾀ（Userｲﾝｽﾀﾝｽ）を取得
Objectｸﾗｽの型で戻ってくるのでUserｸﾗｽの型に(ｷｬｽﾄ)する  -->
<%
User loginUser = (User) session.getAttribute("loginUser");
%>
<!-- 現在の（ﾛｸﾞｲﾝ前の）ｾｯｼｮﾝIDを取得する -->
<%
String oldSessionId = (String) session.getAttribute("oldSessionId");
%>
<!-- ﾛｸﾞｲﾝ後の新しいｾｯｼｮﾝIDを取得する -->
<%
String newSessionId = (String) session.getAttribute("newSessionId");
%>
<!-- POSTの前に生成したﾄｰｸﾝ -->
<%
String csrfToken = (String) session.getAttribute("csrfToken");
%>
<!-- （ﾌｫｰﾑから）POST時に送ったﾄｰｸﾝ -->
<%
String formToken = (String) session.getAttribute("formToken");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>演習２</title>
</head>
<body>
	<h2>演習02</h2>
	<h5>
		ログイン機能とログアウト機能<br> （セッション情報を利用すること）
	</h5>
	<p>
		ログイン前の セッションIDは　 <%= oldSessionId %><br>
		ログイン後の セッションIDは　 <%= newSessionId %><br>
		POST前の　　csrfトークンは　 <%= csrfToken %><br>
		フォームからの　 トークンは　 <%= formToken %>
	</p>

	<!-- 『loginUser』（認証を確認した入力ﾃﾞｰﾀ（Userｲﾝｽﾀﾝｽ））がｾｯｼｮﾝｽｺｰﾌﾟに存在する -->
	<%
	if (loginUser != null) {
	%>
	<p>
		<%=loginUser.getName()%>さん ユーザー認証を確認しました。ログイン可能です
	</p>
	<a href="LoginDone">ログインします</a>
	
	<!-- 認証を確認した入力ﾃﾞｰﾀ（Userｲﾝｽﾀﾝｽ）がｾｯｼｮﾝｽｺｰﾌﾟに存在しない -->
	<%
	} else if (loginUser == null) {
	%>
	<p>ログインに失敗しました</p>
	<a href="Index">TOPへ戻る</a>
	<%
	}
	%>
</body>
</html>