package com.scribbleup.app.common.vo;

import com.scribbleup.app.common.util.UserType;

/**
 * Created by sambhavmalhotra.
 * This VO sends back details of the authorized user
 */
public class UserDetailsResponse {
    private String name;
    private String email;
    private UserType userType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() { return userType; }

    public void setUserType(UserType userType) { this.userType = userType; }
}
