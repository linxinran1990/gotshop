package com.gotIt.gotshop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "t_order_item")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem extends BaseEntity implements Serializable {

    @ManyToOne
    private Order order;

    @Column(length = 64)
    private String openid;

    @OneToOne
    private Product product;

    @Column(length = 50)
    private String productName;

    @Column(columnDefinition = "decimal(10,2) NOT NULL")
    private BigDecimal productPrice;

    private Integer productQuantity;

    @Column(length = 50)
    private String productImg;

    @Column(columnDefinition = "decimal(10,2)")
    private BigDecimal totalPrice;
}
