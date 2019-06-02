package com.gotIt.gotshop.vo;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/6/2</pre>
 */
@Data
public class CategoryUpdateForm {

    @NotNull(message = "id不能为空")
    private Long id;

    private Long parentId;

    private String categoryName;

    private Integer sortOrder;

    private Date createTime;

    private Date updateTime;
}



