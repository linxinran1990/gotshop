package com.gotIt.gotshop.security.validate;

import com.gotIt.gotshop.security.properties.SecurityProperties;
import com.gotIt.gotshop.security.validate.code.Image.ImageCodeGenerator;
import com.gotIt.gotshop.security.validate.code.ValidateCodeGenerator;
import com.gotIt.gotshop.security.validate.code.sms.DefaultSmsCodeSender;
import com.gotIt.gotshop.security.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Action;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/6</pre>
 */
@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imgeCodeGenerator(){
        ImageCodeGenerator generator = new ImageCodeGenerator();
        generator.setSecurityProperties(securityProperties);
        return generator;
    }


    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender(){
       return new DefaultSmsCodeSender();
    }
}



