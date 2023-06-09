package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/EndSessionServlet")
public class EndSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// session.invalidate()ﾒｿｯﾄﾞによりｾｯｼｮﾝｵﾌﾞｼﾞｪｸﾄ（とｾｯｼｮﾝに関連付けられたすべての属性）を破棄する
		// session.invalidate()ﾒｿｯﾄﾞによりｾｯｼｮﾝを終了する場合には、request.getSession(false)ﾒｿｯﾄﾞでｾｯｼｮﾝｵﾌﾞｼﾞｪｸﾄを取得するのが一般的。
		HttpSession session = request.getSession(false);
	      if(session != null){
	         session.invalidate();
	      }

		   // index.jspにフォワード
	      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/index.jsp");
	      dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
