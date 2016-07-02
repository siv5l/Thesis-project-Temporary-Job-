package com.endava.siv5l.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by siv5l on 4/3/16.
 */
@Entity
@Table(name = "User")
public class User implements Serializable {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String phone;
    @Column
    private String email;
    @Column(name = "date_of_birth",columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @ManyToMany(fetch = FetchType.EAGER) //aici era Lazy
    @JoinTable(name = "User_Location",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "location_id")})
    private Set<Location> userLocations = new HashSet<Location>();  // aici era list

    @Transient
    private List<String> locations = new ArrayList<String>();

    @ManyToMany(fetch = FetchType.EAGER)  //aici era Lazy
    @JoinTable(name = "User_Category",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private Set<Category> userCategories = new HashSet<Category>(); //aici era list

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "User_Notifications",
                joinColumns =  {@JoinColumn(name = "user_id")},
                inverseJoinColumns = {@JoinColumn(name = "anunt_id")})
    private Set<Announcement> userNotifications = new HashSet<Announcement>();

    @Transient
    private List<String> categories = new ArrayList<String>();

    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "user")
    @JoinColumn(name = "user_id")   //un user are multe anunturi
    private Set<Announcement> announcementsList = new HashSet<Announcement>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_role_id")
    private Role role;

    @Column(name = "enabled")
    private short enabled;

    public User(){}

    public User(String firstName, String lastName, String username, String password, String phone, String email,
                Date birthday, Set<Location> userLocations, List<String> locations, Set<Category> userCategories,
                Set<Announcement> userNotifications, List<String> categories,
                Set<Announcement> announcementsList, Role role, short enabled) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.userLocations = userLocations;
        this.locations = locations;
        this.userCategories = userCategories;
        this.userNotifications = userNotifications;
        this.categories = categories;
        this.announcementsList = announcementsList;
        this.role = role;
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return !(username != null ? !username.equals(user.username) : user.username != null);
    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Set<Location> getUserLocations() {
        return userLocations;
    }

    public void setUserLocations(Set<Location> userLocations) {
        this.userLocations = userLocations;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public Set<Category> getUserCategories() {
        return userCategories;
    }

    public void setUserCategories(Set<Category> userCategories) {
        this.userCategories = userCategories;
    }

    public Set<Announcement> getUserNotifications() {
        return userNotifications;
    }

    public void setUserNotifications(Set<Announcement> userNotifications) {
        this.userNotifications = userNotifications;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public Set<Announcement> getAnnouncementsList() {
        return announcementsList;
    }

    public void setAnnouncementsList(Set<Announcement> announcementsList) {
        this.announcementsList = announcementsList;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public short getEnabled() {
        return enabled;
    }

    public void setEnabled(short enabled) {
        this.enabled = enabled;
    }
}
