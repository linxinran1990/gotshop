package com.gotIt.gotshop.vo;

import com.gotIt.gotshop.enumer.CategoryStatus;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/26</pre>
 */
@Data
public class CategoryInfo {

    private Long id;

    private Long parentId;

    @NotEmpty(message = "名称不能为空")
    private String categoryName;

    @NotNull(message = "排序不能为空")
    private Integer sortOrder;

    private Date createTime;

    private Date updateTime;

}



