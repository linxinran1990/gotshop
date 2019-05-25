package com.gotIt.gotshop.vo;

import com.gotIt.gotshop.enumer.ProductStatus;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

    private String productName;

    private String productInfo;


    private String productImg;


    private BigDecimal productPrice;


    private BigDecimal productOrgPrice;


    private Integer productStock;


    private String productInfoImg;

    private ProductStatus productStatus;

    private String categoryName;

}



