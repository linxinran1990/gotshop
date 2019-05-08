package com.gotIt.gotshop.entity;

import com.gotIt.gotshop.enumer.MessageStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "t_message")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message extends BaseEntity implements Serializable {

    @ManyToOne
    private User user;

    @Column(columnDefinition = "INT(1)")
    @Enumerated(EnumType.ORDINAL)
    private MessageStatus messageStatus;

    @Column(length = 100)
    private String messageTitle;

    @Column(length = 500)
    private String messageContent;
}
