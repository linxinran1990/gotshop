package com.gotIt.gotshop.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.gotIt.gotshop.app.social.AppSingUpUtils;
import com.gotIt.gotshop.entity.User;
import com.gotIt.gotshop.security.properties.SecurityProperties;
import com.gotIt.gotshop.service.UserService;
import com.gotIt.gotshop.utils.ResultVOUtils;
import com.gotIt.gotshop.vo.ResultVO;
import com.gotIt.gotshop.vo.UserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/9</pre>
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private AuthorizationServerTokenServices authorizationServerTokenServices;

    @Autowired
    private AppSingUpUtils appSingUpUtils;

    @Autowired
    private UserService userService;

    @PostMapping("/regist")
    public void regist(User user, HttpServletRequest request){
        String userId = user.getUsername();
        //providerSignInUtils.doPostSignUp(userId,new ServletWebRequest(request));
        appSingUpUtils.doPostSignUp(new ServletWebRequest(request),userId);
    }


    @GetMapping("/me")
    //@JsonView(UserInfo.UserListView.class)
    public ResultVO<UserInfo> getCurrentUser(Authentication authentication, HttpServletRequest request) throws UnsupportedEncodingException {
       String userName = authentication.getName();
       User user = userService.findByName(userName);
       UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(user,userInfo);
        return ResultVOUtils.success(userInfo);
    }

}



