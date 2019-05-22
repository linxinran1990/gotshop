package com.gotIt.gotshop.service.admin.impl;

import com.gotIt.gotshop.entity.Category;
import com.gotIt.gotshop.entity.Product;
import com.gotIt.gotshop.enumer.CategoryStatus;
import com.gotIt.gotshop.enumer.ProductStatus;
import com.gotIt.gotshop.enumer.ResultEnum;
import com.gotIt.gotshop.exception.ShopWebException;
import com.gotIt.gotshop.repository.ProductRepository;
import com.gotIt.gotshop.service.admin.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/17</pre>
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public Product save(Product product) {
        Category category = product.getCategory();
        if(category.getCategoryStatus().equals(CategoryStatus.ineffective)){
            throw new ShopWebException(ResultEnum.CATEGORY_INEFFECTIVE);
        }
        product.setProductStatus(ProductStatus.NEW);
        return  repository.save(product);
    }

    @Override
    public Page<Product> findByPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Long removeProduct(Long productId) {
        repository.delete(productId);
        return productId;
    }
}



