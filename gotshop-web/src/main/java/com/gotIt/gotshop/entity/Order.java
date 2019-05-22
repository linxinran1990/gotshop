package com.gotIt.gotshop.entity;

import com.gotIt.gotshop.enumer.PayStatus;
import com.gotIt.gotshop.enumer.PayType;
import com.gotIt.gotshop.enumer.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "t_order")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity implements Serializable {


    @Column(columnDefinition = "bigint(20)")
    private Integer orderNo;

    @ManyToOne
    private User user;

    @Column(length = 64)
    private String openid;

    @OneToOne
    private UserAddress address;

    @Column(columnDefinition = "decimal(10,2)")
    private BigDecimal couponDeduction;

    @Column(columnDefinition = "decimal(10,2)")
    private BigDecimal orderAmount;

    @Column(columnDefinition = "INT(1)" )
    @Enumerated(EnumType.ORDINAL)
    private PayType payType;

    @Column(length = 50)
    private String payNo;


    @Column(columnDefinition = "INT(3) default 0" )
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus orderStatus;

    @Column(columnDefinition = "INT(3) default 0" )
    @Enumerated(EnumType.ORDINAL)
    private PayStatus payStatus;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
}
