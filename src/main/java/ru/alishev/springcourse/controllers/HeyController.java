package ru.alishev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hey")
public class HeyController {
    @GetMapping
    public String hey(){

        return "redirect:/people";
    }
}
