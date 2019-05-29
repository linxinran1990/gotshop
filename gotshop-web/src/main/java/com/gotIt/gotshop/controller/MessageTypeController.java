package com.gotIt.gotshop.controller;

import com.gotIt.gotshop.enumer.ResultEnum;
import com.gotIt.gotshop.exception.ServiceException;
import com.gotIt.gotshop.service.admin.MessageTypeService;
import com.gotIt.gotshop.utils.ResultVOUtils;
import com.gotIt.gotshop.vo.MessageTypeInfo;
import com.gotIt.gotshop.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/26</pre>
 */
@RestController
@RequestMapping("/back/messageType")
public class MessageTypeController {

    @Autowired
    private MessageTypeService messageTypeService;

    @PostMapping
    public ResultVO<Map<String,String>> save(@Valid @RequestBody MessageTypeInfo messageTypeInfo,
                                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ServiceException(ResultEnum.PARAM_ERROR);
        }

        return messageTypeService.save(messageTypeInfo);
    }


    @GetMapping
    public ResultVO<Page<MessageTypeInfo>> findByPage(MessageTypeInfo messageTypeInfo,@RequestParam Integer page,
                                                      @RequestParam Integer size){
        Pageable pageable = new PageRequest(page-1,size);
        Page<MessageTypeInfo> messageTypeInfoPage = messageTypeService.findByPage(messageTypeInfo,pageable);
        return ResultVOUtils.success(messageTypeInfoPage);
    }

    @DeleteMapping
    public ResultVO<Map<String,String>> removeMessageType(Long id){
        Map map = new HashMap();
        Long messageTypeId = messageTypeService.removeMessageType(id);
        map.put("id",messageTypeId);
        return ResultVOUtils.success(map);
    }
}



