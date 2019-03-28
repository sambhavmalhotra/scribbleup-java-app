package com.scribbleup.app.service.user;

import com.scribbleup.app.common.vo.UserDetailsRequest;
import com.scribbleup.app.common.vo.UserDetailsResponse;
import com.scribbleup.app.domain.entity.UserDetails;
import com.scribbleup.app.domain.repository.UserDetailsDAORepository;
import com.scribbleup.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sambhavmalhotra.
 * This implementation has business logic for read operations of users(UserDetails)
 */

@Component
public class UserServiceReadImpl implements UserReadService {

    @Autowired
    private UserDetailsDAORepository userDetailsDAORepository;

    @Override
    public UserDetailsResponse authorizeLogin(UserDetailsRequest userDetailsRequest) {
        validateAuthorizeLoginRequest(userDetailsRequest);
        UserDetailsResponse userDetailsResponse = new UserDetailsResponse();
        UserDetails userDetails = userDetailsDAORepository.findByEmail(userDetailsRequest.getEmail());
        //check if user exists
        if(userDetails == null) {
            throw new BusinessException("User not found. Sign up to continue");
        }
        if(userDetails.getPassword().equals(userDetailsRequest.getPassword())) {
            //verify password
            userDetailsResponse.setName(userDetails.getName());
            userDetailsResponse.setEmail(userDetails.getEmail());
            userDetailsResponse.setUserType(userDetails.getUserType());
        } else {
            throw new BusinessException("Your password is incorrect");
        }
        return userDetailsResponse;
    }

    private void validateAuthorizeLoginRequest(UserDetailsRequest userDetailsRequest) {
        try {
            Assert.notNull(userDetailsRequest.getEmail(), "Please enter your email");
            Assert.notNull(userDetailsRequest.getPassword(), "Please enter your password");
        } catch(IllegalArgumentException e) {
            throw new BusinessException(e.getMessage());
        }
    }
}
