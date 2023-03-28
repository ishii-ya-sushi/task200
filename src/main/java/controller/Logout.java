package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ｾｯｼｮﾝｽｺｰﾌﾟの取得
		HttpSession newSession = request.getSession(false);
		if (newSession != null) {
			// invalidate()ﾒｿｯﾄﾞによりﾛｸﾞｲﾝ前のｾｯｼｮﾝｵﾌﾞｼﾞｪｸﾄ（とｾｯｼｮﾝに関連付けられたすべての属性）を破棄する
			newSession.invalidate(); // 現在のセッションを破棄する
		} else if (newSession == null) {
		}

		// ログアウト画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/logout.jsp");
		dispatcher.forward(request, response);
	}
}