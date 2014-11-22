package mta.exceptions;

public class InputException extends Exception {

	public InputException(String input, String errorMessage) {
        super("Input Format exception on \"" + input + "\" : " + errorMessage);
    }
}
