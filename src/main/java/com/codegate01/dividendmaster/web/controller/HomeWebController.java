package com.codegate01.dividendmaster.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeWebController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

}
