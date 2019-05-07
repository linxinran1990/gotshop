package com.gotIt.gotshop.security.validate;


import com.gotIt.gotshop.aspect.ServiceLog;
import com.gotIt.gotshop.security.properties.SecurityProperties;
import com.gotIt.gotshop.security.validate.code.Image.ImageCode;
import com.gotIt.gotshop.security.validate.code.ValidateCode;
import com.gotIt.gotshop.security.validate.code.ValidateCodeGenerator;
import com.gotIt.gotshop.security.validate.code.ValidateCodeProcessor;
import com.gotIt.gotshop.security.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/3/10</pre>
 */
@RestController
public class ValidateCodeController {

    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE   ";

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private Map<String,ValidateCodeProcessor> validateCodeProcessor;
/*
    @GetMapping("/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ImageCode imageCode = (ImageCode) validateCodeGenerator.generate(new ServletWebRequest(request));
        sessionStrategy.setAttribute(new ServletWebRequest(request),SESSION_KEY,imageCode);
        ImageIO.write(imageCode.getImage(),"JPEG",response.getOutputStream());
    }


    @GetMapping("/code/sms")
    public void createSmsCode(HttpServletRequest request,HttpServletResponse response) throws ServletRequestBindingException {
        ValidateCode smsCode = smsCodeGenerator.generate(new ServletWebRequest(request));
        sessionStrategy.setAttribute(new ServletWebRequest(request),SESSION_KEY,smsCode);
        String mobile = ServletRequestUtils.getRequiredStringParameter(request,"mobile");
        smsCodeSender.send(mobile,smsCode.getCode());
    }*/

    @ServiceLog
    @GetMapping("/code/{type}")
    public void createCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) throws Exception {
        validateCodeProcessor.get(type+"ValidateCodeProcessor").create(new ServletWebRequest(request,response));
    }


}



