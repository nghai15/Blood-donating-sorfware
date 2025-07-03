package com.example.blooddonation.controller;

import com.example.blooddonation.model.BlogPost;
import com.example.blooddonation.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@Controller
public class BlogController {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @GetMapping("/blog")
    public String showBlog(Model model) {
        model.addAttribute("posts", blogPostRepository.findAll());
        return "blog";
    }

    @GetMapping("/blog/new")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new BlogPost());
        return "blog_create";
    }

    @PostMapping("/blog/save")
    public String savePost(@ModelAttribute BlogPost post) {
        post.setPostedDate(LocalDate.now());
        blogPostRepository.save(post);
        return "redirect:/blog";
    }
}

