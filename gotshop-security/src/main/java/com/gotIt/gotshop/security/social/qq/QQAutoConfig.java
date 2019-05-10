package com.gotIt.gotshop.security.social.qq;


import com.gotIt.gotshop.security.properties.QQProperties;
import com.gotIt.gotshop.security.properties.SecurityProperties;
import com.gotIt.gotshop.security.social.qq.connect.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.social.connect.ConnectionFactory;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/3/19</pre>
 */
@Configuration
@ConditionalOnProperty(prefix = "gotshop.security.social.qq" , name = "app-id")
@Order(2)
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        QQProperties qqProperties = securityProperties.getSocial().getQq();
        return new QQConnectionFactory(qqProperties.getProviderId(),qqProperties.getAppId(),qqProperties.getAppSecret());
    }
}



