package com.gotIt.gotshop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "t_user",uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})},// 唯一约束
        indexes = {@Index(columnList = "username")})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity implements Serializable {

    private String username;

    private String password;

    @Email
    private String email;

    @Column(length = 20)
    private String mobile;

    @OneToMany(mappedBy = "user")
    private List<UserAddress> userAddress;

    @OneToMany(mappedBy = "user")
    private List<UserCoupon> coupons;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

}
