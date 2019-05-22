package com.gotIt.gotshop.service.admin.impl;

import com.gotIt.gotshop.BaseTest;
import com.gotIt.gotshop.entity.Category;
import com.gotIt.gotshop.enumer.CategoryStatus;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class CategoryServiceImplTest extends BaseTest{

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void save(){
        Category category = new Category();
        category.setCategoryName("肉类");
        category.setCategoryStatus(CategoryStatus.EFFECTIVE);
        category.setParentId(0L);
        category.setSortOrder(2);

      Category categoryResult = categoryService.save(category);

    }

}