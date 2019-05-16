package com.gotIt.gotshop.utils;

import com.gotIt.gotshop.vo.ResultVO;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/16</pre>
 */
public class ResultVOUtils {

    public static ResultVO success(Object object){
        ResultVO resultVO = new  ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("success");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code ,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        resultVO.setData(null);
        return resultVO;
    }
}



