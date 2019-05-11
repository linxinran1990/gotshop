/**
 * 
 */
package com.gotIt.gotshop.app.social.impl;

import com.gotIt.gotshop.security.social.SocialAuthenticationFilterPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class AppSocialAuthenticationFilterPostProcessor implements SocialAuthenticationFilterPostProcessor {
	
	@Autowired
	private AuthenticationSuccessHandler gotshopAuthenticationSuccessHandler;

	/* (non-Javadoc)
	 * @see com.imooc.security.core.social.SocialAuthenticationFilterPostProcessor#process(org.springframework.social.security.SocialAuthenticationFilter)
	 */
	@Override
	public void process(SocialAuthenticationFilter socialAuthenticationFilter) {
		socialAuthenticationFilter.setAuthenticationSuccessHandler(gotshopAuthenticationSuccessHandler);
	}

}
