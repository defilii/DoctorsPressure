package main.exceptions;

public class InvalidAgeException extends Throwable {
    public InvalidAgeException() {
        super("Age is invalid");
    }
}
