package com.gotIt.gotshop.repository;


import com.gotIt.gotshop.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long>,JpaSpecificationExecutor<OrderItem> {
}
