package com.idol.spring_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idol.spring_be.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    public User findByUsername(String username);
    public int deleteByUsername(String username);
    
}