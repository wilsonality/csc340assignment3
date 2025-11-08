package com.wilsonality.animalsmvcapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping({"", "/", "/home"})
    public String redirectToStudents() {
        return "redirect:/animals";
    }
}






