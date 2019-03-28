package com.scribbleup.app.service.post;

import com.scribbleup.app.common.vo.ReadPostRequest;
import com.scribbleup.app.domain.entity.Posts;
import com.scribbleup.app.domain.entity.UserDetails;
import com.scribbleup.app.domain.repository.PostsDAORepository;
import com.scribbleup.app.domain.repository.UserDetailsDAORepository;
import com.scribbleup.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sambhavmalhotra.
 * This implementation has business logic for read operations of Posts
 */

@Component
public class PostServiceReadImpl implements PostReadService {

    @Autowired
    private UserDetailsDAORepository userDetailsDAORepository;

    @Autowired
    private PostsDAORepository postsDAORepository;

    @Override
    public List<Posts> findPostsByUser(ReadPostRequest readPostRequest) {
        validateReadPostsRequest(readPostRequest);
        UserDetails userDetails = userDetailsDAORepository.findByEmail(readPostRequest.getEmail());
        if(userDetails == null) {
            throw new BusinessException("User not found. Sign up to continue.");
        }
        List<Posts> postsList = postsDAORepository.findByUserDetailsIdOrderByCreatedTimeDesc(userDetails.getId());
        if(postsList.isEmpty()) {
            //if no posts are found, return empty array
            return new ArrayList<>();
        } else {
            //if posts are found
            for(Posts posts : postsList) {
                //find time difference between current and the post created time
                posts.setTime(getTimeDiff(posts.getCreatedTime()));
            }
            return postsList;
        }
    }

    private String getTimeDiff(Date postTime){
        //find time difference of created from current and
        // format in a presentable string format: "0d, 0h, 0m, 0s age"
        Date currentDate = new Date();

        //get time difference and find days, hrs, mins and secs diff
        long diff = currentDate.getTime() - postTime.getTime();
        long secs = diff / 1000 % 60;
        long mins = diff / (60 * 1000) % 60;
        long hrs = diff / (60 * 60 * 1000);
        int days = (int) ((currentDate.getTime() - postTime.getTime()) / (1000 * 60 * 60 * 24));

        String time = "";
        if(days > 0) {
            time += (days + "d");
        }
        if(hrs > 0) {
            if(!time.equals("")) {
                time += (", " + hrs + "h");
            } else {
                time += (hrs + "h");
            }
        }
        if(mins > 0) {
            if(!time.equals("")) {
                time += (", " + mins + "m");
            } else {
                time += (mins + "m");
            }
        }
        if(secs >= 0) {
            if(!time.equals("")) {
                time += (", " + secs + "s");
            } else {
                time += (secs + "s");
            }
        }
        time += " ago";
        return time;
    }

    private void validateReadPostsRequest(ReadPostRequest readPostRequest) {
        try {
            Assert.notNull(readPostRequest.getEmail(), "User not specified. Try logging back in.");
        } catch(IllegalArgumentException e) {
            throw new BusinessException(e.getMessage());
        }
    }
}
