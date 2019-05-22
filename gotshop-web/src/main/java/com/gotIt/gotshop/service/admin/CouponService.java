package com.gotIt.gotshop.service.admin;

import com.gotIt.gotshop.entity.Coupon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CouponService {

    Coupon save(Coupon coupon);

    Page<Coupon> findByPage(Pageable page);

    Long removeCoupon(Long couponId);
}
