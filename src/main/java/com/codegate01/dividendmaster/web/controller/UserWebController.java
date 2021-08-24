package com.codegate01.dividendmaster.web.controller;

import com.codegate01.dividendmaster.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserWebController {

    @Autowired
    UserRepository userRepository;


    @RequestMapping("/users")
    public String listUsers(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }
}
