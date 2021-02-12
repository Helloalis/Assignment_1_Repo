package application;

public class InvalidSequenceException extends Exception {
	InvalidSequenceException(String error) {
		super(error);
	}
}
