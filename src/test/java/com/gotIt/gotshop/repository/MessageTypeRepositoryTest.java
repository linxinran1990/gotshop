package com.gotIt.gotshop.repository;

import com.gotIt.gotshop.BaseTest;
import com.gotIt.gotshop.entity.MessageType;
import com.gotIt.gotshop.enumer.Status;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
@Transactional
public class MessageTypeRepositoryTest extends BaseTest{

    @Autowired
    private MessageTypeRepository messageTypeRepository;

    @Test
    public void testSave(){
        MessageType messageType = new MessageType();
        messageType.setTypeInfo("新品上市");
        messageType.setTypeName("New Product");
        messageType.setTypeStatus(Status.USING);

        messageTypeRepository.save(messageType);
    }


}