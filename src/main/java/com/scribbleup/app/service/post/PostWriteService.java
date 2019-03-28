package com.scribbleup.app.service.post;

import com.scribbleup.app.common.vo.CreatePostRequest;

/**
 * Created by sambhavmalhotra.
 * Service interface for write operations on Posts
 */

public interface PostWriteService {
    void createPost(CreatePostRequest createPostRequest);
}
