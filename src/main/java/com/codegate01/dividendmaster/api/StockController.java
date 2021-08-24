package com.codegate01.dividendmaster.api;

import com.codegate01.dividendmaster.model.Stock;
import com.codegate01.dividendmaster.payload.MessageResponse;
import com.codegate01.dividendmaster.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
@RestController
@RequestMapping("api/stock")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService){
        this.stockService = stockService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Stock>> getAllUsers() {
        List<Stock> stocks = stockService.findAllStock();
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @GetMapping("/find/{ticker}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> getStockByTicker(@PathVariable("ticker") String ticker){
        Stock stock = stockService.findStockByTicker(ticker);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{ticker}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteStock(@PathVariable("ticker") String ticker) {
        Stock stock = stockService.findStockByTicker(ticker);
        if(ticker == null){
            return ResponseEntity.notFound().build();
        }
        stockService.deleteStockByTicker(ticker);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{ticker}")
    public ResponseEntity<?> update(@PathVariable String ticker, @RequestBody Stock stock){
        double dividendYield = stock.getDividendYield();
        Date exDividend = stock.getExDividend();
        Date lastDividend = stock.getLastDividend();

        stockService.updateStockDetails(ticker, dividendYield, exDividend, lastDividend);
        return ResponseEntity.ok(new MessageResponse("Ticker Symbol " + ticker + " was updated!"));
    }

}
