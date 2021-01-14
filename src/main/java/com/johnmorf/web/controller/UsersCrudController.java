package com.johnmorf.web.controller;

import com.johnmorf.web.model.Role;
import com.johnmorf.web.model.User;
import com.johnmorf.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;

@Controller
@RequestMapping("/admin")
public class UsersCrudController {

    private final UserService userService;

    @Autowired
    public UsersCrudController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "admin/showUser";
    }

    @GetMapping()
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin/allUsers";
    }

    @GetMapping("/new")
    public String addUser(@ModelAttribute User user) {
        return "admin/new";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/new";
        }
        user.setRoles(Collections.singleton(new Role("ROLE_USER")));
        userService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "admin/edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                             @PathVariable Long id) {
        if (bindingResult.hasErrors()) {
            return "admin/edit";
        }
        userService.updateUser(id, user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}

