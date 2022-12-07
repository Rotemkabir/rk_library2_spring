package com.jb.authour.exception;

import lombok.Getter;

@Getter
public enum ErrMsg {

    ID_NOT_FOUND("id not found"),
    ID_ALREADY_EXIST("id already exist"),
    INVALID_DATE("year mast be grater than 0"),
    INVALID_DATE_RANGE("start date cannot end before end date");

    private String message;

    ErrMsg(String message) {
        this.message = message;
    }
}
