package com.gotIt.gotshop.repository;

import com.gotIt.gotshop.entity.MessageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MessageTypeRepository extends JpaRepository<MessageType,Long>,JpaSpecificationExecutor<MessageType> {
}
