package model;

public class Token_check {

	public boolean tokenInput(String csrfToken, String formToken) {

		if (csrfToken == null || formToken == null || !csrfToken.equals(formToken)) {
			// CSRFトークンが一致しない場合は、エラーを返す
			return false;
		} else {
			// CSRFﾄｰｸﾝが一致したので、ﾊﾞﾘﾃﾞｰｼｮﾝ処理に移行する
			return true;
		}
	}
}