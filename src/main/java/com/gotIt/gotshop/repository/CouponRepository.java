package com.gotIt.gotshop.repository;

import com.gotIt.gotshop.entity.Category;
import com.gotIt.gotshop.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CouponRepository extends JpaRepository<Coupon,Long>,JpaSpecificationExecutor<Coupon> {
}
