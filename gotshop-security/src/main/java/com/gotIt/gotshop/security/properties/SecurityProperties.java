package com.gotIt.gotshop.security.properties;

import com.gotIt.gotshop.security.social.SocialProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/3/10</pre>
 */
@ConfigurationProperties(prefix = "gotshop.security")
@Data
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    private ValidateCodeProperties code = new ValidateCodeProperties();

    private SocialProperties social = new SocialProperties();

    private OAuth2Properties Oauth2 = new OAuth2Properties();

}



