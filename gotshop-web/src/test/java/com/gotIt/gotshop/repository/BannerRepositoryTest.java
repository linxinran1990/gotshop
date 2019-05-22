package com.gotIt.gotshop.repository;

import com.gotIt.gotshop.BaseTest;
import com.gotIt.gotshop.entity.Banner;
import com.gotIt.gotshop.enumer.Status;
import com.gotIt.gotshop.repository.BannerRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BannerRepositoryTest extends BaseTest{

    @Autowired
    private BannerRepository bannerRepository;

    @Test
    public void testSave(){

        Banner banner = new Banner();
        banner.setBannerName("大甩卖");
        banner.setBannerImg("http://ll");
       // banner.setBannerStatus(Status.USING);
        //banner.setProduct();
        bannerRepository.save(banner);
    }

    @Test
    public void testOne(){
        Banner banner = bannerRepository.getOne(14L);
    }
}