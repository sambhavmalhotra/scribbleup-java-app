package com.scribbleup.app.controller.user;

import com.scribbleup.app.common.vo.UserDetailsRequest;
import com.scribbleup.app.service.user.UserWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by sambhavmalhotra.
 * This controller is for performing user related write operations
 */

@RestController
@RequestMapping(value = "/userWrites", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserWriteController {

    @Autowired
    private UserWriteService userServiceWrite;

    //creating a new user as sign up
    @PostMapping(value = "/registerUser")
    @CrossOrigin
    public void registerUser(@Valid @RequestBody UserDetailsRequest userDetailsRequest) throws Exception {
        userServiceWrite.registerUser(userDetailsRequest);
    }
}
