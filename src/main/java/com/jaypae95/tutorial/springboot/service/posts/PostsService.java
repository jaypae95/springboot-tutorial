package com.jaypae95.tutorial.springboot.service.posts;

import com.jaypae95.tutorial.springboot.domian.posts.Posts;
import com.jaypae95.tutorial.springboot.domian.posts.PostsRepository;
import com.jaypae95.tutorial.springboot.web.dto.PostsResponseDto;
import com.jaypae95.tutorial.springboot.web.dto.PostsSaveRequestDto;
import com.jaypae95.tutorial.springboot.web.dto.PostsUpdateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateResponseDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "해당 게시글이 없습니다. id=" + id
                ));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "해당 게시글이 없습니다. id=" + id
                ));

        return new PostsResponseDto(entity);
    }
}
