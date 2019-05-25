package com.gotIt.gotshop.entity;

import com.gotIt.gotshop.enumer.CategoryStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "t_category")
@Entity
//@Data
@NoArgsConstructor
@AllArgsConstructor
//@Builder
public class Category extends BaseEntity implements Serializable {

    private Long parentId;

    private String categoryName;

    @Column(columnDefinition = "INT(1) default 0" )
    @Enumerated(EnumType.ORDINAL)
    private CategoryStatus categoryStatus;

    private Integer sortOrder;

    @OneToMany(mappedBy = "category",fetch= FetchType.EAGER)
    private List<Product> products;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public CategoryStatus getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(CategoryStatus categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
