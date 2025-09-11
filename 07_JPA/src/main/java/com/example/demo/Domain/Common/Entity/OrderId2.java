package com.example.demo.Domain.Common.Entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderId2 implements Serializable { //Object 단위(public cass OrderId 자체)를 전달할 때 직렬화 처리
    //자료형이 Order에 있는 것과 동일해야함!
    private Long orderId;
    private Long productId;
}
