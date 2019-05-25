package com.gotIt.gotshop.controller;

import com.gotIt.gotshop.entity.Banner;
import com.gotIt.gotshop.enumer.ResultEnum;
import com.gotIt.gotshop.exception.ServiceException;
import com.gotIt.gotshop.form.BannerForm;
import com.gotIt.gotshop.service.admin.BannerService;
import com.gotIt.gotshop.utils.ResultVOUtils;
import com.gotIt.gotshop.vo.BannerVO;
import com.gotIt.gotshop.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/21</pre>
 */
@RestController
@RequestMapping("/back")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @PostMapping("/banner")
    public ResultVO<Map<String, String>> saveBanner(@Valid @RequestBody BannerForm bannerForm,
                                        BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String msg = bindingResult.getFieldError().getDefaultMessage().toString();
            throw new ServiceException(ResultEnum.PARAM_ERROR.getCode(), msg);
        }
        return bannerService.save(bannerForm);
    }

    @GetMapping("/banner")
    public ResultVO<Page<BannerVO>>  getBanner(@RequestParam("bannerName") String bannerName,
                                               @RequestParam(value = "page", defaultValue = "0") Integer page,
                                               @RequestParam(value = "size", defaultValue = "10") Integer size){

        PageRequest pageRequest = new PageRequest(page,size);
        Page<Banner> banners = bannerService.findByPage(bannerName, pageRequest);

         return ResultVOUtils.success(banners);
    }

}



