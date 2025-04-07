package org.petstore.automation.exceptions;

public class NotImplementedException extends RuntimeException {
    public NotImplementedException() {
        this("Called functionality is not implemented");
    }

    public NotImplementedException(String message) {
        super(message);
    }
}
