package com.akash.portfolio.dao;

import com.akash.portfolio.model.MyWorks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorksDao extends JpaRepository<MyWorks, Integer> {
}
