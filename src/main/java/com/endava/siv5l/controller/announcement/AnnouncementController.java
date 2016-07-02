package com.endava.siv5l.controller.announcement;

import com.endava.siv5l.model.Announcement;
import com.endava.siv5l.model.Category;
import com.endava.siv5l.model.Location;
import com.endava.siv5l.model.User;
import com.endava.siv5l.service.AnnouncementService;
import com.endava.siv5l.service.CategoryService;
import com.endava.siv5l.service.LocationService;
import com.endava.siv5l.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by siv5l on 4/25/16.
 */

@Controller
public class AnnouncementController {
    @Autowired
    private UserService userService;
    @Autowired
    private AnnouncementService announcementService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value = "/addannouncement", method = RequestMethod.GET)
    public String addingAnnouncment(ModelMap model){
        Announcement announcement = new Announcement();
        model.addAttribute("announcement",announcement);
        return "menu/addannouncement";
    }

    @RequestMapping(value = "/addannouncement", method = RequestMethod.POST)
    public String addingAnnouncements(@ModelAttribute Announcement announcement,BindingResult result,
                                                    HttpSession httpSession, ModelMap model){
        User user = (User) httpSession.getAttribute("userAccount");
        List<String> locations = announcement.getLocations(); //fac bind la localitatile in care va fi pus anuntul
        List<String> categories = announcement.getCategories(); //fac bind la categoriile in care va fi pus anuntul

        Set<User> usersForNotifications = new HashSet<User>(); //***

        if(announcement.getLocations() != null){
            for (String location : locations) {
                Location l = locationService.getByName(location);
                Set<User> temporarListLoc = l.getLocationUsers();  //***  // toti userii care satisfac locatia trimisa la anunt
                //System.out.println("locatieeeeee: " + l.getName());
                for(User u : temporarListLoc){
                    System.out.println("Userrrrrrrrr from location: " + u.getUsername());


                    //verific daca useru are categoria care trebuie sa primeasca notificare
                    if (announcement.getCategories() != null) {
                        System.out.println("- unu");
                        for (String categoryy : categories) {
                            System.out.println("- doi");
                            Set<Category> userscategories = u.getUserCategories();
                            if(userscategories == null){
                                System.out.println("sosi");
                            }
                            System.out.println("- trei");
                            for (Category str : userscategories) {
                                System.out.println("- patru");
                                if (str.getName().equals(categoryy)) {
                                    System.out.println("este un user la locatii " + u.getUsername());
                                    usersForNotifications.add(u);
                                }
                            }
                        }
                    }
                    else{
                        usersForNotifications.add(u);
                    }

                        //usersForNotifications.add(u);
                }
                announcement.getLocationList().add(l); // anuntul poate fi postat pe mai multe localitati
            }
        }
        /***************************************************************************************************/
        if(announcement.getCategories() != null) {
            for (String category : categories) {
                Category c = categoryService.getByName(category);
                Set<User> temporarListCat = c.getCategoryUsers();
                //System.out.println("categorie: " + c.getName());
                for(User u : temporarListCat){
                    System.out.println("Userrrrrrrrr fron category: " + u.getUsername());


                    //verific daca useru are locatia care trebuie sa primeasca notificare
                    if (announcement.getLocations() != null) {
                        System.out.println("unu");
                        for (String location : locations) {
                            System.out.println("doi");
                            Set<Location> usersLocations = u.getUserLocations();
                            System.out.println("trei");
                            for (Location str : usersLocations) {
                                System.out.println("patru");
                                if (str.getName().equals(location)) {
                                    System.out.println("este un user la categorii " + u.getUsername());
                                    usersForNotifications.add(u);
                                }
                            }
                        }
                    }
                    else{
                        usersForNotifications.add(u);
                    }

                    //usersForNotifications.add(u);
                }
                announcement.getCategoryList().add(c); // anuntul poate fi postat pe mai multe categorii
            }
        }
        System.out.println("************************************************************");
        System.out.println("Size: " + usersForNotifications.size());
        for(User ur : usersForNotifications){
            User userWithNotification = userService.getUser(ur.getUserId());
            userWithNotification.getUserNotifications().add(announcement);
            announcement.getUserNotifications().add(userWithNotification);
        }


        User currentUser = userService.getUser(user.getUserId());
        currentUser.getAnnouncementsList().add(announcement);  // un utilizator poate posta mai multe anunturi
        announcement.setUser(currentUser);  // trebuie sa se cunoasca de cine este postat acest anunt
        announcement.setDate(new Date());

        announcementService.add(announcement); //salvez anuntul care are un utilizator, si este postat in mai multe localitati si categorii

        return "log/logged";
    }

    @RequestMapping(value="/{username}/announcements", method = RequestMethod.GET)
    public String  returnAnnouncements(@PathVariable("username") String username,HttpSession session,ModelMap model){

        //pentru a afisa full name in loc de username ******************************************
        Map<String, String> fullNameUser = new HashMap<String, String>();

        List<User> allUsers = userService.getAllUsers();

        for(User u: allUsers){
            String fullName = u.getFirstName() + " " + u.getLastName();
            fullNameUser.put(u.getUsername(),fullName);
        }
        model.addAttribute("fullNameUser",fullNameUser);
        //*************************************************



        Map<Long,String>  idAnnAndUser = new HashMap<Long, String>();

        User user = (User) session.getAttribute("userAccount");
        List<Announcement> announcements = announcementService.getAllMyAnnouncements(user.getUserId());
        if(announcements != null) {
            for (Announcement a : announcements) {
                User userAsignat = userService.getUser(a.getUser_asigned());
                try{
                    idAnnAndUser.put(a.getAnnouncementId(), userAsignat.getUsername());
                }
                catch (NullPointerException e){
                    System.out.println("exception bbbb");
                }
            }

            for(Map.Entry<Long,String> entry: idAnnAndUser.entrySet()){
                System.out.println("Anunt id: " + entry.getKey() + " /  user asignat:" + entry.getValue());
            }
        }
        model.addAttribute("userAccount",user);
        model.addAttribute("anunturi", announcements);
        model.addAttribute("asiggnedUsers", idAnnAndUser);

        return "profile/showMyAnnouncements";
    }

    @RequestMapping(value="{username}/notifications", method = RequestMethod.GET)
    public String returnNotifications(@PathVariable("username") String username, HttpSession session, ModelMap model){
        //pentru a afisa full name in loc de username ******************************************
        Map<String, String> fullNameUser = new HashMap<String, String>();

        List<User> allUsers = userService.getAllUsers();

        for(User u: allUsers){
            String fullName = u.getFirstName() + " " + u.getLastName();
            System.out.println("adsadasdas " +  u.getFirstName() + " " + u.getLastName());
            fullNameUser.put(u.getUsername(),fullName);
        }
        model.addAttribute("fullNameUser",fullNameUser);
        //*************************************************

        //System.out.println("username: " + username);
        User user = (User) session.getAttribute("userAccount");
        List<Announcement> announcements = announcementService.getAllMyNotification(user.getUserId());
        for(Announcement a : announcements){
            //System.out.println(a.getSubject());
        }
        model.addAttribute("notifications",announcements);
        return "notification/myNotifications";
    }

    @RequestMapping(value="{username}/announcements/{announcementId}",method = RequestMethod.POST)
    public String returnSignedUsers(@PathVariable("announcementId") String announcementId, ModelMap model, HttpSession httpSession){
        List<User> assignedUsers = userService.getUsersAssignedToMyAnnouncement(announcementId);
        for(User u : assignedUsers){
            System.out.println("firstName: " + u.getFirstName());
        }
        model.addAttribute("assignedUsers",assignedUsers);
        model.addAttribute("anuntIdAsignat",announcementId);
        return "profile/signedUsers";
    }

    @RequestMapping(value="{username}/announcements/{announcementId}/assignUser/{usertosign}",method = RequestMethod.POST)
    public String assignUser(@PathVariable("announcementId") long announcementId, @PathVariable("usertosign") String usertosign, ModelMap model, HttpSession session) {

        //pentru a afisa full name in loc de username ******************************************
        Map<String, String> fullNameUser = new HashMap<String, String>();

        List<User> allUsers = userService.getAllUsers();

        for(User u: allUsers){
            String fullName = u.getFirstName() + " " + u.getLastName();
            System.out.println("adsadasdas " +  u.getFirstName() + " " + u.getLastName());
            fullNameUser.put(u.getUsername(),fullName);
        }
        model.addAttribute("fullNameUser",fullNameUser);
        //*************************************************


        Announcement a = announcementService.getAnnouncement(announcementId);
        User user  = userService.getByUsername(usertosign);
        a.setUser_asigned(user.getUserId());
        announcementService.edit(a);



        //copy paste from #showMyannouncement requestMap

        Map<Long,String>  idAnnAndUser = new HashMap<Long, String>();

        User userr = (User) session.getAttribute("userAccount");
        List<Announcement> announcements = announcementService.getAllMyAnnouncements(userr.getUserId());
        if(announcements != null) {
            for (Announcement an : announcements) {
                User userAsignat = userService.getUser(an.getUser_asigned());
                try {
                    idAnnAndUser.put(an.getAnnouncementId(), userAsignat.getUsername());
                }catch(NullPointerException e){
                    System.out.println("exception la retun inapoi la showAnunturi");
                }
            }

            for(Map.Entry<Long,String> entry: idAnnAndUser.entrySet()){
                System.out.println("Anunt id: " + entry.getKey() + " /  user asignat:" + entry.getValue());
            }
        }
       /* model.addAttribute("userAccount",user);*/
        model.addAttribute("anunturi", announcements);
        model.addAttribute("asiggnedUsers", idAnnAndUser);


        return "profile/showMyAnnouncements";
    }
}
