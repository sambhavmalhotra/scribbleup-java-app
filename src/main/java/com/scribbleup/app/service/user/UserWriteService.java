package com.scribbleup.app.service.user;

import com.scribbleup.app.common.vo.UserDetailsRequest;

/**
 * Created by sambhavmalhotra.
 * Service interface for write operations on Users
 */

public interface UserWriteService {
    void registerUser(UserDetailsRequest userDetailsRequest);
}
