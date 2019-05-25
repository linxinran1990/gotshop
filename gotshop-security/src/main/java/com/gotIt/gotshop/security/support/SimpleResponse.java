package com.gotIt.gotshop.security.support;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/3/10</pre>
 */
public class SimpleResponse {

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public SimpleResponse(Object data) {
        this.data = data;
    }
}



