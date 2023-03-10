package com.demo.demo.entities;

import java.util.ArrayList;

public class ResponseEntity {
    
    String statusCode;

    String message;

     ArrayList<Object>list=new ArrayList<Object>();
    
    public ResponseEntity() {
    }

    public ResponseEntity(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Object> getList() {
        return list;
    }

    public void setList(ArrayList<Object> list) {
        this.list = list;
    }
    
}
