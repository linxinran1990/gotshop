package com.gotIt.gotshop.repository;

import com.gotIt.gotshop.entity.Banner;
import com.gotIt.gotshop.enumer.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface BannerRepository extends JpaRepository<Banner,Long>,JpaSpecificationExecutor<Banner> {

    List<Banner> findByBannerStatus(Status status);

}
