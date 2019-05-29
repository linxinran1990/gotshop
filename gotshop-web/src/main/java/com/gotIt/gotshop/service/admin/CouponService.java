package com.gotIt.gotshop.service.admin;

import com.gotIt.gotshop.entity.Coupon;
import com.gotIt.gotshop.vo.CouponInfo;
import com.gotIt.gotshop.vo.ResultVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;


public interface CouponService {

    ResultVO<Map<String,String>> save(CouponInfo coupon);

    Page<CouponInfo> findByPage(CouponInfo couponInfo,Pageable page);

    Long removeCoupon(Long couponId);
}
