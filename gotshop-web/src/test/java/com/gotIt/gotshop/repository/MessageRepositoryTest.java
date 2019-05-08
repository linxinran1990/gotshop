package com.gotIt.gotshop.repository;

import com.gotIt.gotshop.BaseTest;
import com.gotIt.gotshop.entity.Message;
import com.gotIt.gotshop.enumer.MessageStatus;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MessageRepositoryTest extends BaseTest{

    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void testSave(){
        Message message = new Message();

        message.setMessageContent("今日新品");
        message.setMessageStatus(MessageStatus.UNREAD);
        message.setMessageTitle("新鲜上市");
        messageRepository.save(message);

    }



}