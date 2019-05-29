package com.gotIt.gotshop.vo;

import com.gotIt.gotshop.enumer.Status;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.util.Date;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/26</pre>
 */
@Data
public class MessageTypeInfo implements Serializable {

    private Long id;

   @NotEmpty(message = "名称不能为空")
    private String typeName;

    @NotEmpty(message = "消息内容不能为空")
    private String typeInfo;

    private Status typeStatus;

    private Date createTime;

    private Date updateTime;
}



