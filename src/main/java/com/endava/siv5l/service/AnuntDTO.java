package com.endava.siv5l.service;

import com.endava.siv5l.model.User;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by siv5l on 6/9/16.
 */
public class AnuntDTO implements Serializable {
    public String subject;
    public String description;
    public Date posted_date;
    public String postedBy;
    public String username;

    public AnuntDTO(){}

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPosted_date() {
        return posted_date;
    }

    public void setPosted_date(Date posted_date) {
        this.posted_date = posted_date;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
