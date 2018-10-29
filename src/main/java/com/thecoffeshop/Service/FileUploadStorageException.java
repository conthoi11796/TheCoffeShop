package com.thecoffeshop.Service;

public class FileUploadStorageException extends RuntimeException {

	public FileUploadStorageException(String message) {
        super(message);
    }

	public FileUploadStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
