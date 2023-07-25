package com.javacode.Goods1_5.Exception;

public class InvalidCredentialsException extends Exception{
    //无效凭据（域验证失败）
    public InvalidCredentialsException(String message){
        super(message);
    }
}
