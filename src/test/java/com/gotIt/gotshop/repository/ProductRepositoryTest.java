package com.gotIt.gotshop.repository;

import com.gotIt.gotshop.BaseTest;
import com.gotIt.gotshop.entity.Category;
import com.gotIt.gotshop.entity.Product;
import com.gotIt.gotshop.enumer.ProductStatus;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@Transactional
public class ProductRepositoryTest extends BaseTest{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testSave(){
        Category category = categoryRepository.getOne(7L);

        Product product = new Product();
        product.setCategory(category);
        product.setProductImg("http:///444");
        product.setProductInfo("商品详情");
        product.setProductName("买到的苹果");
        product.setProductOrgPrice(new BigDecimal(12.0));
        product.setProductPrice(new BigDecimal(18));
        product.setProductStatus(ProductStatus.NEW);
        product.setProductStock(1);

        productRepository.save(product);
    }
}