package com.blogapp.payloads;

import com.blogapp.entities.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {


    private int id;

    private String content;

}
