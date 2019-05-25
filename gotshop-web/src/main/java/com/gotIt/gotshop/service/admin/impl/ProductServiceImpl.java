package com.gotIt.gotshop.service.admin.impl;

import com.gotIt.gotshop.entity.Category;
import com.gotIt.gotshop.entity.Product;
import com.gotIt.gotshop.enumer.CategoryStatus;
import com.gotIt.gotshop.enumer.ProductStatus;
import com.gotIt.gotshop.enumer.ResultEnum;
import com.gotIt.gotshop.exception.ServiceException;
import com.gotIt.gotshop.repository.ProductRepository;
import com.gotIt.gotshop.service.admin.ProductService;
import com.gotIt.gotshop.support.AbstractDomain2InfoConverter;
import com.gotIt.gotshop.support.QueryResultConverter;
import com.gotIt.gotshop.vo.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

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
            throw new ServiceException(ResultEnum.CATEGORY_INEFFECTIVE);
        }
        product.setProductStatus(ProductStatus.NEW);
        return  repository.save(product);
    }

    @Override
    public Page<ProductInfo> findByPage(Pageable pageable) {
        Page<Product> productPage = repository.findAll(pageable);
        return QueryResultConverter.convert(productPage, pageable, new AbstractDomain2InfoConverter<Product, ProductInfo>() {
            @Override
            protected void doConvert(Product domain, ProductInfo info) throws Exception {
                info.setCategoryName(domain.getCategory().getCategoryName());
            }
        });

    }

    @Override
    public Long removeProduct(Long productId) {
        repository.delete(productId);
        return productId;
    }
}



