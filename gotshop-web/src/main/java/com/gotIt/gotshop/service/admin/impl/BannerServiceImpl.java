package com.gotIt.gotshop.service.admin.impl;

import com.gotIt.gotshop.entity.Banner;
import com.gotIt.gotshop.enumer.ResultEnum;
import com.gotIt.gotshop.enumer.Status;
import com.gotIt.gotshop.exception.ServiceException;
import com.gotIt.gotshop.form.BannerForm;
import com.gotIt.gotshop.repository.BannerRepository;
import com.gotIt.gotshop.service.admin.BannerService;
import com.gotIt.gotshop.utils.ResultVOUtils;
import com.gotIt.gotshop.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResultVO<Map<String, String>> save(BannerForm bannerForm) {
        Map map = new HashMap();
        Banner banner = new Banner();
        try{
            if(bannerForm.getId() !=null){
                banner = bannerRepository.findOne(bannerForm.getId());
            }
            BeanUtils.copyProperties(bannerForm,banner);
            bannerRepository.save(banner);
        }catch (Exception e){
            ResultVOUtils.error(ResultEnum.ERROR.getCode(),e.getMessage());
        }

        map.put("bannerId",banner.getId());
        return ResultVOUtils.success(map);
    }

    @Override
    public Page<Banner> findByPage(String bannerName,Pageable pageable) {

        Page<Banner> bannerPage = bannerRepository.findByBannerNameOrderByUpdateTimeDesc(bannerName, pageable);
        //System.out.println(bannerPage.getContent());
        //return bannerPage;

        return new PageImpl<Banner>(bannerPage.getContent(), pageable, bannerPage.getTotalElements());

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



