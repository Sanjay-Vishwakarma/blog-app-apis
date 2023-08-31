package com.blogapp.controllers;


import com.blogapp.entities.Comment;
import com.blogapp.payloads.ApiResponse;
import com.blogapp.payloads.CommentDto;
import com.blogapp.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}/comment")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment, @PathVariable int postId) {
        CommentDto dto = this.commentService.createComment(comment, postId);
        return new ResponseEntity<CommentDto>(dto, HttpStatus.CREATED);
    }


    @DeleteMapping("/{commentId}")
    public ResponseEntity<ApiResponse> createComment(@PathVariable int commentId) {
        this.commentService.deleteComment(commentId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted Successfully", true), HttpStatus.OK);
    }


}
