package com.endava.siv5l.controller.notifications;

/**
 * Created by siv5l on 6/4/16.
 */

import com.endava.siv5l.model.Announcement;
import com.endava.siv5l.model.Serviciu;
import com.endava.siv5l.model.User;
import com.endava.siv5l.service.AnnouncementService;
import com.endava.siv5l.service.ServiciuService;
import com.endava.siv5l.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class NotificationController {

    @Autowired
    private UserService userService;
    @Autowired
    private AnnouncementService announcementService;

    @Autowired
    private ServiciuService serviciuService;


    @RequestMapping(value = "/submitnotification/{announcementId}", method = RequestMethod.POST)
    public String submtiNotification(@PathVariable("announcementId") long announcementId, @RequestParam String action,
                                                   ModelMap model, HttpSession httpSession){

        System.out.println("announcementId: " + announcementId);
        User user = (User) httpSession.getAttribute("userAccount");
        Announcement announcement = announcementService.getAnnouncement(announcementId);
        System.out.println("announcementSubjectGetted: " + announcement.getSubject());



        Serviciu serviciu = new Serviciu();
        serviciu.setUser_id(user.getUserId());
        serviciu.getAssignedUsersToAnnouncement().add(announcement);
        announcement.getAnnouncementsAssignedToUsers().add(serviciu);
        serviciuService.add(serviciu);


        return "log/logged";
    }

}
