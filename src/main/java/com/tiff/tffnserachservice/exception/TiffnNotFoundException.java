package com.tiff.tffnserachservice.exception;

public class TiffnNotFoundException extends RuntimeException{
        public TiffnNotFoundException(Long id){
            super("Could  not find tiffn" + id);
        }
}
