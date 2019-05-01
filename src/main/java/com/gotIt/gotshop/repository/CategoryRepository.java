package com.gotIt.gotshop.repository;

import com.gotIt.gotshop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CategoryRepository extends JpaRepository<Category,Long>,JpaSpecificationExecutor<Category> {


}
