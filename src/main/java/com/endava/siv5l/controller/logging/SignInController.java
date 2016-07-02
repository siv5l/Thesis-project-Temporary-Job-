package com.endava.siv5l.controller.logging;

import com.endava.siv5l.model.User;
import com.endava.siv5l.service.messaging.Message;
import com.endava.siv5l.service.messaging.MessageMap;
import com.endava.siv5l.service.UserService;
import com.endava.siv5l.service.validation.LoginValidation;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.security.Principal;

/**
 * Created by siv5l on 4/3/16.
 */

@Controller
@SessionAttributes("userAccount")
public class SignInController {
    @Autowired
    private UserService userService;
    @Autowired
    private MessageMap messageMap;


    @RequestMapping(value = "/signin" , method = RequestMethod.GET)
    public String checkAccount(@Valid @ModelAttribute("loginValidation") LoginValidation loginValidation,
                                BindingResult result, Principal principal,
                                ModelMap model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        System.out.println("user: " + auth.getName());
        if(result.hasErrors()){
            System.out.println("erori");
            return "log/loginDoi";
           /* return "log/login";*/
        }
        try{
            // adaug useru in MAP pentru chat
           /* User user = userService.getByUsername(loginValidation.getUsername());*/
            User user = userService.getByUsername(principal.getName());
            System.out.println("aiciaici");
        /*    if((user != null) && (loginValidation.getPassword().equals(user.getPassword()))){*/
               /* messageMap.getMapa().put(loginValidation.getUsername(),new HashMap<String, ArrayList<Message>>());*/ // ii cream userului
                                                                                                // logat o mapa de mesaje
               messageMap.getMapa().put(principal.getName(),new HashMap<String, ArrayList<Message>>());
                model.addAttribute("userAccount",user);
                return "log/logged";
              /*  }
            else {
                return "log/unlogged";
            }*/

        }
        catch (NullPointerException e){
            System.out.println("nullllll");
            return "log/unlogged";
        }
        catch(HibernateException hibernateException){
            System.out.println("exceptie");
            hibernateException.printStackTrace();
            return "log/unlogged";
        }
    }

  /*  @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String checkAcount(){
        return "log/logged";
    }*/

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String singUp(ModelMap model, Principal principal){
     /*   System.out.println("princp:" + principal.getName());
        User user  = userService.getByUsername(principal.getName());
        model.addAttribute("userAccount",user);*/
        System.out.println("signUp");
       /* return "log/login";*/
        return "log/loginDoi";
    }

    @RequestMapping(value = "/registrationon", method = RequestMethod.GET)
    public String registrationUp(ModelMap map){
        User user = new User();
        map.put("user",user);
        return "registration/registration";
    }

}
