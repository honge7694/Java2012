package com.hong.restaurant.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor // 모든 파라미터를 갖는 생성자를 생성
@NoArgsConstructor // 파라미터를 갖지않는 생성자를 생성
@ToString
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pno;

    @Column(length = 100, nullable = false)
    private String pname;

    @Column(length = 100, nullable = false)
    private String pcost;

    public void changePname(String pname){
        this.pname = pname;
    }

    public void changePcost(String pcost){
        this.pcost = pcost;
    }
}
