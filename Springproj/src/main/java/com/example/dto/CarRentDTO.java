package com.example.dto;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarRentDTO {

    private int id;
    private String acceptance_date;  // jsp 페이지에서 받아올 때 String으로 넘어옴
    private String return_date;
    private int is_return;
    private int price;
    private String userid;
    private int car_num_id;

}
