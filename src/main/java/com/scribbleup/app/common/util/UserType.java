package com.scribbleup.app.common.util;

/**
 * Created by sambhavmalhotra
 * This file specifies the type of user
 */
public enum UserType {

    ADMIN("ADMIN"), USER("USER");

    private String status;

    public String getStatus() {
        return status;
    }

    UserType(String _status){
        this.status = _status;
    }

}