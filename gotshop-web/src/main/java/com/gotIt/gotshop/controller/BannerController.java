package com.gotIt.gotshop.controller;

import com.gotIt.gotshop.entity.Banner;
import com.gotIt.gotshop.enumer.ResultEnum;
import com.gotIt.gotshop.exception.ShopWebException;
import com.gotIt.gotshop.form.BannerForm;
import com.gotIt.gotshop.service.admin.BannerService;
import com.gotIt.gotshop.utils.ResultVOUtils;
import com.gotIt.gotshop.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/21</pre>
 */
@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @PostMapping("/save")
    public ResultVO<Map<String, String>> saveBanner(@Valid BannerForm bannerForm,
                                        BindingResult bindingResult,
                                            Map<String, Object> map){
        if(bindingResult.hasErrors()){
            String msg = bindingResult.getFieldError().getDefaultMessage().toString();
            throw new ShopWebException(ResultEnum.PARAM_ERROR.getCode(), msg);
        }

        Banner banner = new Banner();
        try{
            if(bannerForm.getId() !=null){
                banner = bannerService.findOne(bannerForm.getId());
            }
            BeanUtils.copyProperties(bannerForm,banner);
            bannerService.save(banner);
        }catch (Exception e){
            ResultVOUtils.error(ResultEnum.ERROR.getCode(),e.getMessage());
        }

        map.put("bannerId",banner.getId());
        return ResultVOUtils.success(map);
    }
}



