package com.gotIt.gotshop.security.validate.code;

import com.gotIt.gotshop.security.validate.code.Image.ImageCode;
import org.springframework.web.context.request.ServletWebRequest;


/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/3/22</pre>
 */
public interface ValidateCodeGenerator {

    ValidateCode generate(ServletWebRequest request);
}



