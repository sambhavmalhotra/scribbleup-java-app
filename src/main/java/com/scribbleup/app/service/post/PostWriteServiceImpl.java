package com.scribbleup.app.service.post;

import com.scribbleup.app.common.util.PostContentType;
import com.scribbleup.app.common.vo.CreatePostRequest;
import com.scribbleup.app.domain.entity.Posts;
import com.scribbleup.app.domain.entity.UserDetails;
import com.scribbleup.app.domain.repository.PostsDAORepository;
import com.scribbleup.app.domain.repository.UserDetailsDAORepository;
import com.scribbleup.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Created by sambhavmalhotra.
 * This implementation has business logic for write operations of Posts
 */

@Component
public class PostWriteServiceImpl implements PostWriteService {

    @Autowired
    private PostsDAORepository postsDAORepository;

    @Autowired
    private UserDetailsDAORepository userDetailsDAORepository;

    @Override
    public void createPost(CreatePostRequest createPostRequest) {
        validateCreatePostRequest(createPostRequest);
        //check if user exists
        UserDetails userDetails = userDetailsDAORepository.findByEmail(createPostRequest.getEmail());
        if(userDetails == null) {
            throw new BusinessException("User not found. Sign up to continue.");
        }
        Posts posts = new Posts();
        posts.setUserDetails(userDetails);
        posts.setHeading(createPostRequest.getHeading());
        if(createPostRequest.getPostContentType().equals(PostContentType.IMAGE)) {
            //if post is image file
            posts.setPostContentType(PostContentType.IMAGE);
            posts.setContent(createPostRequest.getContent());
            posts.setFileName(createPostRequest.getFileName());
            posts.setFormat(createPostRequest.getFormat());
        } else {
            //if post is text
            posts.setPostContentType(PostContentType.TEXT);
            posts.setDescription(createPostRequest.getDescription());
        }
        posts.setDescription(createPostRequest.getDescription());
        postsDAORepository.save(posts);
    }

    private void validateCreatePostRequest(CreatePostRequest createPostRequest) {
        try {
            Assert.notNull(createPostRequest.getEmail(), "User not specified. Try logging back in.");
            Assert.notNull(createPostRequest.getHeading(), "Give your post a heading");
            Assert.notNull(createPostRequest.getPostContentType(), "Post details could not be recognized. Try again.");
            if(createPostRequest.getPostContentType().equals(PostContentType.IMAGE)) {
                Assert.notNull(createPostRequest.getContent(), "Select image for your post");
                Assert.notNull(createPostRequest.getFileName(), "Something went wrong. Try uploading file again.");
                Assert.notNull(createPostRequest.getFormat(), "Something went wrong. Try uploading file again.");
            } else {
                Assert.notNull(createPostRequest.getDescription(), "Give your post a description");
            }
        } catch(IllegalArgumentException e) {
            throw new BusinessException(e.getMessage());
        }
    }
}
