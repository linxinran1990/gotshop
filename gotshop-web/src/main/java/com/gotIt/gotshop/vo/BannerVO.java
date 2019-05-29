package com.gotIt.gotshop.vo;

import com.gotIt.gotshop.entity.Product;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    private String productName;

    private Date createTime;

    private Date updateTime;

}



