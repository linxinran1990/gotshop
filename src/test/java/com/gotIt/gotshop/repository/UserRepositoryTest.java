package com.gotIt.gotshop.repository;

import com.gotIt.gotshop.BaseTest;
import com.gotIt.gotshop.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
@Slf4j
@Transactional
public class UserRepositoryTest extends BaseTest{

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSave(){
        User user = new User();
        user.setEmail("fjlinxinran@126.com");
        user.setMobile("19109876567");
        user.setUsername("lilei");

        userRepository.save(user);
    }

    @Test
    public void testQuery(){
       /* User user = userRepository.getOne(11L);
        log.info(user.getEmail());*/

    }
}