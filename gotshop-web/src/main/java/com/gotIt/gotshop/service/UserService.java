package com.gotIt.gotshop.service;

import com.gotIt.gotshop.entity.User;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/17</pre>
 */
public interface UserService {

    User findById(Long userId);

    User findByName(String userName);
}



