package com.example.SpringBlog.Controller;

import java.util.List;

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

    @GetMapping("/")
    public List<Post> home(){  
        return postService.findAll();
    }

}
