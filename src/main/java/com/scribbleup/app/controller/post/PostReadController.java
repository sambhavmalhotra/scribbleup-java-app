package com.scribbleup.app.controller.post;


import com.scribbleup.app.common.vo.ReadPostRequest;
import com.scribbleup.app.domain.entity.Posts;
import com.scribbleup.app.service.post.PostReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by sambhavmalhotra.
 * This controller is for read operations for Posts
 */

@RestController
@RequestMapping(value = "/postReads", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostReadController {

    @Autowired
    private PostReadService postReadService;

    //to find all the posts by a particular user
    @PostMapping(value = "/findPostsByUser")
    @CrossOrigin
    public List<Posts> findPostsByUser(@Valid @RequestBody ReadPostRequest readPostRequest) {
        return postReadService.findPostsByUser(readPostRequest);
    }
}
