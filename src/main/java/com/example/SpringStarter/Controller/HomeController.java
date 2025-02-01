package com.example.SpringStarter.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(Model Model) {
        return "home";
    }
    
    @GetMapping("/about")
    public String about(Model Model) {
        return "about";
    }
    
    @GetMapping("/book")
    public String book(Model Model){
        return "book";
    }
}
