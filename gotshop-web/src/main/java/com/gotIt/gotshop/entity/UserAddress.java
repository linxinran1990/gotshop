package com.gotIt.gotshop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_user_address")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAddress extends BaseEntity implements Serializable {


    @ManyToOne
    private User user;

    @Column(length = 50)
    private String receiverAddress;

    @Column(length = 50)
    private String receiverLongitude;

    @Column(length = 50)
    private String receiverLatitude;

    @Column(length = 50)
    private String receiverHouseNo;

    @Column(length = 20)
    private String receiverName;

    @Column(length = 20)
    private String receiverMobile;

    @OneToOne(mappedBy = "address")
    private Order order;
}
