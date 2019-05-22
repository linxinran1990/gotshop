package com.gotIt.gotshop.service.admin;

import com.gotIt.gotshop.entity.Category;

import java.util.List;

public interface CategoryService {

    Category save(Category category);

    List<Category> findAll();

    Long removeCategory(Long categoryId);
}
