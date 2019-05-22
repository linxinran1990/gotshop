package com.gotIt.gotshop.service.admin;

import com.gotIt.gotshop.entity.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/17</pre>
 */
public interface BannerService {

    List<Banner> findAll();

    Banner save(Banner banner);

    Page<Banner> findByPage(Pageable pageable);

    Long removeBanner(Long bannerId);

    Banner findOne(Long bannerId);
}
