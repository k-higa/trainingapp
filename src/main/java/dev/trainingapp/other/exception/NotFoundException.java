package dev.trainingapp.other.exception;

public class NotFoundException extends TrainingAppException {
    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }
}
