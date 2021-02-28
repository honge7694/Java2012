package com.hong.restaurant.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.*;

@Entity
@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "restaurant") //연관 관계시 항상 주의
public class RestaurantImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inum;

    private String uuid;

    private String imgName;

    private String path;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE) //무조건 lazy로
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;


}
