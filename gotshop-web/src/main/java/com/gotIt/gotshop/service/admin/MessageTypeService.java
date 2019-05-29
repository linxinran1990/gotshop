package com.gotIt.gotshop.service.admin;

import com.gotIt.gotshop.entity.MessageType;
import com.gotIt.gotshop.vo.MessageTypeInfo;
import com.gotIt.gotshop.vo.ResultVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface MessageTypeService {

    ResultVO<Map<String,String>> save(MessageTypeInfo messageTypeInfo);

    Page<MessageTypeInfo> findByPage(MessageTypeInfo messageTypeInfo,Pageable pageable);

    Long removeMessageType(Long id);
}
