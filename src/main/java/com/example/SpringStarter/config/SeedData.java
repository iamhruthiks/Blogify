package com.example.SpringStarter.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.SpringStarter.models.Account;
import com.example.SpringStarter.models.Post;
import com.example.SpringStarter.services.AccountService;
import com.example.SpringStarter.services.PostService;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private AccountService accountService;

    @Autowired
    private PostService postService;

    @Override
    public void run(String... args) throws Exception {

        Account account01 = new Account();
        Account account02 = new Account();
        
        account01.setEmail("account01@example.com");
        account01.setPassword("password");
        account01.setFirstname("user01");

        account02.setEmail("account02@example.com");
        account02.setPassword("password");
        account02.setFirstname("user02");
        
        accountService.save(account01);
        accountService.save(account02);

        List<Post> posts = postService.getAll();
        if (posts.size() == 0) {
            Post post01 = new Post();
            post01.setTitle("post 01");
            post01.setBody("post 01 body ........");
            post01.setAccount(account01);
            postService.save(post01);

            Post post02 = new Post();
            post02.setTitle("post 02");
            post02.setBody("post 02 body ........");
            post02.setAccount(account02);
            postService.save(post02);

        }
    }
    
}
