/**
 * 
 */
package com.gotIt.gotshop.security.config;

import com.gotIt.gotshop.security.properties.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/3</pre>
 */
public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	protected AuthenticationSuccessHandler gotshopAuthenticationSuccessHandler;
	
	@Autowired
	protected AuthenticationFailureHandler gotshopAuthenticationFailureHandler;
	
	protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
		http.formLogin()
			.loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
			.loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
			.successHandler(gotshopAuthenticationSuccessHandler)
			.failureHandler(gotshopAuthenticationFailureHandler);
	}
	
}
