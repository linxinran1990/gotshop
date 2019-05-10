package com.gotIt.gotshop.security.social.qq.connect;


import com.gotIt.gotshop.security.social.qq.api.QQ;
import com.gotIt.gotshop.security.social.qq.api.QQImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/3/19</pre>
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

    private String appId;

    private static final String URL_AUTHEN = "https://graph.qq.com/oauth2.0/authorize";

    private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";


    public QQServiceProvider(String appId, String appSecret) {
        super(new QQOAuth2Template(appId,appSecret,URL_AUTHEN,URL_ACCESS_TOKEN));
        this.appId = appId;
    }

    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(accessToken,appId);
    }


}



