package com.gotIt.gotshop.entity;

import com.gotIt.gotshop.enumer.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "t_product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity implements Serializable {

    @ManyToOne
    private Category category;

    @Column(length = 50)
    private String productName;

    @Column(length = 100)
    private String productInfo;

    @Column(length = 50)
    private String productImg;

    @Column(columnDefinition = "decimal(10,2) NOT NULL")
    private BigDecimal productPrice;

    @Column(columnDefinition = "decimal(10,2) NOT NULL")
    private BigDecimal productOrgPrice;

    @Column(length = 11)
    private Integer productStock;

    @Column(length = 50)
    private String productInfoImg;

    @Column(columnDefinition = "INT(1) default 0")
    @Enumerated(EnumType.ORDINAL)
    private ProductStatus productStatus;

    @OneToOne(mappedBy = "product")
    private OrderItem orderItem;

    @OneToOne(mappedBy = "product")
    private Banner banners;
}
