package com.rakib.jawed.springngblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rakib.jawed.springngblog.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
