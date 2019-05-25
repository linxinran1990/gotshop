package com.gotIt.gotshop.controller;

import com.gotIt.gotshop.app.social.AppSingUpUtils;
import com.gotIt.gotshop.entity.User;
import com.gotIt.gotshop.security.properties.SecurityProperties;
import com.gotIt.gotshop.service.UserService;
import com.gotIt.gotshop.utils.ResultVOUtils;
import com.gotIt.gotshop.vo.ResultVO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.Parameter;
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
    public ResultVO<User> getCurrentUser(Authentication authentication, HttpServletRequest request) throws UnsupportedEncodingException {
       String userName = authentication.getName();
       User user = userService.findByName(userName);

        return ResultVOUtils.success(user);
    }

    @PostMapping("/refresh/token")
    public ResultVO<OAuth2AccessToken> refreshToken(Authentication authentication,
                                                    @RequestParam("clientId")String clientId,
                                                    @RequestParam("clientSecret")String clientSecret) throws IOException {

        ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);

        if (clientDetails == null) {
            throw new UnapprovedClientAuthenticationException("clientId对应的配置信息不存在:" + clientId);
        } else if (!org.apache.commons.codec.binary.StringUtils.equals(clientDetails.getClientSecret(), clientSecret)) {
            throw new UnapprovedClientAuthenticationException("clientSecret不匹配:" + clientId);
        }

        TokenRequest tokenRequest = new TokenRequest(MapUtils.EMPTY_MAP, clientId, clientDetails.getScope(), "custom");

        OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);

        OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request, authentication);

        OAuth2AccessToken token = authorizationServerTokenServices.createAccessToken(oAuth2Authentication);

        return ResultVOUtils.success(token);
    }


    private String[] extractAndDecodeHeader(String header, HttpServletRequest request) throws IOException {

        byte[] base64Token = header.substring(6).getBytes("UTF-8");
        byte[] decoded;
        try {
            decoded = Base64.decode(base64Token);
        } catch (IllegalArgumentException e) {
            throw new BadCredentialsException("Failed to decode basic authentication token");
        }

        String token = new String(decoded, "UTF-8");

        int delim = token.indexOf(":");

        if (delim == -1) {
            throw new BadCredentialsException("Invalid basic authentication token");
        }
        return new String[] { token.substring(0, delim), token.substring(delim + 1) };
    }
}



