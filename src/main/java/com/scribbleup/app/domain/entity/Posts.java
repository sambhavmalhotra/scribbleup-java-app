package com.scribbleup.app.domain.entity;

import com.scribbleup.app.common.util.PostContentType;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sambhavmalhotra.
 * This entity is to save Posts by users
 */

@Entity
@Table(name = "POSTS")
public class Posts {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private PostContentType postContentType;

    @Column(name = "heading", columnDefinition="varchar(1000)")
    private String heading;

    @Column(name = "description", columnDefinition="varchar(10000)")
    private String description;

    @Column(name = "content", columnDefinition="longblob")
    private byte[] content;

    @Column(name = "format")
    private String format;

    @Column(name = "fileName", columnDefinition="varchar(1000)")
    private String fileName;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserDetails userDetails;

    @CreationTimestamp
    @Column(name = "created_time")
    private Date createdTime;

    @Transient
    private String time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PostContentType getPostContentType() {
        return postContentType;
    }

    public void setPostContentType(PostContentType postContentType) {
        this.postContentType = postContentType;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
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

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
