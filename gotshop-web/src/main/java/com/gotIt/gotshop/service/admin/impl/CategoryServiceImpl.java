package com.gotIt.gotshop.service.admin.impl;

import com.gotIt.gotshop.app.support.ResultVO;
import com.gotIt.gotshop.app.utils.ResultVOUtils;
import com.gotIt.gotshop.entity.Banner;
import com.gotIt.gotshop.entity.Category;
import com.gotIt.gotshop.enumer.CategoryStatus;
import com.gotIt.gotshop.enumer.ResultEnum;
import com.gotIt.gotshop.exception.ServiceException;
import com.gotIt.gotshop.repository.CategoryRepository;
import com.gotIt.gotshop.repository.spec.CategorySpec;
import com.gotIt.gotshop.service.admin.CategoryService;
import com.gotIt.gotshop.support.AbstractDomain2InfoConverter;
import com.gotIt.gotshop.support.QueryResultConverter;
import com.gotIt.gotshop.vo.BannerVO;
import com.gotIt.gotshop.vo.CategoryInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/17</pre>
 */
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ResultVO<Map<String,String>> save(CategoryInfo categoryInfo) {
        Map map = new HashMap();
        Category category = new Category();
        if(categoryInfo.getCategoryName()!=null){
            Category categoryByName = categoryRepository.findByCategoryName(categoryInfo.getCategoryName());
            if(categoryInfo.getId()!=null&&categoryByName!=null&&!categoryInfo.getId().equals(categoryByName.getId())){
                throw new ServiceException(ResultEnum.CATEGORY_EXIST);
            }else if(categoryByName!=null&&categoryInfo.getId()==null){
                throw new ServiceException(ResultEnum.CATEGORY_EXIST);
            }
        }

        if(categoryInfo.getId()!=null){
            category = categoryRepository.findOne(categoryInfo.getId());
            category.setUpdateTime(new Date());
        }
        if(categoryInfo.getParentId() == null){
            categoryInfo.setParentId(0L);
        }
        BeanUtils.copyProperties(categoryInfo,category);
        category.setCategoryStatus(CategoryStatus.EFFECTIVE);
        categoryRepository.save(category);
        map.put("id",category.getId());
        return ResultVOUtils.success(map);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<CategoryInfo> findByPage(CategoryInfo categoryInfo, Pageable pageable) {

        Page<Category> categoryPage = categoryRepository.findAll(new CategorySpec(categoryInfo),pageable);
        return QueryResultConverter.convert(categoryPage, pageable, new AbstractDomain2InfoConverter<Category, CategoryInfo>() {
            @Override
            protected void doConvert(Category domain, CategoryInfo info) throws Exception {

            }
        });
    }

    @Override
    public Long removeCategory(Long categoryId) {
        try {
            categoryRepository.delete(categoryId);
        }catch (Exception e){
            log.error(e.getStackTrace().toString());
            throw new ServiceException(ResultEnum.DELETE_NOT_EXIST);
        }
        return categoryId;
    }

    @Override
    public CategoryInfo findById(Long id) {
        Category category = categoryRepository.findOne(id);
        CategoryInfo categoryInfo = new CategoryInfo();
        BeanUtils.copyProperties(category,categoryInfo);
        return categoryInfo;
    }
}



