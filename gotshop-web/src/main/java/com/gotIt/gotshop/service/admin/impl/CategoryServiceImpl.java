package com.gotIt.gotshop.service.admin.impl;

import com.gotIt.gotshop.entity.Category;
import com.gotIt.gotshop.enumer.CategoryStatus;
import com.gotIt.gotshop.repository.CategoryRepository;
import com.gotIt.gotshop.service.admin.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/17</pre>
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        category.setCategoryStatus(CategoryStatus.EFFECTIVE);
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Long removeCategory(Long categoryId) {
        categoryRepository.delete(categoryId);
        return categoryId;
    }
}



