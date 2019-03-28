package com.scribbleup.app.common.util;

/**
 * Created by sambhavmalhotra
 * Thsi file specifies the type of post
 */
public enum PostContentType {

    TEXT("TEXT"), IMAGE("IMAGE");

    private String status;

    public String getStatus() {
        return status;
    }

    PostContentType(String _status){
        this.status = _status;
    }

}