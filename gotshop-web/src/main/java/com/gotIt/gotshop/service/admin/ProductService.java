package com.gotIt.gotshop.service.admin;

import com.gotIt.gotshop.app.support.ResultVO;
import com.gotIt.gotshop.vo.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface ProductService {

    ResultVO<Map<String,String>> save(ProductInfo product);

    Page<ProductInfo> findByPage(Pageable pageable);

    Long removeProduct(Long productId);

    ProductInfo findById(Long id);
}
