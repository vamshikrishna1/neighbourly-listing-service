package com.neighbourly.listing.exception;

import com.neighbourly.listing.dto.Error;
import com.neighbourly.listing.dto.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvisor {


    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<Response<Error>> handleItemNotFoundException(ItemNotFoundException e) {
        Error error = new Error();
        error.setErrorCode("404");
        error.setErrorMessage(e.getMessage());
        Response<Error> response = Response.<Error>builder().data(error).build();
        return ResponseEntity.badRequest().body(response);


    }

}
