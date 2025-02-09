package com.example.SpringBlog.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.SpringBlog.models.Account;
import com.example.SpringBlog.models.Authority;
import com.example.SpringBlog.models.Post;
import com.example.SpringBlog.services.AccountService;
import com.example.SpringBlog.services.AuthorityService;
import com.example.SpringBlog.services.PostService;
import com.example.SpringBlog.util.constants.Privillages;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private AccountService accountService;

    @Autowired
    private PostService postService;

    @Autowired
    private AuthorityService authorityService;

    @Override
    public void run(String... args) throws Exception {

        for (Privillages auth : Privillages.values()) {
            Authority authority = new Authority();
            authority.setId(auth.getId());
            authority.setName(auth.getPrivillage());
            authorityService.save(authority);
        }

        Account account01 = new Account();
        Account account02 = new Account();
        
        account01.setEmail("account01@example.com");
        account01.setPassword("password");
        account01.setFirstname("user01");
        account01.setLastname("lastname");

        account02.setEmail("account02@example.com");
        account02.setPassword("password");
        account02.setFirstname("user02");
        account02.setLastname("lastname");

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
