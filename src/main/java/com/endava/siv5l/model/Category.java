package com.endava.siv5l.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by siv5l on 4/11/16.
 */
@Entity
@Table(name="Category")
public class Category  {
    @Id
    @Column(name="category_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long categoryId;
    @Column(name="name")
    private String name;
    @Column(name="descriere")
    private String descriere;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "User_Category",
            joinColumns = {@JoinColumn(name = "category_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> categoryUsers = new HashSet<User>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="Announcement_Category_T",
            joinColumns = {@JoinColumn(name="category_id")},
            inverseJoinColumns = {@JoinColumn(name="announcement_id")})
    private Set<Announcement> announcementList = new HashSet<Announcement>();


    public Category(){}

    public Category(String name, String descriere, Set<User> categoryUsers, Set<Announcement> announcementList) {
        this.name = name;
        this.descriere = descriere;
        this.categoryUsers = categoryUsers;
        this.announcementList = announcementList;
    }

    public Set<Announcement> getAnnouncementList() {
        return announcementList;
    }

    public void setAnnouncementList(Set<Announcement> announcementList) {
        this.announcementList = announcementList;
    }

    public Set<User> getCategoryUsers() {
        return categoryUsers;
    }

    public void setCategoryUsers(Set<User> categoryUsers) {
        this.categoryUsers = categoryUsers;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
