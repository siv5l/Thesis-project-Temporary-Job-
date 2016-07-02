package com.endava.siv5l.service;

import com.endava.siv5l.model.Announcement;

import java.util.List;

/**
 * Created by siv5l on 4/11/16.
 */
public interface AnnouncementService {
    public void add(Announcement announcement);
    public void edit(Announcement announcement);
    public void delete(int announcementId);
    public Announcement getAnnouncement(long announcementId);
    public List getAllAnnouncements();
    public List getAllMyAnnouncements(long id);
    public List getAnnouncementJoinCategoryLocation(String locatie, String categorie);
    public List getAnnouncementJoinCategory(String category);
    public List getAnnouncementJoinLocation(String location);
    public List getAllMyNotification(long id);
    public List getAnnouncementsByCurrentDate(String date);
}