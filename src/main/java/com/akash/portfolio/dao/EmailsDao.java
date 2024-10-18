package com.akash.portfolio.dao;

import com.akash.portfolio.model.Emails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailsDao extends JpaRepository<Emails, Integer> {
}
