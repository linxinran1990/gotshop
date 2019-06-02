package com.gotIt.gotshop.service.admin.impl;

import com.gotIt.gotshop.app.support.ResultVO;
import com.gotIt.gotshop.app.utils.ResultVOUtils;
import com.gotIt.gotshop.entity.Category;
import com.gotIt.gotshop.entity.Product;
import com.gotIt.gotshop.enumer.CategoryStatus;
import com.gotIt.gotshop.enumer.ProductStatus;
import com.gotIt.gotshop.enumer.ResultEnum;
import com.gotIt.gotshop.exception.ServiceException;
import com.gotIt.gotshop.repository.CategoryRepository;
import com.gotIt.gotshop.repository.ProductRepository;
import com.gotIt.gotshop.service.admin.ProductService;
import com.gotIt.gotshop.support.AbstractDomain2InfoConverter;
import com.gotIt.gotshop.support.QueryResultConverter;
import com.gotIt.gotshop.vo.ProductInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/17</pre>
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ResultVO<Map<String,String>> save(ProductInfo productInfo) {
        Map map = new HashMap();
        Product product = new Product();

        Category category = categoryRepository.findOne(productInfo.getCategoryId());
        if(category ==  null||category.getCategoryStatus().equals(CategoryStatus.ineffective)){
            throw new ServiceException(ResultEnum.CATEGORY_INEFFECTIVE);
        }

        if(productInfo.getId()!=null){
            product = productRepository.findOne(productInfo.getId());
        }
        BeanUtils.copyProperties(productInfo,product);
        product.setProductStatus(ProductStatus.NEW);
        product.setCategory(category);
        productRepository.save(product);
        map.put("id",product.getId());
        return ResultVOUtils.success(map);
    }

    @Override
    public Page<ProductInfo> findByPage(Pageable pageable) {
        Page<Product> productPage = productRepository.findAll(pageable);
        return QueryResultConverter.convert(productPage, pageable, new AbstractDomain2InfoConverter<Product, ProductInfo>() {
            @Override
            protected void doConvert(Product domain, ProductInfo info) throws Exception {
                info.setCategoryName(domain.getCategory().getCategoryName());
            }
        });

    }

    @Override
    public Long removeProduct(Long productId) {
        productRepository.delete(productId);
        return productId;
    }

    @Override
    public ProductInfo findById(Long id) {
        Product product = productRepository.findOne(id);
        ProductInfo productInfo = new ProductInfo();
        BeanUtils.copyProperties(product,productInfo);
        productInfo.setCategoryName(product.getCategory().getCategoryName());
        productInfo.setCategoryId(product.getCategory().getId());
        return productInfo;
    }
}



