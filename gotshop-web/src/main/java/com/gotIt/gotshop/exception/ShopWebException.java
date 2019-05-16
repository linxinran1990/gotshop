package com.gotIt.gotshop.exception;

import com.gotIt.gotshop.enumer.ResultEnum;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/16</pre>
 */
public class ShopWebException extends RuntimeException {
    private Integer code;

    public ShopWebException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public ShopWebException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}



