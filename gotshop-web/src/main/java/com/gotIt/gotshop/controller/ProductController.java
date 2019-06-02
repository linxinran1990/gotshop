package com.gotIt.gotshop.controller;

import com.gotIt.gotshop.app.support.ResultVO;
import com.gotIt.gotshop.app.utils.ResultVOUtils;
import com.gotIt.gotshop.entity.Product;
import com.gotIt.gotshop.enumer.ResultEnum;
import com.gotIt.gotshop.exception.ServiceException;
import com.gotIt.gotshop.service.admin.ProductService;
import com.gotIt.gotshop.vo.BannerVO;
import com.gotIt.gotshop.vo.ProductInfo;
import com.gotIt.gotshop.vo.ProductUpdateForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.sql.rowset.serial.SerialException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/24</pre>
 */
@RestController
@RequestMapping("/back/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResultVO<Page<ProductInfo>> getBanner(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                 @RequestParam(value = "size", defaultValue = "10") Integer size){
        PageRequest pageRequest = new PageRequest(page-1,size);
        Page<ProductInfo> productInfos = productService.findByPage(pageRequest);

        return ResultVOUtils.success(productInfos);
    }

    @PutMapping
    public ResultVO<Map<String,String>> createProduct(@Valid @RequestBody ProductInfo productInfo,
                                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ServiceException(ResultEnum.PARAM_ERROR);
        }

        return productService.save(productInfo);
    }

    @PostMapping
    public ResultVO<Map<String,String>> updateProduct(@Valid @RequestBody ProductUpdateForm productUpdateForm,
                                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ServiceException(ResultEnum.PARAM_ERROR);
        }
        ProductInfo productInfo = new ProductInfo();
        BeanUtils.copyProperties(productUpdateForm,productInfo);
        return productService.save(productInfo);
    }

    @GetMapping("/{id}")
    public ResultVO<ProductInfo> getOne(@PathVariable Long id){
        ProductInfo productInfo = productService.findById(id);
        return ResultVOUtils.success(productInfo);
    }

    @DeleteMapping
    public ResultVO<Map<String,String>> removeProduct(Long id){
        Map map = new HashMap();
        Long productId = productService.removeProduct(id);
        map.put("id",productId);
        return ResultVOUtils.success(map);
    }
}



