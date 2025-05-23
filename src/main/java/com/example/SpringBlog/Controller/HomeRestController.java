package com.example.SpringBlog.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBlog.models.Post;
import com.example.SpringBlog.services.PostService;

@RestController
@RequestMapping("api/v1")
public class HomeRestController {
    @Autowired
    private PostService postService;
    
    Logger logger = LoggerFactory.getLogger(HomeRestController.class);

    @GetMapping("/")
    public String home() {
        logger.error("this is a test error log");
        return "sample response";
    }

}
