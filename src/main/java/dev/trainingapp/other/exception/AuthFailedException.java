package dev.trainingapp.other.exception;

public class AuthFailedException extends TrainingAppException {
    public AuthFailedException() {
        super();
    }

    public AuthFailedException(String message) {
        super(message);
    }
}
