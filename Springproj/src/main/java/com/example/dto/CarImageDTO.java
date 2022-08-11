package com.example.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarImageDTO {

    private int id;
    private String uuid;
    private String upload_path;
    private String filename;
    private int type;
    private LocalDateTime reg_date;
    private int car_id;

}
