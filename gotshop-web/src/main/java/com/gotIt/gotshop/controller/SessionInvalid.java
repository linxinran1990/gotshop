package com.gotIt.gotshop.controller;

import com.gotIt.gotshop.security.support.SimpleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/10</pre>
 */
@RestController
@RequestMapping("/session")
public class SessionInvalid {

    @GetMapping("invalid")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleResponse sessionInvalid(){
        return new SimpleResponse("session 失效");
    }

}



