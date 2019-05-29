package com.gotIt.gotshop.service.admin.impl;

import com.gotIt.gotshop.entity.Banner;
import com.gotIt.gotshop.entity.Product;
import com.gotIt.gotshop.enumer.ResultEnum;
import com.gotIt.gotshop.enumer.Status;
import com.gotIt.gotshop.exception.ServiceException;
import com.gotIt.gotshop.form.BannerForm;
import com.gotIt.gotshop.repository.BannerRepository;
import com.gotIt.gotshop.repository.ProductRepository;
import com.gotIt.gotshop.repository.spec.BannerSpec;
import com.gotIt.gotshop.service.admin.BannerService;
import com.gotIt.gotshop.support.AbstractDomain2InfoConverter;
import com.gotIt.gotshop.support.QueryResultConverter;
import com.gotIt.gotshop.utils.ResultVOUtils;
import com.gotIt.gotshop.vo.BannerInfo;
import com.gotIt.gotshop.vo.BannerVO;
import com.gotIt.gotshop.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @Autowired
    private ProductRepository productRepository;

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
        if(bannerForm.getId() !=null){
                banner = bannerRepository.findOne(bannerForm.getId());
        }

        BeanUtils.copyProperties(bannerForm,banner);
        banner.setBannerStatus(Status.USING);
        Long productId  = bannerForm.getProductId();
        Product product = productRepository.getOne(productId);
        if(product == null){
                throw new ServiceException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        banner.setProduct(product);
        bannerRepository.save(banner);

        map.put("id",banner.getId());
        return ResultVOUtils.success(map);
    }

    @Override
    public Page<BannerVO> findByPage(BannerVO bannerCondition, Pageable pageable) {

        Page<Banner> bannerPage = bannerRepository.findAll(new BannerSpec(bannerCondition),pageable);
        return QueryResultConverter.convert(bannerPage, pageable, new AbstractDomain2InfoConverter<Banner, BannerVO>() {
            @Override
            protected void doConvert(Banner domain, BannerVO info) throws Exception {
                info.setProductName(domain.getProduct().getProductName());
                info.setProductId(domain.getProduct().getId());
            }
        });
    }

    @Override
    public ResultVO<Map<String, String>> removeBanner(Long bannerId) {
        Map map = new HashMap();
        try {
            bannerRepository.delete(bannerId);
        }catch (Exception e){
            log.error(e.getStackTrace().toString());
            throw new ServiceException(ResultEnum.DELETE_NOT_EXIST);
        }

       map.put("id",bannerId);
        return ResultVOUtils.success(map);
    }

    @Override
    public Banner findOne(Long bannerId) {
        return bannerRepository.findOne(bannerId);
    }
}



