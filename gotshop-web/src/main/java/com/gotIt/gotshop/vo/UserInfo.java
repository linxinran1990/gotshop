package com.gotIt.gotshop.vo;

import com.fasterxml.jackson.annotation.JsonView;
import com.gotIt.gotshop.entity.UserAddress;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/25</pre>
 */
@Data
public class UserInfo implements Serializable {

    public interface UserListView {};

    public interface UserDetailView extends UserListView {};

    private Long id;

    private String username;

   /* @JsonView(UserDetailView.class)
    private String password;*/

    private String email;

    private String mobile;


}



