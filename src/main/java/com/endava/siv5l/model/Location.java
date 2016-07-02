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
@Table(name="Location")
public class Location {

    @Id
    @Column(name="location_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long locationId;

    @Column(name="name")
    private String name;

    @Column(name="zip_code")
    private int zipCode;

    public Set<User> getLocationUsers() {
        return locationUsers;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "User_Location",
            joinColumns = {@JoinColumn(name = "location_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> locationUsers = new HashSet<User>(); // aici era list

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="Announcement_Location_T",
            joinColumns = {@JoinColumn(name="location_id")},
            inverseJoinColumns = {@JoinColumn(name="announcement_id")})
    private Set<Announcement> announcementList = new HashSet<Announcement>();  // aici era list


    public Location(){
    }

    public Location(String name, int zipCode, Set<User> locationUsers, Set<Announcement> announcementList) {
        this.name = name;
        this.zipCode = zipCode;
        this.locationUsers = locationUsers;
        this.announcementList = announcementList;
    }

    public Set<Announcement> getAnnouncementList() {
        return announcementList;
    }

    public void setAnnouncementList(Set<Announcement> announcementList) {
        this.announcementList = announcementList;
    }

    public void setLocationUsers(Set<User> locationUsers) {
        this.locationUsers = locationUsers;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
