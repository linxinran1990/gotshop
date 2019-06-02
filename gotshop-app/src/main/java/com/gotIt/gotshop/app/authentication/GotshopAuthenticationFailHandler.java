package com.gotIt.gotshop.app.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.gotIt.gotshop.app.enumer.ResultEnum;
import com.gotIt.gotshop.app.utils.ResultVOUtils;
import com.gotIt.gotshop.security.enumer.LoginType;
import com.gotIt.gotshop.security.properties.SecurityProperties;
import com.gotIt.gotshop.security.support.SimpleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/3/10</pre>
 */
@Component("gotshopAuthenticationFailHandler")
@Slf4j
public class GotshopAuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.info("登录失败");
        if(LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
            log.info("json");
            response.setStatus(HttpStatus.OK.value());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(ResultVOUtils.error(ResultEnum.LOGIN_FAIL.getCode(),ResultEnum.LOGIN_FAIL.getMessage())));
            log.info(exception.toString());
        }else{
            log.info(exception.toString());
            super.onAuthenticationFailure(request,response,exception);
        }
    }
}



