package model;

public class Validation_Pass {
	
		public boolean validateInput(String input) {
		    String regex = "^[0-9]{4}$"; // 正規表現パターン
		    return input.matches(regex); // 『regex』は正規表現の意
		}

}