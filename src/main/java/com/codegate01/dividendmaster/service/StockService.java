package com.codegate01.dividendmaster.service;

import com.codegate01.dividendmaster.exceptions.StockNotFoundException;
import com.codegate01.dividendmaster.model.Stock;
import com.codegate01.dividendmaster.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    private final StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    //Add Stock
    public Stock addStock(Stock stock){
        return stockRepository.save(stock);
    }

    //Find All stocks
    public List<Stock> findAllStock(){
        return stockRepository.findAll();
    }

    //Find a stock
    public Stock findStockByTicker(String ticker){
        return stockRepository.findStockByTicker(ticker)
                .orElseThrow(()-> new StockNotFoundException("Stock ticker " + ticker + " was not found"));
    }

    //Update a stock
    public Stock updateStock(Stock stock){
        return stockRepository.save(stock);
    }

    //Delete a stock
    public Optional<Stock> deleteStockByTicker(String ticker){
        return stockRepository.deleteStockByTicker(ticker);
    }

    public void updateStockDetails(String ticker, double dividendYield,  Date exDividend, Date lastDividend) {
        Long id = findStockByTicker(ticker).getStockId();
        stockRepository.updateStockDetails(id,dividendYield,exDividend,lastDividend);
    }
}
