package com.scribbleup.app.common.vo;

import com.scribbleup.app.common.util.PostContentType;

/**
 * Created by sambhavmalhotra.
 * The VO is used to for creating a new post
 */
public class CreatePostRequest {
    private String email;
    private String heading;
    private PostContentType postContentType;
    private String description;
    private byte[] content;
    private String format;
    private String fileName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public PostContentType getPostContentType() {
        return postContentType;
    }

    public void setPostContentType(PostContentType postContentType) {
        this.postContentType = postContentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
