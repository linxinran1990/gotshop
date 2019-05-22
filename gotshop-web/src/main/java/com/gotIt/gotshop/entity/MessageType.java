package com.gotIt.gotshop.entity;

import com.gotIt.gotshop.enumer.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_message_type")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageType extends BaseEntity  implements Serializable {

    @Column(length = 50)
    private String typeName;

    @Column(length = 50)
    private String typeInfo;

    @Column(columnDefinition = "INT(1) default 0")
    @Enumerated(EnumType.ORDINAL)
    private Status typeStatus;

}
