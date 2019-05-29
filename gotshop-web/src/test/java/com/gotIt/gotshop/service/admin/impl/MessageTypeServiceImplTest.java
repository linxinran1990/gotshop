package com.gotIt.gotshop.service.admin.impl;

import com.gotIt.gotshop.BaseTest;
import com.gotIt.gotshop.entity.MessageType;
import com.gotIt.gotshop.enumer.Status;
import com.gotIt.gotshop.service.admin.MessageTypeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class MessageTypeServiceImplTest extends BaseTest{

    @Autowired
    private MessageTypeServiceImpl messageTypeService;

    @Test
    public void save(){
        MessageType messageType = new MessageType();
        messageType.setTypeInfo("新品上市");
        messageType.setTypeName("New Product");

        //messageTypeService.save(messageType);

    }
}