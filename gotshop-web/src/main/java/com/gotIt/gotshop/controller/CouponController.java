package com.gotIt.gotshop.controller;

import com.gotIt.gotshop.app.support.ResultVO;
import com.gotIt.gotshop.app.utils.ResultVOUtils;
import com.gotIt.gotshop.enumer.ResultEnum;
import com.gotIt.gotshop.exception.ServiceException;
import com.gotIt.gotshop.service.admin.CouponService;
import com.gotIt.gotshop.vo.BannerVO;
import com.gotIt.gotshop.vo.CouponInfo;
import com.gotIt.gotshop.vo.CouponUpdateForm;
import org.springframework.beans.BeanUtils;
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
@RequestMapping("/back/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PutMapping
    public ResultVO<Map<String,String>> createCoupon(@Valid @RequestBody CouponInfo couponInfo,
                                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String msg = bindingResult.getFieldError().getDefaultMessage().toString();
            throw new ServiceException(ResultEnum.PARAM_ERROR.getCode(), msg);
        }
        return couponService.save(couponInfo);
    }

    @PostMapping
    public ResultVO<Map<String,String>> updateCoupon(@Valid @RequestBody CouponUpdateForm couponUpdateForm,
                                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String msg = bindingResult.getFieldError().getDefaultMessage().toString();
            throw new ServiceException(ResultEnum.PARAM_ERROR.getCode(), msg);
        }
        CouponInfo couponInfo = new CouponInfo();
        BeanUtils.copyProperties(couponUpdateForm,couponInfo);
        return couponService.save(couponInfo);
    }

    @GetMapping
    public ResultVO<Page<CouponInfo>> findByPage(CouponInfo couponInfo, @RequestParam Integer page,
                                                 @RequestParam Integer size){
        Pageable pageable = new PageRequest(page-1,size);
        Page<CouponInfo> couponInfoPage = couponService.findByPage(couponInfo,pageable);
        return ResultVOUtils.success(couponInfoPage);
    }

    @GetMapping("/{id}")
    public ResultVO<CouponInfo> getOne(@PathVariable Long id){
        CouponInfo couponInfo = couponService.findById(id);
        return ResultVOUtils.success(couponInfo);
    }

    @DeleteMapping
    public ResultVO<Map<String,String>> removeCoupon(Long id){
        Map map = new HashMap();
        Long couponId = couponService.removeCoupon(id);
        map.put("id",couponId);
        return ResultVOUtils.success(map);
    }
}



