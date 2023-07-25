package com.javacode.Goods1_5.Exception;

public class InvalidInputException extends Exception{
    //输入不合法
    public InvalidInputException(String message){
        super(message);
    }
}
