package com.gotIt.gotshop.controller;

import com.gotIt.gotshop.entity.Product;
import com.gotIt.gotshop.service.admin.ProductService;
import com.gotIt.gotshop.utils.ResultVOUtils;
import com.gotIt.gotshop.vo.BannerVO;
import com.gotIt.gotshop.vo.ProductInfo;
import com.gotIt.gotshop.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

        PageRequest pageRequest = new PageRequest(page,size);
        Page<ProductInfo> productInfos = productService.findByPage(pageRequest);

        return ResultVOUtils.success(productInfos);
    }
}



