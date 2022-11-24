package com.example.Task1Test.controller;

import com.example.Task1Test.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {

    @RequestMapping(value = "/login", method= RequestMethod.GET)
    public String getLoginForm(){

        return "login";
    }

    //provera username is sifre
    @RequestMapping(value = "/login", method= RequestMethod.POST)
    public String login(@ModelAttribute(name="loginform") User user, Model model) {
        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println("username " + username);
        System.out.println("password " + password);

        if("admin".equals(username) && "admin".equals(password)){
            //ako su username is sifra tacni vracamo home stranicu
            return "home";
        }
            //ako nisu tacni
        model.addAttribute("invalidCredentials", true);
        //opet na login stranicu
        return "login";
    }

}
