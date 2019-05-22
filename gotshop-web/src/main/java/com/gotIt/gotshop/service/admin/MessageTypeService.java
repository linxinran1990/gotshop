package com.gotIt.gotshop.service.admin;

import com.gotIt.gotshop.entity.MessageType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MessageTypeService {

    MessageType save(MessageType messageType);

    Page<MessageType> findByPage(Pageable pageable);
}
