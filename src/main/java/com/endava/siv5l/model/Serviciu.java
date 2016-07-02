package com.endava.siv5l.model;

import com.endava.siv5l.service.ServiciuService;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by siv5l on 6/4/16.
 */
@Entity
public class Serviciu  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "serviciu_id")
    private long serviciuId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Assigned_Users",
            joinColumns =  {@JoinColumn(name = "serviciu_id")},
            inverseJoinColumns = {@JoinColumn(name = "anunt_id")})
    private Set<Announcement> assignedUsersToAnnouncement = new HashSet<Announcement>();

    @Column(name = "user_id")
    private Long user_id;

    public Serviciu(){}

    public Serviciu(Set<Announcement> assignedUsersToAnnouncement, Long user_id) {
        this.assignedUsersToAnnouncement = assignedUsersToAnnouncement;
        this.user_id = user_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public long getServiciuId() {
        return serviciuId;
    }

    public void setServiciuId(long serviciuId) {
        this.serviciuId = serviciuId;
    }

    public Set<Announcement> getAssignedUsersToAnnouncement() {
        return assignedUsersToAnnouncement;
    }

    public void setAssignedUsersToAnnouncement(Set<Announcement> assignedUsersToAnnouncement) {
        this.assignedUsersToAnnouncement = assignedUsersToAnnouncement;
    }
}
