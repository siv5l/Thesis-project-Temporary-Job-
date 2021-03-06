package com.endava.siv5l.controller.logging;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;

/**
 * Created by siv5l on 4/13/16.
 */
@Controller
public class LogoutController {

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(HttpSession httpSession){
        System.out.println("logout");
        httpSession.removeAttribute("userAccount");
        return "log/unlogged";
    }
}
