package com.jaypae95.tutorial.springboot.domian.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity // 테이블과 링크될 클래스임을 나타냄.
// 기본 값으로 클래스의 카멜 케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭
public class Posts {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private Long id;

    // 기본값 외에 추가로 변경하고 싶은 옵션이 있을 경우 @Column 사용
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
