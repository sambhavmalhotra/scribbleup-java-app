package com.scribbleup.app.domain.repository;

import com.scribbleup.app.domain.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by sambhavmalhotra.
 * This is DAO for Posts entity
 */

public interface PostsDAORepository extends JpaRepository<Posts, Long> {
    List<Posts> findByUserDetailsIdOrderByCreatedTimeDesc(Long userId);
}
