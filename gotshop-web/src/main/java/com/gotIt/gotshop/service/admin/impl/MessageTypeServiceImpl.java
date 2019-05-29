package com.gotIt.gotshop.service.admin.impl;

import com.gotIt.gotshop.entity.Coupon;
import com.gotIt.gotshop.entity.MessageType;
import com.gotIt.gotshop.enumer.Status;
import com.gotIt.gotshop.repository.MessageTypeRepository;
import com.gotIt.gotshop.repository.spec.MessageTypeSpec;
import com.gotIt.gotshop.service.admin.MessageTypeService;
import com.gotIt.gotshop.support.AbstractDomain2InfoConverter;
import com.gotIt.gotshop.support.QueryResultConverter;
import com.gotIt.gotshop.utils.ResultVOUtils;
import com.gotIt.gotshop.vo.CouponInfo;
import com.gotIt.gotshop.vo.MessageTypeInfo;
import com.gotIt.gotshop.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
    public ResultVO<Map<String,String>> save(MessageTypeInfo messageTypeInfo) {
        Map map = new HashMap();
        MessageType messageType = new MessageType();
        if(messageTypeInfo.getId()!=null){
            messageType = messageTypeRepository.findOne(messageTypeInfo.getId());
        }
        BeanUtils.copyProperties(messageTypeInfo,messageType);
        messageType.setTypeStatus(Status.USING);
        messageTypeRepository.save(messageType);
        map.put("id",messageType.getId());
        return ResultVOUtils.success(map);
    }

    @Override
    public Page<MessageTypeInfo> findByPage(MessageTypeInfo messageTypeInfo,Pageable pageable) {

        Page<MessageType> messageTypePage = messageTypeRepository.findAll(new MessageTypeSpec(messageTypeInfo),pageable);
        return QueryResultConverter.convert(messageTypePage, pageable, new AbstractDomain2InfoConverter<MessageType, MessageTypeInfo>() {
            @Override
            protected void doConvert(MessageType domain, MessageTypeInfo info) throws Exception {

            }
        });
    }

    @Override
    public Long removeMessageType(Long id) {
         messageTypeRepository.delete(id);
         return id;
    }
}



