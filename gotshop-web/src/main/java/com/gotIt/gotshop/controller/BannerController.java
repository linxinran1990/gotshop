package com.gotIt.gotshop.controller;

import com.gotIt.gotshop.app.support.ResultVO;
import com.gotIt.gotshop.app.utils.ResultVOUtils;
import com.gotIt.gotshop.entity.Banner;
import com.gotIt.gotshop.enumer.ResultEnum;
import com.gotIt.gotshop.exception.ServiceException;
import com.gotIt.gotshop.form.BannerForm;
import com.gotIt.gotshop.service.admin.BannerService;
import com.gotIt.gotshop.vo.BannerUpdateForm;
import com.gotIt.gotshop.vo.BannerVO;
import com.gotIt.gotshop.vo.CategoryInfo;
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
@RequestMapping("/back/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @PutMapping
    public ResultVO<Map<String, String>> createBanner(@Valid @RequestBody BannerForm bannerForm,
                                                    BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String msg = bindingResult.getFieldError().getDefaultMessage().toString();
            throw new ServiceException(ResultEnum.PARAM_ERROR.getCode(), msg);
        }
        ResultVO<Map<String, String>> save = bannerService.save(bannerForm);
        return save;
    }

    @PostMapping()
    public ResultVO<Map<String, String>> updateBanner(@Valid @RequestBody BannerUpdateForm bannerUpdateForm,
                                                    BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String msg = bindingResult.getFieldError().getDefaultMessage().toString();
            throw new ServiceException(ResultEnum.PARAM_ERROR.getCode(), msg);
        }
        BannerForm bannerForm = new BannerForm();
        BeanUtils.copyProperties(bannerUpdateForm,bannerForm);
        ResultVO<Map<String, String>> save = bannerService.save(bannerForm);
        return save;
    }

    @GetMapping("/{id}")
    public ResultVO<BannerVO> getOne(@PathVariable Long id){
        BannerVO bannerVO = bannerService.findOne(id);
        return ResultVOUtils.success(bannerVO);
    }


    @GetMapping
    public ResultVO<Page<BannerVO>>  getBanner(BannerVO bannerCondition,
                                               @RequestParam Integer page,
                                               @RequestParam Integer size){
        Pageable pageable = new PageRequest(page-1,size);
        Page<BannerVO> banners = bannerService.findByPage(bannerCondition, pageable);
         return ResultVOUtils.success(banners);
    }

    @DeleteMapping
    public ResultVO<Map<String,String>> removeBanner(Long id){
       return bannerService.removeBanner(id);
    }
}



