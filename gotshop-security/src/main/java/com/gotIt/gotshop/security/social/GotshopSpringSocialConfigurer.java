package com.gotIt.gotshop.security.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;



/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/3/19</pre>
 */
public class GotshopSpringSocialConfigurer extends SpringSocialConfigurer {

    private String filterProcessesUrl;

    public GotshopSpringSocialConfigurer(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
        filter.setFilterProcessesUrl(filterProcessesUrl);
        return (T) filter;
    }
}



