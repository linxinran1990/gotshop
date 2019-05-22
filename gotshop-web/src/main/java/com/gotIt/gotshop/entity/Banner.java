package com.gotIt.gotshop.entity;

import com.gotIt.gotshop.enumer.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "t_banner")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Banner extends BaseEntity implements Serializable {

    @Column(length = 50)
    private String bannerName;

    @Column(length = 50)
    private String bannerImg;

    @OneToOne
    private Product product;

    @Column(columnDefinition = "INT(1) default 0" )
    @Enumerated(EnumType.ORDINAL)
    private Status bannerStatus;


}
