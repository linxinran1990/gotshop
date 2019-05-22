package com.gotIt.gotshop.entity;

import com.gotIt.gotshop.enumer.CouponStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_user_coupon")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCoupon extends BaseEntity implements Serializable {

    @ManyToOne
    private User user;

    @ManyToOne
    private Coupon coupon;

    @Column(columnDefinition = "INT(1) default 0")
    @Enumerated(EnumType.ORDINAL)
    private CouponStatus status;
}
