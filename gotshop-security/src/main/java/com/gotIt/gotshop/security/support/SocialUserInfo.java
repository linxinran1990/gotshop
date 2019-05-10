package com.gotIt.gotshop.security.support;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/3/19</pre>
 */
public class SocialUserInfo {

    private String providerId;

    private String providerUserId;

    private String nickname;

    private String headimg;

    public String getProviderId() {
        return providerId;
    }

    public String getProviderUserId() {
        return providerUserId;
    }

    public String getNickname() {
        return nickname;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public void setProviderUserId(String providerUserId) {
        this.providerUserId = providerUserId;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }
}



