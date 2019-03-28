package com.scribbleup.app.common.vo;

/**
 * Created by sambhavmalhotra.
 * This VO is for finding posts for a particular user
 */
public class ReadPostRequest {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
