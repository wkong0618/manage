package com.wk.manage.idgen.biz.snowflake.exception;

public class CheckLastTimeException extends RuntimeException {
    public CheckLastTimeException(String msg){
        super(msg);
    }
}
