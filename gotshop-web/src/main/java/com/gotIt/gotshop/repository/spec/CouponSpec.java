package com.gotIt.gotshop.repository.spec;

import com.gotIt.gotshop.entity.Coupon;
import com.gotIt.gotshop.repository.spec.support.QueryWraper;
import com.gotIt.gotshop.repository.spec.support.ShopSimpleSpecification;
import com.gotIt.gotshop.vo.CouponInfo;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/26</pre>
 */
public class CouponSpec extends ShopSimpleSpecification<Coupon,CouponInfo> {


    /**
     * @param condition
     */
    public CouponSpec(CouponInfo condition) {
        super(condition);
    }

    @Override
    protected void addCondition(QueryWraper<Coupon> queryWraper) {
        addEqualsCondition(queryWraper,"id");
        addEqualsCondition(queryWraper,"couponName");
        addEqualsCondition(queryWraper,"couponValue");
    }
}



