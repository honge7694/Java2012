package com.hong.restaurant.dto;

import lombok.*;

@ToString
@NoArgsConstructor
@Data
public class RestaurantDTO {

    private Long pno;
    private String pname;
    private String pcost;
    private String oriFileName;
    private String fileName;
    private String filePath;

}
