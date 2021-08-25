package com.jaypae95.tutorial.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateResponseDto {
    private String title;
    private String content;

    @Builder
    public PostsUpdateResponseDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
