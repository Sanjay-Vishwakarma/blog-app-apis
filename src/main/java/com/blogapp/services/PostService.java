package com.blogapp.services;

import com.blogapp.dto.PostDto;
import com.blogapp.entities.Post;

import java.util.List;

public interface PostService {


    // create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    // update
    PostDto updatePost(PostDto postDto, Integer postId);

    // delete
    void deletePost(Integer postId);

    // get all post
    List<PostDto> getAllPost();

    // get single post
    PostDto getPostById(Integer postId);


    // get all post by category
    List<PostDto> getPostByCategory(Integer categoryId);


    // get all post by user
    List<PostDto> getPostByUser(Integer userId);

    // search posts
List<PostDto> searchPosts(String keyword);

}
