/**
 * 
 */
package com.gotIt.gotshop.app;

import com.gotIt.gotshop.app.social.AppSingUpUtils;
import com.gotIt.gotshop.security.support.SocialUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
@RestController
public class AppSecurityController {
	
	@Autowired
	private ProviderSignInUtils providerSignInUtils;
	
	@Autowired
	private AppSingUpUtils appSingUpUtils;
	
	@GetMapping("/social/signUp")
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public SocialUserInfo getSocialUserInfo(HttpServletRequest request) {
		SocialUserInfo userInfo = new SocialUserInfo();
		Connection<?> connection = providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));
		userInfo.setProviderId(connection.getKey().getProviderId());
		userInfo.setProviderUserId(connection.getKey().getProviderUserId());
		userInfo.setNickname(connection.getDisplayName());
		userInfo.setHeadimg(connection.getImageUrl());
		
		appSingUpUtils.saveConnectionData(new ServletWebRequest(request), connection.createData());
		
		return userInfo;
	}

}
