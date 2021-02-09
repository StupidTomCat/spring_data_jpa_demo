package com.yyh.dao;

import com.yyh.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {//JpaRepository:jpa提供的接口，接口当中定义了实体的基本操作

}
