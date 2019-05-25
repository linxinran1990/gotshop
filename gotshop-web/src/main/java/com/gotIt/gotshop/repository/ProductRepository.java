package com.gotIt.gotshop.repository;

import com.gotIt.gotshop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductRepository extends JpaRepository<Product,Long>,JpaSpecificationExecutor<Product> {

    Page<Product> findAll(Pageable pageable);

}
