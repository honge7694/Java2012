package com.hong.restaurant.dto;

import lombok.*;

@ToString
@NoArgsConstructor // 파라미터가 없는 생성자 생성.
@AllArgsConstructor // 모든 파라미터를 갖는 생성자 생성.
@Data
public class RestaurantDTO {

    private Long pno;
    private String pname;
    private String pcost;
    private String oriFileName;
    private String fileName;
    private String filePath;

}
