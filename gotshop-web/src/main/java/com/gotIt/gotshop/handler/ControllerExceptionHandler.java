package com.gotIt.gotshop.handler;

import com.gotIt.gotshop.app.MyAppSecretException;
import com.gotIt.gotshop.app.support.ResultVO;
import com.gotIt.gotshop.app.utils.ResultVOUtils;
import com.gotIt.gotshop.enumer.ResultEnum;
import com.gotIt.gotshop.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/23</pre>
 */
@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResultVO handleServiceException(ServiceException ex){
            ex.getLocalizedMessage();
            ex.printStackTrace();
            return ResultVOUtils.error(ex.getCode(),ex.getLocalizedMessage());
    }


    @ExceptionHandler(MyAppSecretException.class)
    @ResponseBody
    public ResultVO handleServiceException(MyAppSecretException ex){
        ex.printStackTrace();
        return ResultVOUtils.error(ex.getCode(),ex.getLocalizedMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultVO handleServiceException(Exception ex){
        ex.printStackTrace();
        return ResultVOUtils.error(ResultEnum.ERROR.getCode(),ResultEnum.ERROR.getMessage());
    }
}



