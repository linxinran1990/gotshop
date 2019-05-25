package com.gotIt.gotshop.entity;

import com.gotIt.gotshop.enumer.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "t_product")
//@Data
//@Builder
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

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItem;

    @OneToMany(mappedBy = "product")
    private List<Banner> banners;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getProductOrgPrice() {
        return productOrgPrice;
    }

    public void setProductOrgPrice(BigDecimal productOrgPrice) {
        this.productOrgPrice = productOrgPrice;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public String getProductInfoImg() {
        return productInfoImg;
    }

    public void setProductInfoImg(String productInfoImg) {
        this.productInfoImg = productInfoImg;
    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    public List<OrderItem> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(List<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }

    public List<Banner> getBanners() {
        return banners;
    }

    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }
}
