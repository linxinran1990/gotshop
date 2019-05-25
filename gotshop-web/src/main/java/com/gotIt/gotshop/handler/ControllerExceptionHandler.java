package com.gotIt.gotshop.handler;

import com.gotIt.gotshop.exception.ServiceException;
import com.gotIt.gotshop.utils.ResultVOUtils;
import com.gotIt.gotshop.vo.ResultVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/23</pre>
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResultVO handleServiceException(ServiceException ex){
            return ResultVOUtils.error(ex.getCode(),ex.getLocalizedMessage());
    }

}



