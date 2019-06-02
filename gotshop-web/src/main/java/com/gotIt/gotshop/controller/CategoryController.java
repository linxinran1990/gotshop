package com.gotIt.gotshop.controller;

import com.gotIt.gotshop.app.support.ResultVO;
import com.gotIt.gotshop.app.utils.ResultVOUtils;
import com.gotIt.gotshop.enumer.ResultEnum;
import com.gotIt.gotshop.exception.ServiceException;
import com.gotIt.gotshop.service.admin.CategoryService;
import com.gotIt.gotshop.vo.CategoryInfo;
import com.gotIt.gotshop.vo.CategoryUpdateForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/26</pre>
 */
@RestController
@RequestMapping("/back/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResultVO<Map<String,String>> updateCategory(@Valid @RequestBody CategoryUpdateForm categoryUpdateForm,
                                                     BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String msg = bindingResult.getFieldError().getDefaultMessage().toString();
            throw new ServiceException(ResultEnum.PARAM_ERROR.getCode(), msg);
        }

        CategoryInfo categoryInfo = new CategoryInfo();
        BeanUtils.copyProperties(categoryUpdateForm,categoryInfo);
        return categoryService.save(categoryInfo);
    }

    @PutMapping
    public ResultVO<Map<String,String>> createCategory(@Valid @RequestBody CategoryInfo categoryInfo,
                                                     BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String msg = bindingResult.getFieldError().getDefaultMessage().toString();
            throw new ServiceException(ResultEnum.PARAM_ERROR.getCode(), msg);
        }

        return categoryService.save(categoryInfo);
    }

    @GetMapping
    public ResultVO<Page<CategoryInfo>> queryByPage(CategoryInfo categoryInfo, @RequestParam Integer page,
                                                    @RequestParam Integer size){
        Pageable pageable = new PageRequest(page-1,size);
        Page<CategoryInfo> categoryInfoPage = categoryService.findByPage(categoryInfo,pageable);
        return ResultVOUtils.success(categoryInfoPage);
    }

    @GetMapping("/{id}")
    public ResultVO<CategoryInfo> getOne(@PathVariable Long id){
       CategoryInfo categoryInfo = categoryService.findById(id);
       return ResultVOUtils.success(categoryInfo);
    }

    @DeleteMapping
    public ResultVO<Map<String,String>> removeCategory(Long id){
        Long categoryId = categoryService.removeCategory(id);
        Map map = new HashMap();
        map.put("id",categoryId);
        return ResultVOUtils.success(map);
    }
}



