package ru.skypro.exam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotEnoughServiceQuestionsException extends RuntimeException {

    public NotEnoughServiceQuestionsException(String message) {
        super(message);
    }
}