package com.gotIt.gotshop.vo;

import com.gotIt.gotshop.enumer.ProductStatus;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/6/2</pre>
 */
@Data
public class ProductUpdateForm {

    @NotNull(message = "id不能为空")
    private Long id;

    private String productName;

    private String productInfo;

    private String productImg;

    private BigDecimal productPrice;

    private BigDecimal productOrgPrice;


    private Integer productStock;

    private String productInfoImg;

    private ProductStatus productStatus;

    private String categoryName;

    private Long categoryId;
}



