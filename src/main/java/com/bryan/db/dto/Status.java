package com.bryan.db.dto;

public enum Status {

    PENDING("pending"),
    PROCESS("process"),
    COMPLETED("completed");

    private String value;

    private Status(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
