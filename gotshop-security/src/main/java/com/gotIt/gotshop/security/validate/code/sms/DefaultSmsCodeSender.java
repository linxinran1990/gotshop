package com.gotIt.gotshop.security.validate.code.sms;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/3/23</pre>
 */
public class DefaultSmsCodeSender implements SmsCodeSender {


    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机:"+mobile+"发送验证码:"+code);
    }
}



