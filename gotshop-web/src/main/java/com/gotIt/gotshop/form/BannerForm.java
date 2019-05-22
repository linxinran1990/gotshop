package com.gotIt.gotshop.form;

import com.gotIt.gotshop.entity.Product;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.OneToOne;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/21</pre>
 */
@Data
public class BannerForm {

    private Long id;

    @NotEmpty(message = "名称不能为空")
    private String bannerName;

    private String bannerImg;

    @NotEmpty(message = "产品Id不能为空")
    private Long productId;
}



