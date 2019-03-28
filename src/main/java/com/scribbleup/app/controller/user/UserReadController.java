package com.scribbleup.app.controller.user;


import com.scribbleup.app.common.vo.UserDetailsRequest;
import com.scribbleup.app.common.vo.UserDetailsResponse;
import com.scribbleup.app.service.user.UserReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by sambhavmalhotra.
 * This controller is for performing user related read operations
 */

@RestController
@RequestMapping(value = "/userReads", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserReadController {

    @Autowired
    private UserReadService userReadService;

    //authorize the login of an existing user
    @PostMapping(value = "/authorizeLogin")
    @CrossOrigin
    public UserDetailsResponse authorizeLogin(@Valid @RequestBody UserDetailsRequest loginRequest) throws Exception {
        return userReadService.authorizeLogin(loginRequest);
    }
}
