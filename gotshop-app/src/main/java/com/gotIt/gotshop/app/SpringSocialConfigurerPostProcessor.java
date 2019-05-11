/**
 * 
 */
package com.gotIt.gotshop.app;

import com.gotIt.gotshop.security.social.GotshopSpringSocialConfigurer;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.social.security.SpringSocialConfigurer;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class SpringSocialConfigurerPostProcessor implements BeanPostProcessor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.config.BeanPostProcessor#
	 * postProcessBeforeInitialization(java.lang.Object, java.lang.String)
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.config.BeanPostProcessor#
	 * postProcessAfterInitialization(java.lang.Object, java.lang.String)
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (StringUtils.equals(beanName, "gotshopSocialSecurityConfig")) {
			GotshopSpringSocialConfigurer configurer = (GotshopSpringSocialConfigurer)bean;
			configurer.signupUrl("/social/signUp");
			return configurer;
		}
		return bean;
	}

}
