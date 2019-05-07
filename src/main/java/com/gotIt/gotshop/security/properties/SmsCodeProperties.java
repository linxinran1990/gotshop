package com.gotIt.gotshop.security.properties;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/3/23</pre>
 */
public class SmsCodeProperties {


    private int length = 4;

    private int expireIn = 60;

    private String url;


    public int getLength() {
        return length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public String getUrl() {
        return url;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}



