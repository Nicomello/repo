package PASWORD;

public class UnmatchedException extends RuntimeException {

	public UnmatchedException() {
		super("password does not match.");
	}

	public UnmatchedException (String message) {
		super(message);
	}
}
