package com.scribbleup.app.service.post;

import com.scribbleup.app.common.vo.ReadPostRequest;
import com.scribbleup.app.domain.entity.Posts;

import java.util.List;

/**
 * Created by sambhavmalhotra.
 * Service interface for read operations on Posts
 */

public interface PostReadService {
    List<Posts> findPostsByUser(ReadPostRequest readPostRequest);
}
