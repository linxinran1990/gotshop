package com.gotIt.gotshop.security.properties;

//我去掉以后，这里继承的是你写的SocialProperties


import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/3/19</pre>
 */
public class QQProperties extends SocialProperties {

    private String providerId = "/call";

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}



