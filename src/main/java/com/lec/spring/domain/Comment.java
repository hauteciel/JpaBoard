package com.lec.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity(name = "t7_comment")
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;   // 댓글 내용

    // Commnet:User = N:1   // 특정댓글의 -> 작성자 정보 필요
    @ManyToOne
    @ToString.Exclude
    private User user;   // 댓글 작성자 (FK)

    @Column(name = "post_id")
    @JsonIgnore   // JSON 변환시 제외하는 필드
    private Long post;   // 어느글의 댓글 (FK)

}












