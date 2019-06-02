package com.gotIt.gotshop.vo;

import com.gotIt.gotshop.enumer.CouponSituation;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/6/2</pre>
 */
@Data
public class CouponUpdateForm {

    @NotNull(message = "id不能为空")
    private Long id;

    private String couponName;

    private BigDecimal couponValue;

    private String couponImg;

    private Date startDate;

    private Date endDate;

    private CouponSituation situation;
}



