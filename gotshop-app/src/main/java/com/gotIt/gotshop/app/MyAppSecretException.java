package com.gotIt.gotshop.app;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/29</pre>
 */
public class MyAppSecretException extends RuntimeException {

    private Integer code;

    public MyAppSecretException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}



