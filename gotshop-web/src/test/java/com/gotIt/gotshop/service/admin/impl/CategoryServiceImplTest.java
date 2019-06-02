package com.gotIt.gotshop.service.admin.impl;

import com.gotIt.gotshop.BaseTest;
import com.gotIt.gotshop.app.support.ResultVO;
import com.gotIt.gotshop.entity.Category;
import com.gotIt.gotshop.enumer.CategoryStatus;
import com.gotIt.gotshop.vo.CategoryInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static org.junit.Assert.*;

public class CategoryServiceImplTest extends BaseTest{

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void save(){
        CategoryInfo category = new CategoryInfo();
        category.setCategoryName("肉类");
        category.setParentId(0L);
        category.setSortOrder(2);

      ResultVO<Map<String,String>> categoryResult = categoryService.save(category);

    }

}