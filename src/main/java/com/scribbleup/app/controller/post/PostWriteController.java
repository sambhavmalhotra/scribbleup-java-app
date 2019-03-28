package com.scribbleup.app.controller.post;


import com.scribbleup.app.common.vo.CreatePostRequest;
import com.scribbleup.app.service.post.PostWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by sambhavmalhotra.
 * This controller is for performing write operations for Posts
 */

@RestController
@RequestMapping(value = "/postWrites", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostWriteController {

    @Autowired
    private PostWriteService postWriteService;

    //create a new post for the logged in user
    @PostMapping(value = "/createPost")
    @CrossOrigin
    public void createPost(@Valid @RequestBody CreatePostRequest createPostRequest) throws Exception {
        postWriteService.createPost(createPostRequest);
    }
}
