package com.example.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private int id;
    private String content;
    private LocalDateTime create_at;
    private LocalDateTime update_at;
    private String author;
    private int post;
}
