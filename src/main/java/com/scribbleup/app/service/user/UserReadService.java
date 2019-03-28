package com.scribbleup.app.service.user;

import com.scribbleup.app.common.vo.UserDetailsRequest;
import com.scribbleup.app.common.vo.UserDetailsResponse;

import java.util.List;

/**
 * Created by sambhavmalhotra.
 * Service interface for read operations on Users
 */

public interface UserReadService {
    UserDetailsResponse authorizeLogin(UserDetailsRequest loginRequest);
}
