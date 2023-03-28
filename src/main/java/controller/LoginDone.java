package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

@WebServlet("/LoginDone")
public class LoginDone extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*ログイン成功時（true）の処理*/

		/*（削除予定の）現在のｾｯｼｮﾝに保存されているものを一時引き揚げるために
		現在のｾｯｼｮﾝｵﾌﾞｼﾞｪｸﾄを取得	*/
		HttpSession oldSession = request.getSession(false);

		/*ｾｯｼｮﾝｽｺｰﾌﾟから『loginUser』（認証を確認した入力ﾃﾞｰﾀ（Userｲﾝｽﾀﾝｽ））を取得
		Objectｸﾗｽの型で戻ってくるのでUserｸﾗｽの型に(ｷｬｽﾄ)する*/
		User oldUser = (User) oldSession.getAttribute("loginUser");
		// ｾｯｼｮﾝｽｺｰﾌﾟからﾛｸﾞｲﾝ前のｾｯｼｮﾝIDを取得
		String oldSessionId = oldSession.getId();

		if (oldSession != null) {
			/*invalidate()ﾒｿｯﾄﾞによりﾛｸﾞｲﾝ前のｾｯｼｮﾝｵﾌﾞｼﾞｪｸﾄ（とｾｯｼｮﾝに関連付けられたすべての属性）を破棄する*/
			oldSession.invalidate(); // 現在のセッションを破棄する
			/*request.getSession(true)で新しいセッションを作成*/
			HttpSession newSession = request.getSession(true);

			/* oldUser =『loginUser』を新しいｾｯｼｮﾝｽｺｰﾌﾟに属性名"newLoginUser"で保存する*/
			newSession.setAttribute("newLoginUser", oldUser);
			/*ﾛｸﾞｲﾝ前のｾｯｼｮﾝIDを新しいｾｯｼｮﾝｽｺｰﾌﾟに属性名"oldSessionId"で保存する*/
			newSession.setAttribute("oldSessionId", oldSessionId);
		}
		/*ログイン失敗時（false）の処理*/
		else if (oldSession == null) {
			/*何もしない（間違っている入力ﾃﾞｰﾀ（Userｲﾝｽﾀﾝｽ）は保存しない）*/
		}

		// ログイン結果画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/loginResult.jsp");
		dispatcher.forward(request, response);
	}
}