package com.tiff.tffnserachservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class TiffnNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(TiffnNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String tiffnNotFound(TiffnNotFoundException tiff){
        log.error("Exception {} thrown", tiff.getMessage() );
        return tiff.getMessage();
    }

}
