package com.scribbleup.app.domain.repository;

import com.scribbleup.app.domain.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sambhavmalhotra.
 * This DAO for UserDetails entity
 */

public interface UserDetailsDAORepository extends JpaRepository<UserDetails, Long> {
    UserDetails findByEmail(String email);

    int countByEmail(String email);
}
