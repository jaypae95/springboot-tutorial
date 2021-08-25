package com.jaypae95.tutorial.springboot.web;

import com.jaypae95.tutorial.springboot.service.posts.PostsService;
import com.jaypae95.tutorial.springboot.web.dto.PostsResponseDto;
import com.jaypae95.tutorial.springboot.web.dto.PostsSaveRequestDto;
import com.jaypae95.tutorial.springboot.web.dto.PostsUpdateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateResponseDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
