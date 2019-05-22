package com.gotIt.gotshop.service.admin.impl;

import com.gotIt.gotshop.entity.Coupon;
import com.gotIt.gotshop.enumer.CouponSituation;
import com.gotIt.gotshop.repository.CouponRepository;
import com.gotIt.gotshop.service.admin.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/17</pre>
 */
@Service
public class CouponServiceImpl implements CouponService{

    @Autowired
    private CouponRepository couponRepository;

    @Override
    public Coupon save(Coupon coupon) {
        coupon.setSituation(CouponSituation.COMMOM);
        return couponRepository.save(coupon);
    }

    @Override
    public Page<Coupon> findByPage(Pageable page) {
        return couponRepository.findAll(page);
    }

    @Override
    public Long removeCoupon(Long couponId) {
        couponRepository.delete(couponId);
        return couponId;
    }


}



