package com.gotIt.gotshop.service.admin.impl;

import com.gotIt.gotshop.BaseTest;
import com.gotIt.gotshop.entity.Banner;
import com.gotIt.gotshop.entity.Coupon;
import com.gotIt.gotshop.enumer.CouponSituation;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

@Slf4j
public class CouponServiceImplTest extends BaseTest{

    @Autowired
    private CouponServiceImpl couponService;

    @Test
    public void save(){
        Coupon coupon = new Coupon();
        coupon.setCouponImg("http://33");
        coupon.setCouponName("50元优惠");
        coupon.setCouponValue(new BigDecimal(5));
        coupon.setEndDate(new Date());
        coupon.setStartDate(new Date(-10));
        coupon.setSituation(CouponSituation.COMMON);
        coupon.setCreateTime(new Date());

        //couponService.save(coupon);
    }


    @Test
    public void findByPage(){
        PageRequest pageRequest = new PageRequest(1,10);

       // Page<Coupon> result = couponService.findByPage(pageRequest);

        log.info("");


    }

}