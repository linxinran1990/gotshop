package com.gotIt.gotshop.service.admin.impl;

import com.gotIt.gotshop.entity.Banner;
import com.gotIt.gotshop.enumer.Status;
import com.gotIt.gotshop.repository.BannerRepository;
import com.gotIt.gotshop.service.admin.BannerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/17</pre>
 */
@Service
@Slf4j
//@CacheConfig(cacheNames = "banner")
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    @Override
    //@Cacheable
    public List<Banner> findAll() {
        List<Banner> bannerList = bannerRepository.findAll();
        return bannerList;
    }

    @Override
    public Banner save(Banner banner) {
        banner.setBannerStatus(Status.USING);
        return bannerRepository.save(banner);
    }

    @Override
    public Page<Banner> findByPage(Pageable pageable) {
        return bannerRepository.findAll(pageable);
    }

    @Override
    public Long removeBanner(Long bannerId) {
         bannerRepository.delete(bannerId);
        return bannerId;
    }

    @Override
    public Banner findOne(Long bannerId) {
        return bannerRepository.findOne(bannerId);
    }
}



