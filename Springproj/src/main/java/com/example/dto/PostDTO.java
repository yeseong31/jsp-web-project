package com.example.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private int id;
    private String title;
    private String content;
    private LocalDateTime create_at;
    private LocalDateTime update_at;
    private String hook_text;
    private String author;
    private int category;
}
