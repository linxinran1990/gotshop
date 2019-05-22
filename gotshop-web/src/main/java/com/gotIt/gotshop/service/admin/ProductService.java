package com.gotIt.gotshop.service.admin;

import com.gotIt.gotshop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Product save(Product product);

    Page<Product> findByPage(Pageable pageable);

    Long removeProduct(Long productId);
}
