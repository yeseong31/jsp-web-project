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
    private String name;
    private String image;
    private int car_id;
    private LocalDateTime reg_date;
    private LocalDateTime mod_date;

}
