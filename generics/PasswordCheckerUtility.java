package application;
import java.util.ArrayList;
public class PasswordCheckerUtility
extends java.lang.Object {
	public PasswordCheckerUtility() {}
	
	public static void comparePasswords(java.lang.String password, java.lang.String passwordConfirm) throws UnmatchedException {
		try {
			boolean comp = password.equals(passwordConfirm);
			if (comp) {
			}
			else {
				throw new UnmatchedException("The passwords do not match");
			}
		}
		catch (UnmatchedException u) {
			u.getMessage();
		}
	}
	public static boolean comparePasswordsWithReturn(java.lang.String password, java.lang.String passwordConfirm) {
		return password.equals(passwordConfirm);
	}
	public static java.util.ArrayList<java.lang.String> getInvalidPasswords(java.util.ArrayList<java.lang.String> passwords) throws NoSpecialCharacterException, InvalidSequenceException, NoUpperAlphaException, NoDigitException, NoLowerAlphaException {
		ArrayList<String> invalid = new ArrayList<String>();
		for(int i = 0; i < passwords.size(); i++) {
			try {
				isValidPassword(passwords.get(i));
			} catch(Exception e) {
				invalid.add(passwords.get(i) + " " + e.getMessage());
			}
		}
		return invalid;
		/* Not done, need to add error message */
	}
	static boolean hasBetweenSixAndNineChars(java.lang.String password) {
		if(password.length() >= 6 && password.length() <= 9) {
			return true;
		}
		else {
			return false;
		}
	}
	static boolean hasDigit(java.lang.String password) throws NoDigitException{
		for(int i = 0; i < password.length(); i++) {	
		char c = password.charAt(i);
			if (Character.isDigit(c)) {
				return true;
			}
		}
		throw new NoDigitException("The password must contain at least one digit");
	}  
	static boolean hasLowerAlpha(java.lang.String password) throws NoLowerAlphaException {
		for(int i = 0; i < password.length(); i++) {	
		char c = password.charAt(i);
			if (Character.isLowerCase(c)) {
				return true;
			}
		}
		throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
	}
	
	static boolean hasUpperAlpha(java.lang.String password) throws NoUpperAlphaException {
		for(int i = 0; i < password.length(); i++) {	
		char c = password.charAt(i);
			if (Character.isUpperCase(c)) {
				return true;
			}
		}
		throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
	}
	
	static boolean hasSameCharInSequence(java.lang.String password) throws InvalidSequenceException {
		for(int i = 2; i < password.length(); i++) {
			if(password.charAt(i)  == password.charAt(i-1) && password.charAt(i)  == password.charAt(i-2)) {
				throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence");
			}
			//System.out.println(password.charAt(i-2) + " " + password.charAt(i-1) + " " + password.charAt(i));
		}
		return false;
		
	}
	
	static boolean hasSpecialChar(java.lang.String password) throws NoSpecialCharacterException {
		for(int i = 0; i < password.length(); i++) {	
			char c = password.charAt(i);
				if (!(Character.isUpperCase(c) || Character.isLowerCase(c)|| Character.isDigit(c))) {
					return true;
				}
			}
		throw new NoSpecialCharacterException("The password must contain at least one special character");
	}
	static boolean isValidLength(java.lang.String password) throws LengthException {
		if (password.length() >= 6) {
			return true;
		}
		else {
			throw new LengthException("The password must be at least 6 characters long");
		}
	}
	
	static boolean isValidPassword(java.lang.String password) throws NoSpecialCharacterException, InvalidSequenceException, NoUpperAlphaException, NoDigitException, NoLowerAlphaException, LengthException {
		boolean valid = false;
		//System.out.println(valid);
		valid = valid || isValidLength(password);
		//System.out.println(valid);
		valid = valid && hasUpperAlpha(password);
		//System.out.println(valid);
		valid = valid && hasLowerAlpha(password);
		//System.out.println(valid);
		valid = valid && hasDigit(password);
		//System.out.println(valid);
		valid = valid && hasSpecialChar(password);
		//System.out.println(valid);
		valid = valid && !hasSameCharInSequence(password);
		//System.out.println(valid);
		
			return valid;
	}
	public static boolean isWeakPassword(java.lang.String password) throws WeakPasswordException {
		if(hasBetweenSixAndNineChars(password)){
			throw new WeakPasswordException("The password is OK but weak - it contains fewer than 10 characters");
		}
		else {
			return false;
		}
	}
	
	
	public static void main(String[] args) throws NoSpecialCharacterException, InvalidSequenceException, NoUpperAlphaException, NoDigitException, NoLowerAlphaException, LengthException {
		//System.out.println("James12!" + isValidPassword("James12!"));
		//System.out.println("334455BB#  " + isValidPassword("334455BB#"));
		//System.out.println("a1A#b1Bc1Cd1D  " + isValidPassword("a1A#b1Bc1Cd1D"));
		//System.out.println("Im2cool4U#  " + isValidPassword("Im2cool4U#"));
		//System.out.println("george2ZZZ#  " + isValidPassword("george2ZZZ#"));
		//System.out.println("4Sale#  " + isValidPassword("4Sale#"));
		//System.out.println("bertha22  " + isValidPassword("bertha22"));
		//System.out.println("4wardMarch  #" + isValidPassword("4wardMarch#"));
		//System.out.println("ApplesxxYYzz  #" + isValidPassword("ApplesxxYYzz#"));
	}
	
}
