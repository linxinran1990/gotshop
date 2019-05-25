package com.gotIt.gotshop.service.admin;

import com.gotIt.gotshop.entity.Banner;
import com.gotIt.gotshop.form.BannerForm;
import com.gotIt.gotshop.vo.BannerVO;
import com.gotIt.gotshop.vo.ResultVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/17</pre>
 */
public interface BannerService {

    List<Banner> findAll();

    ResultVO<Map<String, String>> save(BannerForm bannerForm);

    Page<Banner> findByPage(String bannerName, Pageable pageRequest);

    Long removeBanner(Long bannerId);

    Banner findOne(Long bannerId);
}
