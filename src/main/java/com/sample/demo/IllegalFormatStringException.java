package com.sample.demo;

public class IllegalFormatStringException extends Exception{

    private String message;

    public IllegalFormatStringException(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return message;
    }
}
