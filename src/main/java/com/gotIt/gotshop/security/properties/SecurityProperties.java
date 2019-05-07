package com.gotIt.gotshop.security.properties;

import com.gotIt.gotshop.security.validate.code.ValidateCodeFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/3/10</pre>
 */
@ConfigurationProperties(prefix = "gotshop.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    private ValidateCodeProperties code = new ValidateCodeProperties();



    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }
}



