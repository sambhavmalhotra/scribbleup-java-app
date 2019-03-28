package com.scribbleup.app.service.user;

import com.scribbleup.app.common.vo.UserDetailsRequest;
import com.scribbleup.app.domain.entity.UserDetails;
import com.scribbleup.app.domain.repository.UserDetailsDAORepository;
import com.scribbleup.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Created by sambhavmalhotra.
 * This implementation has business logic for write operations of users(UserDetails)
 */

@Component
public class UserWriteServiceImpl implements UserWriteService {

    @Autowired
    private UserDetailsDAORepository userDetailsDAORepository;

    public void registerUser(UserDetailsRequest userDetailsRequest) {
        validateRegisterUserRequest(userDetailsRequest);
        int count = userDetailsDAORepository.countByEmail(userDetailsRequest.getEmail());
        if(count > 0) {
            //if user already exists by same email id, throw exception
            throw new BusinessException("User already exists! Please login to continue.");
        }
        //else create new user
        UserDetails userDetails = new UserDetails();
        userDetails.setName(userDetailsRequest.getName());
        userDetails.setEmail(userDetailsRequest.getEmail());
        userDetails.setPassword(userDetailsRequest.getPassword());
        userDetails.setUserType(userDetailsRequest.getUserType());
        userDetailsDAORepository.save(userDetails);
    }

    private void validateRegisterUserRequest(UserDetailsRequest userDetailsRequest) {
        try {
            Assert.notNull(userDetailsRequest.getName(), "Please enter your name");
            Assert.notNull(userDetailsRequest.getEmail(), "Please enter your email");
            Assert.notNull(userDetailsRequest.getPassword(), "Please enter your password");
        } catch(IllegalArgumentException e) {
            throw new BusinessException(e.getMessage());
        }
    }
}
