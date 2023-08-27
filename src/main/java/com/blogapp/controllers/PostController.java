package com.blogapp.controllers;


import com.blogapp.config.AppConstans;
import com.blogapp.payloads.ApiResponse;
import com.blogapp.payloads.PostDto;
import com.blogapp.payloads.PostResponse;
import com.blogapp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    // create

    @PostMapping("/user/{userId}/category/{categoryId}/post")
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto postDto,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId

    ) {
        PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);

    }

    // get by  user


    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId) {
        List<PostDto> postByUser = this.postService.getPostByUser(userId);
        return new ResponseEntity<List<PostDto>>(postByUser, HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId) {
        List<PostDto> postByCategory = this.postService.getPostByCategory(categoryId);
        return new ResponseEntity<List<PostDto>>(postByCategory, HttpStatus.OK);
    }


    // get all posts and pagination
    @GetMapping("/allPost")
    public ResponseEntity<PostResponse> getAllPosts(
            @RequestParam(value = "pageNumber", defaultValue = AppConstans.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = AppConstans.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstans.SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstans.SORT_DIR, required = false) String sortDir

    ) {
        PostResponse allPost = this.postService.getAllPost(pageNumber, pageSize, sortBy, sortDir);
        return new ResponseEntity<PostResponse>(allPost, HttpStatus.OK);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<PostDto> getSinglePost(@PathVariable Integer postId) {
        PostDto postById = this.postService.getPostById(postId);
        return new ResponseEntity<PostDto>(postById, HttpStatus.OK);
    }

    // delete post
    @DeleteMapping("/deletPost/{postId}")
    public ApiResponse deletePost(@PathVariable int postId) {
        this.postService.deletePost(postId);
        return new ApiResponse("Post is successfully deleted", true);
    }

    // update post

    @PutMapping("/updatePost/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable int postId) {
        PostDto updatePost = this.postService.updatePost(postDto, postId);
        return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);
    }

    //  search

    @GetMapping("/posts/search/{keyword}")
    public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable("keyword") String keyword) {
        List<PostDto> postDtos = this.postService.searchPosts(keyword);
        return new ResponseEntity<List<PostDto>>(postDtos, HttpStatus.OK);
    }


}
