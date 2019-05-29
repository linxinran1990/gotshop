package com.gotIt.gotshop.service.admin;

import com.gotIt.gotshop.entity.Category;
import com.gotIt.gotshop.vo.CategoryInfo;
import com.gotIt.gotshop.vo.ResultVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface CategoryService {

    ResultVO<Map<String,String>> save(CategoryInfo categoryInfo);

    List<Category> findAll();

    Page<CategoryInfo> findByPage(CategoryInfo categoryInfo,Pageable page);

    Long removeCategory(Long categoryId);
}
