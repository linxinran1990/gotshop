package com.gotIt.gotshop.exception;

import com.gotIt.gotshop.enumer.ResultEnum;
import lombok.Data;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/16</pre>
 */
@Data
public class ServiceException extends RuntimeException {
    private Integer code;

    public ServiceException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public ServiceException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}



