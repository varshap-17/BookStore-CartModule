package com.example.cartmodule.dto;

public class ResponseDto {
    private String message;
    private Object data;

    public ResponseDto(String message,Object data) {
        this.data = data;
        this.message=message;
    }
}
