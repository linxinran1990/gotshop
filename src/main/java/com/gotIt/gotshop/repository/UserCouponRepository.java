package com.gotIt.gotshop.repository;

import com.gotIt.gotshop.entity.UserCoupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserCouponRepository extends JpaRepository<UserCoupon,Long>,JpaSpecificationExecutor<UserCoupon> {
}
