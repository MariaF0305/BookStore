package myapp;

public class NoCreditException extends Exception{
    public NoCreditException(String message) {
        super(message);
    }

}
