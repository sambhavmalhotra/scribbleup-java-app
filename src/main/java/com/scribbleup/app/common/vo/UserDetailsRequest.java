package com.scribbleup.app.common.vo;

import com.scribbleup.app.common.util.UserType;

/**
 * Created by sambhavmalhotra.
 * This VO is used to authorize the user's login
 */
public class UserDetailsRequest {
    private String name;
    private String email;
    private String password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
