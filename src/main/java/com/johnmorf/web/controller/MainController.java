package com.johnmorf.web.controller;

import com.johnmorf.web.model.User;
import com.johnmorf.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class MainController {

    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String myProfile(Principal principal, Model model) {
        User user = userService.findByUserName(principal.getName());
        model.addAttribute("user", user);
        return "myAccount";
    }
}
