package com.gotIt.gotshop.vo;

import com.gotIt.gotshop.enumer.CouponSituation;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/26</pre>
 */
@Data
public class CouponInfo implements Serializable{

    private Long id;

    @NotEmpty(message = "名称不能为空")
    private String couponName;

    @NotNull(message = "优惠券价格不能为空")
    private BigDecimal couponValue;

    private String couponImg;

    private Date startDate;

    private Date endDate;

    private CouponSituation situation = CouponSituation.COMMON;

    private Date createTime;

    private Date updateTime;
}



