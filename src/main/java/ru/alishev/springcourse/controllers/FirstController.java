package ru.alishev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.alishev.springcourse.Action;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Viacheslav Korbut
 */
@Controller
//@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        System.out.println("Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbye(@RequestParam(value = "name",required = false) String name,
                          @RequestParam(value = "surname", required = false) String surname, Model model) {
        //System.out.println("Goodbye, " + name + " " + surname);
        model.addAttribute("message","Goodbye, " + name + " " + surname);
        return "first/goodbye";
    }
    @GetMapping("/calculator")
    public String calc(@RequestParam(value = "a",required = false) int a,
                       @RequestParam(value = "action",required = false) String action,
                       @RequestParam(value = "b",required = false) int b,
                       Model model){
        double result;
        switch (action){
            case "add":result=a+b;break;
            case "div":result=a-b;break;
            case "mul":result=a*b;break;
            case "sub":result=a/b;break;
            default:result=0.0;break;
        }
        model.addAttribute("result",a+" "+action+" "+b+" = "+result);
        return "first/calculator";
    }
}
