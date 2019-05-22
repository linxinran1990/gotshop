package com.gotIt.gotshop.repository;

import com.gotIt.gotshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User,Long>,JpaSpecificationExecutor<User> {

    User findByUsername(String username);
}
