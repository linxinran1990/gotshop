package com.gotIt.gotshop.security.config;

import com.gotIt.gotshop.security.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/6</pre>
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
}



