<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User"%>

<!-- 新しいｾｯｼｮﾝｽｺｰﾌﾟに保存されているﾕｰｻﾞ情報ﾃﾞｰﾀ（Userｲﾝｽﾀﾝｽ）を取得
Objectｸﾗｽの型で戻ってくるのでUserｸﾗｽの型に(ｷｬｽﾄ)する -->
<!-- newLoginUser="newLoginUser" =oldUser =『loginUser』 -->
<%
User newLoginUser = (User) session.getAttribute("newLoginUser");
%>
<!-- ﾛｸﾞｲﾝ前のｾｯｼｮﾝIDを取得する -->
<%
String oldSessionId = (String) session.getAttribute("oldSessionId");
%>
<!-- ﾛｸﾞｲﾝ後の新しいｾｯｼｮﾝIDを取得する -->
<!-- ﾛｸﾞｲﾝ後の新しいｾｯｼｮﾝIDを新しいｾｯｼｮﾝｽｺｰﾌﾟに属性名"newSessionId"で保存する  -->
<%
String newSessionId = session.getId();
%>
<%
session.setAttribute("newSessionId", newSessionId);
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


	<!-- newLoginUser="newLoginUser" =oldUser =『loginUser』
	『newLoginUser』がｾｯｼｮﾝｽｺｰﾌﾟに存在しているならば認証済みの証 -->
	<%
	if (newLoginUser != null) {
	%>
	<p>ログインしました</p>
	<p>
		ようこそ<%=newLoginUser.getName()%>さん
	</p>
	<a href="Main">メイン画面へ</a>

	<%
	} else if (newLoginUser == null) {
	%>
	<p>ログインに失敗しました</p>
	<a href="Index">TOPへ</a>
	<%
	}
	%>
</body>
</html>