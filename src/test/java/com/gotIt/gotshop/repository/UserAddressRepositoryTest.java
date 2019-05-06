package com.gotIt.gotshop.repository;

import com.gotIt.gotshop.BaseTest;
import com.gotIt.gotshop.entity.UserAddress;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
@Transactional
public class UserAddressRepositoryTest extends BaseTest{


    @Autowired
    private UserAddressRepository userAddressRepository;

    @Test
    public void save(){
        UserAddress address = new UserAddress();
        address.setReceiverAddress("羊村");
        address.setReceiverHouseNo("110");
        address.setReceiverLatitude("N45");
        address.setReceiverLongitude("W23");
        userAddressRepository.save(address);

    }
}