package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.Token_check;
import model.User;
import model.Validation_Name;
import model.Validation_Pass;

@WebServlet("/Login_check")
public class Login_check extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*csrfトークンの確認*/
		HttpSession session = request.getSession();
		String csrfToken = (String) session.getAttribute("csrfToken");// （フォーム前）POSTの前に生成したﾄｰｸﾝ
		String formToken = request.getParameter("formToken");//  （フォームから）POST時に送ったﾄｰｸﾝ
		session.setAttribute("formToken", formToken);//  （フォームから）POST時に送ったﾄｰｸﾝをｾｯｼｮﾝｽｸｰﾌﾟに保存
		/*Token_checkのtokenInput()で2つのﾄｰｸﾝを渡す*/
		Token_check token_check = new Token_check();
		boolean isToken = token_check.tokenInput(csrfToken,formToken);
		if (!isToken) {
			/*入力が正しくない（2つのﾄｰｸﾝが一致しない）場合の処理*/
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return;
		} else {
			/*入力が正しい場合。"name"のﾊﾞﾘﾃﾞｰｼｮﾝに移行する*/
		}

		/*バリデーションの確認*/
		/*ﾘｸｴｽﾄﾊﾟﾗﾒｰﾀの取得*/
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		/*"name"をﾊﾞﾘﾃﾞｰｼｮﾝ*/
		Validation_Name validation_Name = new Validation_Name();
		boolean isName = validation_Name.validateInput(name);
		if (!isName) {
			/*入力が正しくない（"name"が正規表現に一致しない）場合の処理*/	
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return;
		} else {
			/*"name"が正規表現に一致した場合。"pass"のﾊﾞﾘﾃﾞｰｼｮﾝに移行する*/
		}
		
		/*("pass"をﾊﾞﾘﾃﾞｰｼｮﾝ*/
		Validation_Pass validation_Pass = new Validation_Pass();
		boolean isPass = validation_Pass.validateInput(pass);
		if (!isPass) {
			/*入力が正しくない（"pass"が正規表現に一致しない）場合の処理*/
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return;
		} else {
			// "pass"が正規表現に一致したので、認証処理に移行する
		}

		/*ユーザー認証を実施（"name"と"pass"の組み合わせが正しいか認証する（今回は簡易版なので"pass"のみ））*/

		/*Userクラス（beens）をｲﾝｽﾀﾝｽ化し、入力データ（"name"と"pass"）をセットする*/
		User user = new User(name, pass);

		/*LoginLogicクラス（beens）をｲﾝｽﾀﾝｽ化し、（入力ﾃﾞｰﾀの入った）Userｲﾝｽﾀﾝｽを引き渡して、一致するか確認する*/  
		LoginLogic loginLogic = new LoginLogic();
		boolean isLogin = loginLogic.execute(user);

		/*ログイン成功時（isLogin == true）の処理*/
		if (isLogin) {
			/*認証を確認した入力ﾃﾞｰﾀ（Userｲﾝｽﾀﾝｽ）をｾｯｼｮﾝｽｺｰﾌﾟに属性名"loginUser"で保存する*/
			/*ｾｯｼｮﾝｽｺｰﾌﾟに属性名"loginUser"でUserｸﾗｽの型の『user』が存在することが認証済み証*/
			session.setAttribute("loginUser", user);
	      }	      
			/*ログイン失敗時（isLogin == false）の処理*/   
		else {
			/*何もしない（間違っている入力ﾃﾞｰﾀ（Userｲﾝｽﾀﾝｽ）は保存しない）*/
		}
		/*ログイン確認画面にフォワード*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/loginConfirm.jsp");
		dispatcher.forward(request, response);
	}
}