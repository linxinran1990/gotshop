package com.gotIt.gotshop.vo;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/23</pre>
 */
@Data
public class BannerVO {

    private Long id;

    private String bannerName;

    private String bannerImg;

    private Long productId;
}



