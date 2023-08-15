package com.blogapp.services;

import com.blogapp.dto.PostDto;
import com.blogapp.entities.Post;

import java.util.List;

public interface PostService {


    // create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    // update
    Post updatePost(PostDto postDto, Integer postId);

    // delete
    void deletePost(Integer postId);

    // get all post
    List<Post> getAllPost();

    // get single post
    List getPostById(Integer postId);


    // get all post by category
    List<Post> getPostByCategory(Integer categoryId);


    // get all post by user
    List<Post> getPostByUser(Integer userId);


}
