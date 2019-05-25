package com.gotIt.gotshop.app.support;

import lombok.Data;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/16</pre>
 */
@Data
public class ResultVO<T> {

    /** 错误码.*/
    private Integer code;

    /** 提示信息.*/
    private String msg;

    /** 数据.*/
    private T data;
}



