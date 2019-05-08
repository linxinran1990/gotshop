package com.gotIt.gotshop.repository;

import com.gotIt.gotshop.BaseTest;
import com.gotIt.gotshop.entity.Order;
import com.gotIt.gotshop.entity.User;
import com.gotIt.gotshop.entity.UserAddress;
import com.gotIt.gotshop.enumer.OrderStatus;
import com.gotIt.gotshop.enumer.PayStatus;
import com.gotIt.gotshop.enumer.PayType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Transactional
public class OrderRepositoryTest extends BaseTest{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserAddressRepository userAddressRepository;

    @Autowired
    private UserRepository userRepository;


    @Test
    public void save(){
        User user = userRepository.getOne(11L);
        UserAddress address = userAddressRepository.getOne(14L);

        Order order = new Order();
        order.setAddress(address);
        order.setCouponDeduction(new BigDecimal(0.3));
        order.setOrderAmount(new BigDecimal(119));
        order.setOrderNo(1);
        order.setOrderStatus(OrderStatus.UNPAID);
        order.setPayStatus(PayStatus.UNPAID);
        order.setPayType(PayType.WECHATPAY);
        order.setUser(user);
    }
}