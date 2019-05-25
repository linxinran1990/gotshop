package com.gotIt.gotshop.service.admin.impl;

import com.gotIt.gotshop.BaseTest;
import com.gotIt.gotshop.entity.Category;
import com.gotIt.gotshop.entity.Product;
import com.gotIt.gotshop.enumer.ProductStatus;
import com.gotIt.gotshop.repository.CategoryRepository;
import com.gotIt.gotshop.vo.ProductInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ProductServiceImplTest extends BaseTest {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void save(){
       Category category = categoryRepository.findByCategoryName("水果");

        Product product = new Product();
        product.setCategory(category);
        product.setProductImg("http:///444");
        product.setProductInfo("商品详情1");
        product.setProductName("香蕉");
        product.setProductOrgPrice(new BigDecimal(10.0));
        product.setProductPrice(new BigDecimal(14));
        product.setProductStatus(ProductStatus.NEW);
        product.setProductStock(1);

        productService.save(product);

    }

    @Test
    public void testFindAll(){
        PageRequest pageable = new PageRequest(0,10);

        Page<ProductInfo> productPage = productService.findByPage(pageable);

        System.out.println(productPage);
    }
}