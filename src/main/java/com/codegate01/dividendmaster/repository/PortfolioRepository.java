package com.codegate01.dividendmaster.repository;

import com.codegate01.dividendmaster.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository <Portfolio, Long> {
    
}
