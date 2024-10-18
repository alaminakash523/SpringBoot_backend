package com.akash.portfolio.dao;

import com.akash.portfolio.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamDao extends JpaRepository<Team, Integer> {
    public Team findByName(String name);
}
