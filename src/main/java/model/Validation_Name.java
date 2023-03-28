package model;

public class Validation_Name {
	
		public boolean validateInput(String input) {
		    String regex = "^[YA][A-Za-z0-9]{4,6}$"; // 正規表現パターン
		    return input.matches(regex); // 『regex』は正規表現の意
		}

}