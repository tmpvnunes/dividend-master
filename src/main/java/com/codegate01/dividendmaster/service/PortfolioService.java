package com.codegate01.dividendmaster.service;

import com.codegate01.dividendmaster.errors.PortfolioNotFoundException;
import com.codegate01.dividendmaster.model.Portfolio;
import com.codegate01.dividendmaster.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;

    @Autowired
    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    //Add Portfolio
    public Portfolio addPortfolio(Portfolio portfolio){
        return portfolioRepository.save(portfolio);
    }

    //find portfolio by id
    public Portfolio findPortfolio(Long id){
        return portfolioRepository.findById(id)
                .orElseThrow(()-> new PortfolioNotFoundException("Portfolio not found"));
    }

    public List<Portfolio> findAllPortfolios(){
        return portfolioRepository.findAll();
    }

    //update portfolio
    public Portfolio updatePortfolio(Portfolio portfolio){
        return portfolioRepository.save(portfolio);
    }

    //delete portfolio
    public void deletePortfolio(Long id){
        portfolioRepository.deleteById(id);
    }
}
