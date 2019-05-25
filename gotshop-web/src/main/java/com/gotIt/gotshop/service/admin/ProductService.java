package com.gotIt.gotshop.service.admin;

import com.gotIt.gotshop.entity.Product;
import com.gotIt.gotshop.vo.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Product save(Product product);

    Page<ProductInfo> findByPage(Pageable pageable);

    Long removeProduct(Long productId);
}
