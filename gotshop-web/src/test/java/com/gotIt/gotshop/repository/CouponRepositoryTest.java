package com.gotIt.gotshop.repository;

import com.gotIt.gotshop.BaseTest;
import com.gotIt.gotshop.entity.Coupon;
import com.gotIt.gotshop.enumer.CouponSituation;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@Transactional
public class CouponRepositoryTest extends BaseTest{

    @Autowired
    private CouponRepository couponRepository;

    @Test
    public void testSave(){
        Coupon coupon = new Coupon();
        coupon.setCouponImg("http://33");
        coupon.setCouponName("50元优惠");
        coupon.setCouponValue(new BigDecimal(5));
        coupon.setEndDate(new Date());
        coupon.setStartDate(new Date(-10));
        coupon.setSituation(CouponSituation.COMMON);
        coupon.setCreateTime(new Date());

        couponRepository.save(coupon);
    }
}