package com.example.demo.Domain.Common.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="orders")
@IdClass(OrderId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    //PK로 지정된 컬럼들의 자료형은 OrderId 클래스 내의 PK 자료형들과 일치해야함
    @Id
    private Long orderId;

    @Id
    private Long productId;

    private int quantity;
}
