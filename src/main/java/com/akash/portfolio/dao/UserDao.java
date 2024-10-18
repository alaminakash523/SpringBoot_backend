package com.akash.portfolio.dao;

import com.akash.portfolio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, String> {
    public User findByUsername(String username);
}
