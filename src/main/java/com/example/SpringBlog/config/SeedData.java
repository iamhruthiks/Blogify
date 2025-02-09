package com.example.SpringBlog.config;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.example.SpringBlog.util.constants.Roles;

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
        Account account03 = new Account();
        Account account04 = new Account();
        
        account01.setEmail("user@user.com");
        account01.setPassword("pass987");
        account01.setFirstname("User");
        account01.setLastname("lastname");


        account02.setEmail("admin@admin.com");
        account02.setPassword("pass987");
        account02.setFirstname("Admin");
        account02.setLastname("lastname");
        account02.setRole(Roles.ADMIN.getRole());

        account03.setEmail("editor@editor.com");
        account03.setPassword("pass987");
        account03.setFirstname("Editor");
        account03.setLastname("lastname");
        account03.setRole(Roles.EDITOR.getRole());

        account04.setEmail("super_editor@editor.com");
        account04.setPassword("pass987");
        account04.setFirstname("Super_Editor");
        account04.setLastname("lastname");
        account04.setRole(Roles.EDITOR.getRole());

        Set<Authority> authorities = new HashSet<>();
        authorityService.findById(Privillages.ACCESS_ADMIN_PANEL.getId()).ifPresent(authorities::add);
        authorityService.findById(Privillages.RESET_ANY_USER_PASSWORD.getId()).ifPresent(authorities::add);
        account04.setAuthorities(authorities);

        accountService.save(account01);
        accountService.save(account02);
        accountService.save(account03);
        accountService.save(account04);

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
