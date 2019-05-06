package com.gotIt.gotshop.repository;

import com.gotIt.gotshop.BaseTest;
import com.gotIt.gotshop.entity.Banner;
import com.gotIt.gotshop.enumer.Status;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@Transactional
public class BannerRepositoryTest extends BaseTest{

    @Autowired
    private BannerRepository bannerRepository;

    @Test
    public void testSave(){

        Banner banner = new Banner();
        banner.setBannerName("大甩卖");
        banner.setBannerImg("http://ll");
        banner.setBannerStatus(Status.USING);
        //banner.setProduct();
    }

    @Test
    public void testOne(){
        Banner banner = bannerRepository.getOne(14L);
    }
}