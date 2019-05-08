package com.gotIt.gotshop.repository;

import com.gotIt.gotshop.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BannerRepository extends JpaRepository<Banner,Long>,JpaSpecificationExecutor<Banner> {
}
