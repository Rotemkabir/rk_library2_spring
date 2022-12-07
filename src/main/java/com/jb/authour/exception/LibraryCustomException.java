package com.jb.authour.exception;

public class LibraryCustomException extends Exception{

    public LibraryCustomException(ErrMsg errMsg){
        super(errMsg.getMessage());
    }
}
