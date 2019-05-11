/**
 * 
 */
package com.gotIt.gotshop.security.social;

import org.springframework.social.security.SocialAuthenticationFilter;

/**
 * @author zhailiang
 *
 */
public interface SocialAuthenticationFilterPostProcessor {
	
	void process(SocialAuthenticationFilter socialAuthenticationFilter);

}
