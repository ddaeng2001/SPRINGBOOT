package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Order;
import com.example.demo.Domain.Common.Entity.OrderId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, OrderId> {
                                                        //PK 설정 시 복합키로 묶어서 전달하기에 OrderId 클래스
                                                        //자체를 삽입하면 됨
}
