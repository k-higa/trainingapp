package dev.trainingapp.other.exception;

import org.aspectj.apache.bcel.classfile.annotation.RuntimeTypeAnnos;

public class TrainingAppException extends RuntimeException {

    public TrainingAppException() {
        super();
    }

    public TrainingAppException(String message) {
        super(message);
    }
}
