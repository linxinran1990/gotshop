package com.gotIt.gotshop.entity;


import com.gotIt.gotshop.enumer.CouponSituation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_coupon")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coupon extends BaseEntity implements Serializable {

    @Column(length = 50)
    private String couponName;

    @Column(columnDefinition = "decimal(10,2)")
    private BigDecimal couponValue;

    @Column(length = 50)
    private String couponImg;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Column(name="situation",columnDefinition="tinyint default 0")
    @Enumerated(EnumType.ORDINAL)
    private CouponSituation situation = CouponSituation.COMMON;

    @OneToMany(mappedBy = "coupon")
    private List<UserCoupon> users;
}
