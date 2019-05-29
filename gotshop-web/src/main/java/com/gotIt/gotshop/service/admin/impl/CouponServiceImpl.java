package com.gotIt.gotshop.service.admin.impl;

import com.gotIt.gotshop.entity.Coupon;
import com.gotIt.gotshop.enumer.CouponSituation;
import com.gotIt.gotshop.repository.CouponRepository;
import com.gotIt.gotshop.repository.spec.CouponSpec;
import com.gotIt.gotshop.service.admin.CouponService;
import com.gotIt.gotshop.support.AbstractDomain2InfoConverter;
import com.gotIt.gotshop.support.QueryResultConverter;
import com.gotIt.gotshop.utils.ResultVOUtils;
import com.gotIt.gotshop.vo.CategoryInfo;
import com.gotIt.gotshop.vo.CouponInfo;
import com.gotIt.gotshop.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
    public ResultVO<Map<String,String>> save(CouponInfo couponInfo) {
        Map map = new HashMap();
        Coupon coupon = new Coupon();
        if(couponInfo.getId()!=null){
            coupon = couponRepository.findOne(couponInfo.getId());
        }
        BeanUtils.copyProperties(couponInfo,coupon);
        couponRepository.save(coupon);
        map.put("id",coupon.getId());
        return ResultVOUtils.success(map);
    }

    @Override
    public Page<CouponInfo> findByPage(CouponInfo couponInfo,Pageable page) {

        Page<Coupon> couponPage = couponRepository.findAll(new CouponSpec(couponInfo),page);
        return QueryResultConverter.convert(couponPage, page, new AbstractDomain2InfoConverter<Coupon, CouponInfo>() {
            @Override
            protected void doConvert(Coupon domain, CouponInfo info) throws Exception {

            }
        });
    }

    @Override
    public Long removeCoupon(Long couponId) {
        couponRepository.delete(couponId);
        return couponId;
    }


}



