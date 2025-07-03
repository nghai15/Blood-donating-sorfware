package com.example.blooddonation.service;

import com.example.blooddonation.model.BlogPost;
import com.example.blooddonation.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    public List<BlogPost> getAllPosts() {
        return blogPostRepository.findAll();
    }

    public void savePost(BlogPost post) {
        blogPostRepository.save(post);
    }
}
