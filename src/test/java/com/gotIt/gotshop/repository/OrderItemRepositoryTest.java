package com.gotIt.gotshop.repository;

import com.gotIt.gotshop.BaseTest;
import com.gotIt.gotshop.entity.*;
import com.gotIt.gotshop.enumer.OrderStatus;
import com.gotIt.gotshop.enumer.PayStatus;
import com.gotIt.gotshop.enumer.PayType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@Transactional
public class OrderItemRepositoryTest extends BaseTest{

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserAddressRepository userAddressRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testSave(){
        User user = userRepository.getOne(11L);
        Product product = productRepository.getOne(13L);
        Order order = orderRepository.getOne(15L);


        OrderItem orderItem = new OrderItem();
        orderItem.setOpenid("123456");
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setProductImg(product.getProductImg());
        orderItem.setProductName(product.getProductName());
        orderItem.setProductPrice(product.getProductPrice());
        orderItem.setProductQuantity(12);
        orderItem.setProductPrice(new BigDecimal(234));

        orderItemRepository.save(orderItem);

    }
}