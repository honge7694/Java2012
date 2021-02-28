package com.hong.restaurant.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor // 파라미터가 없는 생성자 생성.
@AllArgsConstructor // 모든 파라미터를 갖는 생성자 생성.
@Data
@Getter
@Setter
public class RestaurantDTO {

    private Long pno;
    private String pname;
    private String pcost;

    @Builder.Default
    private List<RestaurantImageDTO> imageDTOList = new ArrayList<>();

}
