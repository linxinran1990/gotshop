package com.gotIt.gotshop.vo;

import com.gotIt.gotshop.enumer.ProductStatus;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/25</pre>
 */
@Data
public class ProductInfo implements Serializable {

    private Long id;

    @NotEmpty(message = "名称不能为空")
    private String productName;

    private String productInfo;


    private String productImg;

    @NotNull(message = "商品价格不能为空")
    private BigDecimal productPrice;

    @NotNull(message = "productOrgPrice不能为空")
    private BigDecimal productOrgPrice;


    private Integer productStock;

    private String productInfoImg;

    private ProductStatus productStatus;

    private String categoryName;

    @NotNull(message = "categoryId不能为空")
    private Long categoryId;

}



