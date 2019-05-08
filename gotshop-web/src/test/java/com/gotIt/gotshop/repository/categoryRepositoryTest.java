package com.gotIt.gotshop.repository;

import com.gotIt.gotshop.BaseTest;
import com.gotIt.gotshop.entity.Category;
import com.gotIt.gotshop.enumer.CategoryStatus;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
public class categoryRepositoryTest extends BaseTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testQuaryAll(){
        List<Category> categoryList = categoryRepository.findAll();
        categoryList.forEach((category)->log.info(category.getCategoryName()));
    }

    @Test
    public void testSave(){
        Category category = new Category();
        category.setCategoryName("水果");
        category.setCategoryStatus(CategoryStatus.EFFECTIVE);
        category.setParentId(0L);
        category.setSortOrder(1);

        categoryRepository.save(category);
    }

    @Test
    public void testQuery(){
        Category category = categoryRepository.getOne(7L);
        log.info(category.getCategoryName());
    }
}