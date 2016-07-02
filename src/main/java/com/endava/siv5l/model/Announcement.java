package com.endava.siv5l.model;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by siv5l on 4/11/16.
 */
@Entity
@Table(name = "Announcement")
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "announcement_id")
    private long announcementId;

    @Column(name = "subject")
    private String subject;

    @Column(name = "description")
    private String description;

    @Column(name = "posted_date", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "user_assigned")
    private long user_asigned;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")  // un anunt are un utilizator
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="Announcement_Location_T",
            joinColumns = {@JoinColumn(name="announcement_id")},
            inverseJoinColumns = {@JoinColumn(name="location_id")})
    private Set<Location> locationList = new HashSet<Location>();  // aici am schimbat set

    @Transient
    private List<String> locations = new ArrayList<String>();

    @ManyToMany(fetch=FetchType.EAGER )
    @JoinTable(name="Announcement_Category_T",
            joinColumns = {@JoinColumn(name="announcement_id")},
            inverseJoinColumns = {@JoinColumn(name="category_id")})
    private Set<Category> categoryList = new HashSet<Category>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "User_Notifications",
            joinColumns =  {@JoinColumn(name = "anunt_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> userNotifications = new HashSet<User>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Assigned_Users",
               joinColumns = {@JoinColumn(name = "anunt_id")},
                inverseJoinColumns = {@JoinColumn(name = "serviciu_id")} )
    private Set<Serviciu> announcementsAssignedToUsers = new HashSet<Serviciu>();


    @Transient
    private List<String> categories = new ArrayList<String>();

    public Announcement(){}

    public Announcement(String subject, String description, Date date, User user, long user_asigned, Set<Location> locationList,
                        List<String> locations, Set<Category> categoryList, Set<Serviciu> announcementsAssignedToUsers,
                        Set<User> userNotifications, List<String> categories) {
        this.subject = subject;
        this.description = description;
        this.date = date;
        this.user = user;
        this.user_asigned = user_asigned;
        this.locationList = locationList;
        this.locations = locations;
        this.categoryList = categoryList;
        this.announcementsAssignedToUsers = announcementsAssignedToUsers;
        this.userNotifications = userNotifications;
        this.categories = categories;
    }

    public long getUser_asigned() {
        return user_asigned;
    }

    public void setUser_asigned(long user_asigned) {
        this.user_asigned = user_asigned;
    }

    public Set<Serviciu> getAnnouncementsAssignedToUsers() {
        return announcementsAssignedToUsers;
    }

    public void setAnnouncementsAssignedToUsers(Set<Serviciu> announcementsAssignedToUsers) {
        this.announcementsAssignedToUsers = announcementsAssignedToUsers;
    }

    public Set<User> getUserNotifications() {
        return userNotifications;
    }

    public void setUserNotifications(Set<User> userNotifications) {
        this.userNotifications = userNotifications;
    }

    public Set<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(Set<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public Set<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(Set<Location> locationList) {
        this.locationList = locationList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(long announcementId) {
        this.announcementId = announcementId;
    }

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

}
