package com.gotIt.gotshop.repository;

import com.gotIt.gotshop.BaseTest;
import com.gotIt.gotshop.entity.Coupon;
import com.gotIt.gotshop.entity.User;
import com.gotIt.gotshop.entity.UserCoupon;
import com.gotIt.gotshop.enumer.CouponStatus;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserCouponRepositoryTest extends BaseTest{

    @Autowired
    private UserCouponRepository userCouponRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CouponRepository couponRepository;

    @Test
    public void save(){
        User user = userRepository.getOne(11L);
        Coupon coupon = couponRepository.getOne(8L);

        UserCoupon userCoupon = new UserCoupon();
        userCoupon.setCoupon(coupon);
        userCoupon.setStatus(CouponStatus.UNUSED);
        userCoupon.setUser(user);

        userCouponRepository.save(userCoupon);
    }
}