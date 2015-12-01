package com.sefra;

/**
 * Exception for serializer
 *
 * @author Krzysztof Korolczuk <krzysztofkorolczuk2@gmail.com>
 */
public class SefraException extends Exception {

    private String message = null;

    public SefraException() {
        super();
    }

    public SefraException(String message) {
        super(message);
        this.message = message;
    }

    public SefraException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
