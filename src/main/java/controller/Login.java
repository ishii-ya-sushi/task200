package controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*tokenを生成する。フォーム画面に遷移する度に新たにtokenを生成することが望ましい*/
		String token = UUID.randomUUID().toString();

		/*ﾘｸｴｽﾄｽｺｰﾌﾟにtokenを"csrfToken"の属性名で保存する*/
		request.getSession().setAttribute("csrfToken", token);
		/*ｾｯｼｮﾝｽｺｰﾌﾟにtokenを"csrfToken"の属性名で保存する*/
	    HttpSession session = request.getSession();
		session.setAttribute("csrfToken", token);
		
		/*ログイン入力画面】にフォワードする*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/login.jsp");
		dispatcher.forward(request, response);
	}

}
