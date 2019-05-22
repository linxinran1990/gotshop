package com.gotIt.gotshop.service.impl;

import com.gotIt.gotshop.entity.User;
import com.gotIt.gotshop.repository.UserRepository;
import com.gotIt.gotshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/22</pre>
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public User findByName(String username) {
        return userRepository.findByUsername(username);
    }
}



