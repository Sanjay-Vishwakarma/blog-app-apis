package com.blogapp.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostResponse {

    private List<PostDto> content;

    private int pageNumber;

    private int pageSize;

    private long totalElements;

    private int totalPages;

    private boolean lastPage;


}
