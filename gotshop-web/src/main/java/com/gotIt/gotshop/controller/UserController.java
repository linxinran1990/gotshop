package com.gotIt.gotshop.controller;

import com.gotIt.gotshop.app.social.AppSingUpUtils;
import com.gotIt.gotshop.entity.User;
import com.gotIt.gotshop.security.properties.SecurityProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
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
    private AppSingUpUtils appSingUpUtils;

    @PostMapping("/regist")
    public void regist(User user, HttpServletRequest request){
        String userId = user.getUsername();
        //providerSignInUtils.doPostSignUp(userId,new ServletWebRequest(request));
        appSingUpUtils.doPostSignUp(new ServletWebRequest(request),userId);
    }


    @GetMapping("/me")
    public Object getCurrentUser(Authentication user, HttpServletRequest request) throws UnsupportedEncodingException {
        String token = StringUtils.substringAfter(request.getHeader("Authorization"), "Bearer ");

        Claims claims = Jwts.parser().setSigningKey(securityProperties.getOauth2().getJwtSigningKey().getBytes("UTF-8"))
                .parseClaimsJws(token).getBody();

        String company = (String) claims.get("company");

        System.out.println(company);

        return user;

    }

}



