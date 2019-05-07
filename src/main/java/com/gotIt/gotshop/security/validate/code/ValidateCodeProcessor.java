/**
 * 
 */
package com.gotIt.gotshop.security.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/3/10</pre>
 */
public interface ValidateCodeProcessor {

	 String SESSION_KEY_PREFIX = "SESSION_";

	/**
	 * 创建校验码
	 * 
	 * @param request
	 * @throws Exception
	 */
	void create(ServletWebRequest request) throws Exception;

	/**
	 * 校验验证码
	 *
	 * @param servletWebRequest
	 * @throws Exception
	 */
	void validate(ServletWebRequest servletWebRequest);

}
