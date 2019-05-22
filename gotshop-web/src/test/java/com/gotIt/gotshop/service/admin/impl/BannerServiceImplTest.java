package com.gotIt.gotshop.service.admin.impl;

import com.gotIt.gotshop.BaseTest;
import com.gotIt.gotshop.entity.Banner;
import com.gotIt.gotshop.entity.Product;
import com.gotIt.gotshop.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@Slf4j
public class BannerServiceImplTest extends BaseTest{

    @Autowired
    private BannerServiceImpl bannerService;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void findAll(){
        List<Banner> bannerList = bannerService.findAll();

        bannerList.forEach(banner -> log.info(banner.getBannerName()+",状态："+banner.getBannerStatus()+":"+
                banner.getProduct().getCategory().getCategoryName())
            );
    }

    @Test
    public void save(){
        Product product = productRepository.getOne(1L);
        Banner banner = new Banner();
        banner.setProduct(product);
        banner.setBannerImg("http://11");
        banner.setBannerName("美国苹果");

        bannerService.save(banner);
    }

    @Test
    public void findByPage(){
        PageRequest pageRequest = new PageRequest(1,10);

        Page<Banner> result = bannerService.findByPage(pageRequest);

        log.info(result.toString());

    }

}