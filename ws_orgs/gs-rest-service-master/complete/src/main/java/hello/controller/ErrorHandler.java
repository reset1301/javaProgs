package hello.controller;

import hello.view.ErrorWrapper;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    private String stackTrace;

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus
    public Object handlerException(Exception e) {
        return new ErrorWrapper(e.toString());
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public String getStackTrace() {
        return stackTrace;
    }
}
