package com.gotIt.gotshop.repository;

import com.gotIt.gotshop.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserAddressRepository extends JpaRepository<UserAddress,Long>,JpaSpecificationExecutor<UserAddress> {
}
