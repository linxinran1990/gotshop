package com.gotIt.gotshop.service.admin.impl;

import com.gotIt.gotshop.entity.MessageType;
import com.gotIt.gotshop.enumer.Status;
import com.gotIt.gotshop.repository.MessageTypeRepository;
import com.gotIt.gotshop.service.admin.MessageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/17</pre>
 */
@Service
public class MessageTypeServiceImpl implements MessageTypeService {

    @Autowired
    private MessageTypeRepository messageTypeRepository;

    @Override
    public MessageType save(MessageType messageType) {
        messageType.setTypeStatus(Status.USING);
        return messageTypeRepository.save(messageType);
    }

    @Override
    public Page<MessageType> findByPage(Pageable pageable) {
        return messageTypeRepository.findAll(pageable);
    }
}



