package edu.epam.taskoop.exception;

public class FileReaderException extends Exception {
    public FileReaderException() {
    }

    public FileReaderException(String message) {
        super(message);
    }

    public FileReaderException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public FileReaderException(Throwable throwable) {
        super(throwable);
    }
}