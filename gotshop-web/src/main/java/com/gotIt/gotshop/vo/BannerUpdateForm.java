package com.gotIt.gotshop.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/6/2</pre>
 */
@Data
public class BannerUpdateForm {

    @NotNull(message = "id不能为空")
    private Long id;

    private String bannerName;

    private String bannerImg;

    private Long productId;

    private String productName;
}



