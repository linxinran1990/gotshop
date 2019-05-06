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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends BaseEntity implements Serializable {

    private Long parentId;

    private String categoryName;

    @Column(columnDefinition = "INT(1)" )
    @Enumerated(EnumType.ORDINAL)
    private CategoryStatus categoryStatus;

    private Integer sortOrder;

    @OneToMany(mappedBy = "category",fetch= FetchType.EAGER)
    private List<Product> product;
}
